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
    public void CadastrarCarteira(Carteira carteira) throws Exception {
        carteira.setId(obterNumID());
        carteira.setValorCaixa(new BigDecimal(0.0));
        this.conexao.conectar();
        String sql = "INSERT INTO CARTEIRA (id, valorCaixa)" + "VALUES (?, ?)";
        PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);

        statement.setLong(1, carteira.getId());
        statement.setBigDecimal(2, carteira.getValorCaixa());

        statement.executeUpdate();

        this.conexao.desconectar();

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
        String sql = "SELECT * FROM user WHERE id = ?";
        PreparedStatement statement = this.conexao.getConexao().prepareStatement(sql);
        statement.setLong(1, id);
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
    private Long obterNumID() throws Exception {
        String sql = "SELECT MAX(id) maior FROM Carteira";
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
