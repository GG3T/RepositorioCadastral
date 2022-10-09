package br.com.springkafka.dao.modelo.produtos;

import br.com.springkafka.dao.modelo.Produto;

public class Emprestimo extends Produto {

    private Integer id_emprestimo, cod_emprestimo;
    private Double limite_emprestimo;
    private String dt_contratacao_emprestimo;

    public Emprestimo(String ind_produto_cont, Integer id_cliente, Integer cod_emprestimo, Double limite_emprestimo, String dt_contratacao_emprestimo) {
        super(ind_produto_cont, id_cliente);
        this.id_emprestimo = null;
        this.cod_emprestimo = cod_emprestimo;
        this.limite_emprestimo = limite_emprestimo;
        this.dt_contratacao_emprestimo = dt_contratacao_emprestimo;
    }

    public Integer getId_emprestimo() {
        return id_emprestimo;
    }

    public void setId_emprestimo(Integer id_emprestimo) {
        this.id_emprestimo = id_emprestimo;
    }

    public Integer getCod_emprestimo() {
        return cod_emprestimo;
    }

    public void setCod_emprestimo(Integer cod_emprestimo) {
        this.cod_emprestimo = cod_emprestimo;
    }

    public Double getLimite_emprestimo() {
        return limite_emprestimo;
    }

    public void setLimite_emprestimo(Double limite_emprestimo) {
        this.limite_emprestimo = limite_emprestimo;
    }

    public String getDt_contratacao_emprestimo() {
        return dt_contratacao_emprestimo;
    }

    public void setDt_contratacao_emprestimo(String dt_contratacao_emprestimo) {
        this.dt_contratacao_emprestimo = dt_contratacao_emprestimo;
    }
}
