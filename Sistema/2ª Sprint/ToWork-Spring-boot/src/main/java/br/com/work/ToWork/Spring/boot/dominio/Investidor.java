package br.com.work.ToWork.Spring.boot.dominio;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Investidor extends Usuario {

    // Atributos
    private String cnpj;

    // Construtor
    public Investidor(String nome, String email, String senha, String cpf, String cidade, String estado, String telefone, String biografia, Date dataNascimento, String cnpj) {
        super(nome, email, senha, cpf, cidade, estado, telefone, biografia, dataNascimento);
        this.cnpj = cnpj;
    }

    public Investidor() {
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
                "Investidor{" +
                "cnpj='" + cnpj + '\'' +
                '}';
    }

    public String getCnpj() {
        return cnpj;
    }

}