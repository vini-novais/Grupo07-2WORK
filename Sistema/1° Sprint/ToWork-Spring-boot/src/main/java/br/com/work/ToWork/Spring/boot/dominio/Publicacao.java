package br.com.work.ToWork.Spring.boot.dominio;

public class Publicacao extends Dev {

    // Atributos
    private Integer idPublicacao;
    private Integer totalInteracao;

    // Métodos
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