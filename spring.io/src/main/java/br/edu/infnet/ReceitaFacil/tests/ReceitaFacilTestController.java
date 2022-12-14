package br.edu.infnet.ReceitaFacil.tests;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.ReceitaFacil.domain.Usuario;

@RestController
public class ReceitaFacilTestController {
    @RequestMapping("/test")
    public String screenOutput () {
        
        StringBuilder output = new StringBuilder();

        Usuario usuario = new Usuario();
        usuario.setNome("Cozinheiro Chefe");
        usuario.setEmail("cozinheiro@cozinha.com");

        output.append(usuario.toString()).append("\n");
        output.append("test OK!");
        System.out.println(output.toString());
        
        return toHtml(output.toString());
    }

    private String toHtml(String text) {
        return text.replace("\n", "<br>");
    }
}
