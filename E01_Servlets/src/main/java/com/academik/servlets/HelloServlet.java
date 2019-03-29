package com.academik.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esvux
 */
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest req, 
            HttpServletResponse resp
    ) throws ServletException, IOException {
        String person = req.getParameter("person");
        //Si no existe el parametro se muestre el texto 
        //"No hay nadie a quien saludar"
        try(PrintWriter out = resp.getWriter()) {
            if(person == null || person.trim().isEmpty()) {
                out.append("No hay nadie a quien saludar");
            } else {
                out.append("Hola " + person);
            }
        }
    }

    @Override
    protected void doPost(
            HttpServletRequest req, 
            HttpServletResponse resp
    ) throws ServletException, IOException {
        //Declarar un StringBuilder vacio...
        StringBuilder body = new StringBuilder();
        
        //Abrir el buffer de la peticion
        try(BufferedReader reader = req.getReader()) {
            String line = reader.readLine();
            while(line != null) {
                System.err.println("Linea: " + line);
                body.append(line);
                body.append('\n');
                line = reader.readLine();
            }
        }
        //Fin de procesar la peticion
        
        //Escribir la respuesta
        try(PrintWriter out = resp.getWriter()) {
            out.append(body.toString().toUpperCase());
        }
    }
    
}