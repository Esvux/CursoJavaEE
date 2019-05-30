<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    private String countElephants(String numAsString) {
        if (numAsString == null) {
            return "";
        }
        int max = Integer.parseInt(numAsString);
        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= max; i++) {
            result.append(i);
            result.append(i > 1 ? " elefantes se columpiaban" : " elefante se columpiaba");
            result.append(" sobre la tela de una araña...<br>");
        }
        return result.toString();
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="GET">
            <label for="name">Ingresa un numero</label><br>
            <input type="number" name="num"><br><br>
            <input type="submit" value="Contar">
        </form>
        <%
            String numAsString = request.getParameter("num");
            String elephants = countElephants(numAsString);
            out.println(elephants);
        %>
    </body>
</html>
