package br.com.springkafka.dao.modelo.produtos;

import br.com.springkafka.dao.modelo.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@AllArgsConstructor
@Data
@NoArgsConstructor
public class Conta_cliente {

    private int id_produto, id_cliente;
    private String ind_produto_cont;

    private int nr_agencia, nr_conta, nr_verificador, cod_conta;
    private String tp_conta, dt_criacao_conta, conta;


}
