package br.com.work.ToWork.Spring.boot.controlador;

import br.com.work.ToWork.Spring.boot.dominio.*;
import br.com.work.ToWork.Spring.boot.listaObj.FilaObj;
import br.com.work.ToWork.Spring.boot.listaObj.ListaObj;
import br.com.work.ToWork.Spring.boot.listaObj.PilhaObj;
import br.com.work.ToWork.Spring.boot.repositorio.InteracaoRepository;
import br.com.work.ToWork.Spring.boot.repositorio.InvestidorRepository;
import br.com.work.ToWork.Spring.boot.repositorio.PublicacaoRepository;
import br.com.work.ToWork.Spring.boot.repositorio.ToWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/2work")
public class UsuarioControllerJPA<T> {

    List<Usuario> usuarios = new ArrayList<>();
    ListaObj<Usuario> listaObj = new ListaObj<>(100); // Lista Obj

    @Autowired
    private ToWorkRepository repository;

    @Autowired
    private PublicacaoRepository publicacaoRepository;

    @Autowired
    private InteracaoRepository interacaoRepository;

    @Autowired
    private InvestidorRepository investidorRepository;

    // Cadastro
    @PostMapping("/cadastrar-dev") // Cadastro de um usuário Dev
    public ResponseEntity postUsuarioDev(@RequestBody Dev novoDev) {
        novoDev.setUsuarioDev(true);
        repository.save(novoDev);
        usuarios.add(novoDev);
        listaObj.adiciona(novoDev); // Lista Obj
        exportarRegistro();
        return ResponseEntity.status(201).build();
    }

    @PatchMapping("/alterar-visualizacao/{id}/{valorNovo}") //Atualizar os dados do perfil de Dev
    public ResponseEntity alterarVisualizacoes(@PathVariable Integer id, @PathVariable Integer valorNovo) {
        if (repository.existsById(id)) {
            valorNovo++;
            repository.updateDevWhereById(id, valorNovo);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping("/cadastrar-investidor") // Cadastro de um usuário Dev
    public ResponseEntity postUsuarioInvestidor(@RequestBody Investidor novoInvestidor) {
        novoInvestidor.setUsuarioDev(false);
        investidorRepository.save(novoInvestidor);
        repository.save(novoInvestidor);
        usuarios.add(novoInvestidor);
        listaObj.adiciona(novoInvestidor); //Lista Obj
        return ResponseEntity.status(201).build();
    }

    // Procuras
    @GetMapping("/procura") // Exibir todos os Usuarios (seja Dev ou Investidor)
    public ResponseEntity getTodosUsuarios() {
        List<Usuario> usuario = repository.findAll();
        listaObj.exibe(); //Lista Obj
        if (usuario.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(usuario);
    }

    @GetMapping("/procura/{id}") // Exibir os dados por um id especifico
    public ResponseEntity getUsuarioPorId(@PathVariable Integer id) {
        listaObj.getElemento(id - 1);
        if (repository.findById(id).isEmpty()) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.of(repository.findById(id));
    }

    // Vai servir como registro de dados até mesmo apagados
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

    // Deletar o usuário
    @DeleteMapping("/deleta/{id}") // Deletar a conta do usuário
    public ResponseEntity deleteUsuario(@PathVariable int id) {
        listaObj.removerPeloIndice(id - 1);
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    // Atualizar os usuários
    @PutMapping("/atualiza-dev/{id}") // Atualizar os dados do perfil de Dev
    public ResponseEntity putDev(@PathVariable Integer id, @RequestBody Dev devAlterado) {
        if (repository.existsById(id)) {
            devAlterado.setId(id);
            repository.save(devAlterado);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/atualiza-investidor/{id}") // Atualizar os dados do perfil de Dev
    public ResponseEntity putInvestidor(@PathVariable Integer id, @RequestBody Investidor investidorAlterado) {
        if (repository.existsById(id)) {
            investidorAlterado.setId(id);
            repository.save(investidorAlterado);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping("/login-dev")
    public ResponseEntity login(@RequestBody Dev devInserido) {
        Dev dev = repository.findByEmailAndSenha(devInserido.getEmail(), devInserido.getSenha());
        if (dev == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(dev);
    }

    @PostMapping("/login-investidor")
    public ResponseEntity login(@RequestBody Investidor investidorInserido) {
        Investidor investidor = investidorRepository.findByEmailAndSenha(investidorInserido.getEmail(),
                investidorInserido.getSenha());
        if (investidor == null) {
            return ResponseEntity.status(404).build();
        }
        return ResponseEntity.status(200).body(investidor);
    }

    @PatchMapping("/logoff-investidor/{id}") // Atualizar os dados do perfil de Dev
    public ResponseEntity logoffInvestidor(@PathVariable Integer id) {
        Optional<Usuario> usuarioOptional = repository.findById(id);
        // Usuario u = null;
        if (usuarioOptional.isEmpty()) { // Usuário está nulo, no caso ele não encontrou
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

    @PatchMapping("/login-dev/{id}") // Atualizar os dados do perfil de Dev
    public ResponseEntity loginDev(@PathVariable Integer id) {
        Optional<Usuario> usuarioOptional = repository.findById(id);
        //Usuario u = null;
        if (usuarioOptional.isEmpty()) { // Usuário está nulo, no caso ele não encontrou
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

    @PatchMapping("/logoff-dev/{id}") // Atualizar os dados do perfil de Dev
    public ResponseEntity logoffDev(@PathVariable Integer id, Dev devAlterado) {
        Optional<Usuario> usuarioOptional = repository.findById(id);
        // Usuario u = null;
        if (usuarioOptional.isEmpty()) { // Usuário está nulo, no caso ele não encontrou
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

    @PostMapping("/publicar/{idUsuario}") // Cadastro de uma publicacao
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

    @GetMapping("/procura-todas-publicacoes") // Exibe todas as publicações
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

    @GetMapping("exibir-ultimos-projetos")
    public ResponseEntity ultimasPublicacoes() {
        List<Publicacao> publicacaoList = publicacaoRepository.findAll();
        PilhaObj<Publicacao> pilhaPublicacoes = new PilhaObj<>(publicacaoList.size()); // Pilha Obj
        Integer contador = 0;
        for (Publicacao listaProvisoria : publicacaoList) {
            pilhaPublicacoes.push(listaProvisoria);
        }
        publicacaoList.removeAll(publicacaoList);
        while (contador < 3) {
            publicacaoList.add(pilhaPublicacoes.pop());
            contador++;
        }
        contador = 0;
        if (publicacaoList.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(publicacaoList);
    }

    @GetMapping("/publicacoes-do-usuario/{idUsuario}")
    public ResponseEntity exibirPublicacoesDoUsuario(@PathVariable Integer idUsuario) {
        List<Publicacao> listaPublicacao = publicacaoRepository.findAll();
        FilaObj<Publicacao> filaPublicacoes = new FilaObj<>(listaPublicacao.size());
        for (Publicacao listaProvisoria : listaPublicacao) {
            if (listaProvisoria.getDev().getId().equals(idUsuario)) {
                filaPublicacoes.insert(listaProvisoria);
            }
        }
        listaPublicacao.removeAll(listaPublicacao);
        while (!filaPublicacoes.isEmpty()) {
            listaPublicacao.add(filaPublicacoes.poll());
        }
        if (listaPublicacao.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(listaPublicacao);
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
        List<Usuario> exportacao = repository.findAll();
        System.out.printf("%-6s;%-45s;%-45s;%-10s;\n", "ID", "NOME", "E-MAIL", "SENHA");
        gravaArquivoTxt(exportacao, "Usuarios.txt");
        return ResponseEntity.status(200).build();
    }

    public static void gravaRegistro(String registro, String nomeArq) {
        BufferedWriter saida = null;    // Objeto usado para gravar no arquivo

        // Abre o arquivo
        try {
            // Abre o arquivo com append = true, para poder ir acrescentando registros no arquivo
            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: " + erro.getMessage());
        }

        // Grava o registro e fecha o arquivo
        try {
            saida.append(registro + "\n");  // Grava o registro e o final de registro (\n)
            saida.close();                  // Fecha o arquivo
        } catch (IOException erro) {
            System.out.println("Erro ao gravar no arquivo: " + erro.getMessage());
        }
    }

    public static void gravaArquivoTxt(List<Usuario> lista, String nomeArq) {
        int contaRegDados = 0;      // Contador de registros de dados (para poder gravar no trailer)

        // Monta o registro de header
        String header = "00USUARIOS";
        Date dataDeHoje = new Date();       // Data e hora do momento, no formato padrão do Java
        SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");     // configura o padrão de formatação da data e horário
        header += formataData.format(dataDeHoje);   // Formata a data e hora para o padrão desejado
        header += "01";

        // Grava o header
        gravaRegistro(header, nomeArq);

        // Monta e grava o corpo do arquivo
        for (Usuario usuario : lista) {
            String corpo = "02";
            corpo += String.format("%-3.5s", usuario.getId());
            corpo += String.format("%-20.8s", usuario.getNome());
            corpo += String.format("%-40.40s", usuario.getEmail());
            corpo += String.format("%-40.40s", usuario.getSenha());
            // Incrementa o contador de registro de dados
            contaRegDados++;
            // Grava o registro de corpo no arquivo
            gravaRegistro(corpo, nomeArq);
        }

        // Monta e grava o registro de trailer
        String trailer = "01";
        trailer += String.format("%010d", contaRegDados);   // contador de registros de dados
        gravaRegistro(trailer, nomeArq);

    }

    public static void leArquivoTxt(String nomeArq) {
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        String nome, email, senha;
        Integer id;
        int qtdRegistrosGravados;
        // int contaRegDados = 0; // vamos usar o size() da listaLida

        List<Usuario> listaLida = new ArrayList();
        List<ListaObj> listaLidaTeste = new ArrayList();

        // ListaObj <Usuario> listaObjLeitura = new ListaObj<>(100);

        // Abre o arquivo
        try {
            entrada = new BufferedReader(new FileReader(nomeArq));
        } catch (IOException erro) {
            System.out.println("Erro ao abrir o arquivo: " + erro.getMessage());
        }

        // Lê o arquivo
        try {
            // Lê o primeiro registro do arquivo
            registro = entrada.readLine();
            while (registro != null) { // Enquanto não chegou ao fim do arquivo
                tipoRegistro = registro.substring(0, 2);
                if (tipoRegistro.equals("00")) {
                    System.out.println("Eh um registro de header");
                    System.out.println("Tipo de arquivo: " + registro.substring(2, 6));
                    System.out.println("Data: " + registro.substring(6, 11));
                    System.out.println("Data/hora de gravação: " + registro.substring(11, 30));
                } else if (tipoRegistro.equals("01")) {
                    System.out.println("Eh um registro de trailer");
                    qtdRegistrosGravados = Integer.valueOf(registro.substring(2, 12));
                    listaLida.size();
                    if (qtdRegistrosGravados == listaLida.size()) {
                        System.out.println("Quantidade de registros gravados compatível com quantidade lida");
                    } else {
                        System.out.println("Quantidade de registros gravados não confere com quantidade lida");
                    }
                } else if (tipoRegistro.equals("02")) {
                    System.out.println("Eh um registro de corpo");
                    id = Integer.valueOf(registro.substring(2, 5));   // O trim() remove os brancos à direita
                    nome = registro.substring(5, 25);
                    email = registro.substring(25, 45).trim();
                    senha = registro.substring(45, 65).trim();
                    List<Usuario> listatest = new ArrayList<>();
                    listatest.add(new Usuario(id, nome, email, senha) {
                        @Override
                        public void reagirPublicacao(Integer idBuscarPublicacao) {
                        }

                        @Override
                        public void reagirPublicacao(Integer idBuscarPublicacao, List<Publicacao> list) {
                        }
                    });
                    for (Usuario usuario : listatest) {
                        listaLida.add(usuario);
                    }
                    // contaRegDados++;
                } else {
                    System.out.println("Tipo de registro inválido!");
                }
                // Lê o próximo registro
                registro = entrada.readLine();
            }
            entrada.close();    // Fecha o arquivo
        } catch (IOException erro) {
            System.out.println("Erro ao ler o arquivo: " + erro.getMessage());
        }
        // Exibe o conteúdo da listaLida
        System.out.println("\nConteúdo lido do arquivo:");
        for (Usuario usuario : listaLida) {
            System.out.println(usuario);
        }
    }
}