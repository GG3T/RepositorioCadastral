package br.com.springkafka.dao.modelo.produtos;

import br.com.springkafka.dao.modelo.Produto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emprestimo {

    private int id_emprestimo, cod_emprestimo, limite_emprestimo, id_produto, id_cliente;
    private String dt_contratacao_emprestimo, tp_emprestimo, emprestimo, ind_produto_cont;

}
