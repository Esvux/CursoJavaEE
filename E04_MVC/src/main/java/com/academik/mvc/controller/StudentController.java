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
                redirectPage = "student-view.jsp";
                Student sToView = setEntity(req, resp);
                if(sToView==null)
                    return;
                break;
            case "/edit":
                redirectPage = "student-edit.jsp";
                Student sToEdit = setEntity(req, resp);
                if(sToEdit==null)
                    return;
                break;
            case "/list":
            case "/":
            case "":
                redirectPage = "student-list.jsp";
                List<Student> students = dao.queryAll();
                req.setAttribute("list_of_students", students);
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
    
    private Student setEntity(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        if (id == null) {
            resp.sendRedirect(req.getContextPath() + "/students");
            return null;
        }
        long _id = Long.parseLong(id);
        Student student = dao.findById(_id);
        if(student == null) {
            resp.sendRedirect(req.getContextPath() + "/students");
            return null;
        }
        req.setAttribute("single_student", student);
        return student;
    }
    
}
