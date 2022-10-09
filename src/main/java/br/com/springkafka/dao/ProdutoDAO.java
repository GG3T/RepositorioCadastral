package br.com.springkafka.dao;

import br.com.springkafka.configuration.Conexao;
import br.com.springkafka.dao.modelo.Produto;
import br.com.springkafka.dao.modelo.produtos.*;

import java.sql.Date;
import java.sql.SQLException;

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
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }

        sql = "insert into CONTA_CLIENTE("
                + "nr_agencia," // 1
                + "nr_conta," // 2
                + "nr_verificador" // 3
                + "tp_conta" // 4
                + "dt_criacao_conta" // 5
                + "id_produto)" // 6
                + "values(?, ?, ?, ?, ?, PRODUTO_ID_PRODUTO_SEQ.CURRENTVAL)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, produto.getNr_agencia());
            ps.setInt(2, produto.getNr_conta());
            ps.setInt(3, produto.getNr_verificador());
            ps.setString(4, produto.getTp_conta());
            ps.setDate(5, Date.valueOf(produto.getDt_criacao_conta()));
            ps.execute();
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
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }

        sql = "insert into VEICULO("
                + "id_veiculo," // 1
                + "cod_veiculo," // 2
                + "modelo_veiculo" // 3
                + "ano_veiculo" // 4
                + "dt_contratacao_veiculo" // 5
                + "id_produto)" // 6
                + "values(?, ?, ?, ?, ?, PRODUTO_ID_PRODUTO_SEQ.CURRENTVAL)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, produto.getId_veiculo());
            ps.setInt(2, produto.getCod_veiculo());
            ps.setString(3, produto.getModelo_veiculo());
            ps.setString(4, produto.getAno_veiculo());
            ps.setDate(5, Date.valueOf(produto.getDt_contratacao_veiculo()));
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }
    }

    // método para Inserir SEGURO na tabela
    public void inserir(Seguro produto) {
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
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }

        sql = "insert into SEGURO("
                + "id_seguro," // 1
                + "cod_seguro," // 2
                + "dt_contratacao_seguro," // 3
                + "id_produto)" // 4
                + "values(?, ?, ?, PRODUTO_ID_PRODUTO_SEQ.CURRENTVAL)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, produto.getId_seguro());
            ps.setInt(2, produto.getCod_seguro());
            ps.setDate(3, Date.valueOf(produto.getDt_contratacao_seguro()));
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }
    }

    // método para Inserir CONSIGNADO na tabela
    public void inserir(Consignado produto) {
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
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }

        sql = "insert into CONSIGNADO("
                + "id_consignado," // 1
                + "cod_consignado," // 2
                + "dt_contratacao_consignado," // 3
                + "id_produto)" // 4
                + "values(?, ?, ?, PRODUTO_ID_PRODUTO_SEQ.CURRENTVAL)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, produto.getId_consignado());
            ps.setInt(2, produto.getCod_consignado());
            ps.setDate(3, Date.valueOf(produto.getDt_contratacao_consignado()));
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }
    }

    // método para Inserir CARTAO na tabela
    public void inserir(Cartao produto) {
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
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }

        sql = "insert into CARTAO("
                + "id_cartao," // 1
                + "cod_cartao," //2
                + "limite_cartao," //3
                + "bandeira_cartao," // 4
                + "dt_contratacao_cartao," // 5
                + "id_produto)" // 6
                + "values(?, ?, ?, ?, ?, PRODUTO_ID_PRODUTO_SEQ.CURRENTVAL)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, produto.getId_cartao());
            ps.setInt(2, produto.getCod_cartao());
            ps.setDouble(3, produto.getLimite_cartao());
            ps.setString(4, produto.getBandeira_cartao());
            ps.setDate(5, Date.valueOf(produto.getDt_contratacao_cartao()));
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }
    }

    // método para Inserir EMPRESTIMO na tabela
    public void inserir(Emprestimo produto) {
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
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }

        sql = "insert into EMPRESTIMO("
                + "id_emprestimo," // 1
                + "cod_emprestimo," //2
                + "limite_emprestimo," //3
                + "dt_contratacao_emprestimo," // 4
                + "id_produto)" // 5
                + "values(?, ?, ?, ?, PRODUTO_ID_PRODUTO_SEQ.CURRENTVAL)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, produto.getId_emprestimo());
            ps.setInt(2, produto.getCod_emprestimo());
            ps.setDouble(3, produto.getLimite_emprestimo());
            ps.setDate(4, Date.valueOf(produto.getDt_contratacao_emprestimo()));
            ps.execute();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }
    }

    // método para SELECT se já existe o ID_produto
    public boolean verifProduto(Integer id_produto) {
        connection = new Conexao().conectar();
        boolean aux = false;
        sql = "select * from PRODUTO where id_produto = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id_produto);
            rs = ps.executeQuery();
            aux = rs.next();
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar produto\n" + e);
        }
        return aux;
    }

    // método para SELECT os dados do produto
    public Produto pesquisar(Integer id_produto) {
        connection = new Conexao().conectar();
        sql = "select * from PRODUTO where id_produto = ?";
        Produto produto = null;

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id_produto);
            rs = ps.executeQuery();
            if (rs.next()) {
                produto = new Produto(rs.getInt("id_produto"), rs.getString("ind_produto_cont"),
                        rs.getInt("id_cliente"));
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar dados do produto pelo ID\n" + e);
        }

        return produto;
    }

}
