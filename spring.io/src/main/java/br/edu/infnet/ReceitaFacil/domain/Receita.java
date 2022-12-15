package br.edu.infnet.ReceitaFacil.domain;

import java.util.List;

public class Receita {
    private String nome;
    private Usuario usuario;
    private List<Prato> pratos;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Prato> getPratos() {
        return pratos;
    }
    public void setPratos(List<Prato> pratos) {
        this.pratos = pratos;
    }

    public int qtdeReceitas() {
        return pratos.size();
    }

    @Override
    public String toString(){
        return String.format("R;%s;%s;%d;%s\n", nome, usuario.toString(), pratos.size(), pratos.toString());
    }
}
