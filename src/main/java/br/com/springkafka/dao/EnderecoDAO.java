package br.com.springkafka.dao;

import br.com.springkafka.configuration.Conexao;
import br.com.springkafka.dao.modelo.localizacao.Endereco;

import java.sql.SQLException;

public class EnderecoDAO extends DAO{

    // método para INSERT de produtos na tabela
    public void inserir(Endereco endereco) {
        connection = new Conexao().conectar();
        sql = "insert into ENDERECO("
                + "id_endereco," // 1
                + "cep," // 2
                + "logradouro," // 3
                + "uf," // 4
                + "id_cidade," // 5
                + "id_cliente)" // 6
                + "values(?, ?, ?, ?, ?)";

        try {
            ps = connection.prepareStatement(sql);

            ps.setString(2, endereco.getCep());
            ps.setString(3, endereco.getLogradouro());

            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }
    }


}
