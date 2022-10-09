package br.com.springkafka.dao;

import br.com.springkafka.configuration.Conexao;
import br.com.springkafka.dao.modelo.Cliente;
import br.com.springkafka.dao.modelo.Pessoa_fisica;
import br.com.springkafka.dao.modelo.Pessoa_juridica;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Random;
import java.util.concurrent.Callable;

public class ClienteDAO extends DAO{
    // método para INSERT de Clientes Pessoa_Física na tabela
    public void inserir(Pessoa_fisica cliente) {

        connection = new Conexao().conectar();
        Random random = new Random();
        int integer = random.nextInt();

        sql = "insert into PESSOA_FISICA("
                + "cpf," // 1
                + "id_cliente," // 2
                + "nm_cliente," // 3
                + "dt_nascimento," // 4
                + "sexo," // 5
                + "estado_civil)" // 6
                + "values(?, ?, ?, ?, ?, ?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, cliente.getCpf());
            ps.setInt(2, cliente.setId_cliente(integer));
            ps.setString(3, cliente.getNm_cliente());
            ps.setString(4, (cliente.getDt_nascimento()));
            ps.setString(5, cliente.getSexo());
            ps.setString(6, cliente.getEstado_civil());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }

        sql = "insert into CLIENTE("
                + "id_cliente," // 1
                + "tp_cliente," // 2
                + "telefone01," // 3
                + "telefone02," // 4
                + "email,"		// 5
                + "senha,"//6
                + "ind_cliente_novo,"//7
                + "nm_cliente," // 8
                + "dt_nascimento)" // 9
                + "values(?, ?, ?, ?, ?, ?, ?,?,?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, cliente.getId_cliente());
            ps.setString(2, cliente.getTp_cliente());
            ps.setString(3, cliente.getTelefone01());
            ps.setString(4, cliente.getTelefone02());
            ps.setString(5, cliente.getEmail());
            ps.setString(6, cliente.getSenha());
            ps.setString(7, cliente.getInd_cliente_novo());
            ps.setString(8,cliente.getNm_cliente());
            ps.setString(9, cliente.getDt_nascimento());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }

    }


    // método para INSERT de Clientes Pessoa_Juridica na tabela
    public void inserir(Pessoa_juridica cliente) {
        connection = new Conexao().conectar();
        sql = "insert into CLIENTE("
                + "id_cliente," // 1
                + "tp_cliente," // 2
                + "telefone01," // 3
                + "telefone02," // 4
                + "email,"		// 5
                + "senha," // 6
                + "ind_cliente_novo)" // 7
                + "values(?, ?, ?, ?, ?, ?, ?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, cliente.getId_cliente());
            ps.setString(2, cliente.getTp_cliente());
            ps.setString(3, cliente.getTelefone01());
            ps.setString(4, cliente.getTelefone02());
            ps.setString(5, cliente.getEmail());
            ps.setString(6, cliente.getSenha());
            ps.setString(7, cliente.getInd_cliente_novo());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }
        sql = "insert into PESSOA_JURIDICA("
                + "cnpj," // 1
                + "id_cliente," // 2
                + "razao_social," // 3
                + "porte," // 4
                + "dt_abertura_emp," // 5
                + "values(?, ?, ?, ?, ?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, cliente.getCnpj());
            ps.setInt(2, cliente.getId_cliente());
            ps.setString(3, cliente.getRazao_social());
            ps.setString(4, cliente.getPorte());
            ps.setDate(5, Date.valueOf((cliente.getDt_abertura_emp())));
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }

    }

    // m�todo para SELECT se j� existe o id_cliente
    public boolean verifCliente(Integer id_cliente) {
        connection = new Conexao().conectar();
        boolean aux = false;
        sql = "select * from CLIENTE where id_cliente = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id_cliente);
            rs = ps.executeQuery();
            aux = rs.next();
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar id_cliente\n" + e);
        }
        return aux;
    }


    public boolean AtualizaCliente(String cpf) {
        connection = new Conexao().conectar();
        boolean aux = false;
        sql = "select * from CLIENTE where id_cliente = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, cpf);
            rs = ps.executeQuery();
            aux = rs.next();
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar id_cliente\n" + e);
        }
        return aux;
    }

    public boolean buscacpf(String cpf) {

        Cliente cliente = null;
        Pessoa_fisica pessoa = null;
        connection = new Conexao().conectar();
        boolean aux = false;
        sql = "select * from pessoa_fisica where cpf = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, cpf);
            rs = ps.executeQuery();
           if ( aux = rs.next()){
               pessoa = new Pessoa_fisica();
               pessoa.setCpf(rs.getString(cpf));
               pessoa.setNm_cliente(rs.getString("nm_cliente"));
               pessoa.setDt_nascimento(rs.getString("dt_nascimento"));
               pessoa.setSexo(rs.getString("sexo"));
               pessoa.setEstado_civil(rs.getString("estado_civil"));
               pessoa.setId_cliente(rs.getInt("id_cliente"));

           }
            sql = "update pessoa_fisica set cpf = ?, nm_cliente = ? where id = ?";

        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar id_cliente\n" + e);
        }
        return aux;
    }



    // m�todo para DELETE o cliente
    public void apagar(Integer id_cliente) {
        connection = new Conexao().conectar();

        try {
            sql = "delete from CLIENTE where id_cliente = ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id_cliente);
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao deletar a Conta\n" + e);
        }
    }
}
