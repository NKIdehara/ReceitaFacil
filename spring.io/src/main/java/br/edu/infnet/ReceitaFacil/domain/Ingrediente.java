package br.edu.infnet.ReceitaFacil.domain;

public class Ingrediente {
    private String nome;
    private float quantidade;
    private boolean liquido;

    public String getNome() {
        return nome;
    }
    public float getQuantidade() {
        return quantidade;
    }
    public boolean isLiquido() {
        return liquido;
    }

    public Ingrediente(String nome, float quantidade, boolean liquido) {
        this.nome = nome;
        this.quantidade = quantidade;
        this.liquido = liquido;
    }

    @Override
    public String toString() {
        return String.format("%s;%5.2f;%s", nome, quantidade, liquido ? "líquido" : "sólido");
    }
}

