package br.com.work.ToWork.Spring.boot.dominio;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Investidor extends Usuario {

    //Atributos
    private String cnpj;


    //Construtor
    public Investidor(String nome, String email, String senha, String cpf, String cidade, String estado, String telefone, String biografia, String planoUsuario, ZonedDateTime dataNascimento, String cnpj) {
        super(nome, email, senha, cpf, cidade, estado, telefone, biografia, planoUsuario, dataNascimento);
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

    //Métodos
    /*@Override
    public void reagirPublicacao(Integer idBuscarPublicacao, List<Publicacao> list){
        Boolean encontrouPublicacao = false; //Verifica se esse id da Publicação realmente existe
        for (Publicacao publicacao : list){ //Percorre a lista de todas Publicações
            if (idBuscarPublicacao == publicacao.getIdPublicacao()){ // Se encontrar a Publicação
                System.out.println("Achou a Publicação:" + idBuscarPublicacao); // Nos informa que achou
                encontrouPublicacao = true; // Atribua o valor de verdadeiro caso encontre a publicação
                Interacao novaInteracao = new Interacao(publicacao.getIdPublicacao(),
                        publicacao.getTotalInteracao()+1, super.getNome()); //Simplificadamente ele adiciona um objeto de reação
                publicacao.setTotalInteracao(publicacao.getTotalInteracao()+1); //Isso aqui é para aumentar 1 no valor do objeto de torais de interação
                System.out.println("Você foi a " + publicacao.getTotalInteracao()+ " pessoa que reagiu a publicação");
            }
        }
        if (encontrouPublicacao.equals(false)){ //Caso não encontre nada, retornará essa mensagem.
            System.out.println("Publicação não existe!");
        }
    }*/

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
