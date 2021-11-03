package br.com.work.ToWork.Spring.boot.dominio;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
//@MappedSuperclass - Anotação responsável por fazer com que funcione a relação de Hierarquia
//Fazendo com que se crie somente as tabelas para os filhos
@Inheritance(strategy = InheritanceType.JOINED) //Com isso será feito o papel da MappedSuperclass mas
//chaves estrangeiras
public abstract class Usuario {

    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private String cidade;
    private String estado;
    private String telefone;
    private String biografia;
    private Date dataNascimento;
    private Boolean usuarioDev;
    private Boolean onlineStatus;

    //Construtor
    public Usuario(String nome, String email, String senha, String cpf, String cidade, String estado, String telefone, String biografia, Date dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.cidade = cidade;
        this.estado = estado;
        this.telefone = telefone;
        this.biografia = biografia;
        this.dataNascimento = dataNascimento;
        this.usuarioDev = false;
        this.onlineStatus = false;
    }

    public Usuario() { //Para funcionamento do Get entre classe abstrata e concreta se usa esse "Construtor Defaut"
    }

    //Métodos
    public abstract void reagirPublicacao(Integer idBuscarPublicacao);

    public abstract void reagirPublicacao(Integer idBuscarPublicacao, List<Publicacao> list);

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", cpf='" + cpf + '\'' +
                ", usuarioDev=" + usuarioDev +
                ", onlineStatus=" + onlineStatus +
                '}';
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Boolean getUsuarioDev() {
        return usuarioDev;
    }

    public void setUsuarioDev(Boolean usuarioDev) {
        this.usuarioDev = usuarioDev;
    }

    public Boolean getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(Boolean onlineStatus) {
        this.onlineStatus = onlineStatus;
    }
}
