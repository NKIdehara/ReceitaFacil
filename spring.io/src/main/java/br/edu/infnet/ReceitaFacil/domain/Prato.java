package br.edu.infnet.ReceitaFacil.domain;

import java.util.List;

public abstract class Prato {
    private String nome;
    private int tempo;  // tempo de preparo, em minutos
    private List<Ingrediente> ingredientes;
    private String preparo;
    
    public String getNome() {
        return nome;
    }

    public int getTempo() {
        return tempo;
    }

    public String getPreparo() {
        return preparo;
    }

    public List<Ingrediente> getIngrediente() {
        return ingredientes;
    }

    public Prato(String nome, int tempo, List<Ingrediente> ingredientes, String preparo) {
        this.nome = nome;
        this.tempo = tempo;
        this.ingredientes = ingredientes;
        this.preparo = preparo;
    }

    public abstract float calcularPeso();

    public int qtdeIngredientes() {
        return ingredientes == null ? 0 : ingredientes.size();
    }

    @Override
    public String toString() {
        StringBuilder prato = new StringBuilder();
        prato
            .append("\nP;")
            .append(nome)
            .append(";")
            .append(String.valueOf(tempo))
            .append(";")
            .append(preparo);
        for (Ingrediente i : ingredientes) {
            prato.append("\nI;" + i.toString());
        }
        return prato.toString();
    }
}