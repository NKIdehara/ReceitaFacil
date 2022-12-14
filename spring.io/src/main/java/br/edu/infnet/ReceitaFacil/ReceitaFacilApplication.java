package br.edu.infnet.ReceitaFacil;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.infnet.ReceitaFacil.tests.ReceitaFacilTestController;

@SpringBootApplication
public class ReceitaFacilApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReceitaFacilApplication.class, args);

		new ReceitaFacilTestController();
	}

}
