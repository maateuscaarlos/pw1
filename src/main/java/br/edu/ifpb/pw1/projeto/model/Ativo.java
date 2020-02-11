package br.edu.ifpb.pw1.projeto.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Ativo {

    public Long id;
    public String nome;
    public BigDecimal precoDeCompra;
    public BigDecimal quantidade;
    public Disponibilidade disponibilidade;


    public Ativo() {
    }

    public Ativo(Long id, String nome, BigDecimal precoDeCompra, BigDecimal quantidade, Disponibilidade disponibilidade) {
        this.id = id;
        this.nome = nome;
        this.precoDeCompra = precoDeCompra;
        this.quantidade = quantidade;
        this.disponibilidade = disponibilidade;
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

    public Disponibilidade getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(Disponibilidade disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ativo ativo = (Ativo) o;
        return Objects.equals(id, ativo.id) &&
                Objects.equals(nome, ativo.nome) &&
                Objects.equals(precoDeCompra, ativo.precoDeCompra) &&
                Objects.equals(quantidade, ativo.quantidade) &&
                disponibilidade == ativo.disponibilidade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, precoDeCompra, quantidade, disponibilidade);
    }

    @Override
    public String toString() {
        return "Ativo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", precoDeCompra=" + precoDeCompra +
                ", quantidade=" + quantidade +
                ", disponibilidade=" + disponibilidade +
                '}';
    }
}
