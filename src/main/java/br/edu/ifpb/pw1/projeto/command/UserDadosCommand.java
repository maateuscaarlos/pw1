package br.edu.ifpb.pw1.projeto.command;

import br.edu.ifpb.pw1.projeto.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserDadosCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getRequestDispatcher("usuario/dados.jsp").forward(request, response);
    }
}
