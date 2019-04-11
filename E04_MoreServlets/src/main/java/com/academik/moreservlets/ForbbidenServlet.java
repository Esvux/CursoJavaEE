package com.academik.moreservlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esvin
 */
@WebServlet("/forbbiden")
public class ForbbidenServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(403);
        try(PrintWriter out = resp.getWriter()) {
            out.append("<html>");
            out.append("<h1>¬¬</h1>");
            out.append("</html>");
        }
    }
    
}
