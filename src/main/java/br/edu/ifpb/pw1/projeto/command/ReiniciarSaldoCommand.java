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
@WebServlet(name = "reiniciarSaldo", urlPatterns = {"/reiniciarSaldo"})
public class ReiniciarSaldoCommand  {

    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        User user = new User();
        user = (User) session.getAttribute("login");

        CarteiraDAO carteiraDAO = DaoFactory.criarCarteiraDAO();
        carteiraDAO.reinicarSaldo(user.getCarteira().getId());
        Carteira carteira = carteiraDAO.buscarCarteira(user.getCarteira().getId()).orElseThrow(() -> new ServletException());
        user.setCarteira(carteira);
        session.setAttribute("login", user);


        response.sendRedirect("usuario.html");
    }
}
