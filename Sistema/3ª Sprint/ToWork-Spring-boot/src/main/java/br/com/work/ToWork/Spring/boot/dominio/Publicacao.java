package br.com.work.ToWork.Spring.boot.dominio;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Entity
public class Publicacao {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPublicacao;
    private String tituloPublicacao;
    private LocalDateTime dataPublicacao;
    @ManyToOne
    private Dev dev;
    @Column(length = 1000)
    private String descricaoPublicacao;
    private Integer totalInteracao = 0;
    private String urlImagem;

    public Publicacao() {
    }

    // Métodos
    public String dataFormatada(ZonedDateTime zonedDateTime) {
        SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
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

    public void setIdPublicacao(Integer idPublicacao) {
        this.idPublicacao = idPublicacao;
    }

    public String getTituloPublicacao() {
        return tituloPublicacao;
    }

    public void setTituloPublicacao(String tituloPublicacao) {
        this.tituloPublicacao = tituloPublicacao;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDateTime dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Dev getDev() {
        return dev;
    }

    public void setDev(Dev dev) {
        this.dev = dev;
    }

    public String getDescricaoPublicacao() {
        return descricaoPublicacao;
    }

    public void setDescricaoPublicacao(String descricaoPublicacao) {
        this.descricaoPublicacao = descricaoPublicacao;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }
}