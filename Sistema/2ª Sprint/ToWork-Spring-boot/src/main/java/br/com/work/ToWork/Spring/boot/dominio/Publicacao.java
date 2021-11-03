package br.com.work.ToWork.Spring.boot.dominio;

import javax.persistence.*;

public class Publicacao extends Dev {

    //Atributos
    private Integer idPublicacao;
    private Integer totalInteracao;

    //Construtor
    /*public Publicacao(String nome, String email, String senha, String cpf, String especialidade, Integer idPublicacao, Integer totalInteracao) {
        super(nome, email, senha, cpf, especialidade);
        this.idPublicacao = idPublicacao;
        this.totalInteracao = 0;
    }*/

    //Métodos
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
