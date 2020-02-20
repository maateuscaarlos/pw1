package br.edu.ifpb.pw1.projeto.viewJSF;

import br.edu.ifpb.pw1.projeto.DAO.AtivoDAO;
import br.edu.ifpb.pw1.projeto.DAO.DaoFactory;
import br.edu.ifpb.pw1.projeto.DAO.TransacaoDAO;
import br.edu.ifpb.pw1.projeto.model.Ativo;
import br.edu.ifpb.pw1.projeto.model.Transacao;
import br.edu.ifpb.pw1.projeto.model.User;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name="Historico")
@SessionScoped
public class Historico implements Serializable {
    private List<Transacao> transacoes;
    private User user;
    public Historico() throws Exception {
        FacesContext fc = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fc.getExternalContext().getSession(false);
        setUser((User)session.getAttribute("login"));
        transacoes = new ArrayList<>();

        TransacaoDAO transacaoDAO = DaoFactory.criarTransacaoDAO();
        AtivoDAO ativoDAO = DaoFactory.criarAtivoDAO();

        transacoes = transacaoDAO.buscarTodos(user.getId());
        Ativo ativo;

        for (int i=0;i<transacoes.size();i++){
            ativo = new Ativo();
            ativo = ativoDAO.buscarAtivo(transacoes.get(i).getAtivo().getId()).orElseThrow(() -> new NullPointerException());
            transacoes.get(i).setUser(user);
            transacoes.get(i).setAtivo(ativo);
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Transacao> getTransacoes() {
        return transacoes;
    }

    public void setTransacoes(List<Transacao> transacoes) {
        this.transacoes = transacoes;
    }
}
