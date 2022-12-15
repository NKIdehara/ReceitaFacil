package br.edu.infnet.ReceitaFacil.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.ReceitaFacil.domain.PratoEntrada;
import br.edu.infnet.ReceitaFacil.domain.PratoPrincipal;
import br.edu.infnet.ReceitaFacil.domain.PratoSobremesa;
import br.edu.infnet.ReceitaFacil.domain.Prato;
import br.edu.infnet.ReceitaFacil.domain.Receita;
import br.edu.infnet.ReceitaFacil.domain.Usuario;
import br.edu.infnet.ReceitaFacil.exception.QuantidadeInvalidaException;

public class ArquivoTest {
    public static void main(String[] args) {
        String DIR = "./";
        String ARQ_IN  = "in_teste.txt";
        String ARQ_OUT = "out_teste.txt";

        try {
            FileReader fileIn = new FileReader(DIR + ARQ_IN);
            BufferedReader leitura = new BufferedReader(fileIn);

            FileWriter fileOut = new FileWriter(DIR + ARQ_OUT);
            BufferedWriter escrita = new BufferedWriter(fileOut);

            String linha = leitura.readLine();
            String[] campos = null;

            StringBuilder output = null;            

            Usuario usuario = null;
            Receita receita = null;
            PratoEntrada entrada = null;
            PratoPrincipal principal = null;
            PratoSobremesa sobremesa = null;
            List<Prato> pratos = new ArrayList<>();

            while (linha != null) {
                campos = linha.split(";");

                switch (campos[0].toUpperCase()) {
					case "U": // USUÁRIO
                        usuario = new Usuario(campos[1], campos[2], campos[3]);
                        pratos.clear();
                        break;
                    case "R": // RECEITA
                        receita = new Receita();
                        receita.setNome(campos[1]);
                        receita.setUsuario(usuario);
                        receita.setPratos(pratos);

                        output = new StringBuilder();
                        output.append(usuario.getNome());
                        output.append(";");
                        output.append(receita.getNome());
                        output.append(";");
                        output.append(Integer.toString(receita.qtdeReceitas()));
                        output.append("\n");

                        escrita.write(output.toString());
                        System.out.print(output.toString());
                        break;
                    case "E": // ENTRADA
                        entrada = new PratoEntrada(campos[1], Integer.parseInt(campos[2]), null, campos[4]);
                        entrada.setIndividual(campos[5] == "true" ? true : false);
                        entrada.setUnidade(Integer.parseInt(campos[6]));
                        entrada.setVegetariano(campos[7] == "true" ? true : false);
                        pratos.add(entrada);
                        break;
                    case "P": // PRATO PRINCIPAL
                        principal = new PratoPrincipal(campos[1], Integer.parseInt(campos[2]), null, campos[4]);
                        principal.setTipo(campos[5]);
                        principal.setQtdePessoas(Integer.parseInt(campos[6]));
                        principal.setMolho(campos[7] == "true" ? true : false);
                        pratos.add(principal);
                        break;
                    case "S": // SOBREMESA
                        sobremesa = new PratoSobremesa(campos[1], Integer.parseInt(campos[2]), null, campos[4]);
                        sobremesa.setQuente(campos[5] == "true" ? true : false);
                        sobremesa.setSaudavel(campos[6] == "true" ? true : false);
                        sobremesa.setPedacos(Integer.parseInt(campos[7]));
                        pratos.add(sobremesa);
                        break;
					default:
                        System.out.println("[ERROR] " + linha);
						break;
					}

                linha = leitura.readLine();
            }
            escrita.close();
            fileOut.close();

            leitura.close();
            fileIn.close();       
        } catch (IOException | NumberFormatException | QuantidadeInvalidaException e) {
            System.out.println("[ERROR] " + e.getMessage());
        }
    }
}
