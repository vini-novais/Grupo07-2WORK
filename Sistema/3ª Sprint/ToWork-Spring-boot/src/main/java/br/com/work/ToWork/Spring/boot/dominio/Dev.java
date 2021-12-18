package br.com.work.ToWork.Spring.boot.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Dev extends Usuario {

    // Atributos
    private String especialidade;
    private String planoUsuario;
    private Integer totalPublicacoes = 0;
    private Integer publicacoesCurtidas = 0;
    private Integer totalVisualizacoes = 0;

    @JsonIgnore // será ignorado no JSON
    @Column(length = 2_000_000) // 20MB
    private byte[] foto;

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

    public Integer getTotalPublicacoes() {
        return totalPublicacoes;
    }

    public void setTotalPublicacoes(Integer totalPublicacoes) {
        this.totalPublicacoes = totalPublicacoes;
    }

    public Integer getPublicacoesCurtidas() {
        return publicacoesCurtidas;
    }

    public void setPublicacoesCurtidas(Integer publicacoesCurtidas) {
        this.publicacoesCurtidas = publicacoesCurtidas;
    }

    public String getPlanoUsuario() {
        return planoUsuario;
    }

    public void setPlanoUsuario(String planoUsuario) {
        this.planoUsuario = planoUsuario;
    }

    public Integer getTotalVisualizacoes() {
        return totalVisualizacoes;
    }

    public void setTotalVisualizacoes(Integer totalVisualizacoes) {
        this.totalVisualizacoes = totalVisualizacoes;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}