<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0" />
    <title>Usuario</title>

    <!-- CSS  -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="./materialize/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection" />
    <link href="./materialize/css/style.css" type="text/css" rel="stylesheet" media="screen,projection" />
</head>

<body>
<c:import url="/usuario/usuarioHeader.jsp"/>
<div class="row" style="margin: 1%;">
    <div class="col s12">
        <h5 style="text-align: center; font-family: Arial, Helvetica, sans-serif; font-style:inherit;"><b> EM ALTA:</b></h5>
        <div class="col s6">
            <div class="card-panel green lighten-5 row" style="padding: 5%; margin-top: 8%;">
                <div class="container">
                    <div class="card">
                    </div>
                </div>
            </div>
        </div>
        <div class="col s6">
            <div id="chartContainer" style="height: 30%; width: 100%;"></div>
        </div>
    </div>
</div>

<!--  Scripts-->
<script type="text/javascript" src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<script src="./graficoAtivo.js"></script>
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="./materialize/js/materialize.js"></script>
<script src="./materialize/js/init.js"></script>

</body>
</body>

</html>