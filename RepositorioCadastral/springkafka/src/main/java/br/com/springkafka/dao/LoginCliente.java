package br.com.springkafka.dao;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
public class LoginCliente {

    private Integer id_cliente;
    private String cpfcnpj, senha, tp_cliente, nm_cliente, cliente_novo, ind_cliente_novo;


    public LoginCliente(String nm_cliente) {
        this.nm_cliente = nm_cliente;
    }

    public LoginCliente(Integer id_cliente, String cpfcnpj, String senha, String tp_cliente) {
        this.id_cliente = id_cliente;
        this.cpfcnpj = cpfcnpj;
        this.senha = senha;
        this.tp_cliente = tp_cliente;
    }

    public LoginCliente(Integer id_cliente, String tp_cliente) {
        this.id_cliente = id_cliente;
        this.tp_cliente = tp_cliente;
    }


    public LoginCliente(int id_cliente, String tp_cliente, String nm_cliente) {
    }
}
