<%-- 
    Document   : listacartao.jsp
    Created on : 18 de jun. de 2022, 16:20:15
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
            <h1>Bancos:</h1>
        <form method="POST" action="Controller">
            
            <div>
                <table border="1">
                    <tr><th>Identificador</th><th>Descrição</th></tr>
                    <c:forEach items="${lista}" var="linha">
                        <tr>
                            
                            <td><c:out value="${linha.id}"/></td>
                            <td><c:out value="${linha.nome}"/></td>  
                            <td><c:out value="${linha.numero}"/></td>
                            <td><c:out value="${linha.bandeira}"/></td>
                            <td><c:out value="${linha.limite}"/></td>
                            <td><c:out value="${linha.agencia}"/></td>
                            <td><c:out value="${linha.userId}"/></td>
                            <td><c:out value="${linha.numeroConta}"/></td>        

                        </tr>
                    </c:forEach>
                </table>
            </div>
        </form>
</body>

</html>
