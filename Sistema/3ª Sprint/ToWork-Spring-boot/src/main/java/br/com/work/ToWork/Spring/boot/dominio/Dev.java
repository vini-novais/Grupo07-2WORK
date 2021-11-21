package br.com.work.ToWork.Spring.boot.dominio;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Dev extends Usuario {

    //Atributos
    private String especialidade;
    private Integer totalPublicacoes = 0;
    private Integer publicacoesCurtidas = 0;

    //Construtor


    /*public Dev(String nome, String email, String senha, String cpf, String cidade, String estado, String telefone, String biografia, String planoUsuario, ZonedDateTime dataNascimento, String especialidade, Integer quantidadeTotalPublicacoes) {
        super(nome, email, senha, cpf, cidade, estado, telefone, biografia, planoUsuario, dataNascimento);
        this.especialidade = especialidade;
        this.quantidadeTotalPublicacoes = 0;
    }*/

    public Dev(){
        super();
    }

    //Métodos
    /*public void publicar(){
        setQuantidadeTotalPublicacoes(quantidadeTotalPublicacoes+1);//Está setando 1 a quantidade total de publicaçoes
        Publicacao p = new Publicacao(quantidadeTotalPublicacoes);
        listaPublicacao.add(p);
        System.out.println("Adicionado a Publicação:" + quantidadeTotalPublicacoes);
    }

    public void removerPublicacao(Integer idPublicacao){
        Boolean encontrouPublicacao = false; //Verifica se esse id da Publicação realmente existe
        for (Publicacao publicacao: listaPublicacao){
            if (publicacao.getIdPublicacao().equals(idPublicacao)){//Está verificando se existe esse ID
                listaPublicacao.remove(publicacao);
                encontrouPublicacao = true;
                System.out.println("Publicacao removida!");
            }
        }
        if (encontrouPublicacao.equals(false)){ //Caso não encontre nada, retornará essa mensagem.
            System.out.println("Publicação não existe!");
        }

    }

    @Override
    public void reagirPublicacao(Integer idBuscarPublicacao){
        Boolean encontrouPublicacao = false; //Verifica se esse id da Publicação realmente existe
        for (Publicacao publicacao : listaPublicacao){ //Percorre a lista de todas Publicações
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
    }

    @Override
    public void reagirPublicacao(Integer idBuscarPublicacao, List<Publicacao> list) {

    }*/

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

    //Getters e Setters
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
}
