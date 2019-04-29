package com.academik.multipart;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author esvux
 */
@WebServlet("/new-file")
@MultipartConfig(location = "/tmp")
public class UploadFileServlet extends HttpServlet {

    @Override
    protected void doPost(
            HttpServletRequest req, 
            HttpServletResponse resp
    ) throws ServletException, IOException {
        String name = null;
        SimpleDateFormat formatter = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        boolean fileExtensionIsOk = true;
        for (Part part : req.getParts()) {
            if(name == null)
                name = formatter.format(new Date()) + "-" + part.getSubmittedFileName();
            if(! name.endsWith(".txt")) {
                fileExtensionIsOk = false;
                break;
            }
            part.write(name);
        }
        
        try(PrintWriter out = resp.getWriter()) {
            out.append("<!DOCTYPE html>");
            out.append("<html>");
            out.append("<head>");
            out.append("<meta content='text/html; charset=UTF-8'>");
            out.append("<title>Probando multipart en Servlets</title>");
            out.append("</head>");
            out.append("<body>");
            out.append("<h1>");
            out.append(fileExtensionIsOk ? "Archivo correcto" : "Archivo no permitido");
            out.append("</h1>");
            out.append("</body>");
            out.append("</html>");
        }
        
    }

}
