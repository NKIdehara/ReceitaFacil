package br.edu.infnet.ReceitaFacil.tests;

import br.edu.infnet.ReceitaFacil.domain.Usuario;

public class ReceitaFacilTest {
    public static void main(String[] args) {
        StringBuilder output = new StringBuilder();

        Usuario usuario = new Usuario();
        usuario.setNome("Cozinheiro Chefe");
        usuario.setEmail("cozinheiro@cozinha.com");

        output.append(usuario.toString()).append("\n");
        output.append("test");
        System.out.println(output.toString());
    }
}
