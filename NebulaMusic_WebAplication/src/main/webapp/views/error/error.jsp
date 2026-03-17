<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Error</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/styles.css">
</head>

<body>

<section class="auth-container">

    <div class="auth-card">

        <div class="form-header">
            <h3>Algo salió mal</h3>
            <p class="form-subtitle">
                No se pudo completar la operación.
            </p>
        </div>

        <div class="form-group">
            <p>
                Ocurrió un problema al procesar tu solicitud.
                Intenta nuevamente o vuelve al inicio.
            </p>
        </div>

        <div class="form-group">
            <label>Detalle del error:</label>
            <p id="error-message">
                Aquí aparecerá el mensaje de la excepción.
                <%= exception != null && exception.getMessage() != null ? exception.getMessage() : "Ocurrio un error desconocido al cargar el recurso solicitado" %>
            </p>
            Hora del error: <% new Date(); %>
        </div>

        <button class="btn-primary" onclick="location.href='./views/auth/iniciar-sesion.jsp'">
            Volver a iniciar sesión
        </button>

        <button class="btn-secondary" onclick="location.href='./index.html'">
            Ir al inicio
        </button>

    </div>

</section>

</body>
</html>

