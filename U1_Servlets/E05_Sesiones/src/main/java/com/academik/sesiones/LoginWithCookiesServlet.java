package com.academik.sesiones;

import com.academik.sesiones.utils.ServletUtilities;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esvin
 */
@WebServlet("/login-with-cookies")
public class LoginWithCookiesServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(PrintWriter out = resp.getWriter()) {
            ServletUtilities.openHTML(out, "Inicio de sesion");
            out.println("<div class='container'>");
            out.println("<h1>Login con cookies</h1>");            
            out.println("<div class='row'>");
            out.println("   <form action='login-with-cookies' method='post'>");
            out.println("       <div class='form-group'>");
            out.println("           <label for='user'>Usuario:</label>");
            out.println("           <input class='form-control' type='text' name='user'>");
            out.println("       </div>");
            out.println("       <div class='form-group'>");
            out.println("           <label for='pwd'>Contraseña:</label>");
            out.println("           <input class='form-control' type='password' name='pwd'>");
            out.println("       </div>");
            out.println("       <input type='submit' value='Entrar'>");
            out.println("   </form>");
            out.println("</div>");
            out.println("</div>");
            ServletUtilities.closeHTML(out);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        String dummyUser = "admin";
        String dummyPass = "123";
        if(
                dummyUser.equals(req.getParameter("user"))
                &&
                dummyPass.equals(req.getParameter("pwd"))
        ) {
            Cookie cookie = new Cookie("logged-user", "Emperador del universo");
            cookie.setMaxAge(10*60);
            resp.addCookie(cookie);
            resp.sendRedirect(req.getContextPath() + "/protected/hello");
        }
        
    }
    
}
