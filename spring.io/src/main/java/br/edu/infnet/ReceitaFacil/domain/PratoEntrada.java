package br.edu.infnet.ReceitaFacil.domain;

import java.util.List;

import br.edu.infnet.ReceitaFacil.exception.QuantidadeInvalidaException;

public class PratoEntrada extends Prato {
    private boolean individual;
    private int unidade;
    private boolean vegetariano;
    
    public boolean isIndividual() {
        return individual;
    }
    public void setIndividual(boolean individual) {
        this.individual = individual;
    }

    public int getUnidade() {
        return unidade;
    }
    public void setUnidade(int unidade) throws QuantidadeInvalidaException {
        if (unidade <= 0)
            throw new QuantidadeInvalidaException("Unidade deve ser maior do que um!");
        this.unidade = unidade;
    }

    public boolean isVegetariano() {
        return vegetariano;
    }
    public void setVegetariano(boolean vegetariano) {
        this.vegetariano = vegetariano;
    }

    public PratoEntrada(String nome, int tempo, List<Ingrediente> ingredientes, String preparo) {
        super(nome, tempo, ingredientes, preparo);
    }

    @Override
    public String toString() {
        StringBuilder prato = new StringBuilder();
        prato
            .append("\nP;")
            .append(super.getNome())
            .append(";")
            .append(String.valueOf(super.getTempo()))
            .append(";")
            .append(super.getPreparo())
            .append(";")
            .append(individual ? "individual" : "compartilhar")
            .append(";")
            .append(String.valueOf(unidade))
            .append(";")
            .append(vegetariano ? "vegetariano" : "não vegetariano")
            .append(";")
            .append(String.valueOf(calcularPeso()));
        for (Ingrediente i : super.getIngrediente()) {
            prato.append("\nI;" + i.toString());
        }
        return prato.toString();
    }
    @Override
    public float calcularPeso() {
        float peso = 0;
        for (Ingrediente i : super.getIngrediente()) {
            peso = peso + unidade*i.getQuantidade();
        }
        return peso;
    }

}
