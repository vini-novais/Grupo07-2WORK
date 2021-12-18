package br.com.bandtec.projeto2work;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/2work")
public class App {

    List<Usuario> listaUsuario = new ArrayList<>();
    List<Dev> listaUsuarioDev = new ArrayList<>();
    List<Investidor> listaUsuarioInvestidor = new ArrayList<>();
    Sistema sistema = new Sistema();

    // Cadastrar os usuários no Sistema
    @GetMapping("/cadastrar-usuario/{cpf}/{nome}/{email}/{senha}/{usuarioDev}/{especialidade}/{cnpj}")
    public String cadastraUsuario(
            @PathVariable String cpf,
            @PathVariable String nome,
            @PathVariable String email,
            @PathVariable String senha,
            @PathVariable Boolean usuarioDev,
            @PathVariable String especialidade,
            @PathVariable String cnpj
    ) {
        if (usuarioDev.equals(true)) {
            Dev novoDev = new Dev(nome, email, senha, cpf, usuarioDev, false, especialidade);
            listaUsuario.add(novoDev);
            listaUsuarioDev.add(novoDev);
            System.out.println("---------------------------------");
            System.out.println("Novo desenvolvedor cadastrado!");
            return "O Dev " + novoDev.getNome() + " foi adicionado";
        } else {
            Investidor novoInvestidor = new Investidor(nome, email, senha, cpf, false, usuarioDev, cnpj);
            //sistema.cadastrar(novoInvestidor);
            listaUsuario.add(novoInvestidor);
            listaUsuarioInvestidor.add(novoInvestidor);
            System.out.println("---------------------------------");
            System.out.println("Novo investidor cadastrado!");
            return "O Investidor " + novoInvestidor.getNome() + " foi adicionado";
        }
    }

    // Alterar os dados do Dev
    @GetMapping("/alterar-dados-dev/{cpf}/{novoCpf}/{novoNome}/{novoEmail}/{novaSenha}/{novaEspecialidade}")
    public String alterarDadosDev(@PathVariable String cpf,
                                  @PathVariable String novoCpf,
                                  @PathVariable String novoNome,
                                  @PathVariable String novoEmail,
                                  @PathVariable String novaSenha,
                                  @PathVariable String novaEspecialidade) {
        Boolean usuarioEncontrado = false;
        Boolean usuarioLogado = true;
        String guardarNome = "";
        for (Dev dev : listaUsuarioDev) {
            if (dev.getCpf().equals(cpf)) {
                usuarioEncontrado = true;
                if (!dev.getOnlineStatus()) {
                    usuarioLogado = false;
                } else {
                    dev.setCpf(novoCpf);
                    dev.setEmail(novoEmail);
                    dev.setNome(novoNome);
                    dev.setSenha(novaSenha);
                    dev.setEspecialidade(novaEspecialidade);
                    System.out.println("---------------------------------");
                    System.out.println("Usuário dev atualizado!");
                    guardarNome = dev.getNome();
                    break;
                }
            }
        }
        if (!usuarioLogado) {
            return "Usuário não está logado!";
        }
        if (usuarioEncontrado.equals(false)) {
            System.out.println("---------------------------------");
            System.out.println("Usuário dev não encontrado");
            return "Usuário Dev não encontrado!";
        } else {
            return "Usuário " + guardarNome + " atualizado!";
        }
    }

    // Alterar os dados do investidor
    @GetMapping("/alterar-dados-investidor/{cpf}/{novoCpf}/{novoNome}/{novoEmail}/{novaSenha}/{novoCnpj}")
    public String alterarDadosInvestidor(@PathVariable String cpf,
                                         @PathVariable String novoCpf,
                                         @PathVariable String novoNome,
                                         @PathVariable String novoEmail,
                                         @PathVariable String novaSenha,
                                         @PathVariable String novoCnpj) {
        Boolean usuarioEncontrado = false;
        Boolean usuarioLogado = true;
        for (Investidor investidor : listaUsuarioInvestidor) {
            if (investidor.getCpf().equals(cpf)) {
                usuarioEncontrado = true;
                if (!investidor.getOnlineStatus()) {
                    usuarioLogado = false;
                } else {
                    investidor.setCpf(novoCpf);
                    investidor.setEmail(novoEmail);
                    investidor.setNome(novoNome);
                    investidor.setSenha(novaSenha);
                    investidor.setCnpj(novoCnpj);
                    System.out.println("---------------------------------");
                    System.out.println("Usuário investidor atualizado!");
                    break;
                }
            }
        }
        if (!usuarioLogado) {
            return "Usuário não está logado!";
        }
        if (usuarioEncontrado.equals(false)) {
            System.out.println("---------------------------------");
            System.out.println("Usuário investidor não encontrado");
            return "Usuário investidor não encontrado!";
        } else {
            return "Usuário alterado com sucesso!";
        }
    }

    // Exibir o usuário
    @GetMapping("/exibir-perfil-usuario/{cpf}")
    public List<Usuario> getUsuario(@PathVariable String cpf) {
        List<Usuario> usuarioEncontrado = listaUsuario.stream()
                .filter((listaUsuario) -> listaUsuario.getCpf().equals(cpf)).collect(Collectors.toList());

        if (usuarioEncontrado.isEmpty()) {
            System.out.println("---------------------------------");
            System.out.println("Usuário não encontrado!");
            return null;
        } else {
            return usuarioEncontrado;
        }
    }

    // Login Usuário
    @GetMapping("/login/{cpf}/{senha}")
    public String login(@PathVariable String cpf, @PathVariable String senha) {
        Boolean usuarioEncontrado = false;
        String guardarNome = "";
        for (Usuario usuario : listaUsuario) {
            if (usuario.getCpf().equals(cpf) && usuario.getSenha().equals(senha)) {
                usuario.login();
                usuarioEncontrado = true;
                System.out.println("---------------------------------");
                guardarNome = usuario.getNome();
                break;
            }
        }
        if (usuarioEncontrado) {
            System.out.println("Usuario " + guardarNome + " encontrado!");
            return "Usuario " + guardarNome + " está logado!";
        } else {
            System.out.println("Usuario não encontrado!");
            return "Usuario não encontrado!";
        }
    }

    // Logoff Usuário
    @GetMapping("/logoff/{cpf}/{senha}")
    public String logoff(@PathVariable String cpf, @PathVariable String senha) {
        Boolean usuarioEncontrado = false;
        String guardarNome = "";
        for (Usuario usuario : listaUsuario) {
            if (usuario.getCpf().equals(cpf) && usuario.getSenha().equals(senha)) {
                usuario.logoff();
                usuarioEncontrado = true;
                System.out.println("---------------------------------");
                guardarNome = usuario.getNome();
                break;
            }
        }
        if (usuarioEncontrado) {
            System.out.println("Usuario " + guardarNome + " encontrado!");
            return "Usuario " + guardarNome + " não está mais logado!";
        } else {
            System.out.println("Usuario não encontrado!");
            return "Usuario não encontrado!";
        }
    }

    // Remover o Usuário
    @GetMapping("/remover-usuario/{cpf}/{senha}")
    public String removerUsuario(@PathVariable String cpf, @PathVariable String senha) {
        Boolean usuarioEncontrado = false;
        Boolean usuarioLogado = true;
        String guardarNome = "";
        for (Usuario usuario : listaUsuario) {
            if (usuario.getCpf().equals(cpf) && usuario.getSenha().equals(senha)) {
                usuarioEncontrado = true;
                if (!usuario.getOnlineStatus()) {
                    usuarioLogado = false;
                } else {
                    listaUsuario.remove(usuario);
                    System.out.println("---------------------------------");
                    guardarNome = usuario.getNome();
                    break;
                }
            }
        }
        if (!usuarioLogado) {
            return "Usuário não está logado!";
        }
        if (usuarioEncontrado) {
            System.out.println("Usuario " + guardarNome + " encontrado!");
            return "Usuario " + guardarNome + " removido";
        } else {
            System.out.println("Usuario não encontrado!");
            return "Usuario não encontrado!";
        }
    }
}