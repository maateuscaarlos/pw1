package br.edu.ifpb.pw1.projeto.model;

public enum NomeAtivo {

    AmBev("ABEV3.SA"),
    BancoDoBrasil("BBAS3.SA"),
    BRF("BRFS3.SA"),
    CCR("CCRO3.SA"),
    Copel("CPLE6.SA");


    private String nome;

    private NomeAtivo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
