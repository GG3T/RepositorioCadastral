package br.com.springkafka.dao.modelo.produtos;

import br.com.springkafka.dao.modelo.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cartao{

    private int id_cartao, cod_cartao, limite_cartao;
    private String bandeira_cartao, dt_contratacao_cartao, tp_cartao, cartao;
    private int id_produto, id_cliente;
    private String ind_produto_cont;

}
