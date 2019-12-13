package br.edu.ifpb.pw1.projeto.command;

import br.edu.ifpb.pw1.projeto.DAO.DaoFactory;
import br.edu.ifpb.pw1.projeto.DAO.UserDAO;
import br.edu.ifpb.pw1.projeto.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EditarUserCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HttpSession session = request.getSession();
        User user = new User();
        user = (User) session.getAttribute("login");

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String confimar = request.getParameter("confirmarsenha");


            user.setNome(nome);
            user.setEmail(email);
            user.setSenha(senha);
            UserDAO userDAO = DaoFactory.criarUserDAO();
            userDAO.atualizarUser(user);

            session.setAttribute("login", user);

            new UserDadosCommand().execute(request, response);



    }
}
