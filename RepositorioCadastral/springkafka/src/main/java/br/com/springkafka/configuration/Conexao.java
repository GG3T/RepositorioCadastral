package br.com.springkafka.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private String driver = "oracle.jdbc.driver.OracleDriver";
    private String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
    private String login = "RM87192";
    private String senha = "040202";
    private Connection connection;

    public Connection conectar() {

        try {

            if (connection != null  && connection.isValid(0)) {
                return connection;
            }else {
                Class.forName(driver);
                connection = DriverManager.getConnection(url, login, senha);
            }

        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar o driver\n" + e);
        } catch (SQLException e) {
            System.out.println("Erro ao conectar com o banco de dados\n" + e);
        }


        return connection;
    }

    public void desconectar() {
        try {
            connection.close();
        }
        catch(SQLException e) {
            System.out.println("Erro ao desconectar do banco de dados\n" + e);
        }
    }

}
