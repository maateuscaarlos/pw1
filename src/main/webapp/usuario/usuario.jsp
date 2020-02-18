<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html;" />
    <meta  charset=UTF-8/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0" />
    <title>Rende Fácil</title>

    <!-- CSS  -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="./materialize/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection" />
    <link href="./materialize/css/style.css" type="text/css" rel="stylesheet" media="screen,projection" />
</head>

<body>
<c:import url="/usuario/usuarioHeader.jsp"/>
    <div class="row" style="margin: 2%;">
        <div class="col s12" style="margin-top: 5%;">
            <div class="col s4">
                    <div class="card">
                    <div class="card-image">
                        <img style="width: 100%; height: 300px;" src="./imagens/card1.jpg">
                        <a class="btn-floating btn-large halfway-fab green darken-3"><i
                                class="large material-icons">call_made</i></a>
                    </div>
                    <div class="card-content">
                            <span class="card-title">Em Alta</span>
                    </div>
                </div>
            </div>
            <div class="col s4">
                <div class="card">
                    <div class="card-image">
                        <img style="width: 100%; height: 300px;" src="./imagens/card2.jpg">
                        <a class="btn-floating btn-large halfway-fab green darken-3"><i
                                class="large material-icons">call_made</i></a>
                    </div>
                    <div class="card-content">
                            <span class="card-title">Sugestão do Dia</span>
                    </div>
                </div>
            </div>
            <div class="col s4">
                    <div class="card">
                    <div class="card-image">
                        <img style="width: 100%; height: 300px;" src="./imagens/card3.jpg">
                        <a class="btn-floating btn-large halfway-fab green darken-3"><i
                                class="large material-icons">call_made</i></a>
                    </div>
                    <div class="card-content">
                            <span class="card-title">Mais Procurados</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="./materialize/js/materialize.js"></script>
    <script src="./materialize/js/init.js"></script>

</body>
</body>

</html>