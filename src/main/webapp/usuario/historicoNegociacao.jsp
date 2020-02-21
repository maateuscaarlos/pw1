<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html" charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0" />
    <title>Histórico</title>

    <!-- CSS  -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <link href="./materialize/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection" />
    <link href="./materialize/css/style.css" type="text/css" rel="stylesheet" media="screen,projection" />
</head>
<body>

<c:import url="/usuario/usuarioHeader.jsp"/>

<div class="container">
    <h2 class="center">Histórico de Transações</h2>
    <c:forEach items="${transacaos}" var="transacao">
    <div class="card-panel green lighten-5" style="max-height: 800px">

        <table class="responsive-table highlight container">
            <fmt:setLocale value="pt-BR"/>
            <thead>
            <tr>
                <th>Nome</th>
                <td>${transacao.ativo.nome}</td>
            </tr>
            <tr>
                <th>Numero da Transação</th>
                <td>${transacao.id}</td>
            </tr>
            <tr>
                <th>Data</th>
                <td>${transacao.data}</td>
            </tr>
            <tr>
                <th>Valor</th>
                <td><fmt:formatNumber type="currency">${transacao.valor}</fmt:formatNumber></td>
            </tr>
            <tr>
                <th>Quantidade</th>
                <td>${transacao.ativo.quantidade}</td>
            </tr>
            <tr>
                <th>Preço</th>
                <td><fmt:formatNumber type="currency">${transacao.ativo.precoDeCompra}</fmt:formatNumber></td>
            </tr>
            <tr>
                <th>Ação</th>
                <td>${transacao.acao}</td>
            </tr>
            </thead>
        </table>

    </div>
    </c:forEach>
</div>

<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script src="./materialize/js/materialize.js"></script>
<script src="./materialize/js/init.js"></script>
</body>
</html>
