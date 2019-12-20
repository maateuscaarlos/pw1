package br.edu.ifpb.pw1.projeto.DAOBD;

import br.edu.ifpb.pw1.projeto.DAO.CarteiraDAO;
import br.edu.ifpb.pw1.projeto.DAO.Conexao;
import br.edu.ifpb.pw1.projeto.model.Carteira;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;

public class CarteiraDAOBD implements CarteiraDAO {
    private Conexao conexao;

    public CarteiraDAOBD() {
        this.conexao = new Conexao();
    }

    @Override
    public Carteira cadastrarCarteira() throws Exception {

        this.conexao.conectar();
        String sql = "INSERT INTO CARTEIRA (valorCaixa)" + "VALUES (?)";
        PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);

        statement.setBigDecimal(1, new BigDecimal(10000.00));

        statement.executeUpdate();

        this.conexao.desconectar();
        return obterUltimaCarteira();

    }

    @Override
    public void removerCarteira(Long id) throws Exception {
        this.conexao.conectar();
        String sql = "DELETE FROM CARTEIRA WHERE id = ?";
        PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
        statement.setLong(1, id);
        statement.executeUpdate();
        this.conexao.desconectar();

    }

    @Override
    public Optional<Carteira> buscarCarteira(Long id) throws Exception {
        this.conexao.conectar();
        String sql = "SELECT * FROM carteira WHERE id = ?";
        PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
        int idCarteira = Integer.parseInt(String.valueOf(id));
        statement.setInt(1, idCarteira);
        ResultSet result = statement.executeQuery();
        Carteira carteira = null;
        while (result.next()) {
            carteira = new Carteira();
            carteira.setId(result.getLong("id"));
            carteira.setValorCaixa(result.getBigDecimal("valorCaixa"));


        }
        this.conexao.desconectar();

        return Optional.ofNullable(carteira);
    }

    @Override
    public void reinicarSaldo(Long id) throws Exception {
        this.conexao.conectar();
        String sql = "UPDATE CARTEIRA SET valorCaixa = 10000.00 WHERE id = ?" + "VALUES (?)";
        PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);

        statement.setLong(1, id);

        statement.executeUpdate();

        this.conexao.desconectar();
        }

    @Override
    public void atualizarSaldo(Carteira carteira) throws Exception {
        this.conexao.conectar();
        String sql = "UPDATE Carteira SET valorCaixa = ? WHERE id = ?";
        PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);

        statement.setBigDecimal(1, carteira.getValorCaixa());
        statement.setLong(2, carteira.getId());

        statement.executeUpdate();

        this.conexao.desconectar();

    }


    private Carteira obterUltimaCarteira() throws Exception {
        String sql = "SELECT * FROM Carteira ORDER BY id DESC LIMIT 1";
        ResultSet rs = null;
        Statement statement = null;
        this.conexao.conectar();


        statement = this.conexao.getConexao().createStatement();
        rs = statement.executeQuery(sql);
        Carteira carteira = null;
        while (rs.next()) {
            carteira = new Carteira();
            carteira.setId(rs.getLong("id"));
            carteira.setValorCaixa(rs.getBigDecimal("valorCaixa"));
        }


            conexao.desconectar();
            return carteira;
    }
}
