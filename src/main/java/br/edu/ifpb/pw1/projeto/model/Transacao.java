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

    public Transacao() {
    }

    public Transacao(Long id, Ativo ativo, User user, LocalDate data, BigDecimal valor) {
        this.id = id;
        this.ativo = ativo;
        this.user = user;
        this.data = data;
        this.valor = valor;
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

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Transacao)) return false;
        if (!super.equals(object)) return false;
        Transacao trasacao = (Transacao) object;
        return java.util.Objects.equals(getId(), trasacao.getId()) &&
                java.util.Objects.equals(getAtivo(), trasacao.getAtivo()) &&
                java.util.Objects.equals(getUser(), trasacao.getUser()) &&
                java.util.Objects.equals(getData(), trasacao.getData()) &&
                java.util.Objects.equals(getValor(), trasacao.getValor());
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getAtivo(), getUser(), getData(), getValor());
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Trasacao{" +
                "id=" + id +
                ", ativo=" + ativo +
                ", user=" + user +
                ", data=" + data +
                ", valor=" + valor +
                '}';
    }
}
