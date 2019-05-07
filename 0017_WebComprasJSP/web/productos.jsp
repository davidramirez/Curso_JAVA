<%-- 
    Document   : productos
    Created on : 02-may-2019, 12:55:59
    Author     : david
--%>

<%@page import="com.c2b.comprasjsp.dominio.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

        <title>Catálogo</title>
    </head>
    <body>
        <%@include file="WEB-INF/vistas/menu.jspf" %>
        <div class="container">
            <h1>${applicationScope.tituloAPP}</h1>
            <c:if test="${sessionScope.usuario != null}"><h2>Hola ${sessionScope.usuario.nombre}</h2></c:if>
                <h1>Productos</h1>

                <div class="card-columns">
                <%-- Forma A 
                <%
                    List<String> productos = (List) request.getAttribute("productos");

                    for (String s : productos) {%>
                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title"><%= s%></h5>
                        <a class="card-link btn btn-primary d-block" href="addCarro?producto=<%= s%>">Comprar</a>
                    </div>
                </div>
                <% }%>--%>

                <%-- Forma B--%>
                <jsp:useBean id="productos" scope="request" class="java.util.ArrayList"/>
                <%--<%=productos%>
                <br>
                ${productos}    *********************Etiquetas jstl******************
                <br>
                ${sessionScope.usr} accede a la sesion y visualiza el atributo
                ${requestScope.producto}
                ${cookie.color}--%>
                <c:if test="${productos.size() == 0}">lista vacia</c:if>
                <c:forEach items="${productos}" var="p">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">${p}</h5>
                            <p class="card-text">Muy monos.</p>
                            <a class="card-link btn btn-primary d-block" href='addCarro?producto=${p}'>Comprar</a>
                        </div>
                    </div>
                </c:forEach>

                <%--<%
                    List<String> productos = (List) request.getAttribute("productos");
                    
                    for(String s:productos){
                        out.println("<div class='card' style='width: 18rem;'>");
                        out.println("<div class='card-body'>");
                        out.println("<h5 class='card-title'>" + s + "</h5>");
                        out.println("<a class='card-link btn btn-primary d-block' href='addCarro?producto="+s+"'>Comprar</a>");
                        out.println("</div></div>");
                    }
                %>

                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title">Zapatos</h5>
                        <p class="card-text">Muy monos.</p>
                        <a class="card-link btn btn-primary d-block" href="addCarro?producto=zapato">Comprar</a>
                    </div>
                </div>--%>

            </div>
                
                <h2>jsession id es ${cookie.JSESSIONID.value}</h2>
        </div>

        <%@include file="WEB-INF/vistas/pie.jspf" %>
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>