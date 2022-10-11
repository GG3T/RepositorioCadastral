package br.com.springkafka.dao;

import br.com.springkafka.configuration.Conexao;
import br.com.springkafka.dao.modelo.localizacao.Endereco;

import java.sql.SQLException;

public class EnderecoDAO extends DAO{

    // método para INSERT de produtos na tabela
    public void inserir(Endereco endereco) {
        connection = new Conexao().conectar();
        sql = "insert into ENDERECO("
                + "id_endereco," // SEQUENCE
                + "cep," // 1
                + "logradouro," // 2
                + "uf," // 3
                + "id_cidade)" // 4
                + "values(?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, endereco.getId_endereco());
            ps.setString(2, endereco.getCep());
            ps.setString(3, endereco.getLogradouro());
            ps.setString(4, endereco.getUf());
            ps.setInt(5, endereco.getId_cidade());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }
    }


}
