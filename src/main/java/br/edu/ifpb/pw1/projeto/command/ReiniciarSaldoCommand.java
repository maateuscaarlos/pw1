package br.edu.ifpb.pw1.projeto.command;

import br.edu.ifpb.pw1.projeto.DAO.CarteiraDAO;
import br.edu.ifpb.pw1.projeto.DAO.DaoFactory;
import br.edu.ifpb.pw1.projeto.model.Carteira;
import br.edu.ifpb.pw1.projeto.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ReiniciarSaldoCommand implements Command {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        User user = new User();
        user = (User) session.getAttribute("login");

        Carteira carteira2 = new Carteira();
        carteira2 = (Carteira) session.getAttribute("carteira");

        CarteiraDAO carteiraDAO = DaoFactory.criarCarteiraDAO();
        carteiraDAO.reinicarSaldo(carteira2.getId());
        Carteira carteira = carteiraDAO.buscarCarteira(user.getCarteira().getId()).orElseThrow(() -> new ServletException());
        user.setCarteira(carteira);
        session.setAttribute("login", user);
        session.setAttribute("carteira", carteira);



        request.getRequestDispatcher("usuario/dados.jsp").forward(request, response);
    }
}