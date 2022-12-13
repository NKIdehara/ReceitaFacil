package br.edu.infnet.ReceitaFacil;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ReceitaFacilTestController {
    @RequestMapping("/test")
    public String teste() {
        return "Receita Fácil!!";
    }
    
}
