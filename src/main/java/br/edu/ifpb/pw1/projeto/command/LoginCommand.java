package br.edu.ifpb.pw1.projeto.command;

import br.edu.ifpb.pw1.projeto.DAO.CarteiraDAO;
import br.edu.ifpb.pw1.projeto.DAO.DaoFactory;
import br.edu.ifpb.pw1.projeto.DAO.UserDAO;
import br.edu.ifpb.pw1.projeto.model.Carteira;
import br.edu.ifpb.pw1.projeto.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LoginCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {


        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        UserDAO userDAO = DaoFactory.criarUserDAO();
        User user = userDAO.autenticarUser(email, senha).orElseThrow(() -> new ServletException());

        CarteiraDAO carteiraDAO = DaoFactory.criarCarteiraDAO();
        Carteira carteiaUser = carteiraDAO.buscarCarteira(user.getCarteira().getId()).orElseThrow(() -> new ServletException());
        user.setCarteira(carteiaUser);



        HttpSession sessao = request.getSession();
        sessao.setAttribute("login", user);
        sessao.setAttribute("carteira", carteiaUser);

        request.getRequestDispatcher("usuario.jsp").forward(request, response);

    }
}
