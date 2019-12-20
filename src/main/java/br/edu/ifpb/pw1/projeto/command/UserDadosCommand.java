package br.edu.ifpb.pw1.projeto.command;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserDadosCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) {

        try {
            request.getRequestDispatcher("/usuario/dados.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
