package br.com.bandtec.projeto2work;

public class Publicacao {

    // Atributos
    private Integer idPublicacao;
    private Integer totalInteracao;

    // Construtor
    public Publicacao(Integer idPublicacao) {
        this.idPublicacao = idPublicacao;
        this.totalInteracao = 0;
    }

    public Integer getIdPublicacao() {
        return idPublicacao;
    }

    public Integer getTotalInteracao() {
        return totalInteracao;
    }

    public void setTotalInteracao(Integer totalInteracao) {
        this.totalInteracao = totalInteracao;
    }
}