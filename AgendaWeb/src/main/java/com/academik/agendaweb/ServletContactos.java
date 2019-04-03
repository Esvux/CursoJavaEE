package com.academik.agendaweb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
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
        contactos.add(new Contacto("esvux", "Esvin Gonzalez", "eesvux@gmail.com"));
        contactos.add(new Contacto("aniras", "Sarina Bolaños", "aniras@gmail.com"));
        contactos.add(new Contacto("juanpa", "Juan Pablo", "jp@correo.com"));
        contactos.add(new Contacto("emersssson", "Emerson Velasquez", "mecho@correo.com"));
        contactos.add(new Contacto("sarahi", "Sara Chajon", "saraiiii@correo.com"));
    }

    /*
     * 1) Modificar el metodo doGet para mostrar TODA la informacion de los 
     * contactos que estan en el sistema en una tabla.
     <table>
        <tr>
            <th>Nickname</th>
            <th>Fullname</th>
            <th>email</th>
        </tr>
    
        <!--Aqui iria la info de los contactos asi-->
        <tr>
            <td>juanpa</td>
            <td>Juan Sajche</td>
            <td>jp@correo.com</td>
        </tr>
    
     </table>
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter out = resp.getWriter()) {
            //Construir el encabezado de la tabla
            out.append("<table border='1'>");
            out.append("<tr>");
            out.append("<th>Nickname</th>");
            out.append("<th>Fullname</th>");
            out.append("<th>email</th>");
            out.append("</tr>");            
            
            contactos.forEach((Contacto c) -> {
                out.append("<tr>");
                out.append("<td>" + c.getNickname() + "</td>");
                out.append("<td>" + c.getFullname()+ "</td>");
                out.append("<td>" + c.getEmail()+ "</td>");
                out.append("</tr>");
            });
            
            out.append("</table>");
        }
    }

    @Override
    protected void doPost(
            HttpServletRequest req, 
            HttpServletResponse resp
    ) throws ServletException, IOException {
        try (BufferedReader buffer = req.getReader()) {
            Contacto nuevo = getContactoFromJson(buffer);
            contactos.add(nuevo);
            System.err.println("Se agrego: " + nuevo.getNickname());
        }
    }
    
    /**
     * 2) Sobrescribir el metodo doPut para modificar un recurso ya existente,
     * la data a recibir sera:
     * - Por medio de la URL el 'nickname' del elemento a modificar
     * - En el cuerpo de la peticion el nuevo contenido
     * - Buscar el elemento por medio del nickname
     *     - Si no existe responder con un 404
     *     - Si se encuentra, reemplazarlo por el nuevo elemento
     */
    @Override
    protected void doPut(
            HttpServletRequest req,  
            HttpServletResponse resp
    ) throws ServletException, IOException {
        String nickname = req.getParameter("nickname");
        if(nickname==null || nickname.trim().isEmpty()) {
            //HTTP status -> 400 = Bad request
            resp.setStatus(400);
            return;
        }
        BufferedReader buffer = req.getReader();
        PrintWriter out = resp.getWriter();
        boolean encontrado = false;
        
//Verficar que exista el contacto con el nickname ingresado
        for(Contacto c : contactos) {
            //Si no es el que estoy buscando, continua a la siguiente iteración
            if(! c.getNickname().equals(nickname)) {
                continue;
            }
            //Lo encontré...
            encontrado = true;
            Contacto nuevo = getContactoFromJson(buffer);
            c.setNickname(nuevo.getNickname());
            c.setFullname(nuevo.getFullname());
            c.setEmail(nuevo.getEmail());
            
            break;
        }
        if(encontrado) {
            out.append("Contacto modificado exitosamente");
        } else {
            resp.setStatus(404);
        }
    }

    private Contacto getContactoFromJson(BufferedReader buffer) {
        JsonReader reader = Json.createReader(buffer);
        JsonObject jsonObject = reader.readObject();
        String nuevoNickname = jsonObject.getString("nickname");
        String nuevoFullname = jsonObject.getString("fullname");
        String nuevoEmail = jsonObject.getString("email");
        Contacto nuevo = new Contacto(nuevoNickname, nuevoFullname, nuevoEmail);
        return nuevo;
    }

}
