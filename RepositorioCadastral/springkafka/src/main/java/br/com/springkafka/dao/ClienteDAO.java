package br.com.springkafka.dao;

import br.com.springkafka.configuration.Conexao;
import br.com.springkafka.dao.modelo.AtualizarCliente;
import br.com.springkafka.dao.modelo.Cliente;
import br.com.springkafka.dao.modelo.Pessoa_fisica;
import br.com.springkafka.dao.modelo.Pessoa_juridica;
import br.com.springkafka.dao.modelo.localizacao.Endereco;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Random;
import java.util.concurrent.Callable;

public class ClienteDAO extends DAO {
    // método para INSERT de Clientes Pessoa_Física na tabela

    public void atualizarpessoa(Pessoa_fisica pessoa_fisica){
        connection = new Conexao().conectar();

        sql = "update pessoa_fisica SET nm_cliente = ? where id_cliente = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, pessoa_fisica.getNm_cliente());
            ps.setInt(2, pessoa_fisica.getId_cliente());
            ps.execute();
            ps.close();

        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }
    }

    public void email(Cliente cliente){
        connection = new Conexao().conectar();
        sql2 = "update cliente SET email = ?, telefone01 = ? WHERE ID_CLIENTE = ?";

        try {
            ps = connection.prepareStatement(sql2);
            ps.setString(1, cliente.getEmail());
            ps.setString(2, cliente.getTelefone01());
            ps.setInt(3, cliente.getId_cliente());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }
    }


    public void inserir(Pessoa_fisica cliente) {

        connection = new Conexao().conectar();

        sql = "insert into CLIENTE("
                + "id_cliente," // SEQUENCE
                + "tp_cliente," // 1
                + "telefone01," // 2
                + "telefone02," // 3
                + "email,"        // 4
                + "senha,"//5
                + "ind_cliente_novo,"//6
                + "id_endereco)" // SEQUENCE
                + "values(null, ?, ?, ?, ?, ?, ?, ?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, cliente.getTp_cliente());
            ps.setString(2, cliente.getTelefone01());
            ps.setString(3, cliente.getTelefone02());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getSenha());
            ps.setString(6, cliente.getInd_cliente_novo());
            ps.setInt(7, cliente.getId_endereco());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }

        sql = "insert into PESSOA_FISICA("
                + "cpf," // 1
                + "nm_cliente," // 2
                + "dt_nascimento," // 3
                + "sexo," // 4
                + "estado_civil," // 5
                + "id_cliente)" // SEQUENCE
                + "values(?, ?, ?, ?, ?, CLIENTE_ID_CLIENTE_SEQ.CURRVAL)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, cliente.getCpf());
            ps.setString(2, cliente.getNm_cliente());
            ps.setDate(3, Date.valueOf((cliente.getDt_nascimento())));
            ps.setString(4, cliente.getSexo());
            ps.setString(5, cliente.getEstado_civil());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }
    }
    public void inserirIndicador(int id, String indicadonovo) {
        connection = new Conexao().conectar();

        sql = "UPDATE cliente SET ind_cliente_novo = ? WHERE id_cliente = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, indicadonovo);
            ps.setInt(2, id);
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }
    }

    // método para INSERT de Clientes Pessoa_Juridica na tabela
    public void inserir(Pessoa_juridica cliente) {
        connection = new Conexao().conectar();

        sql = "insert into CLIENTE("
                + "id_cliente," // SEQUENCE
                + "tp_cliente," // 1
                + "telefone01," // 2
                + "telefone02," // 3
                + "email,"        // 4
                + "senha,"//5
                + "ind_cliente_novo,"//6
                + "id_endereco)" // SEQUENCE
                + "values(null, ?, ?, ?, ?, ?, ?, ?)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, cliente.getTp_cliente());
            ps.setString(2, cliente.getTelefone01());
            ps.setString(3, cliente.getTelefone02());
            ps.setString(4, cliente.getEmail());
            ps.setString(5, cliente.getSenha());
            ps.setString(6, cliente.getInd_cliente_novo());
            ps.setInt(7, cliente.getId_endereco());
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }

        sql = "insert into PESSOA_JURIDICA("
                + "cnpj," // 1
                + "razao_social," // 2
                + "porte," // 3
                + "dt_abertura_emp," // 4
                + "id_cliente)" // SEQUENCE
                + "values(?, ?, ?, ?, CLIENTE_ID_CLIENTE_SEQ.CURRVAL)";

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, cliente.getCnpj());
            ps.setString(2, cliente.getRazao_social());
            ps.setString(3, cliente.getPorte());
            ps.setDate(4, Date.valueOf((cliente.getDt_abertura_emp())));
            ps.execute();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco\n" + e);
        }

    }

    // método para SELECT o id_cliente a partir do CPF
    public LoginCliente consultar(String cpfcnpj) {
        connection = new Conexao().conectar();
        LoginCliente dados = null;
        String tp_cliente;
        String nm_cliente = null;

        if (cpfcnpj.length() <= 14) {
            sql = "Select * from pessoa_fisica where cpf = ?";
            tp_cliente = "PF";
        } else {
            sql = "select id_cliente, razao_social from PESSOA_JURIDICA where cnpj = ?";
            tp_cliente = "PJ";
        }

        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, cpfcnpj);
            rs = ps.executeQuery();
            while (rs.next()) {
                dados = new LoginCliente();
                dados.setId_cliente(rs.getInt("id_cliente"));
                if (tp_cliente.equals("PF")) {
                    dados.setNm_cliente(rs.getString("nm_cliente"));
                    dados.setCpfcnpj(rs.getString("cpf"));
                    dados.setTp_cliente("PF");
                } else {
                    dados.setNm_cliente(rs.getString("razao_social"));
                    dados.setCpfcnpj(rs.getString("cnpj"));
                    dados.setTp_cliente("PJ");
                }
            }


            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar id_cliente\n" + e);
        }
        return dados;
    }

    // método para SELECT o nm_cliente a partir do id_cliente
    public String buscarNome(Integer id_cliente, String tp_cliente) {
        connection = new Conexao().conectar();
        String nome = null;

        if (tp_cliente.equals("PF"))
            sql = "select nm_cliente from PESSOA_FISICA where id_cliente = ?";
        else
            sql = "select razao_social from PESSOA_JURIDICA where id_cliente = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id_cliente);
            rs = ps.executeQuery();
            if (rs.next()) {
                if (tp_cliente.equals("PF"))
                    nome = rs.getString("nm_cliente");
                else
                    nome = rs.getString("razao_social");
            }
        } catch (SQLException e) {
            System.out.println(" Erro ao buscar cliente a partir da conta\n" + e);
        }
        return nome;
    }

    // método para SELECT os dados do cliente PF
    public Cliente buscarDadosPF(Integer id_cliente ) {
        connection = new Conexao().conectar();
        Cliente cliente = null;
        Pessoa_fisica pessoa_fisica = null;
        Pessoa_juridica pessoa_juridica = null;

        sql = "select * from CLIENTE where id_cliente = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id_cliente);
            rs = ps.executeQuery();
            if (rs.next()) {
                cliente = new Pessoa_fisica();
                cliente.setId_cliente(rs.getInt("id_cliente"));
                cliente.setTp_cliente(rs.getString("tp_cliente"));
                cliente.setTelefone01(rs.getString("telefone01"));
                cliente.setTelefone01(rs.getString("telefone02"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));
                cliente.setInd_cliente_novo(rs.getString("ind_cliente_novo"));
                cliente.setId_endereco(rs.getInt("id_endereco"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar o Cliente pelo ID\n" + e);
        }
        return cliente;
    }

    public Endereco consultarEndereco(int id_endereco_aux ) {
        connection = new Conexao().conectar();
        Endereco cliente = null;
            sql = "select * from ENDERECO where id_endereco = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id_endereco_aux);
            rs = ps.executeQuery();
            if (rs.next()) {
                cliente = new Endereco();
                cliente.setId_endereco(rs.getInt("id_endereco"));
                cliente.setCep(rs.getString("cep"));
                cliente.setLogradouro(rs.getString("logradouro"));
                cliente.setUf(rs.getString("uf"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar o Cliente pelo ID\n" + e);
        }
        return cliente;
    }

    // método para SELECT os dados do cliente PJ
    public Pessoa_juridica buscarDadosPJ(Integer id_cliente) {
        connection = new Conexao().conectar();
        Pessoa_juridica cliente = null;

        sql = "select J.razao_social, J.cnpj, J.dt_abertura_emp, J.porte, C.telefone1, C.email from PESSOA_JURIDICA J, CLIENTE C where J.id_cliente = ? AND C.id_cliente = ?";

        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id_cliente);
            ps.setInt(2, id_cliente);
            rs = ps.executeQuery();
            if (rs.next()) {
                cliente = new Pessoa_juridica();
                cliente.setRazao_social(rs.getString("razao_social"));
                cliente.setCnpj(rs.getString("cnpj"));
                cliente.setDt_abertura_emp("dt_abertura_emp");
                cliente.setPorte("porte");
                cliente.setTelefone01("telefone01");
                cliente.setEmail("email");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao pesquisar o Cliente pelo ID\n" + e);
        }
        return cliente;
    }
}
