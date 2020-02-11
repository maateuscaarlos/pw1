package br.edu.ifpb.pw1.projeto.command;

import br.edu.ifpb.pw1.projeto.DAO.AtivoDAO;
import br.edu.ifpb.pw1.projeto.DAO.DaoFactory;
import br.edu.ifpb.pw1.projeto.DAO.TransacaoDAO;
import br.edu.ifpb.pw1.projeto.DAO.UserDAO;
import br.edu.ifpb.pw1.projeto.model.Ativo;
import br.edu.ifpb.pw1.projeto.model.Transacao;
import br.edu.ifpb.pw1.projeto.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

public class HistoricoNegociacoesCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession sessao = request.getSession();

        User user = (User)sessao.getAttribute("login");
        TransacaoDAO transacaoDAO = DaoFactory.criarTransacaoDAO();
        List<Transacao> transacaos = new ArrayList<>();
        transacaos = transacaoDAO.buscarTodos(user.getId());
        AtivoDAO ativoDAO = DaoFactory.criarAtivoDAO();
        Ativo ativo;

        for (int i=0;i<transacaos.size();i++){
            ativo = new Ativo();
            ativo = ativoDAO.buscarAtivo(transacaos.get(i).getAtivo().getId()).orElseThrow(() -> new NullPointerException());
            transacaos.get(i).setUser(user);
            transacaos.get(i).setAtivo(ativo);
        }



        sessao.setAttribute("transacaos", transacaos);
        request.getRequestDispatcher("usuario/historicoNegociacao.jsp").forward(request, response);
    }
}
