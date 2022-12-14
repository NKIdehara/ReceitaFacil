package br.edu.infnet.ReceitaFacil.domain;

public class Usuario {
    private String nome;
    private String email;
    private String senha;

    public void setNome(String nome) {
        this.nome = nome;        
    }

    public String getNome() {
        return this.nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    @Override
    public String toString() {
        StringBuilder usuario = new StringBuilder();
        usuario.append("Usuário: ")
            .append(nome)
            .append(" | ")
            .append("email: ")
            .append(email)
            .append(" | ")
            .append("senha: ")
            .append(senha);
        
        return usuario.toString();
    }
}