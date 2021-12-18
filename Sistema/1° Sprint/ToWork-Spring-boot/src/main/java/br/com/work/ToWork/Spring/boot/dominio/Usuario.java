package br.com.work.ToWork.Spring.boot.dominio;

import javax.persistence.*;
import java.util.List;

@Entity
//@MappedSuperclass - Anotação responsável por fazer com que funcione a relação de Hierarquia
//Fazendo com que se crie somente as tabelas para os filhos
@Inheritance(strategy = InheritanceType.JOINED) //Com isso será feito o papel da MappedSuperclass mas
//chaves estrangeiras
public abstract class Usuario {

    // Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private Boolean usuarioDev;
    private Boolean onlineStatus;

    // Construtor
    public Usuario(String nome, String email, String senha, String cpf) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.usuarioDev = false;
        this.onlineStatus = false;
    }

    public Usuario() { // Para funcionamento do Get entre classe abstrata e concreta se usa esse "Construtor Defaut"
    }

    // Métodos
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public Boolean getOnlineStatus() {
        return onlineStatus;
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

    public Boolean getUsuarioDev() {
        return usuarioDev;
    }

    public void login() {
        this.onlineStatus = true;
    }

    public void logoff() {
        this.onlineStatus = false;
    }

    public void setOnlineStatus(Boolean onlineStatus) {
        this.onlineStatus = onlineStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}