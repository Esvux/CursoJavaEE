package com.academik.sesiones;

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
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(PrintWriter out = resp.getWriter()) {
            out.append("<!DOCTYPE html>");
            out.append("<html>");
            out.append("	<head>");
            out.append("		<link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css' integrity='sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T' crossorigin='anonymous'>");
            out.append("		<meta charset='UTF-8'>");
            out.append("		<title>Login Page</title>");
            out.append("	</head>");
            out.append("	<body>");
            out.append("	<div class='container'>");
            out.append("	<h1>Login Page</h1>");            
            out.append("	<div class='row'>");
            out.append("		<form action='LoginServlet' method='post'>");
            out.append("			<label for='user'>User:</label>");
            out.append("			<input type='text' name='user'><br>");
            out.append("			<label for='pwd'>Password:</label>");
            out.append("			<input type='password' name='pwd'><br>");
            out.append("			<input type='submit' value='Login'>");
            out.append("		</form>");
            out.append("	</div>");
            out.append("	</div>");
            out.append("	</body>");
            out.append("</html>");
        }
    }
    
    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        
    }
    
}
