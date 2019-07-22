<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
        <title>Bienvenida</title>
    </head>
    <body>
        <section>
            <div class="jumbotron">
                <div class="container">
                    <c:if test="${exitoAdd != null}">
                        <div class="alert alert-success">${exitoAdd}</div>
                    </c:if>
                    <table class="table table-stripped">
                        <thead>
                            <tr>
                                <th scope="col">Id</th>
                                <th scope="col">Título</th>
                                <th scope="col"></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${dvds}" var="dvd">
                                <tr>
                                    <th scope="row">${dvd.id}</th>
                                    <td>${dvd.titulo}</td>
                                    <td><a class="btn btn-primary" href="<spring:url value='/dvd/detalle/${dvd.id}'/>">Ver detalle</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>
    </body>
</html>