package br.edu.ifpb.pw1.projeto.model;

import java.time.LocalDate;

public class User {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private LocalDate nascimento;
    private Carteira carteira;

    public User(){

    }

    public User(Long id, String nome, String email, String senha, LocalDate nascimento, Carteira carteira) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.nascimento = nascimento;
        this.carteira = carteira;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public Carteira getCarteira() {
        return carteira;
    }

    public void setCarteira(Carteira carteira) {
        this.carteira = carteira;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof User)) return false;
        if (!super.equals(object)) return false;
        User user = (User) object;
        return java.util.Objects.equals(getId(), user.getId()) &&
                java.util.Objects.equals(getNome(), user.getNome()) &&
                java.util.Objects.equals(getEmail(), user.getEmail()) &&
                java.util.Objects.equals(getSenha(), user.getSenha()) &&
                java.util.Objects.equals(getNascimento(), user.getNascimento()) &&
                java.util.Objects.equals(getCarteira(), user.getCarteira());
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), getId(), getNome(), getEmail(), getSenha(), getNascimento(), getCarteira());
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "User{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", nascimento=" + nascimento +
                ", carteira=" + carteira +
                '}';
    }
}
