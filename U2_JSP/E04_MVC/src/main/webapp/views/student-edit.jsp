<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean 
    id="single_student" 
    scope="request" 
    class="com.academik.mvc.model.Student"/>
<jsp:include page="../templates/header.jsp">
    <jsp:param name="custom-title" value="Academik | Editar estudiante"/>
</jsp:include>

<h1>Editar estudiante</h1>
<form method="POST">
    <div class="form-group">
        <label for="s_firstname">Nombres</label>
        <input class="form-control" type="text" name="s_firstname" value="${single_student.firstName}"/>
    </div>
    <div class="form-group">
        <label for="s_lastname">Apellidos</label>
        <input class="form-control" type="text" name="s_lastname" value="${single_student.lastName}"/>
    </div>
    <div class="form-group">
        <label for="s_gender">Género</label>
        <select class="form-control" name="s_gender">
            <option value="M">Masculino</option>
            <option value="F">Femenino</option>
        </select>
    </div>
    <div class="form-group">
        <label for="s_email">Correo electrónico</label>
        <input class="form-control" type="text" name="s_email" value="${single_student.email}"/>
    </div>
    <div class="form-group">
        <label for="s_birthday">Fecha de nacimiento</label>
        <input class="form-control" type="text" name="s_birthday" value="${single_student.birthday}"/>
    </div>
    <div class="form-group">
        <label for="s_guardian">Encargado (a)</label>
        <input class="form-control" type="text" name="s_guardian" value="${single_student.guardian}"/>
    </div>
    <div class="form-group">
        <label for="s_contactPhone">Teléfono de contacto</label>
        <input class="form-control" type="text" name="s_contactPhone" value="${single_student.contactPhone}"/>
    </div>
    <input class="btn btn-primary" type="submit" value="Guardar"/>
</form>

<%@include file="../templates/footer.jsp" %>