package com.academik.mvc.controller;

import com.academik.mvc.dao.StudentDAO;
import com.academik.mvc.model.Student;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author esvux
 */
@WebServlet("/students/*")
public class StudentController extends HttpServlet {

    StudentDAO dao = new StudentDAO();
    
    /**
     * Determina que "recurso" mostrar al usuario.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String complement = req.getPathInfo();
        if(complement == null)
            complement = "";
        System.err.println(complement);
        String redirectPage;
        switch(complement) {
            case "/create":
                redirectPage = "student-create.jsp";
                break;
            case "/view":
                //Obtengo el parametro desde la URL
                long id = Long.parseLong(req.getParameter("id"));
                Student sToView = dao.findById(id);
                req.setAttribute("single_student", sToView);
                redirectPage = "student-view.jsp";
                break;
            case "/edit":
                redirectPage = "student-edit.jsp";
                break;
            case "/list":
            case "/":
            case "":
                List<Student> allStudents = dao.queryAll();
                req.setAttribute("list_of_students", allStudents);
                redirectPage = "student-list.jsp";
                break;
            default:
                resp.sendRedirect(req.getContextPath() + "/students");
                return;
        }

        //Renderice este JSP
        RequestDispatcher rd = req.getRequestDispatcher(
                "/views/" + redirectPage
        );
        //Adelante con la renderización
        rd.forward(req, resp);
    }

    /**
     * Para recibir la petición de crear un nuevo estudiante.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    /**
     * Para modificar un estudiante ya existente.
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    /**
     * Para eliminar un estudiante.
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }
    
}
