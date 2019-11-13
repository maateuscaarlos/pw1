package br.edu.ifpb.pw1.projeto.DAOBD;

import br.edu.ifpb.pw1.projeto.DAO.Conexao;
import br.edu.ifpb.pw1.projeto.DAO.UserDAO;
import br.edu.ifpb.pw1.projeto.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.ZoneId;
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
    public void CadastrarUser(User user) throws Exception {
        user.setId(obterNumID());
        this.conexao.conectar();
        String sql = "INSERT INTO USER (id, nome, email, senha, nascimento, idCarteira)" + "VALUES (?, ?, ?,?,?,?)";
        PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
        statement.setLong(1, user.getId());
        statement.setString(2, user.getNome());
        statement.setString(3, user.getEmail());
        statement.setString(4, user.getSenha());
        statement.setDate(5, (java.sql.Date) Date.from(user.getNascimento().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        statement.setLong(6, user.getCarteira().getId());


        statement.executeUpdate();

        this.conexao.desconectar();

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
        String sql = "SELECT * FROM user WHERE id = ?";
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
            user.setNascimento(nascimento.toInstant().atZone( ZoneId.systemDefault() ).toLocalDate());
            user.getCarteira().setId(result.getLong("idCarteira"));

        }
        this.conexao.desconectar();

        return Optional.ofNullable(user);
    }

    @Override
    public List<User> buscarTodos() throws Exception {
        this.conexao.conectar();
        String query = "SELECT * FROM USER";
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
            user.setNascimento(nascimento.toInstant().atZone( ZoneId.systemDefault() ).toLocalDate());
            user.getCarteira().setId(result.getLong("idCarteira"));
            users.add(user);
        }
        this.conexao.desconectar();

        return users;
    }

    @Override
    public Optional<User> autenticarUser(String email, String senha) throws Exception {

        this.conexao.conectar();
        String sql = "SELECT * FROM user WHERE email = ? AND senha = ?";
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
            user.setNascimento(nascimento.toInstant().atZone( ZoneId.systemDefault() ).toLocalDate());
            user.getCarteira().setId(result.getLong("idCarteira"));

        }
        this.conexao.desconectar();

        return Optional.ofNullable(user);
    }
    private Long obterNumID() throws Exception {
        String sql = "SELECT MAX(id) maior FROM User";
        ResultSet rs = null;
        Statement statement = null;
        this.conexao.conectar();

        try {
            statement = this.conexao.getConexao().createStatement();
            rs = statement.executeQuery(sql);

            if (rs.next()) {
                Long maior = rs.getLong("maior");
                return maior++;
            }
            return 1L ;
        } finally {
            conexao.desconectar();
        }
    }
}
