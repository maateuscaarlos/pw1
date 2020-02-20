package br.edu.ifpb.pw1.projeto.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Transacao {

    private Long id;
    private Ativo ativo;
    private User user;
    private LocalDate data;
    private BigDecimal valor;
    private Acao acao;

    public Transacao() {
    }

    public Transacao(Long id, Ativo ativo, User user, LocalDate data, BigDecimal valor, Acao acao) {
        this.id = id;
        this.ativo = ativo;
        this.user = user;
        this.data = data;
        this.valor = valor;
        this.acao = acao;
    }

    public Acao getAcao() {
        return acao;
    }

    public void setAcao(Acao acao) {
        this.acao = acao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Ativo getAtivo() {
        return ativo;
    }

    public void setAtivo(Ativo ativo) {
        this.ativo = ativo;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transacao transacao = (Transacao) o;
        return Objects.equals(id, transacao.id) &&
                Objects.equals(ativo, transacao.ativo) &&
                Objects.equals(user, transacao.user) &&
                Objects.equals(data, transacao.data) &&
                Objects.equals(valor, transacao.valor) &&
                acao == transacao.acao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ativo, user, data, valor, acao);
    }

    @Override
    public String toString() {
        return "Transacao{" +
                "id=" + id +
                ", ativo=" + ativo +
                ", user=" + user +
                ", data=" + data +
                ", valor=" + valor +
                ", acao=" + acao +
                '}';
    }
}
