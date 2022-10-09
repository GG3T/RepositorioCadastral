package br.com.springkafka.dao.modelo.produtos;

import br.com.springkafka.dao.modelo.Produto;

public class Veiculo extends Produto {

    private Integer id_veiculo, cod_veiculo;
    private String modelo_veiculo, ano_veiculo, dt_contratacao_veiculo;

    public Veiculo(String ind_produto_cont, Integer id_cliente, Integer cod_veiculo, String modelo_veiculo, String ano_veiculo, String dt_contratacao_veiculo) {
        super(ind_produto_cont, id_cliente);
        this.id_veiculo = null;
        this.cod_veiculo = cod_veiculo;
        this.modelo_veiculo = modelo_veiculo;
        this.ano_veiculo = ano_veiculo;
        this.dt_contratacao_veiculo = dt_contratacao_veiculo;
    }

    public Integer getId_veiculo() {
        return id_veiculo;
    }

    public void setId_veiculo(Integer id_veiculo) {
        this.id_veiculo = id_veiculo;
    }

    public Integer getCod_veiculo() {
        return cod_veiculo;
    }

    public void setCod_veiculo(Integer cod_veiculo) {
        this.cod_veiculo = cod_veiculo;
    }

    public String getModelo_veiculo() {
        return modelo_veiculo;
    }

    public void setModelo_veiculo(String modelo_veiculo) {
        this.modelo_veiculo = modelo_veiculo;
    }

    public String getAno_veiculo() {
        return ano_veiculo;
    }

    public void setAno_veiculo(String ano_veiculo) {
        this.ano_veiculo = ano_veiculo;
    }

    public String getDt_contratacao_veiculo() {
        return dt_contratacao_veiculo;
    }

    public void setDt_contratacao_veiculo(String dt_contratacao_veiculo) {
        this.dt_contratacao_veiculo = dt_contratacao_veiculo;
    }
}
