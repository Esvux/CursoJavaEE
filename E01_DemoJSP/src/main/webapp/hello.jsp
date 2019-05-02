<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
<body>
    <form method="GET">
        <select name="operator">
            <option value="add">Suma</option>
            <option value="sub">Resta</option>
        </select><br>
        <label for="name">Valor 1</label><br>
        <input type="text" name="name"><br><br>
        <input type="submit" value="Calcular">
    </form>
    <% 
    String person = request.getParameter("name");
    
    if(person == null || person.trim().isEmpty()) { 
    
        //Double.parseDouble(string);
        //Integer.parseInt(string);
        //Validar y obtener el primer numero > if
        //Validar y obtener el segundo numero > if
        //Segun sea el operador crear la respuesta > switch
        //Si la respuesta no es null, mostrarla
    
    %>
        <h1>No hay nadie a quien saludar</h1>
    <%} else {%>
        <h1>Hola <%=person%></h1>
    <%}%>
</body>
</html>
