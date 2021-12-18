package br.com.bandtec.projeto2work;

import java.util.List;

public abstract class Usuario {

    // Atributos
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private Boolean usuarioDev;
    private Boolean onlineStatus;

    public Usuario(String nome, String email, String senha, String cpf, Boolean usuarioDev, Boolean onlineStatus) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.cpf = cpf;
        this.usuarioDev = usuarioDev;
        this.onlineStatus = onlineStatus;
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
}