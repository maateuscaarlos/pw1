package br.edu.ifpb.pw1.projeto.DAOBD;

import br.edu.ifpb.pw1.projeto.DAO.AtivoDAO;
import br.edu.ifpb.pw1.projeto.DAO.Conexao;
import br.edu.ifpb.pw1.projeto.model.Ativo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class AtivoDAOBD implements AtivoDAO {
    private Conexao conexao;

    public AtivoDAOBD() {
        this.conexao = new Conexao();

    }

    @Override
    public void CadastrarAtivo(Ativo ativo, Long idCarteira) throws Exception {
        this.conexao.conectar();
        String sql = "INSERT INTO ATIVO (id, nome, precoDeCompra, quantidade, idCarteira)" + "VALUES (?, ?, ?,?,?)";
        PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);

        statement.setLong(1, ativo.getId());
        statement.setString(2, ativo.getNome());
        statement.setBigDecimal(3, ativo.getPrecoDeCompra());
        statement.setBigDecimal(4, ativo.getQuantidade());
        statement.setLong(5,idCarteira);


        statement.executeUpdate();

        this.conexao.desconectar();

    }

    @Override
    public void removerAtivo(Long id) throws Exception {
        this.conexao.conectar();
        String sql = "DELETE FROM ATIVO WHERE id = ?";
        PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
        statement.setLong(1, id);
        statement.executeUpdate();
        this.conexao.desconectar();

    }

    @Override
    public Optional<Ativo> buscarAtivo(Long id) throws Exception {
        this.conexao.conectar();
        String sql = "SELECT * FROM ATIVO WHERE id = ?";
        PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
        statement.setLong(1, id);
        ResultSet result = statement.executeQuery();
        Ativo ativo = null;
        while (result.next()) {
            ativo = new Ativo();
            ativo.setId(result.getLong("id"));
            ativo.setNome(result.getString("nome"));
            ativo.setPrecoDeCompra(result.getBigDecimal("precoDeCompra"));
            ativo.setQuantidade(result.getBigDecimal("quantidade"));

        }
        this.conexao.desconectar();

        return Optional.ofNullable(ativo);
    }

    @Override
    public List<Ativo> buscarTodos(Long idCarteira) throws Exception {
        this.conexao.conectar();
        String sql = "SELECT * FROM ATIVO WHERE idCarteira = ?";
        PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
        statement.setLong(1,idCarteira);
        ResultSet result = statement.executeQuery();
        List<Ativo> ativos = new ArrayList<>();
        while (result.next()) {
            Ativo ativo = new Ativo();
            ativo.setId(result.getLong("id"));
            ativo.setNome(result.getString("nome"));
            ativo.setPrecoDeCompra(result.getBigDecimal("precoDeCompra"));
            ativo.setQuantidade(result.getBigDecimal("quantidade"));
            ativos.add(ativo);
        }
        this.conexao.desconectar();

        return ativos;
    }

}
