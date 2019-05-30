<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../templates/header.jsp">
    <jsp:param name="custom-title" value="Academik | Crear estudiante"/>
</jsp:include>

    <h1>Nuevo estudiante</h1>
    <form method="POST">
        <div class="form-group">
            <label for="s_firstname">Nombres</label>
            <input class="form-control" type="text" name="s_firstname"/>
        </div>
        <div class="form-group">
            <label for="s_lastname">Apellidos</label>
            <input class="form-control" type="text" name="s_lastname"/>
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
            <input class="form-control" type="text" name="s_email"/>
        </div>
        <div class="form-group">
            <label for="s_birthday">Fecha de nacimiento</label>
            <input class="form-control" type="text" name="s_birthday"/>
        </div>
        <div class="form-group">
            <label for="s_guardian">Encargado (a)</label>
            <input class="form-control" type="text" name="s_guardian"/>
        </div>
        <div class="form-group">
            <label for="s_contactPhone">Teléfono de contacto</label>
            <input class="form-control" type="text" name="s_contactPhone"/>
        </div>
        <input class="btn btn-primary" type="submit" value="Crear"/>
    </form>

<%@include file="../templates/footer.jsp" %>