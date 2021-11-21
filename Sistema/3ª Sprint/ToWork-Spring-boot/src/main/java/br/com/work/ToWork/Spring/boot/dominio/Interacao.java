package br.com.work.ToWork.Spring.boot.dominio;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
public class Interacao{

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInteracao;
    private ZonedDateTime dataInteracao;
    private String nomeDeQuemInteragiu;
    @ManyToOne
    private Publicacao publicacao;
    private String Comentario;

    //Construtor

    /*public Interacao(String nome, String email, String senha, String cpf, String especialidade, Integer idPublicacao, Integer totalInteracao, Integer idInteracao, String nomeDeQuemInteragiu) {
        super(nome, email, senha, cpf, especialidade, idPublicacao, totalInteracao);
        this.idInteracao = idInteracao;
        this.nomeDeQuemInteragiu = nomeDeQuemInteragiu;
    }*/


    //Métodos


    public Integer getIdInteracao() {
        return idInteracao;
    }

    public void setIdInteracao(Integer idInteracao) {
        this.idInteracao = idInteracao;
    }

    public ZonedDateTime getDataInteracao() {
        return dataInteracao;
    }

    public void setDataInteracao(ZonedDateTime dataInteracao) {
        this.dataInteracao = dataInteracao;
    }

    public String getNomeDeQuemInteragiu() {
        return nomeDeQuemInteragiu;
    }

    public void setNomeDeQuemInteragiu(String nomeDeQuemInteragiu) {
        this.nomeDeQuemInteragiu = nomeDeQuemInteragiu;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String comentario) {
        Comentario = comentario;
    }
}
