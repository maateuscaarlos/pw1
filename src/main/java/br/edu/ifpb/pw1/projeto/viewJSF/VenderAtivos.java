package br.edu.ifpb.pw1.projeto.viewJSF;

import br.edu.ifpb.pw1.projeto.DAO.*;
import br.edu.ifpb.pw1.projeto.model.Ativo;
import br.edu.ifpb.pw1.projeto.model.AtivoJson;
import br.edu.ifpb.pw1.projeto.model.Transacao;
import br.edu.ifpb.pw1.projeto.model.User;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@ManagedBean(name="VenderAtivosUser")
@SessionScoped
public class VenderAtivos implements Serializable {

    private List<Ativo> ativos;
    private List<AtivoJson> ativoJsons;
    private User user;
    private AtivoJson comparando;

    public VenderAtivos() throws Exception {
        this.ativos = new ArrayList<>();
        this.ativoJsons= new ArrayList<>();

        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        setUser((User)session.getAttribute("login"));

        AtivoDAO ativoDAO = DaoFactory.criarAtivoDAO();
        this.ativos = ativoDAO.buscarTodos(user.getCarteira().getId());

        ConexaoJsonApi conexaoJsonApi = new ConexaoJsonApi();
        this.ativoJsons = conexaoJsonApi.buscarAtivos();
    }



    public List<Ativo> getAtivos() {
        return ativos;
    }

    public void setAtivos(List<Ativo> ativos) {
        this.ativos = ativos;
    }

    public AtivoJson getComparando() {
        return comparando;
    }

    public void setComparando(AtivoJson comparando) {
        this.comparando = comparando;
    }

    public List<AtivoJson> getAtivoJsons() {
        return ativoJsons;
    }

    public void setAtivoJsons(List<AtivoJson> ativoJsons) {
        this.ativoJsons = ativoJsons;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void vender(Ativo ativo) throws Exception {

        AtivoDAO ativoDAO = DaoFactory.criarAtivoDAO();

        CarteiraDAO carteiraDAO = DaoFactory.criarCarteiraDAO();

        this.user.getCarteira().setValorCaixa(this.user.getCarteira().getValorCaixa().add(ativo.getPrecoDeCompra().multiply(ativo.getQuantidade())));
        carteiraDAO.atualizarSaldo(this.user.getCarteira());

        TransacaoDAO transacaoDAO = DaoFactory.criarTransacaoDAO();

        Transacao transacao = new Transacao();
        transacao.setValor(ativo.getPrecoDeCompra().multiply(ativo.getQuantidade()));
        transacao.setAtivo(ativo);
        transacao.setUser(this.user);
        LocalDate localDate = LocalDate.now();
        transacao.setData(localDate);

        transacaoDAO.cadastrarTransacao(transacao);
        ativoDAO.removerAtivo(ativo.getId());

        ativos.remove(ativo);

    }
    public AtivoJson compararAtivo(String nome) throws Exception {
        comparando = new AtivoJson();
        comparando = ativoJsons.stream().filter( ativoJson -> ativoJson.getNameAtivo().equals(nome)).findFirst().orElseThrow(() -> new Exception());
        return comparando;
    }
    public BigDecimal balanco(Long id) throws Exception {
        BigDecimal resultado = null;
        Ativo ativoPraComparar = new Ativo();
        ativoPraComparar = ativos.stream().filter( ativo -> ativo.getId().equals(id)).findFirst().orElseThrow(() -> new Exception());
        resultado = comparando.getPrice().subtract(ativoPraComparar.getPrecoDeCompra());

        return resultado;
    }
}
