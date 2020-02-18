package br.edu.ifpb.pw1.projeto.command;

import br.edu.ifpb.pw1.projeto.DAO.CarteiraDAO;
import br.edu.ifpb.pw1.projeto.DAO.DaoFactory;
import br.edu.ifpb.pw1.projeto.DAO.UserDAO;
import br.edu.ifpb.pw1.projeto.DAOBD.LocalizacaoDAOBD;
import br.edu.ifpb.pw1.projeto.model.Carteira;
import br.edu.ifpb.pw1.projeto.model.User;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

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
        String latitude = request.getParameter("latitude");
        String longitude = request.getParameter("longitude");

        LocalizacaoDAOBD localizacaoDAOBD = new LocalizacaoDAOBD();
        UserDAO userDAO = DaoFactory.criarUserDAO();
        User user = userDAO.autenticarUser(email, senha).orElseThrow(() -> new ServletException());
        CarteiraDAO carteiraDAO = DaoFactory.criarCarteiraDAO();
        Carteira carteiaUser = carteiraDAO.buscarCarteira(user.getCarteira().getId()).orElseThrow(() -> new ServletException());
        user.setCarteira(carteiaUser);
        localizacaoDAOBD.salvarLocalizacao(latitude, longitude, user);



        HttpSession sessao = request.getSession();
        sessao.setAttribute("login", user);
        sessao.setAttribute("carteira", carteiaUser);

        Jedis jedis =  new Jedis("127.0.0.1", 6379);
        jedis.set(user.getEmail(),sessao.getId(), SetParams.setParams());

        System.out.println(latitude + longitude);
        request.getRequestDispatcher("/usuario/usuario.jsp").forward(request, response);

    }
}
