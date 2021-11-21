package br.com.work.ToWork.Spring.boot.controlador;

import br.com.work.ToWork.Spring.boot.dominio.*;
import br.com.work.ToWork.Spring.boot.dominio.Iterator;
import br.com.work.ToWork.Spring.boot.listaObj.ListaObj;
import br.com.work.ToWork.Spring.boot.repositorio.InteracaoRepository;
import br.com.work.ToWork.Spring.boot.repositorio.PublicacaoRepository;
import br.com.work.ToWork.Spring.boot.repositorio.ToWorkRepository;
import org.hibernate.annotations.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/2work")
public class UsuarioControllerJPA<T> {

    List<Usuario> usuarios = new ArrayList<>();
    ListaObj<Usuario> listaObj = new ListaObj<>(100); //Lista Obj

    @Autowired
    private ToWorkRepository repository;

    @Autowired
    private PublicacaoRepository publicacaoRepository;

    @Autowired
    private InteracaoRepository interacaoRepository;

    //Cadastro
    @PostMapping("/cadastrar-dev")//Cadastro de um usuário Dev
    public ResponseEntity postUsuarioDev(@RequestBody Dev novoDev) {
        novoDev.setUsuarioDev(true);
        repository.save(novoDev);
        usuarios.add(novoDev);
        listaObj.adiciona(novoDev); //Lista Obj
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/cadastrar-investidor")//Cadastro de um usuário Dev
    public ResponseEntity postUsuarioInvestidor(@RequestBody Investidor novoInvestidor) {
        novoInvestidor.setUsuarioDev(false);
        repository.save(novoInvestidor);
        usuarios.add(novoInvestidor);
        listaObj.adiciona(novoInvestidor); //Lista Obj
        return ResponseEntity.status(201).build();
    }

    //Procuras
    @GetMapping("/procura") //Exibir todos os Usuarios (seja Dev ou Investidor)
    public ResponseEntity getTodosUsuarios() {
        List<Usuario> usuario = repository.findAll();
        listaObj.exibe(); //Lista Obj
        if (usuario.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(usuario);
    }

    @GetMapping("/procura/{id}")//Exibir os dados por um id especifico
    public ResponseEntity getUsuarioPorId(@PathVariable Integer id) {
        listaObj.getElemento(id - 1);
        if (repository.findById(id).isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.of(repository.findById(id));
    }

    //Vai servir como registro de dados até mesmo apagados
    @GetMapping("/procura/iterator/{nome}")
    public ResponseEntity getRecover(@PathVariable String nome) {
        Usuario[] usuariosFiltrados = new Usuario[listaObj.getTamanho()];
        ListaObj<Usuario> listaObjRecover = new ListaObj<>(listaObj.getTamanho());
        Integer contador = 0;
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome)) {
                listaObjRecover.adiciona(usuario);
                usuariosFiltrados[contador] = usuario;
            }
            contador++;
        }
        while (listaObjRecover.hasNext()) {
            Usuario usuarioWhileIterator = (Usuario) (listaObjRecover.next());
            System.out.println(listaObjRecover.next());
            return ResponseEntity.status(200).body(usuariosFiltrados);
        }
        return ResponseEntity.status(204).build();
    }


    //Deletar o usuário
    @DeleteMapping("/deleta/{id}")//Deletar a conta do usuário
    public ResponseEntity deleteUsuario(@PathVariable int id) {
        listaObj.removerPeloIndice(id - 1);
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    //Atualizar os usuários
    @PutMapping("/atualiza-dev/{id}")//Atualizar os dados do perfil de Dev
    public ResponseEntity putDev(@PathVariable Integer id,
                                 @RequestBody Dev devAlterado) {
        if (repository.existsById(id)) {
            devAlterado.setId(id);
            repository.save(devAlterado);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/atualiza-investidor/{id}")//Atualizar os dados do perfil de Dev
    public ResponseEntity putInvestidor(@PathVariable Integer id,
                                        @RequestBody Investidor investidorAlterado) {
        if (repository.existsById(id)) {
            investidorAlterado.setId(id);
            repository.save(investidorAlterado);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    //Login e Logoff
    @PatchMapping("/login-investidor/{id}")//Atualizar os dados do perfil de Dev
    public ResponseEntity loginInvestidor(@PathVariable Integer id) {
        Optional<Usuario> usuarioOptional = repository.findById(id);
        //Usuario u = null;
        if (usuarioOptional.isEmpty()) { //Usuário está nulo, no caso ele não encontrou
            return ResponseEntity.status(404).build();
        } else {
            Usuario usuario = usuarioOptional.get();
            if (usuario.getUsuarioDev()) {
                return ResponseEntity.status(403).build();
            }
            usuario.setOnlineStatus(true);
            repository.save(usuario);
            return ResponseEntity.status(200).build();
        }

        /*if (repository.existsById(id)) {
            Investidor investidor = (Investidor) listaObj.getElemento(id-1);
            //Aqui está desnullificando os dados
            investidorAlterado.setNome(investidor.getNome());
            investidorAlterado.setEmail(investidor.getEmail());
            investidorAlterado.setSenha(investidor.getSenha());
            investidorAlterado.setCpf(investidor.getCpf());
            investidorAlterado.setCidade(investidor.getCidade());
            investidorAlterado.setEstado(investidor.getEstado());
            investidorAlterado.setTelefone(investidor.getTelefone());
            investidorAlterado.setBiografia(investidor.getBiografia());
            investidorAlterado.setPlanoUsuario(investidor.getPlanoUsuario());
            investidorAlterado.setDataNascimento(investidor.getDataNascimento());
            investidorAlterado.setUsuarioDev(investidor.getUsuarioDev());
            investidorAlterado.setCnpj(investidor.getCnpj());
            investidorAlterado.setId(id);
            //Aqui abaixo está trocando o valor de false para true
            investidorAlterado.setOnlineStatus(true);
            repository.save(investidorAlterado);
        }*/

    }

    @GetMapping("/login/{email}/{senha}")
    public ResponseEntity login(@PathVariable String email, @PathVariable String senha) {
        Usuario usuario = repository.findByEmailAndSenha(email, senha);
        if (usuario == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).build();
    }

    @PatchMapping("/logoff-investidor/{id}")//Atualizar os dados do perfil de Dev
    public ResponseEntity logoffInvestidor(@PathVariable Integer id) {
        Optional<Usuario> usuarioOptional = repository.findById(id);
        //Usuario u = null;
        if (usuarioOptional.isEmpty()) { //Usuário está nulo, no caso ele não encontrou
            return ResponseEntity.status(404).build();
        } else {
            Usuario usuario = usuarioOptional.get();
            if (usuario.getUsuarioDev()) {
                return ResponseEntity.status(403).build();
            }
            usuario.setOnlineStatus(false);
            repository.save(usuario);
            return ResponseEntity.status(200).build();
        }
    }

    @PatchMapping("/login-dev/{id}")//Atualizar os dados do perfil de Dev
    public ResponseEntity loginDev(@PathVariable Integer id) {
        Optional<Usuario> usuarioOptional = repository.findById(id);
        //Usuario u = null;
        if (usuarioOptional.isEmpty()) { //Usuário está nulo, no caso ele não encontrou
            return ResponseEntity.status(404).build();
        } else {
            Usuario usuario = usuarioOptional.get();
            if (!usuario.getUsuarioDev()) {
                return ResponseEntity.status(403).build();
            }
            usuario.setOnlineStatus(true);
            repository.save(usuario);
            return ResponseEntity.status(200).build();
        }
    }

    @PatchMapping("/logoff-dev/{id}")//Atualizar os dados do perfil de Dev
    public ResponseEntity logoffDev(@PathVariable Integer id,
                                    Dev devAlterado) {
        Optional<Usuario> usuarioOptional = repository.findById(id);
        //Usuario u = null;
        if (usuarioOptional.isEmpty()) { //Usuário está nulo, no caso ele não encontrou
            return ResponseEntity.status(404).build();
        } else {
            Usuario usuario = usuarioOptional.get();
            if (!usuario.getUsuarioDev()) {
                return ResponseEntity.status(403).build();
            }
            usuario.setOnlineStatus(false);
            repository.save(usuario);
            return ResponseEntity.status(200).build();
        }
    }

    //----------------------------------------------------------------------------------------------------
    //-----------                           <------------------->                               ----------
    //-----------        <-------------------    Publicações    ------------------->            ----------
    //-----------                           <------------------->                               ----------
    //----------------------------------------------------------------------------------------------------

    @PostMapping("/publicar/{idUsuario}")//Cadastro de uma publicacao
    public ResponseEntity postPublicacao(@PathVariable Integer idUsuario, @RequestBody Publicacao novaPublicacao) {
        Optional<Usuario> usuarioOptional = repository.findById(idUsuario);
        Dev guardaDev = null;
        if (usuarioOptional.isEmpty()) {
            return ResponseEntity.status(404).build();
        } else {
            Usuario usuario = usuarioOptional.get();
            if (!usuario.getUsuarioDev()) {
                return ResponseEntity.status(403).build();
            }
            ((Dev) usuario).setTotalPublicacoes(((Dev) usuario).getTotalPublicacoes() + 1);
            repository.save(usuario);
            guardaDev = (Dev) usuario;
            novaPublicacao.setDev(guardaDev);
            publicacaoRepository.save(novaPublicacao);
            return ResponseEntity.status(201).build();
        }
    }

    @GetMapping("/procura-todas-publicacoes")// Exibe todas as publicações
    public ResponseEntity procurarPublicacoes() {
        List<Publicacao> publicacao = publicacaoRepository.findAll();
        if (publicacao.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(publicacao);
    }

    @DeleteMapping("deletar-publicacao/{id}")
    public ResponseEntity deletarPublicacao(@PathVariable Integer id) {
        if (publicacaoRepository.existsById(id)) {
            publicacaoRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    //----------------------------------------------------------------------------------------------------
    //-----------                           <------------------->                               ----------
    //-----------        <-------------------    Interações     ------------------->            ----------
    //-----------                           <------------------->                               ----------
    //----------------------------------------------------------------------------------------------------

    @PostMapping("/interagir/{idPublicacao}")
    public ResponseEntity curtirPublicacao(@PathVariable Integer idPublicacao, @RequestBody Interacao novaInteracao) {
        Optional<Publicacao> publicacaoOptional = publicacaoRepository.findById(idPublicacao);
        if (publicacaoOptional.isEmpty()) {
            return ResponseEntity.status(404).build();
        } else {
            Publicacao publicacao = publicacaoOptional.get();
            novaInteracao.setPublicacao(publicacao);
            interacaoRepository.save(novaInteracao);
            return ResponseEntity.status(201).build();
        }
    }

    @GetMapping("/exibir-todas-interacoes")
    public ResponseEntity exibirTodasInteracoes() {
        List<Interacao> interacao = interacaoRepository.findAll();
        if (interacao.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(interacao);
    }

    //----------------------------------------------------------------------------------------------------
    //-----------                           <------------------->                               ----------
    //-----------        <-------------------    Documentos     ------------------->            ----------
    //-----------                           <------------------->                               ----------
    //----------------------------------------------------------------------------------------------------

    @GetMapping("/exportar-registro")
    public ResponseEntity exportarRegistro() {
        System.out.printf("%-6s;%-45s;%-45s;%-10s;%-11s;%-25s;%-25s;%-11s;%-29s;%-5s;%-6s\n", "ID", "NOME", "E-MAIL", "SENHA",
                "CPF", "CIDADE", "ESTADO", "TELEFONE", "DATA DE NASCIMENTO", "DEV", "ONLINE");
        gravaArquivoCsv(listaObj, "arquivo");
        leExibeArquivoCsv("arquivo");
        return ResponseEntity.status(200).build();
    }

    public static void gravaArquivoCsv(ListaObj<Usuario> lista, String nomeArq) {
        FileWriter arq = null;  //Objeto que representa o arquivo a ser gravado
        Formatter saida = null; //Objeto que usaremos para escrever no arquivo
        Boolean deuRuim = false;
        nomeArq += ".csv";

        // Bloco try-catch para abrir o arquivo
        try {
            arq = new FileWriter(nomeArq); // Abre o arquivo nomeArq
            saida = new Formatter(arq);    // Associa o objeto saida ao arquivo
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo");
            System.exit(1);
        }

        // Bloco try catch para percorrer a lista e gravar no arquivo
        try {
            for (int i = 0; i < lista.getTamanho(); i++) {
                Usuario usuario = lista.getElemento(i);
                saida.format("%d;%s;%s;%s;%s;%s;%s;%s;%s;%b;%b\n", usuario.getId(), usuario.getNome(), usuario.getEmail(),
                        usuario.getSenha(), usuario.getCpf(), usuario.getCidade(), usuario.getCidade(), usuario.getTelefone(),
                        usuario.getDataNascimento(), usuario.getUsuarioDev(), usuario.getOnlineStatus());
            }
        } catch (FormatterClosedException erro) {
            System.out.println("Erro ao gravar no arquivo");
            deuRuim = true;
        } finally {
            saida.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.println("Erro ao fechar o arquivo");
                deuRuim = true;
            }
        }
    }

    public static void leExibeArquivoCsv(String nomeArq) {
        FileReader arq = null; // objeto que representa o arquivo para Leitura
        Scanner entrada = null; // objeto usado para ler do arquivo
        Boolean deuRuim = false;
        nomeArq += ".csv";

        // Bloco try-catch para abrir o arquivo
        try {
            arq = new FileReader(nomeArq);
            /* Cria o objeto do Scanner, informando que o delimitador é o ';' OU o '\n'*/
            entrada = new Scanner(arq).useDelimiter(";|\\n");
        } catch (FileNotFoundException erro) {
            System.out.println("Arquivo não encontrado");
            System.exit(1);
        }

        // Bloco try-catch para Ler do arquivo
        try {
            while (entrada.hasNext()) { //Enquanto não for final do arquivo
                Integer id = entrada.nextInt();
                String nome = entrada.next();
                String email = entrada.next();
                String senha = entrada.next();
                String cpf = entrada.next();
                String cidade = entrada.next();
                String estado = entrada.next();
                String telefone = entrada.next();
                String dataNascimento = entrada.next();
                Boolean usuarioDev = entrada.nextBoolean();
                Boolean onlineStatus = entrada.nextBoolean();
                System.out.printf("%6d;%-45s;%-45s;%-10s;%-11s;%-25s;%-25s;%-11s;%-29s;%-5b;%-6b \n",
                        id, nome, email, senha, cpf, cidade, estado, telefone, dataNascimento, usuarioDev, onlineStatus);
            }
        } catch (NoSuchElementException erro) {
            System.out.println("Arquivo com problemas");
            deuRuim = true;
        } catch (IllegalStateException erro) {
            System.out.printf("Erro na leitura do arquivo");
            deuRuim = true;
        } finally {
            entrada.close();
            try {
                arq.close();
            } catch (IOException erro) {
                System.out.printf("Erro ao fechar o arquivo");
                deuRuim = true;
            }
            if (deuRuim) {
                System.exit(1);
            }
        }
    }
}
