package br.com.bandtec.projeto2work;

import java.util.ArrayList;
import java.util.List;

public class Dev extends Usuario {

    // Atributos
    private String especialidade;
    private Integer quantidadeTotalPublicacoes;
    List<Publicacao> listaPublicacao;

    // Construtor
    public Dev(String nome, String email, String senha, String cpf, Boolean onlineStatus, Boolean usuarioDev, String especialidade) {
        super(nome, email, senha, cpf, onlineStatus, usuarioDev);
        this.especialidade = especialidade;
        this.quantidadeTotalPublicacoes = 0;
        listaPublicacao = new ArrayList<>();
    }

    // Métodos
    public void publicar() {
        setQuantidadeTotalPublicacoes(quantidadeTotalPublicacoes + 1); // Está setando 1 a quantidade total de publicaçoes
        Publicacao p = new Publicacao(quantidadeTotalPublicacoes);
        listaPublicacao.add(p);
        System.out.println("Adicionado a Publicação:" + quantidadeTotalPublicacoes);
    }

    public void removerPublicacao(Integer idPublicacao) {
        Boolean encontrouPublicacao = false; // Verifica se esse id da Publicação realmente existe
        for (Publicacao publicacao : listaPublicacao) {
            if (publicacao.getIdPublicacao().equals(idPublicacao)) { // Está verificando se existe esse ID
                listaPublicacao.remove(publicacao);
                encontrouPublicacao = true;
                System.out.println("Publicacao removida!");
            }
        }
        if (encontrouPublicacao.equals(false)) { // Caso não encontre nada, retornará essa mensagem.
            System.out.println("Publicação não existe!");
        }
    }

    @Override
    public void reagirPublicacao(Integer idBuscarPublicacao) {
        Boolean encontrouPublicacao = false; // Verifica se esse id da Publicação realmente existe
        for (Publicacao publicacao : listaPublicacao) { // Percorre a lista de todas Publicações
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

    @Override
    public void reagirPublicacao(Integer idBuscarPublicacao, List<Publicacao> list) {

    }

    @Override
    public String toString() {
        return super.toString() +
                "Dev{" +
                "especialidade='" + especialidade + '\'' +
                '}';
    }

    // Getters e Setters
    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public Integer getQuantidadeTotalPublicacoes() {
        return quantidadeTotalPublicacoes;
    }

    public void setQuantidadeTotalPublicacoes(Integer quantidadeTotalPublicacoes) {
        this.quantidadeTotalPublicacoes = quantidadeTotalPublicacoes;
    }

    public List<Publicacao> getListaPublicacao() {
        return listaPublicacao;
    }

    public void setListaPublicacao(List<Publicacao> listaPublicacao) {
        this.listaPublicacao = listaPublicacao;
    }
}