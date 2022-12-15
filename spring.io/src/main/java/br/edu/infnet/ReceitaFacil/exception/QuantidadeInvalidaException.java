package br.edu.infnet.ReceitaFacil.exception;

public class QuantidadeInvalidaException extends Exception{
	private static final long serialVersionUID = 1L;

    public QuantidadeInvalidaException(String mensagem) {
        super(mensagem);
    }
}
