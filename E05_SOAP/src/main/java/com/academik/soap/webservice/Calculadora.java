package com.academik.soap.webservice;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author esvux
 */
@WebService(serviceName = "servicio-calculadora")
public class Calculadora {
    
    @WebMethod
    public String sumar(int a, int b) {
        return "Resultado: " + (a + b);
    }
    
    @WebMethod
    public String restar(int a, int b) {
        return "Resultado: " + (a - b);
    }

}
