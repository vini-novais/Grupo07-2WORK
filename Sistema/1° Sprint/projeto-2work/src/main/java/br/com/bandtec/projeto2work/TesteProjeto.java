package br.com.bandtec.projeto2work;

public class TesteProjeto {

    public static void main(String[] args) {
        // Teste de criação de objeto Dev
        Dev testeDev = new Dev("João",
                "joao@gmail.com",
                "joao123",
                "11122233344",
                true,
                false,
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

        // Começando o teste do investidor
        System.out.println("------------------------------");
        System.out.println("Testando o investidor");

        // Criando o objeto do investidor
        Investidor testeInvestidor = new Investidor("Pedro",
                "pedro@gmail.com",
                "pedro123",
                "00011122233",
                false,
                false,
                "12345678910111");

        // Teste de reação a uma publicação
        testeInvestidor.reagirPublicacao(3, testeDev.getListaPublicacao());
        testeInvestidor.reagirPublicacao(1, testeDev.getListaPublicacao());

        // Criando sistema
        System.out.println("------------------------------");
        System.out.println("Testando o sistema");
        System.out.println("");

        // Criação do objeto Sistema
        Sistema sistema = new Sistema();

        // Teste de Cadastro
        sistema.cadastrar(testeInvestidor);
        sistema.cadastrar(testeDev);

        // Teste de alteração de dados do Dev
        sistema.alterarDados("11122233344", "00011122255", "joao@gmeil.com", "joao",
                "joao4321", null, "aaaaaaaa");

        // Teste de exibição de dados
        sistema.exibirDados("00011122233");

        // Teste de login
        sistema.login(testeDev);

        // Teste de exclusão de usuario
        sistema.excluir(testeDev);

        // Teste de alteração de dados do investidor
        sistema.alterarDados("11122233344", "00011122255", "joao@gmeil.com", "joao",
                "joao4321", "FullStack", null);

        // Teste de logoff
        sistema.logoff(testeDev);
    }
}