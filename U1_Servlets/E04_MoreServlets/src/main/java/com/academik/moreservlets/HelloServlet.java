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
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    private static int CUENTA_SERVLETS = 0;
    private int num;
    
    private static synchronized int incNum() {
        return ++CUENTA_SERVLETS;
    }
    
    private static synchronized void decNum() {
        CUENTA_SERVLETS--;
    }
    
    @Override
    public void init() throws ServletException {
        num = incNum();
        System.out.println("Inicializando HelloServlet #" + num);
        super.init();
    }

    @Override
    public void destroy() {
        decNum();
        System.out.println("Destruyendo HelloServlet #" + num);
        super.destroy();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getMethod() + ": Trabajando, trabajando... Soy un Servlet y estoy trabajando...");
        super.service(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(PrintWriter out = resp.getWriter()) {
            out.append("<html>");
            out.append("<h1>Que onda!!!</h1>");
            out.append("</html>");
        }
    }
    
    
}
