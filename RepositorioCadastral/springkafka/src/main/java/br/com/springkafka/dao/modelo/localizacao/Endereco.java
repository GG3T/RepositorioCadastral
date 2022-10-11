package br.com.springkafka.dao.modelo.localizacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    private int id_endereco, id_cidade;
    private String cep, logradouro, uf;


}
