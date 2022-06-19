<%-- 
    Document   : listarreceita.jsp
    Created on : 18 de jun. de 2022, 20:03:50
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
                    </li>
                </ul>
            </nav>
        </header>
        <div style="margin-left:20%; margin-top:10%; width:60% ;">

            <table class="table table-hover" style="color:whitesmoke;">
                <legend>Lista de Receitas</legend>
                <thead>
                    <tr>
                        <th scope="col">Identificador</th>
                        <th scope="col">Descrição</th>
                        <th scope="col">Valor</th>
                        <th scope="col">Data</th>
                        <th scope="col">Número da Conta</th>
                        
                        
                    </tr>
                </thead>
                <c:forEach items="${lista}" var="linha">
                    <tr style=" color:whitesmoke;">

                        <td><c:out value="${linha.id}" /></td>
                        <td><c:out value="${linha.descricao}" /></td>   
                        <td><c:out value="${linha.valor}" /></td>
                        <td><c:out value="${linha.data}" /></td>
                        <td><c:out value="${linha.numConta}" /> </td>


                    </tr>
                </c:forEach>
            </table>
        </div>
    </form>
</body>

</html>

