<%-- 
    Document   : listarConta
    Created on : 18 de jun. de 2022, 09:18:23
    Author     : Usuário
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap.min.css.map">
        <link rel="stylesheet" href="css_puro/style.css">
    </head>
   <body>
    <div class="container">
        <header>
            <nav>
                <ul class="nav nav-tabs">
                      <li class="nav-item"><a style="color:whitesmoke;" class="nav-link" href="menu.jsp">Menu</a></li>
                    <li class="nav-item"><a style="color:whitesmoke;" class="nav-link" href="banco.jsp">Banco</a></li>
                    <li class="nav-item"><a style="color:whitesmoke;" class="nav-link" href="conta.jsp">Conta</a></li>
                    <li class="nav-item"><a style="color:whitesmoke;" class="nav-link" href="cartao.jsp">Cartao</a></li>
                    <li class="nav-item"><a style="color:whitesmoke;" class="nav-link" href="receita.jsp">Receita</a></li>
                    <li class="nav-item"><a style="color:whitesmoke;" class="nav-link" href="despesa.jsp">Despesa</a></li>

                </ul>
            </nav>
        </header>
        <div style="margin-left:20%; margin-top:10%; width:60% ;">
            <table class="table table-hover" style="color:whitesmoke;">
                <legend>Lista de Contas</legend>
                <thead>
                    <tr>
                        <th scope="col" >Id conta</th>
                        <th scope="col">Número</th>
                        <th scope="col">Saldo</th>
                        <th scope="col">Limite</th>
                        <th scope="col">Id usuário</th>
                    </tr>
                </thead>
                <c:forEach items="${lista}" var="linha">
                    <tr style="color:whitesmoke ;">

                        <td>
                            <c:out value="${linha.id}" />
                        </td>
                        <td>
                            <c:out value="${linha.numero}" />
                        </td>
                        <td>
                            <c:out value="${linha.saldo}" />
                        </td>
                        <td>
                            <c:out value="${linha.limite}" />
                        </td>
                        <td>
                            <c:out value="${linha.userId}" />
                        </td>

                    </tr>
                </c:forEach>
            </table>
        </div>
</body>

</html>
