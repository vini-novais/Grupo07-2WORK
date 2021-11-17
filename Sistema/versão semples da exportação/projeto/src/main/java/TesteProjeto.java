import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TesteProjeto {

    public static void gravaReg(String registro, String nomeArq) {


        //versão 01

        BufferedWriter saida = null;

        try {

            saida = new BufferedWriter(new FileWriter(nomeArq, true));
        }
        catch (IOException erro) {
            System.out.println("Erro ao tentar abrir o arquivo: " + erro.getMessage());
        }


        try {
            saida.append(registro + "\n");
            saida.close();
        }
        catch (IOException erro) {
            System.out.println("Erro ao gravar informações no arquivo: " + erro.getMessage());
        }
    }

    public static void gravaArquivoTxt(List<Usuario> lista, String nomeArq) {
        int contaRegistroDeDados = 0;

        String header = "00DEVS20212";
        Date dataDeHoje = new Date();
        SimpleDateFormat formataData = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        header += formataData.format(dataDeHoje);
        header += "01";

        gravaReg(header, nomeArq);

        for (Usuario usuario : lista) {
            String corpo = "02";
            corpo += String.format("%-50.50s",usuario.getNome());
            corpo += String.format("%11s",usuario.getCpf());
            corpo += String.format("%-50.50s",usuario.getEmail());
            corpo += String.format("%-40.40s",usuario.getSenha());

            contaRegistroDeDados++;

            gravaReg(corpo, nomeArq);
        }

        String trailer = "01";
        trailer += String.format("%010d", contaRegistroDeDados);
        gravaReg(trailer, nomeArq);

    }

    public static void leArquivoTxt(String nomeArq) {
        BufferedReader entrada = null;
        String registro, tipoRegistro;
        String nome, email, senha, cpf;
        int qtdRegistrosGravados;

        List<Usuario> listaLida = new ArrayList();

        try {
            entrada = new BufferedReader(new FileReader(nomeArq));
        }
        catch (IOException erro) {
            System.out.println("Erro ao tentar abrir o arquivo: " + erro.getMessage());
        }

        try{

            registro = entrada.readLine();

            while (registro != null) {

                tipoRegistro = registro.substring(0, 2);

                if (tipoRegistro.equals("00")) {
                    System.out.println("HEADER");
                    System.out.println("Tipo de arquivo: "+registro.substring(2,6));
                    System.out.println("Data de inicialização: "+registro.substring(6,11));
                    System.out.println("Data/hora de gravação: "+registro.substring(11,30));
                    System.out.println("Versão do documento: "+registro.substring(30,32));
                }
                else  if (tipoRegistro.equals("01")) {
                    System.out.println("TRAILER");
                    qtdRegistrosGravados = Integer.valueOf(registro.substring(2, 12));
                    if (qtdRegistrosGravados == listaLida.size()) {
                        System.out.println("Quantidade de registros é gravados compatível com quantidade lida");
                    }
                    else {
                        System.out.println("Quantidade de registros gravados não confere com quantidade lida");
                    }
                }
                else  if (tipoRegistro.equals("02")) {
                    System.out.println("CORPO");
                    nome = registro.substring(50,51).trim();
                    cpf = registro.substring(51,62);
                    email = registro.substring(62,105).trim();
                    senha = registro.substring(105,120).trim();
                    Usuario a1 = new Usuario("João", "joao@gmail.com", "super", "444.444.444-90", true){
                        @Override
                        public void reagirPublicacao(Integer idBuscarPublicacao) {
                        }
                        @Override
                        public void reagirPublicacao(Integer idBuscarPublicacao, List<Publicacao> list) {
                        }
                    };

                    listaLida.add(a1);

                }
                else {
                    System.out.println("Tipo de registro inválido");
                }

                registro = entrada.readLine();

            }
            entrada.close();
        }
        catch (IOException erro) {
            System.out.println("Erro ao tentar ler o arquivo: " + erro.getMessage());
        }

        System.out.println("\nConteúdo lido do arquivo:");
        for (Usuario usuario : listaLida) {
            System.out.println(usuario);
        }
    }

    public static void main(String[] args) {



        Dev testeDev = new Dev("João",
                "joao@gmail.com",
                "joao123",
                "11122233344",
                true,
                "FullStatck");

        // Exibir o Usuário de Dev
        System.out.println(testeDev);

        // Teste a respeito de publicar uma nova publicação
        testeDev.publicar();
        testeDev.publicar();
        testeDev.publicar();

        // Teste de remover uma publicação
        testeDev.removerPublicacao(2);

        // Reagir publicação
        testeDev.reagirPublicacao(3);
        testeDev.reagirPublicacao(2);
        testeDev.reagirPublicacao(3);
        testeDev.reagirPublicacao(1);

        //Começando o teste do investidor
        System.out.println("------------------------------");
        System.out.println("Testando o investidor");

        //Criando o objeto do investidor
        Investidor testeInvestidor = new Investidor("Pedro",
                "pedro@gmail.com",
                "pedro123",
                "00011122233",
                false,
                "12345678910111");

        //Teste de reação a uma publicação
        testeInvestidor.reagirPublicacao(3, testeDev.getListaPublicacao());
        testeInvestidor.reagirPublicacao(1, testeDev.getListaPublicacao());

        // Criando sistema
        System.out.println("------------------------------");
        System.out.println("Testando o sistema");
        System.out.println("");

        //Criação do objeto Sistema
        Sistema sistema = new Sistema();

        //Teste de Cadastro
        sistema.cadastrar(testeInvestidor);
        sistema.cadastrar(testeDev);

        //Teste de alteração de dados do Dev
        sistema.alterarDados("11122233344", "00011122255", "joao@gmeil.com", "joao",
                "joao4321", null,"aaaaaaaa");

        //Teste de exibição de dados
        sistema.exibirDados("00011122233");

        //Teste de login
        sistema.login(testeDev);

        //Teste de exclusão de usuario
        sistema.excluir(testeDev);

        //Teste de alteração de dados do investidor
        sistema.alterarDados("11122233344", "00011122255", "joao@gmeil.com", "joao",
                "joao4321", "FullStack",null);

        //Teste de logoff
        sistema.logoff(testeDev);
    }
}
