package br.edu.ifpb.pw1.projeto.DAOBD;

import br.edu.ifpb.pw1.projeto.DAO.Conexao;
import br.edu.ifpb.pw1.projeto.DAO.UserDAO;
import br.edu.ifpb.pw1.projeto.model.Carteira;
import br.edu.ifpb.pw1.projeto.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class UserDAOBD implements UserDAO {
    private Conexao conexao;

    public UserDAOBD() {
        this.conexao = new Conexao();
    }

    @Override
    public boolean cadastrarUser(User user) throws Exception {
        this.conexao.conectar();
        String sql = "INSERT INTO usuario (nome, email, senha, nascimento, idCarteira)" + "VALUES (?, ?,?,?,?)";
        try {
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
            statement.setString(1, user.getNome());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getSenha());
            statement.setDate(4, java.sql.Date.valueOf(user.getNascimento()));
            statement.setLong(5, user.getCarteira().getId());


            statement.executeUpdate();
            return true;
        }catch (Exception e){
            return false;

        }finally {
            this.conexao.desconectar();
        }



    }

    @Override
    public void removerUser(Long id) throws Exception {
        this.conexao.conectar();
        String sql = "DELETE FROM USER WHERE id = ?";
        PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
        statement.setLong(1, id);
        statement.executeUpdate();
        this.conexao.desconectar();

    }

    @Override
    public void atualizarUser(User user) throws Exception {

    }

    @Override
    public Optional<User> buscarUser(Long id) throws Exception {

        this.conexao.conectar();
        String sql = "SELECT * FROM usuario WHERE id = ?";
        PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
        statement.setLong(1, id);
        ResultSet result = statement.executeQuery();
        User user = null;
        while (result.next()) {
            user = new User();
            user.setId(result.getLong("id"));
            user.setNome(result.getString("nome"));
            user.setEmail(result.getString("email"));
            user.setSenha(result.getString("senha"));
            Date nascimento = result.getDate("nascimento");
            String data = new SimpleDateFormat("dd/MM/yyyy").format(nascimento);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(data,formatter);

            user.setNascimento(date);
            Carteira carteira = new Carteira();
            carteira.setId(result.getLong("idCarteira"));
            user.setCarteira(carteira);

        }
        this.conexao.desconectar();

        return Optional.ofNullable(user);
    }

    @Override
    public List<User> buscarTodos() throws Exception {
        this.conexao.conectar();
        String query = "SELECT * FROM usuario";
        PreparedStatement statement = this.conexao.getConexao().prepareStatement(query);
        ResultSet result = statement.executeQuery();
        List<User> users = new ArrayList<>();
        while (result.next()) {
            User user = new User();
            user.setId(result.getLong("id"));
            user.setNome(result.getString("nome"));
            user.setEmail(result.getString("email"));
            user.setSenha(result.getString("senha"));
            Date nascimento = result.getDate("nascimento");
            String data = new SimpleDateFormat("dd/MM/yyyy").format(nascimento);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(data,formatter);

            user.setNascimento(date);
            Carteira carteira = new Carteira();
            carteira.setId(result.getLong("idCarteira"));
            user.setCarteira(carteira);
            users.add(user);
        }
        this.conexao.desconectar();

        return users;
    }

    @Override
    public Optional<User> autenticarUser(String email, String senha) throws Exception {

        this.conexao.conectar();
        String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
        PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);

        statement.setString(1, email);
        statement.setString(2, senha);

        ResultSet result = statement.executeQuery();
        User user = null;
        while (result.next()) {
            user = new User();
            user.setId(result.getLong("id"));
            user.setNome(result.getString("nome"));
            user.setEmail(result.getString("email"));
            user.setSenha(result.getString("senha"));
            Date nascimento = result.getDate("nascimento");
            String data = new SimpleDateFormat("dd/MM/yyyy").format(nascimento);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(data,formatter);

            user.setNascimento(date);

            Carteira carteira = new Carteira();
            carteira.setId(result.getLong("idCarteira"));
            user.setCarteira(carteira);

        }
        this.conexao.desconectar();

        return Optional.ofNullable(user);
    }

}
