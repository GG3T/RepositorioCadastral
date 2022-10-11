package br.com.springkafka.dao.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtualizarCliente {

private String cpf;
private String nm_cliente;
private String id_cliente;
private String email;
private String telefone01;


}
