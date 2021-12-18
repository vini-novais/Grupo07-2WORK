package br.com.work.ToWork.Spring.boot.dominio;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Interacao {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idInteracao;
    private LocalDateTime dataInteracao;
    private String nomeDeQuemInteragiu;

    @ManyToOne
    private Publicacao publicacao;
    private String Comentario;

    // Métodos
    public Integer getIdInteracao() {
        return idInteracao;
    }

    public void setIdInteracao(Integer idInteracao) {
        this.idInteracao = idInteracao;
    }

    public LocalDateTime getDataInteracao() {
        return dataInteracao;
    }

    public void setDataInteracao(LocalDateTime dataInteracao) {
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