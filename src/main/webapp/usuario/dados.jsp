<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <head>
        <meta http-equiv="Content-Type" content="text/html" charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0" />
        <title>Perfil</title>

        <!-- CSS  -->
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="./materialize/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection" />
        <link href="./materialize/css/style.css" type="text/css" rel="stylesheet" media="screen,projection" />
    </head>
</head>
<body>

<c:import url="/usuario/usuarioHeader.jsp"/>

<div class="container">
    <div class="row">
        <div class="col s12">
            <div>
                <h4 class="center"> Seu Perfil</h4>
            </div>
            <div style="margin: 1%" class="card-panel green lighten-5">
                <table class="responsive-table highlight container">
                    <thead>
                    <tr>
                        <th>Nome</th>
                        <td>${sessionScope.login.nome}</td>
                    </tr>
                    <tr>
                        <th>E-mail</th>
                        <td> ${sessionScope.login.email}</td>
                    </tr>
                    <tr>
                        <th>Nascimento</th>
                        <td>${sessionScope.login.nascimento}</td>
                    </tr>
                    </thead>


                </table>
                <div style="margin: 5%">
                    <a class="btn-flat modal-trigger" href="#editar"><i class="material-icons">edit</i>Editar Dados</a>
                    <a class="btn-flat"><i class="material-icons" href="../reiniciarSaldo">refresh</i> Resetar Carteira </a>
                </div>
            </div>
            <div>

                <div style="width: 70%;" id="editar" class="modal">
                    <div class="modal-content">
                        <div style="margin-left: 10%; margin-right: 10%" class="row">
                            <form class="col s12" action="Controller?command=EditarUserCommand" method="post">
                                <h4 style="margin-bottom: 5%; margin-top: 0%" class="center">Edite seus Dados de usuário:</h4>
                                <div class="row">
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix">person</i>
                                        <input value="${sessionScope.login.nome}" id="nome" name="nome" type="text" class="validate" pattern="[a-z A-Z]+" title="Apenas letras">
                                        <label for="nome">Nome</label>
                                    </div>
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix">email</i>
                                        <input value="${sessionScope.login.email}" id="email" name="email" type="email" class="validate" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$">
                                        <label for="email">Email</label>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="input-field col s6">
                                        <i class="material-icons prefix">lock</i>
                                        <input value="${sessionScope.login.senha}" id="senha" name="senha" type="password" class="validate" pattern=".{6,}" title="Seis ou mais caracteres">
                                        <label for="senha">Senha</label>
                                    </div>

                                    <div class="input-field col s6">
                                        <i class="material-icons prefix">lock</i>
                                        <input value="${sessionScope.login.senha}" id="confirmarsenha" name="confirmarsenha" type="password" class="validate" pattern=".{6,}" title="Seis ou mais caracteres">
                                        <label for="confirmarsenha">Confirmar Senha</label>
                                    </div>
                                </div>
                                <div style="float:right">
                                    <button class="btn waves-effect waves-light green darken-3" type="action" name="action">Salvar
                                        <i class="material-icons right">send</i>
                                    </button>

                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>



<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="./materialize/js/materialize.js"></script>
<script src="./materialize/js/init.js"></script>
</body>
</html>