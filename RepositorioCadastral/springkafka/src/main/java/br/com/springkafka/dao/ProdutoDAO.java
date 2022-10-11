package br.com.springkafka.dao;

import br.com.springkafka.configuration.Conexao;
import br.com.springkafka.dao.modelo.Produto;
import br.com.springkafka.dao.modelo.produtos.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO extends DAO {

    // método para Inserir CONTA na tabela
    public void inserir(Conta_cliente produto) {
        connection = new Conexao().conectar();

        sql = "insert into PRODUTO("
                + "id_produto," // 1
                + "ind_produto_cont," // 2
                + "id_cliente)" // 3
                + "values(?, ?, ?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, produto.getId_produto());
            ps.setString(2, produto.getInd_produto_cont());
            ps.setInt(3, produto.getId_cliente());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }

        sql = "insert into CONTA_CLIENTE("
                + "nr_agencia," // 1
                + "nr_conta," // 2
                + "nr_verificador" // 3
                + "tp_conta" // 4
                + "dt_criacao_conta" // SYSDATE
                + "id_produto)" // SEQUENCE
                + "values(?, ?, ?, ?, SYSDATE, ?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, produto.getNr_agencia());
            ps.setInt(2, produto.getNr_conta());
            ps.setInt(3, produto.getNr_verificador());
            ps.setString(4, produto.getTp_conta());
            ps.setString(5, produto.getDt_criacao_conta());
            ps.setInt(6, produto.getId_produto());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }
    }

    // método para Inserir VEICULO na tabela
    public void inserir(Veiculo produto) {
        connection = new Conexao().conectar();

        sql = "insert into PRODUTO("
                + "id_produto," // 1
                + "ind_produto_cont," // 2
                + "id_cliente)" // 3
                + "values(?, ?, ?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, produto.getId_produto());
            ps.setString(2, produto.getInd_produto_cont());
            ps.setInt(3, produto.getId_cliente());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }

        sql = "insert into VEICULO("
                + "id_veiculo," // SEQUENCE
                + "cod_veiculo," // 1
                + "modelo_veiculo" // 2
                + "ano_veiculo" // 3
                + "dt_contratacao_veiculo" // SYSDATE
                + "id_produto)" // SEQUENCE
                + "values(null, ?, ?, ?, SYSDATE, ?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, produto.getCod_veiculo());
            ps.setString(2, produto.getModelo_veiculo());
            ps.setString(3, produto.getAno_veiculo());
            ps.setInt(4, produto.getId_produto());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }
    }

    // método para Inserir SEGURO na tabela
    public void inserir(Seguro produto) {
        connection = new Conexao().conectar();

        sql = "insert into PRODUTO("
                + "id_produto," // SEQUENCE
                + "ind_produto_cont," // 1
                + "id_cliente)" // 2
                + "values(?, ?, ?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, produto.getId_produto());
            ps.setString(2, produto.getInd_produto_cont());
            ps.setInt(3, produto.getId_cliente());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }

        sql = "insert into SEGURO("
                + "id_seguro," // SEQUENCE
                + "tp_seguro," // 1
                + "cod_seguro," // 2
                + "dt_contratacao_seguro," // SYSDATE
                + "id_produto)" // SEQUENCE
                + "values(null, ?, ?, SYSDATE, ?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, produto.getTp_seguro());
            ps.setInt(2, produto.getCod_seguro());
            ps.setInt(3, produto.getId_produto());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }
    }

    // método para Inserir CONSIGNADO na tabela
    public void inserir(Consignado produto) {
        connection = new Conexao().conectar();

        sql = "insert into PRODUTO("
                + "id_produto," // SEQUENCE
                + "ind_produto_cont," // 1
                + "id_cliente)" // 2
                + "values(?, ?, ?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, produto.getId_produto());
            ps.setString(2, produto.getInd_produto_cont());
            ps.setInt(3, produto.getId_cliente());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }

        sql = "insert into CONSIGNADO("
                + "id_consignado," // SEQUENCE
                + "cod_consignado," // 1
                + "dt_contratacao_consignado," // SYSDATE
                + "id_produto)" // SEQUENCE
                + "values(?, ?, SYSDATE, ?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, produto.getCod_consignado());
            ps.setInt(2, produto.getId_produto());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }
    }

    // método para Inserir CARTAO na tabela
    public void inserir(Cartao produto) {
        connection = new Conexao().conectar();

        sql = "insert into PRODUTO("
                + "ID_PRODUTO," // SEQUENCE
                + "IND_PRODUTO_CONT," // 1
                + "ID_CLIENTE,"
                + "PRODUTO_CONTRATADO)" // 2
                + "values(?, ?, ?, ?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, produto.getId_produto());
            ps.setString(2, produto.getInd_produto_cont());
            ps.setInt(3, produto.getId_cliente());
            ps.setString(4, produto.getInd_produto_cont());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }

        sql2 = "INSERT INTO CARTAO(" +
                "ID_CARTAO," +
                "TP_CARTAO," +
                "COD_CARTAO," +
                "BANDEIRA_CARTAO," +
                "LIMITE_CARTAO," +
                "DT_CONTRATACAO_CARTAO," +
                "ID_PRODUTO) values (?,?,?,?,?,SYSDATE,?)";
        try {
            ps = connection.prepareStatement(sql2);
            ps.setInt(1, produto.getId_cartao());
            ps.setString(2, produto.getTp_cartao());
            ps.setInt(3, produto.getCod_cartao());
            ps.setString(4, produto.getBandeira_cartao());
            ps.setDouble(5, produto.getLimite_cartao());
            ps.setString(6, produto.getDt_contratacao_cartao());
            ps.setInt(7, produto.getId_produto());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }
    }

    // método para Inserir EMPRESTIMO na tabela
    public void inserir(Emprestimo produto) {
        connection = new Conexao().conectar();
        String ind = "0";
        sql = "insert into PRODUTO("
                + "id_produto," // SEQUENCE
                + "ind_produto_cont," // 1
                + "id_cliente)" // 2
                + "values(?, ?, ?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, produto.getId_produto());
            ps.setString(2, ind);
            ps.setInt(3, produto.getId_cliente());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }

        sql = "insert into EMPRESTIMO("
                + "id_emprestimo," // 1
                + "tp_emprestimo," // 2
                + "cod_emprestimo," //3
                + "limite_emprestimo," //4
                + "dt_contratacao_emprestimo," // 5
                + "id_produto)" // 6
                + "values(?, ?, ?, ?, ?, ?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1,produto.getId_emprestimo());
            ps.setString(2, produto.getTp_emprestimo());
            ps.setInt(3, produto.getCod_emprestimo());
            ps.setDouble(4, produto.getLimite_emprestimo());
            ps.setString(5, produto.getDt_contratacao_emprestimo());
            ps.setInt(6, produto.getId_produto());
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }
    }

    // método para SELECT e LISTAR os produtosXcliente
    public List<Produto> listarProdutos(Integer id_cliente) {
        List<Produto> lista = new ArrayList<Produto>();
        connection = new Conexao().conectar();
        sql = "select * from PRODUTO where id_cliente = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id_cliente);
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Produto(rs.getInt("id_produto"), rs.getString("ind_produto_cont"),
                        rs.getInt("id_cliente")));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos do cliente\n" + e);
        }

        return lista;
    }

}
