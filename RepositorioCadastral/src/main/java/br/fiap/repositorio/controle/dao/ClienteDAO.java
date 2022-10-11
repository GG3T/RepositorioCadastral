package br.fiap.repositorio.controle.dao;

import java.sql.Date;
import java.sql.SQLException;

import br.fiap.repositorio.controle.conexao.Conexao;
import br.fiap.repositorio.modelo.Cliente;
import br.fiap.repositorio.modelo.Conta_cliente;
import br.fiap.repositorio.modelo.Pessoa_fisica;
import br.fiap.repositorio.modelo.Pessoa_juridica;

public class ClienteDAO extends DAO {

	// m�todo para INSERT de Clientes Pessoa_F�sica na tabela
	public void inserirPF(Pessoa_fisica cliente) {
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
			ps.setInt(2, cliente.getId_cliente());
			ps.setString(3, cliente.getNm_cliente());
			ps.setDate(4, Date.valueOf((cliente.getDt_nascimento())));
			ps.setString(5, cliente.getSexo());
			ps.setString(6, cliente.getEstado_civil());
			ps.execute();
		} catch (SQLException e) {
			System.out.println("Erro ao conectar com o banco\n" + e);
		}

	}

	// m�todo para INSERT de Clientes Pessoa_Juridica na tabela
	public void inserirPJ(Pessoa_juridica cliente) {
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

	// m�todo para SELECT os dados do cliente
	public Cliente pesquisar(Integer id_cliente, String tp_cliente) {
		connection = new Conexao().conectar();
		sql = "s elect * from CLIENTE where id_cliente = ?";
		Cliente cliente = null;

		try {
			ps = connection.prepareStatement(sql);
			ps.setInt(1, id_cliente);
			rs = ps.executeQuery();
			if (rs.next()) {
				cliente = new Cliente(rs.getString("telefone01"), rs.getString("telefone02"), rs.getString("dt_nascimento"),
						rs.getString("tp_cliente"));
			}
			String telefone01, String telefone02, String tp_cliente, String email, String senha
			sql = "insert into CLIENTE("
					+ "id_cliente," // 1
					+ "tp_cliente," // 2
					+ "telefone01," // 3
					+ "telefone02," // 4
					+ "email,"		// 5
					+ "senha," // 6
					+ "ind_cliente_novo)" // 7
					+ "values(?, ?, ?, ?, ?, ?, ?)";
		} catch (SQLException e) {
			System.out.println("Erro ao pesquisar o Cliente pelo ID\n" + e);
		}

		return cliente;
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
