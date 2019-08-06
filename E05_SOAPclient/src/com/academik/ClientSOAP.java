package com.academik;

import com.academik.banguat.InfoVariable;

/**
 *
 * @author esvux
 */
public class ClientSOAP {

    public static void main(String[] args) {
        System.out.println(tipoCambioDia());
    }

    private static String sumar(int arg0, int arg1) {
        com.academik.CalculadoraService service = new com.academik.CalculadoraService();
        com.academik.Calculadora port = service.getCalculadoraPort();
        return port.sumar(arg0, arg1);
    }

    private static InfoVariable tipoCambioDia() {
        com.academik.banguat.TipoCambio service = new com.academik.banguat.TipoCambio();
        com.academik.banguat.TipoCambioSoap port = service.getTipoCambioSoap();
        return port.tipoCambioDia();
    }

}
