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
import javax.servlet.http.HttpSession;

/**
 *
 * @author esvin
 */
@WebServlet("/login-with-session")
public class LoginWithSessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(PrintWriter out = resp.getWriter()) {
            ServletUtilities.openHTML(out, "Inicio de sesion");
            out.println("<div class='container'>");
            out.println("<h1>Login con HttpSession</h1>");            
            out.println("<div class='row'>");
            out.println("   <form action='login-with-session' method='post'>");
            out.println("       <div class='form-group'>");
            out.println("           <label for='user'>Usuario:</label>");
            out.println("           <input class='form-control' type='text' name='user' id='user'>");
            out.println("       </div>");
            out.println("       <div class='form-group'>");
            out.println("           <label for='pwd'>Contraseña:</label>");
            out.println("           <input class='form-control' type='password' name='pwd' id='pwd'>");
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
        String user = req.getParameter("user");
        String pass = req.getParameter("pwd");
        if(
                dummyUser.equals(user)
                &&
                dummyPass.equals(pass)
        ) {
            HttpSession session = req.getSession();
            session.setAttribute("logged-user", "Yo");
            resp.sendRedirect(req.getContextPath() + "/protected/hello");
        }
        
    }
    
}
