<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ page errorPage="views/error/error.jsp" contentType="text/html;charset=UTF-8" language="java" %><!DOCTYPE html>
<%@ page import="java.util.Date" %>
<html>

<head>
    <title>Nébula music</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="assets/css/styles.css" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>

<body>

    <%
        if (session.getAttribute("usuario") == null){
            response.sendRedirect("./views/auth/iniciar-sesion.jsp");
        }
    %>

    <%@include file="WEB-INF/jsp/fragments/header.jspf" %>

    <c:if test="${sessionScope.usuario != null}">
        <h1>Bienvenido ${sessionScope.usuario}</h1>
    </c:if>

    <header class="principal hero">
        <img src="${pageContext.request.contextPath}/assets/imgs/cover.jpg" />
        <h1>Tu música en la <span>nube</span> y en tu <span>espacio</span>.</h1>
    </header>

    <main>

        <section id="news" class="news-box">
            <article class="card">
                <img
                    src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRfGRivZ1CFL4jhQXNbF9phy9h-CASW3TM9UQ&s" />
                <h3>Taylor Swift en su nueva era</h3>
                <p>El nuevo disco de Taylor, <i>"The life of a showgirl"</i> saldrá a la venta el 3 de octubre.</p>
                <p><a href="views/aplication/play-music.jsp">Escuchar ahora</a></p>
            </article>

            <article class="card">
                <img
                    src="https://media.gq.com.mx/photos/66cdf89fe21e890818a07d6d/4:3/w_2248,h_1686,c_limit/Oasis.jpg" />
                <div>
                    <h3>Oasis</h3>
                    <p>Revelan el setlist completo de la banda.</p>
                </div>
                <p>Los hermanos Liam y Noel Gallagher se reencontrarán con sus fans mexicanos y traerán un setlist que
                    promete emocionar hasta las lágrimas.</p>
                <p><a href="views/aplication/play-music.jsp">Escuchar ahora</a></p>

            </article>

            <article class="card">
                <img
                    src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRU2wpHalZ_btJnPiNpMLziQ2Pcu0BDxxJBVA&s" />
                <h3>Los Reztos tocan tributo a Marea</h3>
                <p>Un éxito el tributo en Ciudad Obregón.</p>
                <p><a href="views/aplication/play-music.jsp">Escuchar ahora</a></p>

            </article>
        </section>

    </main>

    <%@include file="WEB-INF/jsp/fragments/footer.jspf" %>

</body>

</html>