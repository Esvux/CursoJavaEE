<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="GET">
            <label for="num1">Ingresa un numero</label><br>
            <input type="number" name="num1"><br><br>
            
            <label for="num2">Ingresa otro numero</label><br>
            <input type="number" name="num2"><br><br>
            
            <label for="op">Selecciona una operacion</label><br>
            <select name="op">
                <option value="add">Sumar</option>
                <option value="sub">Restar</option>
                <option value="mul">Multiplicar</option>
                <option value="div">Dividir</option>
            </select>
            <br><br>

            <input type="submit" value="Calcular">
        </form>
        <%
            String num1AsString = request.getParameter("num1");
            String num2AsString = request.getParameter("num2");
            String opAsString = request.getParameter("op");
            if(num1AsString!=null && num2AsString!=null && opAsString!=null) {
                int num1 = Integer.parseInt(num1AsString);
                int num2 = Integer.parseInt(num2AsString);
                if("add".equals(opAsString)) {
                    out.print("El resultado de la suma es: " + (num1 + num2));
                } else if ("sub".endsWith(opAsString)) {
                    out.print("El resultado de la resta es: " + (num1 - num2));
                } else if ("mul".endsWith(opAsString)) {
                    out.print("El resultado de la multiplicacion es: " + (num1 * num2));
                } else if ("div".endsWith(opAsString)) {
                    out.print("El resultado de la division es: " + ((double)num1 / num2));
                }
            }
        %>
    </body>
</html>
