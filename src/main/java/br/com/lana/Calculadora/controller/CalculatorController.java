package br.com.lana.Calculadora.controller;

import br.com.lana.Calculadora.exeptions.InvalidNumberOperationException;
import br.com.lana.Calculadora.exeptions.IsNullOperatorException;
import br.com.lana.Calculadora.model.Calculator;
import org.springframework.web.bind.annotation.*;

import java.util.InvalidPropertiesFormatException;

@RestController
public class CalculatorController {

    // AQUI EU DEFINI AS ROTAS E O MÉTODO--------------------------------------------------------

    @RequestMapping(value = "/sum", method = RequestMethod.GET)
    public  float sum(@RequestParam("n1") String n1, @RequestParam("n2") String n2) {

        //Quando for nulo
        if(isNull(n1) || isNull(n2)){
            throw new IsNullOperatorException("Por favor, coloque algum valor!");
        }

        //Quando não for valor numérico
        if(!isNumeric(n1) || !isNumeric(n2)){
            throw new InvalidNumberOperationException("Por favor, coloque números válidos!");   //infelizmente não aparece no postman :(
        }
        return Calculator.sum(Float.parseFloat(n1), Float.parseFloat(n2));
    }

    @RequestMapping(value = "/minus", method = RequestMethod.GET)
    public float minus(@RequestParam("n1") String n1, @RequestParam("n2") String n2)
    {
        //Quando for nulo
        if(isNull(n1) || isNull(n2)){
            throw new IsNullOperatorException("Por favor, coloque algum valor!");
        }

        if (!isNumeric(n1) || !isNumeric(n2)){
            throw new IsNullOperatorException("Coloque números válidos!");
        }
        return Calculator.minus(Float.parseFloat(n1), Float.parseFloat(n2));
    }

    @RequestMapping(value = "/divi", method = RequestMethod.GET)
    public float divi(@RequestParam("n1") String n1, @RequestParam("n2") String n2)
    {

        //Quando for nulo
        if(isNull(n1) || isNull(n2)){
            throw new IsNullOperatorException("Por favor, coloque algum valor!");
        }

        if (!isNumeric(n1) || !isNumeric(n2)){
            throw new InvalidNumberOperationException("Coloque números válidos!");
        }
        return Calculator.divi(Float.parseFloat(n1), Float.parseFloat(n2));
    }

    @RequestMapping(value = "/multi", method = RequestMethod.GET)
    public float multi(@RequestParam("n1") String n1, @RequestParam("n2") String n2)
    {
        //Quando for nulo
        if(isNull(n1) || isNull(n2)){
            throw new IsNullOperatorException("Por favor, coloque algum valor!");
        }

        if (!isNumeric(n1) || !isNumeric(n2)){
            throw new InvalidNumberOperationException("Coloque números válidos!");
        }

        return Calculator.multi(Float.parseFloat(n1), Float.parseFloat(n2));
    }


    // AQUI SÃO AS EXCEÇÕES --------------------------------------------

    // VERIFICA SE É NUMÉRICO
    public boolean isNumeric(String value) {
        try {
            Float.parseFloat(value);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }


    // VERIFICA SE ESTÁ NULO---------------------------------------------------------------------
    public boolean isNull(String value){
        if (value.isBlank()){
            return true;
        }                                                   //Não apareceeeeeeeeeeeeeeeeeeeeeee :(
        else{
            return false;
        }
    }
}
