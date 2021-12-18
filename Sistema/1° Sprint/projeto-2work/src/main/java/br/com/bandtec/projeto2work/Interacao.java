package br.com.bandtec.projeto2work;

public class Interacao extends Publicacao {

    // Atributos
    private Integer idInteracao;
    //private Date dataInteracao;
    private String nomeDeQuemInteragiu;

    // Construtor
    public Interacao(Integer idPublicacao, Integer idInteracao, String nomeDeQuemInteragiu) {
        super(idPublicacao);
        this.idInteracao = idInteracao;
        this.nomeDeQuemInteragiu = nomeDeQuemInteragiu;
    }
}