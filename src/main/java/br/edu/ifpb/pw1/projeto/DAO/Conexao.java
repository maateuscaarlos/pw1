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
        InputStream inputStream = Conexao.class.getResourceAsStream("config.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            URL = properties.getProperty("banco.url");
            usuario = properties.getProperty("banco.usuario");
            senha = properties.getProperty("banco.senha");
            driver = properties.getProperty("banco.driver");
        } catch (IOException e) {
            e.printStackTrace();
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
