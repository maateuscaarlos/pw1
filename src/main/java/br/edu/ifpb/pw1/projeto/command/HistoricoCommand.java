package br.edu.ifpb.pw1.projeto.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HistoricoCommand implements Command{
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.getRequestDispatcher("usuario/historicoJSF.xhtml").forward(request, response);
    }
}
