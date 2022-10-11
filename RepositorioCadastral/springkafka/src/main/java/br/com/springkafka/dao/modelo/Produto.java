package br.com.springkafka.dao.modelo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Produto {

    private Integer id_produto, id_cliente;
    private String ind_produto_cont;

    public Produto(Integer id_produto, String ind_produto_cont, Integer id_cliente) {
        this.id_produto = id_produto;
        this.ind_produto_cont = ind_produto_cont;
        this.id_cliente = id_cliente;

    }
}



