package br.edu.ifpb.pw1.projeto.model;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class Carteira {

    private Long id;
    private List<Ativo> ativos;
    private BigDecimal valorCaixa;

    public Carteira() {
    }

    public Carteira(Long id, List<Ativo> ativos, BigDecimal valorCaixa) {
        this.id = id;
        this.ativos = ativos;
        this.valorCaixa = valorCaixa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ativo> getAtivos() {
        return ativos;
    }

    public void setAtivos(List<Ativo> ativos) {
        this.ativos = ativos;
    }

    public BigDecimal getValorCaixa() {
        return valorCaixa;
    }

    public void setValorCaixa(BigDecimal valorCaixa) {
        this.valorCaixa = valorCaixa;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Carteira)) return false;
        if (!super.equals(object)) return false;
        Carteira carteira = (Carteira) object;
        return java.util.Objects.equals(getId(), carteira.getId()) &&
                java.util.Objects.equals(getAtivos(), carteira.getAtivos()) &&
                java.util.Objects.equals(getValorCaixa(), carteira.getValorCaixa());
    }

    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getAtivos(), getValorCaixa());
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Carteira{" +
                "id=" + id +
                ", ativos=" + ativos +
                ", valorCaixa=" + valorCaixa +
                '}';
    }
}
