<%-- 
    Document   : login
    Created on : 02-may-2019, 14:01:00
    Author     : david
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<jsp:include page="WEB-INF/vista/cabecera.jsp">
    <jsp:param name="title" value="Inicio de sesión"/>
</jsp:include>--%>

<%String title = "Inicio de sesión"; %>
<%@include file="WEB-INF/vista/cabecera.jspf" %>

<%@include file="WEB-INF/vista/menu.jspf" %>

<div class="container">
            <h1>${applicationScope.tituloAPP}</h1>
            <h1>Introduce tus datos para iniciar sesión</h1>
            <c:if test="${requestScope.noValido}">
                <div class="alert alert-danger">
                    El nombre de usuario o la contraseña son incorrectas
                </div>
            </c:if>
            <form action="login" method="POST">
                <div class="form-group">
                    <label for="nombre">Nombre de usuario</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Usuario">
                </div>
                <div class="form-group">
                    <label for="pass">Password</label>
                    <input type="password" class="form-control" id="pass" name="pass" placeholder="Contraseña">
                </div>
                <button type="submit" class="btn btn-primary">Iniciar sesión</button>
            </form>

        </div>

<%@include file="WEB-INF/vista/pie.jspf" %>