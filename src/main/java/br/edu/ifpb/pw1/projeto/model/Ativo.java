package br.edu.ifpb.pw1.projeto.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Ativo {

    public Long id;
    public String nome;
    public BigDecimal precoDeCompra;
    public BigDecimal quantidade;


    public Ativo() {
    }

    public Ativo(Long id, String nome, BigDecimal precoDeCompra, BigDecimal quantidade) {
        this.id = id;
        this.nome = nome;
        this.precoDeCompra = precoDeCompra;
        this.quantidade = quantidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPrecoDeCompra() {
        return precoDeCompra;
    }

    public void setPrecoDeCompra(BigDecimal precoDeCompra) {
        this.precoDeCompra = precoDeCompra;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Ativo)) return false;
        if (!super.equals(object)) return false;
        Ativo ativo = (Ativo) object;
        return java.util.Objects.equals(getId(), ativo.getId()) &&
                java.util.Objects.equals(getNome(), ativo.getNome()) &&
                java.util.Objects.equals(getPrecoDeCompra(), ativo.getPrecoDeCompra()) &&
                java.util.Objects.equals(getQuantidade(), ativo.getQuantidade());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getNome(), getPrecoDeCompra(), getQuantidade());
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Ativo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", precoDeCompra=" + precoDeCompra +
                ", quantidade=" + quantidade +
                '}';
    }
}
