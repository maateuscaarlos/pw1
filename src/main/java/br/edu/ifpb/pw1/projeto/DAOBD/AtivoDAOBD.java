package br.edu.ifpb.pw1.projeto.DAOBD;

import br.edu.ifpb.pw1.projeto.DAO.AtivoDAO;
import br.edu.ifpb.pw1.projeto.DAO.Conexao;
import br.edu.ifpb.pw1.projeto.model.Ativo;
import br.edu.ifpb.pw1.projeto.model.Disponibilidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AtivoDAOBD implements AtivoDAO {
    private Conexao conexao;

    public AtivoDAOBD() {
        this.conexao = new Conexao();

    }

    @Override
    public Ativo CadastrarAtivo(Ativo ativo, Long idCarteira) throws Exception {
        this.conexao.conectar();
        String sql = "INSERT INTO ATIVO (nome, precoDeCompra, quantidade, idCarteira, disponibilidade)" + "VALUES (?, ?,?,?,?)";
        PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);

        statement.setString(1, ativo.getNome());
        statement.setBigDecimal(2, ativo.getPrecoDeCompra());
        statement.setBigDecimal(3, ativo.getQuantidade());
        statement.setLong(4,idCarteira);
        statement.setString(5,ativo.getDisponibilidade().name());


        statement.executeUpdate();

        this.conexao.desconectar();
        return obterUltimoAtivo();

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
            if(result.getString("disponibilidade") == "DISPONIVEL")
                ativo.setDisponibilidade(Disponibilidade.DISPONIVEL);
            else ativo.setDisponibilidade(Disponibilidade.INDISPONIVEL);

        }
        this.conexao.desconectar();

        return Optional.ofNullable(ativo);
    }

    @Override
    public void updtadeDisponibilidade(Ativo ativo) throws Exception {
        this.conexao.conectar();
        String sql = "UPDATE ATIVO SET disponibilidade = ?  WHERE id = ?";
        PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
        statement.setString(1, ativo.getDisponibilidade().name());
        statement.setLong(2, ativo.getId());

        statement.executeUpdate();

        this.conexao.desconectar();
    }

    @Override
    public List<Ativo> buscarTodos(Long idCarteira, Disponibilidade disponibilidade) throws Exception {
        this.conexao.conectar();
        String sql = "SELECT * FROM ATIVO WHERE idCarteira = ? and disponibilidade = ?";
        PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
        statement.setLong(1,idCarteira);
        statement.setString(2, disponibilidade.name());
        ResultSet result = statement.executeQuery();
        List<Ativo> ativos = new ArrayList<>();
        while (result.next()) {
            Ativo ativo = new Ativo();
            ativo.setId(result.getLong("id"));
            ativo.setNome(result.getString("nome"));
            ativo.setPrecoDeCompra(result.getBigDecimal("precoDeCompra"));
            ativo.setQuantidade(result.getBigDecimal("quantidade"));
            if(result.getString("disponibilidade") == "DISPONIVEL")
                ativo.setDisponibilidade(Disponibilidade.DISPONIVEL);
            else ativo.setDisponibilidade(Disponibilidade.INDISPONIVEL);
            ativos.add(ativo);
        }
        this.conexao.desconectar();

        return ativos;
    }
    private Ativo obterUltimoAtivo() throws Exception {
        String sql = "SELECT * FROM Ativo ORDER BY id DESC LIMIT 1";
        ResultSet rs = null;
        Statement statement = null;
        this.conexao.conectar();

        statement = this.conexao.getConexao().createStatement();
        rs = statement.executeQuery(sql);
        Ativo ativo = null;
        while (rs.next()) {
            ativo = new Ativo();
            ativo.setId(rs.getLong("id"));
            ativo.setQuantidade(rs.getBigDecimal("quantidade"));
            ativo.setPrecoDeCompra(rs.getBigDecimal("precoDeCompra"));
            ativo.setNome(rs.getString("nome"));
            if(rs.getString("disponibilidade") == "DISPONIVEL")
                ativo.setDisponibilidade(Disponibilidade.DISPONIVEL);
            else ativo.setDisponibilidade(Disponibilidade.INDISPONIVEL);
        }
        conexao.desconectar();
        return ativo;
    }

}
