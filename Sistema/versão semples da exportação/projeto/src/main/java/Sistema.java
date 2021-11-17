import java.util.ArrayList;
import java.util.List;

public class Sistema {

    //Atributos
    List<Usuario> listaUsuario;

    //Construtor
    public Sistema() {
        this.listaUsuario = new ArrayList<>();
    }

    //Métodos
    public void login(Usuario usuario) {
        System.out.println("Usuário " + usuario.getNome() + " está logado");//Exibe no console que logou
    }
    public void logoff(Usuario usuario) {
        System.out.println("Usuário " + usuario.getNome() + " está deslogado");//Exibe no console que deslogou
    }

    public void excluir(Usuario usuario){
        listaUsuario.remove(usuario);//Exclui o usuário
        System.out.println("Usuário " + usuario.getNome() +" removido!");//Exibe no console que o usuário foi removido
    }
    public void cadastrar(Usuario usuario) {
        listaUsuario.add(usuario);//Adicionar o usuário na lista
    }

    public void exibirDados(String cpfUsuario) {
        for (Usuario usuario : listaUsuario) {//está lendo toda a lista
            if (cpfUsuario == usuario.getCpf()){//procurando um usuário que tenha o CPF solicitado no argumento do método
                System.out.println(usuario);//Exibir os dados de quem foi encontrado
                break;
            }
        }
    }

    public void alterarDados(String cpfUsuario,String novoCpf,String email, String nome, String senha, String especialidade, String cnpj){
        for (Usuario usuario : listaUsuario){//Irá ler a lista até o final
            if (usuario instanceof Dev){//Se o usuário for da classe Dev
                alterarDadosDev(cpfUsuario,novoCpf,email,nome,senha,especialidade);//chamar o método alterarDadosDev
            }else{
                alterarDadosInvestidor(cpfUsuario,novoCpf,email,nome,senha,cnpj);//chamar o método alterarDadosInvestidor
            }
            break;//Finaliza o laço após alterar
        }
    }

    public void alterarDadosDev(String cpfUsuario,String novoCpf,String email, String nome, String senha, String especialidade) {
        Boolean usuarioEncontrado = false;//Variável para dizer se encontrou ou não o usuário;
        for (Usuario usuario : listaUsuario) {//Percorrerá a lista até o final
            if(usuario.getCpf() == cpfUsuario){//Verifica a igualdade entre os CPF's
                listaUsuario.remove(usuario);//Remove o usuário da lista
                Dev novoDev = new Dev(nome,email,senha,novoCpf,true,especialidade);//Cria um usuário novo na lista
                listaUsuario.add(novoDev);//Adiciona na lista
                usuarioEncontrado = true;//Seta true para a variável de verificação
                System.out.println("Usuário atualizado!");//Exibir no console que o usuário foi atualizado
                System.out.println(novoDev);//Exibir o usuário no console
                break;// Parar o laço
            }
        }
        if (usuarioEncontrado.equals(false)){
            System.out.println("Usuário não encontrado");//Usuário não encontrado será exibido no console caso não encontre
        }
    }

    public void alterarDadosInvestidor(String cpfUsuario,String novoCpf,String email, String nome, String senha, String cnpj) {
        Boolean usuarioEncontrado = false;//Variável para dizer se encontrou ou não o usuário;
        for (Usuario usuario : listaUsuario) {//Percorrerá a lista até o final
            if(usuario.getCpf() == cpfUsuario){//Verifica a igualdade entre os CPF's
                listaUsuario.remove(usuario);//Remove o usuário da lista
                Investidor novoInvestidor = new Investidor(nome,email,senha,cpfUsuario,false,cnpj);//Cria um usuário novo na lista
                listaUsuario.add(novoInvestidor);//Adiciona na lista
                usuarioEncontrado = true;//Seta true para a variável de verificação
                System.out.println("Usuário atualizado!");//Exibir no console que o usuário foi atualizado
                System.out.println(novoInvestidor);//Exibir o usuário no console
                break;// Parar o laço
            }
        }
        if (usuarioEncontrado.equals(false)){
            System.out.println("Usuário não encontrado");//Usuário não encontrado será exibido no console caso não encontre
        }
    }

}
