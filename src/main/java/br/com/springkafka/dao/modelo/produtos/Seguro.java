package br.com.springkafka.dao.modelo.produtos;

import br.com.springkafka.dao.modelo.Produto;

public class Seguro extends Produto {

    private Integer id_seguro, cod_seguro;
    private String dt_contratacao_seguro;

    public Seguro(String ind_produto_cont, Integer id_cliente, Integer cod_seguro, String dt_contratacao_seguro) {
        super(ind_produto_cont, id_cliente);
        this.id_seguro = null;
        this.cod_seguro = cod_seguro;
        this.dt_contratacao_seguro = dt_contratacao_seguro;
    }

    public Integer getId_seguro() {
        return id_seguro;
    }

    public void setId_seguro(Integer id_seguro) {
        this.id_seguro = id_seguro;
    }

    public Integer getCod_seguro() {
        return cod_seguro;
    }

    public void setCod_seguro(Integer cod_seguro) {
        this.cod_seguro = cod_seguro;
    }

    public String getDt_contratacao_seguro() {
        return dt_contratacao_seguro;
    }

    public void setDt_contratacao_seguro(String dt_contratacao_seguro) {
        this.dt_contratacao_seguro = dt_contratacao_seguro;
    }

}
