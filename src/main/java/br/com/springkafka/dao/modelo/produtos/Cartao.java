package br.com.springkafka.dao.modelo.produtos;

import br.com.springkafka.dao.modelo.Produto;

public class Cartao extends Produto {

    private Integer id_cartao, cod_cartao;
    private Double limite_cartao;
    private String bandeira_cartao, dt_contratacao_cartao;

    public Cartao(String ind_produto_cont, Integer id_cliente, Integer cod_cartao, Double limite_cartao, String bandeira_cartao, String dt_contratacao_cartao) {
        super(ind_produto_cont, id_cliente);
        this.id_cartao = null;
        this.cod_cartao = cod_cartao;
        this.limite_cartao = limite_cartao;
        this.bandeira_cartao = bandeira_cartao;
        this.dt_contratacao_cartao = dt_contratacao_cartao;
    }

    public Double getLimite_cartao() {
        return limite_cartao;
    }

    public void setLimite_cartao(Double limite_cartao) {
        this.limite_cartao = limite_cartao;
    }

    public Integer getId_cartao() {
        return id_cartao;
    }

    public void setId_cartao(Integer id_cartao) {
        this.id_cartao = id_cartao;
    }

    public Integer getCod_cartao() {
        return cod_cartao;
    }

    public void setCod_cartao(Integer cod_cartao) {
        this.cod_cartao = cod_cartao;
    }

    public String getBandeira_cartao() {
        return bandeira_cartao;
    }

    public void setBandeira_cartao(String bandeira_cartao) {
        this.bandeira_cartao = bandeira_cartao;
    }

    public String getDt_contratacao_cartao() {
        return dt_contratacao_cartao;
    }

    public void setDt_contratacao_cartao(String dt_contratacao_cartao) {
        this.dt_contratacao_cartao = dt_contratacao_cartao;
    }

}
