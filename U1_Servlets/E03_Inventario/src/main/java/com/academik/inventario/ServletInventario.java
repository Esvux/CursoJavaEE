/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.academik.inventario;

import com.academik.inventario.model.Producto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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
@WebServlet("/inventario")
public class ServletInventario extends HttpServlet {

    private static HashMap<Integer, Producto> data = new HashMap<>();

    static {
        data.put(1, new Producto(1, "Combo 12 piezas", "Combo", 124.00));
        data.put(2, new Producto(2, "Combo 8 piezas", "Combo", 104.00));
        data.put(3, new Producto(3, "Combo 4 piezas", "Combo", 60.00));
        data.put(4, new Producto(4, "Menu 2 piezas", "Menu", 42.00));
        data.put(5, new Producto(5, "Menu 3 piezas", "Menu", 53.50));
        data.put(6, new Producto(6, "Menu de camperitos", "Menu", 44.00));
        data.put(7, new Producto(7, "Helado de cono", "Postre", 5.00));
        data.put(8, new Producto(8, "Dona glaceada", "Postre", 10.00));
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String param = request.getParameter("query");
        try (PrintWriter out = response.getWriter()) {
            out.append("<html>");
            out.append("<ul>");
            for (Producto p : data.values()) {
                if (param == null || p.getNombre().contains(param)) {
                    out.append("<li>");
                    out.append(p.getNombre());
                    out.append("</li>");
                }
            }
            out.append("</ul>");
            out.append("</html>");
        }
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        //Leer el Body de la peticion...
//        try(BufferedReader br = request.getReader()) {
//            StringBuilder sb = new StringBuilder();
//            String linea = br.readLine();
//            while(linea != null) {
//                sb.append(linea);
//                linea = br.readLine();
//            }
//            System.out.println(sb.toString());
//        }

        //Parsear el JSON a propiedades individuales
        JsonReader jr = Json.createReader(request.getReader());
        JsonObject jObject = jr.readObject();
        Integer c = jObject.getInt("codigo");
        String n = jObject.getString("nombre");
        String t = jObject.getString("tipo");
        Double p = jObject.getJsonNumber("precio").doubleValue();
        
        //Crear el objeto 'Producto' con las propiedades individuales
        Producto nuevo = new Producto(c, n, t, p);
        data.put(c, nuevo);
    }

    @Override
    protected void doDelete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        //Obtengo el parametro
        String c = request.getParameter("codigo");
        
        //Verifico la existencia del parametro
        if(c==null) {
            response.setStatus(400);
            return;
        }
        
        //Verifico el formato del parametro (y lo parseo)
        c = c.trim();
        Integer codigo;
        try {
            codigo = Integer.parseInt(c);
        } catch (Exception e) {
            response.setStatus(400);
            return;
        }
        
        //Verifico la existencia del codigo que deseo eliminar
        if(! data.containsKey(codigo)) {
            response.setStatus(404);
            return;
        }
        
        //Hacer la eliminacion
        data.remove(codigo);
    }    

}
