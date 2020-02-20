package br.edu.ifpb.pw1.projeto.DAOBD;

import br.edu.ifpb.pw1.projeto.DAO.Conexao;
import br.edu.ifpb.pw1.projeto.DAO.TransacaoDAO;
import br.edu.ifpb.pw1.projeto.model.*;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class TransacaoDAOBD implements TransacaoDAO {
    private Conexao conexao;

    public TransacaoDAOBD() {
        this.conexao = new Conexao();
    }

    @Override
    public void cadastrarTransacao(Transacao transacao) throws Exception {
        this.conexao.conectar();
        String sql = "INSERT INTO TRANSACAO (idAtivo, idUser, dia, valor, acao)" + "VALUES (?, ?,?,?,?)";
        PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);

        statement.setLong(1, transacao.getAtivo().getId());
        statement.setLong(2, transacao.getUser().getId());
        statement.setDate(3, java.sql.Date.valueOf(transacao.getData()));
        statement.setBigDecimal(4,transacao.getValor());
        statement.setString(5,transacao.getAcao().name());


        statement.executeUpdate();

        this.conexao.desconectar();

    }

    @Override
    public void removerTransacao(Long id) throws Exception {
        this.conexao.conectar();
        String sql = "DELETE FROM TRANSACAO WHERE id = ?";
        PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
        statement.setLong(1, id);
        statement.executeUpdate();
        this.conexao.desconectar();

    }

    @Override
    public Optional<Transacao> buscarTransacao(Long id) throws Exception {
        this.conexao.conectar();
        String sql = "SELECT * FROM TRANSACAO WHERE id = ?";
        PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
        statement.setLong(1, id);
        ResultSet result = statement.executeQuery();
        Transacao transacao = null;
        while (result.next()) {
            transacao = new Transacao();
            transacao.setId(result.getLong("id"));
            transacao.getAtivo().setId(result.getLong("idAtivo"));
            transacao.getUser().setId(result.getLong("idUser"));
            transacao.setValor(result.getBigDecimal("valor"));
            Date dia = result.getDate("dia");
            transacao.setData(dia.toInstant().atZone( ZoneId.systemDefault() ).toLocalDate());
            if(result.getString("acao") == "VENDA")
                transacao.setAcao(Acao.VENDA);
            else transacao.setAcao(Acao.COMPRA);

        }
        this.conexao.desconectar();

        return Optional.ofNullable(transacao);
    }

    @Override
    public List<Transacao> buscarTodos(Long idUser) throws Exception {
        this.conexao.conectar();
        String sql = "SELECT * FROM TRANSACAO WHERE idUser = ?";
        PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
        statement.setLong(1,idUser);
        ResultSet result = statement.executeQuery();
        List<Transacao> transacoes = new ArrayList<>();
        while (result.next()) {
            Transacao transacao = new Transacao();

            transacao.setId(result.getLong("id"));
            Ativo ativo = new Ativo();
            ativo.setId(result.getLong("idAtivo"));
            transacao.setAtivo(ativo);
            User user = new User();

            user.setId(result.getLong("idUser"));
            transacao.setUser(user);
            transacao.setValor(result.getBigDecimal("valor"));

            if(result.getString("acao") == "VENDA")
                transacao.setAcao(Acao.VENDA);
            else transacao.setAcao(Acao.COMPRA);

            Date dia = result.getDate("dia");
            String data = new SimpleDateFormat("dd/MM/yyyy").format(dia);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate date = LocalDate.parse(data,formatter);
            transacao.setData(date);

            transacoes.add(transacao);
        }
        this.conexao.desconectar();

        return transacoes;
    }
}
