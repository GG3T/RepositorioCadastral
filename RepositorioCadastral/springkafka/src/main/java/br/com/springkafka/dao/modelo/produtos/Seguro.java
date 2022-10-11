package br.com.springkafka.dao.modelo.produtos;

import br.com.springkafka.dao.modelo.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Seguro {

    private int id_seguro, cod_seguro;
    private String dt_contratacao_seguro, tp_seguro;
    private int id_produto, id_cliente;
    private String ind_produto_cont, seguro;

}
