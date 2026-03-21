<%--
    Document   : about
    Created on : 5 mar 2026, 6:21:18 p.m.
    Author     : martinbl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <title>Mis Albums</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/styles.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

</head>

<body>
<%@include file="/WEB-INF/jsp/fragments/header.jspf" %>
<header class="about-header">
    <img src="${pageContext.request.contextPath}/assets/img/header2.jpg" />
    <h1>Mis Albums</h1>
</header>

<main class="about-main">
    <c:if test="${album == null}">
        Nuevo Album
    </c:if>

    <c:if test="${album != null}">
        Editar Album
    </c:if>

    <c:if test="${error != null}">
        <p style="color:red" class="error">${error}</p>
    </c:if>

    <c:if test="${album != null}">
        <form action="albums" method="post" enctype="multipart/form-data">
            <input type="hidden" name="id" value="${album.id}">

            <label>Titulo</label><br>
            <input type="text" name="titulo" value="${album.title}" required>
            <br><br>
            <label>Titulo</label><br>
            <textarea name="descipcion" required>${album.descripcion}</textarea>
            <br><br>
            <label>Portada</label><br>
            <input type="file" name="imagen" accept="image/png" required>
            <br><br>
            <button type="submit">Guardar</button>
        </form>

        <a href="albums">Volver</a>
    </c:if>

</main>
<%@include file="/WEB-INF/jsp/fragments/footer.jspf" %>
</body>

</html>