package br.com.work.ToWork.Spring.boot.controlador;

import br.com.work.ToWork.Spring.boot.dominio.Dev;
import br.com.work.ToWork.Spring.boot.dominio.Investidor;
import br.com.work.ToWork.Spring.boot.dominio.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/2Work")
public class UsuarioController {

    /*List<Usuario> listaUsuario = new ArrayList<>(List.of(new Investidor("Luiz",
            "luiz123@gmail.com", "luiz1234", "00011122233", "00011122233344"),
            new Dev("João", "joao@gmail.com", "joao1234", "00011122244", "C#"))
            );*/
    List<Usuario> listaUsuario = new ArrayList<>();
    List<Dev> listaUsuarioDev = new ArrayList<>();
    /*private List<Investidor> listaUsuarioInvestidor = new ArrayList<>(List.of(new Investidor("Luiz",
            "luiz123@gmail.com", "luiz1234", "00011122233", "00011122233344")));*/

    //Checar todos usuários da nossa lista
    @GetMapping
    public List<Usuario> getUsuario() {
        return listaUsuario;
    }

    //Cadastrar os usuários no Sistema
    @PostMapping("/Cadastra-Investidor")
    public String cadastraInvestidor(@RequestBody Investidor investidor) {
        investidor.setId(investidor.getId());
        listaUsuario.add(investidor);
        return "Usuário " + investidor.getNome() + " cadastrado!";
    }
    @PostMapping("/Cadastra-Dev")
    public String cadastraDev(@RequestBody Dev dev) {
        dev.setId(dev.getId());
        listaUsuario.add(dev);
        return "Usuário " + dev.getNome() + " cadastrado!";
    }

    //Encontrar um usuário
    @GetMapping("/{id}")
    public Usuario getUsuario(@PathVariable Integer id){
        return listaUsuario.stream()
                .filter(listaUsuario -> listaUsuario.getId().equals(id))
                .findFirst().get();
    }

    //Deletar um usuário
    @DeleteMapping("/Deletar-Usuario/{id}")
    public String deleteUsuario(@PathVariable Integer id){
        listaUsuario.remove(getUsuario(id));
        return "Usuário excluido com sucesso";
    }

    //Atualizar os usuários
    /*@PutMapping("/Atualizar-Usuario/{id}")
    public  String putUsuario(@PathVariable Integer id,
                              @RequestBody Usuario usuarioAtualizado){
        if(getUsuario(id) instanceof  Investidor){
            putInvestidor(id, (Investidor) usuarioAtualizado);
            return "Investidor atualizado!";
        }else{
            putDev(id, (Dev) usuarioAtualizado);
            return "Dev atualizado!";
        }
    }*/
    @PutMapping("/Atualizar-Investidor/{id}")
    public String putInvestidor(@PathVariable Integer id,
                           @RequestBody Investidor investidorAtualizado){
        investidorAtualizado.setId(id);
        deleteUsuario(id);
        listaUsuario.add(investidorAtualizado);
        return "Investidor atualizado!";
    }
    @PutMapping("/Atualizar-Dev/{id}")
    public String putDev(@PathVariable Integer id,
                           @RequestBody Dev devAtualizado){
        devAtualizado.setId(id);
        deleteUsuario(id);
        listaUsuario.add(devAtualizado);
        return "Dev atualizado!";
    }
}
