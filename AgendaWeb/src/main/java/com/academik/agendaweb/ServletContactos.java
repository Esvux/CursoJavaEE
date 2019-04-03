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
        <!--Aqui iria la info de los contactos-->
     </table>
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try (PrintWriter out = resp.getWriter()) {
            contactos.forEach((Contacto c) -> {
                out.append("<p>");
                out.append(c.getNickname());
                out.append("</p>");
            });
        }
    }

    @Override
    protected void doPost(
            HttpServletRequest req, 
            HttpServletResponse resp
    ) throws ServletException, IOException {
        try (BufferedReader buffer = req.getReader()) {
            JsonReader reader = Json.createReader(buffer);
            JsonObject jsonObject = reader.readObject();
            String nuevoNickname = jsonObject.getString("nickname");
            String nuevoFullname = jsonObject.getString("fullname");
            String nuevoEmail = jsonObject.getString("email");
            Contacto nuevo = new Contacto(nuevoNickname, nuevoFullname, nuevoEmail);
            contactos.add(nuevo);
            System.err.println("Se agrego: " + nuevoNickname);
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

}
