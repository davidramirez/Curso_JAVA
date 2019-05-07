<%-- 
    Document   : carro
    Created on : 03-may-2019, 12:47:25
    Author     : david
--%>

<%@page import="com.c2b.tienda.dominio.Producto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%--<jsp:include page="WEB-INF/vista/cabecera.jsp">
        <jsp:param name="title" value="Carro de la compra"/>
</jsp:include>--%>
<%String title = "Carro de la compra"; %>
<%@include file="WEB-INF/vista/cabecera.jspf" %>
<%@include file="WEB-INF/vista/menu.jspf" %>


<div class="container">
    <h2>Productos en el carro</h2>
    <c:if test="${sessionScope.total != null || sessionScope.total != 0.0}">
        <table class="table table-striped">
        <thead class="thead thead-dark">
            <tr>
                <th scope="col">Producto</th>
                <th scope="col">Unidades</th>
                <th scope="col">Precio unitario</th>
                <th scope="col">Total</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${sessionScope.carro}" var="p">
                <tr>    
                    <th scope="row">${p.key.nombre}</th>
                    <td>${p.value}</td>
                    <td>${p.key.precio}€</td>
                    <td>${p.value * p.key.precio}€</td>
                </tr>
            </c:forEach>
            <tr>
                <th scope="row"></th>
                <td></td>
                <td>Total:</td>
                <td>${sessionScope.total}€</td>
            </tr>
        </tbody>
    </table>
    </c:if>
    <c:if test="${sessionScope.total == 0.0}">
        <h2>Esto está vacío</h2>
    </c:if>
</div>


<%@include file="WEB-INF/vista/pie.jspf" %>