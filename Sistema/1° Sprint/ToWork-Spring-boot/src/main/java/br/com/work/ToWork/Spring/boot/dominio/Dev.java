package br.com.work.ToWork.Spring.boot.dominio;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Dev extends Usuario {

    // Atributos
    private String especialidade;
    private Integer quantidadeTotalPublicacoes;

    // Construtor
    public Dev(String nome, String email, String senha, String cpf, String especialidade) {
        super(nome, email, senha, cpf);
        this.especialidade = especialidade;
        this.quantidadeTotalPublicacoes = 0;
    }

    public Dev() {
        super();
    }

    @Override
    public void reagirPublicacao(Integer idBuscarPublicacao) {
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
}