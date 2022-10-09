package br.com.springkafka.dao.modelo.produtos;

import br.com.springkafka.dao.modelo.Produto;

public class Consignado extends Produto {

    private Integer id_consignado, cod_consignado;
    private String dt_contratacao_consignado;

    public Consignado(String ind_produto_cont, Integer id_cliente, Integer cod_consignado, String dt_contratacao_consignado) {
        super(ind_produto_cont, id_cliente);
        this.id_consignado = null;
        this.cod_consignado = cod_consignado;
        this.dt_contratacao_consignado = dt_contratacao_consignado;
    }

    public Integer getId_consignado() {
        return id_consignado;
    }

    public void setId_consignado(Integer id_consignado) {
        this.id_consignado = id_consignado;
    }

    public Integer getCod_consignado() {
        return cod_consignado;
    }

    public void setCod_consignado(Integer cod_consignado) {
        this.cod_consignado = cod_consignado;
    }

    public String getDt_contratacao_consignado() {
        return dt_contratacao_consignado;
    }

    public void setDt_contratacao_consignado(String dt_contratacao_consignado) {
        this.dt_contratacao_consignado = dt_contratacao_consignado;
    }
}
