package br.com.bandtec.projeto2work;

import java.util.List;

public class Investidor extends Usuario {

    // Atributos
    private String cnpj;

    // Construtor
    public Investidor(String nome, String email, String senha, String cpf, Boolean onlineStatus, Boolean usuarioDev, String cnpj) {
        super(nome, email, senha, cpf, onlineStatus, usuarioDev);
        this.cnpj = cnpj;
    }

    @Override
    public void reagirPublicacao(Integer idBuscarPublicacao) {

    }

    @Override
    public String toString() {
        return super.toString() +
                "Investidor{" +
                "cnpj='" + cnpj + '\'' +
                '}';
    }

    // Métodos
    @Override
    public void reagirPublicacao(Integer idBuscarPublicacao, List<Publicacao> list) {
        Boolean encontrouPublicacao = false; // Verifica se esse id da Publicação realmente existe
        for (Publicacao publicacao : list) { // Percorre a lista de todas Publicações
            if (idBuscarPublicacao == publicacao.getIdPublicacao()) { // Se encontrar a Publicação
                System.out.println("Achou a Publicação:" + idBuscarPublicacao); // Nos informa que achou
                encontrouPublicacao = true; // Atribua o valor de verdadeiro caso encontre a publicação
                Interacao novaInteracao = new Interacao(publicacao.getIdPublicacao(),
                        publicacao.getTotalInteracao() + 1, super.getNome()); // Simplificadamente ele adiciona um objeto de reação
                publicacao.setTotalInteracao(publicacao.getTotalInteracao() + 1); // Isso aqui é para aumentar 1 no valor do objeto de torais de interação
                System.out.println("Você foi a " + publicacao.getTotalInteracao() + " pessoa que reagiu a publicação");
            }
        }
        if (encontrouPublicacao.equals(false)) { // Caso não encontre nada, retornará essa mensagem.
            System.out.println("Publicação não existe!");
        }
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}