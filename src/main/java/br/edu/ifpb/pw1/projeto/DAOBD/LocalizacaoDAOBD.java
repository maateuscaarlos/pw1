package br.edu.ifpb.pw1.projeto.DAOBD;

import br.edu.ifpb.pw1.projeto.DAO.Conexao;
import br.edu.ifpb.pw1.projeto.model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LocalizacaoDAOBD {
    private Conexao conexao;

    public LocalizacaoDAOBD (){ conexao = new Conexao();};

    public void salvarLocalizacao(String latitude, String logitude, User usuario) throws Exception {
        this.conexao.conectar();
        String query = "INSERT INTO locallogin (idususario, geometria) values (?,?)";
        String pontoUm = "ST_GeomFromText('POINT(" + latitude + " " + logitude + ")')";
        try {
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(query);
            statement.setLong(1, usuario.getId());
            statement.setString(2, pontoUm);
            statement.executeUpdate();
        }catch (Exception e){

        }finally {
            this.conexao.desconectar();
        }
        System.out.println("foi");
    }
    public String recuperarLocalizacao(User usuario) throws Exception {
        String pos = new String();
        this.conexao.conectar();
        String query = "SELECT geometria FROM pontos WHERE idUsusario = ?";
        try {
            PreparedStatement statement = this.conexao.getConexao().prepareStatement(query);
            statement.setLong(1, usuario.getId());
            ResultSet rs = statement.executeQuery();
            pos = rs.getString("geometria");
        }catch (Exception e){

        }finally {
            this.conexao.desconectar();
        }
        return pos;
    }
}
