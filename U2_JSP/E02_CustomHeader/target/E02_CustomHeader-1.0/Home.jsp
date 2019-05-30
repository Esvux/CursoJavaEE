<%@page import="com.academik.e02_customheader.dao.CarDAO" %>

<jsp:include page="templates/Header.jsp">
    <jsp:param name="custom-title" value="Inicio"/>
</jsp:include>

<div class="container">
    <h1>Tu JSESSIONID es: ${ cookie["JSESSIONID"].value }</h1> 
</div>

<%@include file="templates/Footer.jsp"%>