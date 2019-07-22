<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
                    <c:if test="${error != null}">
                        <div class="alert alert-warning">${error}</div>
                    </c:if>
                    <form:form method="POST" modelAttribute="dvdNuevo" class="form-horizontal">
                        <form:errors path="*" cssClass="alert alert-warning"/>
                        <fieldset> 
                            <legend>Crear un nuevo DVD</legend> 

                            <div class="form-group"> 
                                <label class="control-label col-lg-2 col-lg-2" 
                                       for="idDvd">
                                    Id
                                </label> 
                                <div class="col-lg-10"> 
                                    <form:input id="id" path="id" type="text" class="form:input-large"/>
                                    <form:errors path="id" />
                                </div> 
                            </div>
                            <div class="form-group"> 
                                <label class="control-label col-lg-2 col-lg-2" 
                                       for="titulo">Titulo</label> 
                                <div class="col-lg-10"> 
                                    <form:input id="titulo" path="titulo" type="text" class="form:input-large"/> 
                                    <form:errors path="titulo" />
                                </div> 
                            </div>

                            <div class="form-group"> 
                                <label class="control-label col-lg-2" 
                                       for="autor">Autor</label> 
                                <div class="col-lg-10"> 
                                    <form:input id="autor" path="autor" type="text" class="form:input-large"/>
                                    <form:errors path="autor" />
                                </div> 
                            </div> 
                            <div class="form-group"> 
                                <label class="control-label col-lg-2 col-lg-2" 
                                       for="anio">Año</label> 
                                <div class="col-lg-10"> 
                                    <form:input id="anio" path="anio" type="text" class="form:input-large"/> 
                                    <form:errors path="anio" />
                                </div> 
                            </div>


                            <div class="form-group"> 
                                <label class="control-label col-lg-2 col-lg-2" 
                                       for="alquilado">Alquilado? </label> 
                                <div class="col-lg-10">
                                    <form:checkbox id="alquilado" path="alquilado"/>
                                </div> 
                            </div>

                            <div class="form-group"> 
                                <div class="col-lg-offset-2 col-lg-10"> 
                                    <input type="submit" id="btnCrear" class="btn 
                                           btn-primary" value ="Crear DVD"/> 
                                </div> 
                            </div> 
                        </fieldset> 
                    </form:form>
                </div>
            </div>
        </section>
    </body>