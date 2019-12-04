package br.edu.ifpb.pw1.projeto.DAO;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {

    private Connection connection;
    private static String URL;
    private static String usuario;
    private static String senha;
    private static String driver;

    static {
        try (InputStream input = DaoFactory.class.getClassLoader().getResourceAsStream("config.properties")) {

            Properties prop = new Properties();
            if (input == null) {
                System.out.println("Não dá certo");

            }
            prop.load(input);

            URL =  prop.getProperty("banco.url");
            usuario =  prop.getProperty("banco.usuario");
            senha =  prop.getProperty("banco.senha");
            driver =  prop.getProperty("banco.driver");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public void conectar() throws Exception {
        Class.forName(driver);
        Connection connection = DriverManager.getConnection(URL, usuario, senha);
        this.connection = connection;
    }

    public void desconectar() throws SQLException {
        if (!this.connection.isClosed()) {
            this.connection.close();
        }
    }

    public Connection getConexao() {
        return this.connection;
    }

}
