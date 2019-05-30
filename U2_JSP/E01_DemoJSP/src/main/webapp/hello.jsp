<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
<body>
    <form method="GET">
        <label for="name">Ingresa tu nombre</label><br>
        <input type="text" name="name"><br><br>
        <input type="submit" value="Saludar">
    </form>
    <% 
    String person = request.getParameter("name");
    
    if(person == null || person.trim().isEmpty()) {     
    %>
        <h1>No hay nadie a quien saludar</h1>
    <%} else {%>
        <h1>Hola <%=person%></h1>
    <%}%>
</body>
</html>
