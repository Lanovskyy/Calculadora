package br.com.lana.Calculadora.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidNumberOperationException extends RuntimeException {  // a classe InvalidNumberOperationException é uma herança de RuntimeException

    private static final long serialVersionUID = 1L;

    public InvalidNumberOperationException(String exception){ super(exception);}

}
