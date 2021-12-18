package br.com.work.ToWork.Spring.boot.requisicao;

public class TotalAvaliacoesResponse {

    // Atributos
    private Integer id;
    private Integer valorNovo;

    // Construtor
    public TotalAvaliacoesResponse(Integer id, Integer valorNovo) {
        this.id = id;
        this.valorNovo = valorNovo;
    }

    // Getter e Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getValorNovo() {
        return valorNovo;
    }

    public void setValorNovo(Integer valorNovo) {
        this.valorNovo = valorNovo;
    }
}