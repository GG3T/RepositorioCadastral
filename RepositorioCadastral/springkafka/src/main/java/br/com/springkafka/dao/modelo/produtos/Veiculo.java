package br.com.springkafka.dao.modelo.produtos;

import br.com.springkafka.dao.modelo.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Veiculo  {

    private int id_veiculo, cod_veiculo, id_produto, id_cliente;
    private String modelo_veiculo, ano_veiculo, dt_contratacao_veiculo, veiculo, ind_produto_cont;

}
