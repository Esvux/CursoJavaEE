package com.academik.agendaweb;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esvux
 */
@WebServlet("/contactos")
public class ServletContactos extends HttpServlet {

    private static List<Contacto> contactos = new ArrayList<>();
    static {
        contactos.add(new Contacto("esvux"));
        contactos.add(new Contacto("aniras"));
        contactos.add(new Contacto("juanpa"));
        contactos.add(new Contacto("emersssson"));
        contactos.add(new Contacto("sarahi"));
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(PrintWriter out = resp.getWriter()) {
            contactos.forEach((Contacto c) -> {
                out.append("<p>");
                out.append(c.getNickname());
                out.append("</p>");
            });
        }
    }
    
    
    
}
