package br.edu.infnet.ReceitaFacil.domain;

import java.util.List;

import br.edu.infnet.ReceitaFacil.exception.QuantidadeInvalidaException;

public class PratoSobremesa extends Prato {
    private boolean quente;
    private boolean saudavel;
    private int pedacos;

    public boolean isQuente() {
        return quente;
    }
    public void setQuente(boolean quente) {
        this.quente = quente;
    }

    public boolean isSaudavel() {
        return saudavel;
    }
    public void setSaudavel(boolean saudavel) {
        this.saudavel = saudavel;
    }

    public int getPedacos() {
        return pedacos;
    }
    public void setPedacos(int pedacos) throws QuantidadeInvalidaException {
        if (pedacos <= 0)
            throw new QuantidadeInvalidaException("Quantidade de pedaços deve ser maior do que um!");
        this.pedacos = pedacos;
    }

    public PratoSobremesa(String nome, int tempo, List<Ingrediente> ingredientes, String preparo) {
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
            .append(quente ? "quente" : "frio")
            .append(";")
            .append(String.valueOf(pedacos))
            .append(";")
            .append(saudavel ? "saudável" : "gostoso")
            .append(";")
            .append(String.valueOf(calcularPeso()));
        if (super.qtdeIngredientes() > 0)
            for (Ingrediente i : super.getIngrediente()) {
                prato.append("\nI;" + i.toString());
            }
        return prato.toString();
    }

    @Override
    public float calcularPeso() {
        float peso = 0;
        if (super.qtdeIngredientes() > 0)
            for (Ingrediente i : super.getIngrediente()) {
                peso = peso + pedacos*i.getQuantidade();
            }
        return peso;
    }
}
