<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                    <h1> ${dvd.titulo} </h1>
                    <h3>${dvd.autor}</h3>
                    <h4>A�o: ${dvd.getAnio()}</h4>
                </div>
            </div>
        </section>
    </body>
</html>