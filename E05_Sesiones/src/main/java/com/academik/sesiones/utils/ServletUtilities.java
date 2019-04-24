package com.academik.sesiones.utils;

import java.io.PrintWriter;

/**
 *
 * @author esvux
 */
public class ServletUtilities {
    
    /**
     * Metodo para generar el inicio de un HTML con Bootstrap, 
     * es necesario utilizarlo dentro del try-with-resources del
     * metodo de servicio donde se desea utilizar.
     * @param out objeto que sirve para escribir la respuesta.
     * @param title titulo de la pagina.
     */
    public static void openHTML(PrintWriter out, String title) {
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T' crossorigin='anonymous'>");
        out.println("<meta content='text/html; charset=UTF-8'>");
        out.println("<title>");
        out.println(title);
        out.println("</title>");
        out.println("</head>");
        out.println("<body>");
    }
    
    /**
     * Metodo para generar el final de un HTML correspondiente
     * al metodo de arriba 'openHTML', es necesario utilizarlo 
     * dentro del try-with-resources del metodo de servicio donde 
     * se desea utilizar.
     * @param out objeto que sirve para escribir la respuesta.
     */
    public static void closeHTML(PrintWriter out) {
        out.println("</body>");
        out.println("</html>");
    }
    
}
