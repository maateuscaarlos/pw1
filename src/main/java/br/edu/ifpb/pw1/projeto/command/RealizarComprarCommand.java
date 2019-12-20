package br.edu.ifpb.pw1.projeto.command;

import br.edu.ifpb.pw1.projeto.DAO.*;
import br.edu.ifpb.pw1.projeto.model.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.net.DatagramPacket;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RealizarComprarCommand implements Command {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {


        HttpSession session = request.getSession();
        List<AtivoJson> ativosJson = new ArrayList<>();
        ativosJson = (List<AtivoJson>) session.getAttribute("ativos");
        User user = (User) session.getAttribute("login");

        String idAtivo = request.getParameter("idAtivo");
        BigDecimal quantidade = new BigDecimal(request.getParameter("quantidade"));

        ConexaoJsonApi conexaoJsonApi = new ConexaoJsonApi();

        AtivoJson ativoJson = conexaoJsonApi.buscarAtivoJson(ativosJson,idAtivo).orElseThrow(() -> new ServletException());

        Ativo ativo = new Ativo();

        ativo.setPrecoDeCompra(ativoJson.getPrice());
        ativo.setNome(ativoJson.getNameAtivo());
        ativo.setQuantidade(quantidade);





        Carteira carteira = new Carteira();
        carteira = (Carteira) session.getAttribute("carteira");
        carteira.setValorCaixa(carteira.getValorCaixa().subtract(ativo.getPrecoDeCompra().multiply(ativo.getQuantidade())));

        AtivoDAO ativoDAO= DaoFactory.criarAtivoDAO();
        ativo = ativoDAO.CadastrarAtivo(ativo,carteira.getId());

        CarteiraDAO carteiraDAO = DaoFactory.criarCarteiraDAO();
        carteiraDAO.atualizarSaldo(carteira);
        user.setCarteira(carteira);

        Transacao transacao = new Transacao();
        transacao.setValor(ativo.getPrecoDeCompra().multiply(ativo.getQuantidade()));
        transacao.setAtivo(ativo);
        transacao.setUser(user);
        LocalDate localDate = LocalDate.now();
        transacao.setData(localDate);

        TransacaoDAO transacaoDAO = DaoFactory.criarTransacaoDAO();
        transacaoDAO.cadastrarTransacao(transacao);


        session.setAttribute("login", user);
        session.setAttribute("carteira", carteira);

        request.getRequestDispatcher("usuario/telaNegociacao.jsp").forward(request, response);

    }
}
