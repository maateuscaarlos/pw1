package br.edu.ifpb.pw1.projeto.command;

import br.edu.ifpb.pw1.projeto.DAO.ConexaoJsonApi;
import br.edu.ifpb.pw1.projeto.model.AtivoJson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class UserNegociacaoCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

        ConexaoJsonApi conexaoJsonApi = new ConexaoJsonApi();
        List<AtivoJson> ativoJsons = new ArrayList<>();
        ativoJsons= conexaoJsonApi.buscarAtivos();


        HttpSession sessao = request.getSession();
        sessao.setAttribute("ativos", ativoJsons);
        request.getRequestDispatcher("usuario/telaNegociacao.jsp").forward(request, response);
    }
}
