package br.edu.ifpb.pw1.projeto.command;

import br.edu.ifpb.pw1.projeto.model.User;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        Jedis jedis =  new Jedis("127.0.0.1", 6379);

        HttpSession sessao = request.getSession();
        User user =(User) sessao.getAttribute("login");
        jedis.del(user.getEmail());

        request.getSession().invalidate();
        response.sendRedirect("index.html");
    }
}
