package br.edu.infnet.ReceitaFacil.tests;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.ReceitaFacil.domain.Ingrediente;
import br.edu.infnet.ReceitaFacil.domain.Prato;
import br.edu.infnet.ReceitaFacil.domain.PratoEntrada;
import br.edu.infnet.ReceitaFacil.domain.PratoPrincipal;
import br.edu.infnet.ReceitaFacil.domain.PratoSobremesa;
import br.edu.infnet.ReceitaFacil.domain.Receita;
import br.edu.infnet.ReceitaFacil.domain.Usuario;
import br.edu.infnet.ReceitaFacil.exception.QuantidadeInvalidaException;

@RestController
public class ReceitaFacilTestController {
    @RequestMapping("/test")
    public String screenOutput () {
        StringBuilder output = new StringBuilder();

        Usuario usuario = new Usuario("Cozinheiro Chefe", "cozinheiro@cozinha.com", null);

        // RECEITA 1
        Receita receita1 = new Receita();
        receita1.setNome("Almoço com Frango");
        receita1.setUsuario(usuario);

        List<Prato> pratos_receita1 = new ArrayList<Prato>();

        List<Ingrediente> i11 = new ArrayList<>();
        i11.add(new Ingrediente("azeitona", 5.0f, false));
        i11.add(new Ingrediente("oregano", 1.5f, false));
        try {
            PratoEntrada prato1_receita1 = new PratoEntrada("Azeitonas Temperadas", 0, i11, "Colocar o orégano nas azeitonas");
            prato1_receita1.setIndividual(true);
            prato1_receita1.setUnidade(5);
            prato1_receita1.setVegetariano(true);
            pratos_receita1.add(prato1_receita1); 
        } catch (QuantidadeInvalidaException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

        List<Ingrediente> i12 = new ArrayList<>();
        i12.add(new Ingrediente("frango", 500.0f, false));
        i12.add(new Ingrediente("mostarda", 50.0f, true));
        try {
            PratoPrincipal prato2_receita1 = new PratoPrincipal("Frango com Mostarda", 50, i12, "Temperar o frango e colocar no forno");
            prato2_receita1.setMolho(true);
            prato2_receita1.setQtdePessoas(3);
            prato2_receita1.setTipo("proteína");
            pratos_receita1.add(prato2_receita1);
        } catch (QuantidadeInvalidaException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

        receita1.setPratos(pratos_receita1);

        // RECEITA 2
        Receita receita2 = new Receita();
        receita2.setNome("Jantar com Peixe");
        receita2.setUsuario(usuario);

        List<Prato> pratos_receita2 = new ArrayList<Prato>();

        List<Ingrediente> i21 = new ArrayList<>();
        i21.add(new Ingrediente("peixe", 300.0f, false));
        i21.add(new Ingrediente("azeite", 10.0f, true));
        i21.add(new Ingrediente("sal", 5.0f, false));
        try {
            PratoPrincipal prato1_receita2 = new PratoPrincipal("Peixe Assado", 30, i21, "Temperar o peixe com sal e azeite e colocar no forno");
            prato1_receita2.setMolho(false);
            prato1_receita2.setQtdePessoas(2);
            prato1_receita2.setTipo("proteína");
            pratos_receita2.add(prato1_receita2);
        } catch (QuantidadeInvalidaException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

        List<Ingrediente> i22 = new ArrayList<>();
        i22.add(new Ingrediente("morango", 20.0f, false));
        i22.add(new Ingrediente("creme de leite", 5.0f, true));
        try {
            PratoSobremesa prato2_receita2 = new PratoSobremesa("Morango com Creme de Leite", 0, i22, "Cortar os morangos e colocar creme de leite");
            prato2_receita2.setQuente(false);
            prato2_receita2.setSaudavel(true);
            prato2_receita2.setPedacos(10);
            pratos_receita2.add(prato2_receita2);
        } catch (QuantidadeInvalidaException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }

        receita2.setPratos(pratos_receita2);

        output.append(receita1.toString());
        output.append(receita2.toString());
        System.out.println(output.toString());
        
        return toHtml(output.toString());
    }

    private String toHtml(String text) {
        return text.replace("\n", "<br>");
    }
}
