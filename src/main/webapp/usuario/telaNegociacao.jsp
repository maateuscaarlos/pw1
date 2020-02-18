<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0" />
    <title>Ativos</title>

    <!-- CSS  -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="./materialize/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection" />
    <link href="./materialize/css/style.css" type="text/css" rel="stylesheet" media="screen,projection" />
</head>

<body>
<c:import url="/usuario/usuarioHeader.jsp"/>
<div class="row" style="margin: 1%;">
    <div class="container">
        <h5 style="text-align: center; font-family: Arial, Helvetica, sans-serif; font-style:inherit;"><b> COMECE A INVESTIR:</b></h5>
        <div class="col s12">

            <c:forEach items="${ativos}" var="ativo">
                <div class="card-panel green lighten-5" style="max-height: 800px">

                    <table class="responsive-table highlight container">
                        <fmt:setLocale value="pt-BR"/>
                        <thead>
                        <tr>
                            <th>Nome</th>
                            <td>${ativo.nameAtivo}</td>
                        </tr>
                        <tr>
                            <th>OPEN</th>
                            <td><fmt:formatNumber type="currency">${ativo.open}</fmt:formatNumber></td>
                        </tr>
                        <tr>
                            <th>HIGH</th>
                            <td><fmt:formatNumber type="currency">${ativo.high}</fmt:formatNumber></td>
                        </tr>
                        <tr>
                            <th>LOW</th>
                            <td><fmt:formatNumber type="currency">${ativo.low}</fmt:formatNumber></td>
                        </tr>
                        <tr>
                            <th>PREÇO</th>
                            <td><fmt:formatNumber type="currency">${ativo.price}</fmt:formatNumber></td>
                        </tr>
                        <tr>
                            <th>AÇÃO</th>
                            <td style="width: 300px">
                                <form method="post" action="Controller?command=RealizarComprarCommand">
                                    <label>Quantidade maxima: ${(sessionScope.login.carteira.valorCaixa)/(ativo.price)}</label>
                                    <input id="idAtivo" name="idAtivo" value="${ativo.symbol}">
                                    <input id="quantidade" name="quantidade" type="number" value="1">
                                    <button class="btn waves-effect" style="float: right; border-radius: 20px;"> Comprar<i class="material-icons left">attach_money</i></button>
                                </form>
                            </td>

                        </tr>
                        </thead>
                    </table>

                </div>
            </c:forEach>

            <%--            <div class="card-panel green lighten-5 row" style="padding: 5%; margin-top: 2%;">--%>

            <%--                <div class="card" style="overflow-y: scroll; height: 350px; width: 100%; margin: 2%" >--%>
            <%--                    <fmt:setLocale value="pt-BR"/>--%>
            <%--                    <table class="responsive-table highlight container">--%>
            <%--                        <tr>--%>
            <%--                            <th>NOME</th>--%>
            <%--                            <th>OPEN</th>--%>
            <%--                            <th>HIGH</th>--%>
            <%--                            <th>LOW</th>--%>
            <%--                            <th>PRICE</th>--%>
            <%--                            <th style="width: 300px">AÇÃO</th>--%>
            <%--                        </tr>--%>
            <%--                        <c:forEach items="${ativos}" var="ativo">--%>
            <%--                            <tr>--%>
            <%--                                --%>
            <%--                                <td><fmt:formatNumber type="currency">${ativo.open}</fmt:formatNumber></td>--%>
            <%--                                <td><fmt:formatNumber type="currency">${ativo.high}</fmt:formatNumber></td>--%>
            <%--                                <td><fmt:formatNumber type="currency">${ativo.low}</fmt:formatNumber></td>--%>
            <%--                                <td><fmt:formatNumber type="currency">${ativo.price}</fmt:formatNumber></td>--%>
            <%--                                <td style="width: 300px">--%>
            <%--                                    <form method="post" action="Controller?command=RealizarComprarCommand">--%>
            <%--                                        <!--<label>Quantidade maxima: ${(sessionScope.login.carteira.valorCaixa)/(ativo.price)}</label> -->--%>
            <%--                                        <input id="idAtivo" name="idAtivo" value="${ativo.symbol}">--%>
            <%--                                        <input id="quantidade" name="quantidade" type="number" placeholder="${(sessionScope.login.carteira.valorCaixa)/(ativo.price)}">--%>
            <%--                                        <button class="btn-floating waves-effect" style="float: right"><i class="material-icons left">attach_money</i></button>--%>
            <%--                                    </form>--%>
            <%--                                </td>--%>
            <%--                            </tr>--%>
            <%--                        </c:forEach>--%>
            <%--                    </table>--%>
            <%--                </div>--%>
            <%--            </div>--%>
        </div>
    </div>
</div>

<!--  Scripts-->
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="./materialize/js/materialize.js"></script>
<script src="./materialize/js/init.js"></script>

</body>
</body>

</html>