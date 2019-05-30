<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Todos los carros</title>
        <sql:setDataSource 
            var = "conn" driver = "org.postgresql.Driver"
            url = "jdbc:postgresql://localhost:5432/academik"
            user = "postgres" password = "1234qwer"/>

        <sql:query dataSource = "${conn}" var = "cars">
            SELECT code, brand, model, color, year FROM car;
        </sql:query>
    </head>
    <body>
        <div class="container">            
            <table class="table">
                <thead>
                    <tr>
                        <td>Codigo</td>
                        <td>Marca</td>
                        <td>Modelo</td>
                        <td>Color</td>
                        <td>Año</td>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="carrito" items="${cars.rows}">
                        <tr>
                            <td><c:out value = "${carrito.code}"/></td>
                            <td><c:out value = "${carrito.brand}"/></td>
                            <td><c:out value = "${carrito.model}"/></td>
                            <td style="background: ${carrito.color}"><c:out value = "${carrito.color}"/></td>
                            <td><c:out value = "${carrito.year}"/></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </body>
</html>
