package br.com.lana.Calculadora.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class IsNullOperatorException extends RuntimeException {

    // aqui devolve os dados quando o arquivo é nulo


    private static final long serialVersionUID = 1L;

    public IsNullOperatorException(String exception){ super(exception);}
}
