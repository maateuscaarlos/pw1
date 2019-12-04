<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0" />
    <title>Rende Fácil</title>

    <!-- CSS  -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection" />
    <link href="css/style.css" type="text/css" rel="stylesheet" media="screen,projection" />
</head>

<body>
<nav class="green darken-3">
    <div class="nav-wrapper container">
        <ul class="right hide-on-med-and-down">
            <li> <a class="dropdown-trigger" href="#" data-target="usuario">Usuário</a></li>
            <li><a href="telaNegociacao.html">Ativos</a></li>
            <li><a href="#">Histórico</a></li>
        </ul>
        <a href="usuario.html" class="brand-logo">Rende Fácil</a>
    </div>
</nav>
<ul id='usuario' class="dropdown-content green lighten-5">
    <li><a class="black-text" href="dados.jsp">Dados</a></li>
    <li><a class="black-text modal-trigger" href="#carteira">Carteira</a></li>
    <li><a class="black-text" href="#!">Logout</a></li>
</ul>
<div style="width: 35%; height: 60%" id="carteira" class="modal green lighten-5">
    <div class="modal-content">
        <div class="green darken-3">
            <label style="font-size: 32pt;" class="white-text">Carteira:</label>
        </div>
        <table>
            <tr>
                <td><b class="text-darken-3 green-text"> Saldo Atual</b></td>
            </tr>
            <tr>
                <td name="carteira">${sessionScope.login.carteira.valorCaixa}</td>
            </tr>
        </table>
    </div>
    <div class="modal-footer green lighten-5">
        <a href="#!" class="modal-close btn-flat text-darken-3 green-text">Fechar</a>
    </div>
</div>
    <div class="row" style="margin: 2%;">
        <div class="col s12" style="margin-top: 5%;">
            <div class="col s4">
                    <div class="card">
                    <div class="card-image">
                        <img style="width: 100%; height: 300px;" src="imagens/card1.jpg">
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
                        <img style="width: 100%; height: 300px;" src="imagens/card2.jpg">
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
                        <img style="width: 100%; height: 300px;" src="imagens/card3.jpg">
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
    <!--  Scripts-->
    <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="js/materialize.js"></script>
    <script src="js/init.js"></script>

</body>
</body>

</html>