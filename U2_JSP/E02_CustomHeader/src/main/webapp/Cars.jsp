<%@page import="com.academik.e02_customheader.dao.CarDAO" %>
<%@page import="com.academik.e02_customheader.model.Car" %>

<jsp:include page="templates/Header.jsp">
    <jsp:param name="custom-title" value="Inicio"/>
</jsp:include>

<div class="container">
    <table class="table">
        <thead>
            <!-- tr = table row -->
            <tr>
                <!-- th = table header-->
                <th>Codigo</th>
                <th>Marca</th>
                <th>Modelo</th>
                <th>Color</th>
                <th>Año</th>
            </tr>
        </thead>
        <tbody>
            <%
                CarDAO db = CarDAO.getInstance();
                for(Car carrito : db.getAll()) {
            %>
            <tr>
                <td><%= carrito.getCode() %></td>
                <td><%= carrito.getBrand()%></td>
                <td><%= carrito.getModel()%></td>
                <td><%= carrito.getColor()%></td>
                <td><%= carrito.getYear()%></td>
            </tr>
            <% } %>
        </tbody>
    </table>
    
    
</div>

<%@include file="templates/Footer.jsp"%>