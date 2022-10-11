package br.com.springkafka.dao.modelo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Cliente {

    private int id_cliente, id_endereco;

    private String telefone01, telefone02, tp_cliente, email, ind_cliente_novo, senha;

    // Construtor para cadastrar Cliente
    public Cliente(String telefone01, String telefone02, String tp_cliente, String email, String senha) {
        super();
        this.telefone01 = telefone01;
        this.telefone02 = telefone02;
        this.tp_cliente = tp_cliente;
        this.email = email;
        this.senha = senha;
        this.ind_cliente_novo = "S";
    }

}
