package com.academik.sesiones.secure;

import com.academik.sesiones.utils.ServletUtilities;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author esvux
 */
@WebServlet("/protected/hello")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(PrintWriter out = resp.getWriter()) {
            ServletUtilities.openHTML(out, "Bienvenido");
            out.println("<div class='container'>");
            out.append("<h1>Hola ");
            
            Cookie[] cookies = req.getCookies();
            if(cookies != null) {
                for(Cookie c : cookies) {
                    if("logged-user".equals(c.getName())) {
                        out.append(c.getValue());
                        out.append("<br>");
                        out.append("Autenticado con cookies");
                    }
                }
            }
            
            HttpSession session = req.getSession(false);
            if(session != null) {
                String loggedUser = (String) session.getAttribute("logged-user");
                if(loggedUser != null) {
                    out.append(loggedUser);
                }
            }
            
            out.append("</h1>");
            out.println("</div>");
            ServletUtilities.closeHTML(out);
        }

    }

    
}
