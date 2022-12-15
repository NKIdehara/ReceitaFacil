package br.edu.infnet.ReceitaFacil.domain;

import java.util.List;

import br.edu.infnet.ReceitaFacil.exception.QuantidadeInvalidaException;

public class PratoPrincipal extends Prato {
    private String tipo;      // acompanhamento, proteína
    private int qtdePessoas;
    private boolean molho;

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQtdePessoas() {
        return qtdePessoas;
    }
    public void setQtdePessoas(int qtdePessoas) throws QuantidadeInvalidaException {
        if (qtdePessoas <= 0)
            throw new QuantidadeInvalidaException("Quantidade de pessoas deve ser maior do que um!");
        this.qtdePessoas = qtdePessoas;
    }

    public boolean isMolho() {
        return molho;
    }
    public void setMolho(boolean molho) {
        this.molho = molho;
    }

    public PratoPrincipal(String nome, int tempo, List<Ingrediente> ingredientes, String preparo) {
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
            .append(tipo)
            .append(";")
            .append(String.valueOf(qtdePessoas))
            .append(";")
            .append(molho ? "com molho" : "sem molho")
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
            peso = peso + qtdePessoas*i.getQuantidade();
        }
        return peso;
    }

}
