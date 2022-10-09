package br.com.springkafka.dao.modelo.localizacao;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {
     private String cep, logradouro;
}

