package br.com.work.ToWork.Spring.boot.controlador;

import br.com.work.ToWork.Spring.boot.dominio.Dev;
import br.com.work.ToWork.Spring.boot.dominio.Investidor;
import br.com.work.ToWork.Spring.boot.dominio.Usuario;
import br.com.work.ToWork.Spring.boot.listaObj.ListaObj;
import br.com.work.ToWork.Spring.boot.repositorio.ToWorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/2work")
public class UsuarioControllerJPA {

    List<Usuario> usuarios = new ArrayList<>();
    ListaObj<Usuario> listaObj = new ListaObj<>(100); // Lista Obj

    @Autowired
    private ToWorkRepository repository;

    // Cadastro
    @PostMapping("/cadastrar-dev") // Cadastro de um usuário Dev
    public ResponseEntity postUsuarioDev(@RequestBody Dev novoDev) {
        repository.save(novoDev);
        usuarios.add(novoDev);
        listaObj.adiciona(novoDev); // Lista Obj
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/cadastrar-investidor") // Cadastro de um usuário Dev
    public ResponseEntity postUsuarioInvestidor(@RequestBody Investidor novoInvestidor) {
        repository.save(novoInvestidor);
        usuarios.add(novoInvestidor);
        listaObj.adiciona(novoInvestidor); // Lista Obj
        return ResponseEntity.status(201).build();
    }

    // Procuras
    @GetMapping("/procura") // Exibir todos os Usuarios (seja Dev ou Investidor)
    public ResponseEntity getTodosUsuarios() {
        List<Usuario> usuario = repository.findAll();
        listaObj.exibe(); // Lista Obj
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
        List<Usuario> usuariosFiltrados = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().equals(nome)) {
                usuariosFiltrados.add(usuario);
            }
        }
        Iterator<Usuario> iterator = usuariosFiltrados.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            return ResponseEntity.status(200).body(usuariosFiltrados);
        }
        return ResponseEntity.status(204).build();
    }

    // Deletar o usuário
    @DeleteMapping("deleta/{id}") // Deletar a conta do usuário
    public ResponseEntity deleteUsuario(@PathVariable int id) {
        listaObj.removerPeloIndice(id - 1);
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    // Atualizar os usuários
    @PatchMapping("atualiza-dev/{id}") // Atualizar os dados do perfil de Dev
    public ResponseEntity patchDev(@PathVariable Integer id, @RequestBody Dev devAlterado) {
        if (repository.existsById(id)) {
            devAlterado.setId(id);
            repository.save(devAlterado);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PatchMapping("atualiza-investidor/{id}") // Atualizar os dados do perfil de Dev
    public ResponseEntity patchInvestidor(@PathVariable Integer id, @RequestBody Investidor investidorAlterado) {
        if (repository.existsById(id)) {
            investidorAlterado.setId(id);
            repository.save(investidorAlterado);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    // Login e Logoff
    @PatchMapping("login-investidor/{id}") // Atualizar os dados do perfil de Dev
    public ResponseEntity loginInvestidor(@PathVariable Integer id, Investidor investidorAlterado) {
        if (repository.existsById(id)) {
            investidorAlterado.setId(id);
            investidorAlterado.setOnlineStatus(true);
            repository.save(investidorAlterado);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PatchMapping("logoff-investidor/{id}") // Atualizar os dados do perfil de Dev
    public ResponseEntity logoffInvestidor(@PathVariable Integer id, Investidor investidorAlterado) {
        if (repository.existsById(id)) {
            investidorAlterado.setId(id);
            investidorAlterado.setOnlineStatus(false);
            repository.save(investidorAlterado);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PatchMapping("login-dev/{id}") // Atualizar os dados do perfil de Dev
    public ResponseEntity loginDev(@PathVariable Integer id, Dev devAlterado) {
        if (repository.existsById(id)) {
            devAlterado.setId(id);
            devAlterado.setOnlineStatus(true);
            repository.save(devAlterado);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PatchMapping("logoff-dev/{id}") // Atualizar os dados do perfil de Dev
    public ResponseEntity logoffDev(@PathVariable Integer id, Dev devAlterado) {
        if (repository.existsById(id)) {
            devAlterado.setId(id);
            devAlterado.setOnlineStatus(false);
            repository.save(devAlterado);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("exportar-registro/")
    public ResponseEntity exportarRegistro() {
    }
}