<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: wernnevon
  Date: 20/12/2019
  Time: 12:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta http-equiv="Content-Type" content="text/html" charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0" />
<title>Histórico</title>

<!-- CSS  -->
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link href="./materialize/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection" />
<link href="./materialize/css/style.css" type="text/css" rel="stylesheet" media="screen,projection" />
<body>

<c:import url="/usuario/usuarioHeader.jsp"/>

<div class="container">
    <h2 class="center">Histórico de Transações</h2>
    <c:forEach items="${transacaos}" var="transacao">
    <div class="card-panel green lighten-5" style="max-height: 800px">
        <!--Aqui add um forEach pra pegar o histórico completo do usuario-->

        <table class="responsive-table highlight container">
            <thead>
            <tr>
                <th>Nome</th>
                <td>${transacao.ativo.nome}</td>
            </tr>
            <tr>
                <th>Numero da Compra</th>
                <td>${transacao.id}</td>
            </tr>
            <tr>
                <th>Data</th>
                <td>${transacao.data}</td>
            </tr>
            <tr>
                <th>Valor</th>
                <td><fmt:setLocale value="pt-BR"/>
                    <fmt:formatNumber type="currency">${transacao.valor}</fmt:formatNumber></td></td>
            </tr>
            <tr>
                <th>Quantidade</th>
                <td>${transacao.ativo.quantidade}</td>
            </tr>
            <tr>
                <th>Preço de Compra</th>
                <td>${transacao.ativo.precoDeCompra}</td>
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
