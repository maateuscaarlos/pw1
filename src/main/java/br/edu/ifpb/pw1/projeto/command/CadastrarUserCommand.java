package br.edu.ifpb.pw1.projeto.command;

import br.edu.ifpb.pw1.projeto.DAO.CarteiraDAO;
import br.edu.ifpb.pw1.projeto.DAO.DaoFactory;
import br.edu.ifpb.pw1.projeto.DAO.UserDAO;
import br.edu.ifpb.pw1.projeto.DAOBD.UserDAOBD;
import br.edu.ifpb.pw1.projeto.model.Carteira;
import br.edu.ifpb.pw1.projeto.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CadastrarUserCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String nascimento = request.getParameter("dataNasc");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(nascimento,formatter);

        User user = new User();
        user.setNome(nome);
        user.setEmail(email);
        user.setSenha(senha);
        user.setNascimento(date);


        UserDAO userDAO = new UserDAOBD();
        CarteiraDAO carteiraDAO = DaoFactory.criarCarteiraDAO();
        Carteira carteira = carteiraDAO.cadastrarCarteira();
        user.setCarteira(carteira);

        if(userDAO.cadastrarUser(user)){
            response.sendRedirect("index.html");
        }
        else carteiraDAO.removerCarteira(carteira.getId());

    }
}
