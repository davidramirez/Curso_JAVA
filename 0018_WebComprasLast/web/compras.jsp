<%-- 
    Document   : compras
    Created on : 03-may-2019, 12:47:12
    Author     : david
--%>
<%@page import="com.c2b.tienda.dominio.Producto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%--<jsp:include page="WEB-INF/vista/cabecera.jsp">
    <jsp:param name="title" value="Lista de productos"/>
</jsp:include>--%>

<%String title = "Lista de productos"; %>
<%@include file="WEB-INF/vista/cabecera.jspf" %>

<%@include file="WEB-INF/vista/menu.jspf" %>


<div class="container">
    <h2>Lista de productos</h2>
    <c:if test="${requestScope.error != null}">
        <div class="alert alert-warning">${requestScope.error}</div>
    </c:if>
    <div class="card-columns">
        <c:forEach items="${applicationScope.productos}" var="p">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">${p.nombre}</h5>
                    <p class="card-text">${p.descripcion}</p>
                    <div class="d-flex w-100 justify-content-between align-items-center">
                        <small>Stock: ${p.stock}</small> <p class="lead"><strong>${p.precio}€</strong></p>
                    </div>
                    <a class="card-link btn btn-primary d-block" href='comprar?producto=${p.id}'>Comprar</a>
                </div>
            </div>
        </c:forEach>
    </div>
</div>


<%@include file="WEB-INF/vista/pie.jspf" %>