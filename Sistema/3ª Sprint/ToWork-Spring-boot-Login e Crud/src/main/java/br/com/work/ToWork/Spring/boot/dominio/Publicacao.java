package br.com.work.ToWork.Spring.boot.dominio;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;

@Entity
public class Publicacao {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPublicacao;
    private String tituloPublicacao;
    private ZonedDateTime dataPublicacao;
    private SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    private String descricaoPublicacao;
    @ManyToOne
    private Dev dev;
    private Integer totalInteracao;

    public Publicacao() {
    }

    // Métodos
    public String dataFormatada(ZonedDateTime zonedDateTime) {
        return formatador.format(zonedDateTime);
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