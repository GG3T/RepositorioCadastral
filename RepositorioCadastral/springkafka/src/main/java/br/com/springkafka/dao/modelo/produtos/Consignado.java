package br.com.springkafka.dao.modelo.produtos;

import br.com.springkafka.dao.modelo.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Consignado {

    private int id_consignado, cod_consignado;
    private String dt_contratacao_consignado;
    private int id_produto, id_cliente;
    private String ind_produto_cont, consignado;

}
