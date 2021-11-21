package br.com.work.ToWork.Spring.boot.dominio;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Entity
public class Publicacao {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPublicacao;
    private String tituloPublicacao;
    private ZonedDateTime dataPublicacao;
    @ManyToOne
    private Dev dev;
    private String descricaoPublicacao;
    private Integer totalInteracao = 0;

    //Construtor
    /*public Publicacao(String nome, String email, String senha, String cpf, String cidade, String estado, String telefone, String biografia, String planoUsuario, ZonedDateTime dataNascimento, String especialidade, Integer quantidadeTotalPublicacoes, String tituloPublicacao, String descricaoPublicacao, Integer totalInteracao) {
        super(nome, email, senha, cpf, cidade, estado, telefone, biografia, planoUsuario, dataNascimento, especialidade, quantidadeTotalPublicacoes);
        this.tituloPublicacao = tituloPublicacao;
        this.dataPublicacao = ZonedDateTime.now(ZoneId.of("America,Recife"));
        this.descricaoPublicacao = descricaoPublicacao;
        this.totalInteracao = totalInteracao;
    }*/

    /*public Publicacao(String nome, String email, String senha, String cpf, String especialidade, Integer idPublicacao, Integer totalInteracao) {
        super(nome, email, senha, cpf, especialidade);
        this.idPublicacao = idPublicacao;
        this.totalInteracao = 0;
    }*/
    public Publicacao(){
    }

    //Métodos
    public String dataFormatada (ZonedDateTime zonedDateTime){
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

    public ZonedDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(ZonedDateTime dataPublicacao) {
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
}
