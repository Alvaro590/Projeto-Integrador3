<%-- 
    Document   : inicio.jsp
    Created on : 16 de jun. de 2022, 13:01:27
    Author     : Usuário
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css_puro/style_inicio.css">
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap.min.css.map">
        <link rel="stylesheet" href="css_puro/style.css">
    </head>
    <body>
        <div class="container" style="height:95%;">

            <header>
                <nav>
                    <ul class="nav nav-tabs" style="display:flex; justify-content: center;">
                        <!-- <li class="nav-item"><a style="color:white ;" class="nav-link" href="index.jsp">HOME PAGE</a></li>
                        <li class="nav-item"><a style="color:white ;" class="nav-link" href="banco.jsp">Banco</a></li>
                        <li class="nav-item"><a style="color:white ;" class="nav-link" href="conta.jsp">Conta</a></li>
                        <li class="nav-item"><a style="color:white ;" class="nav-link" href="usuario.jsp">Login</a></li>
                        <li class="nav-item"><a style="color:white ;" class="nav-link" href="cadastro.jsp">Cadastro</a></li> -->
                    </ul>
                </nav>
            </header>

            <div class="content-nav">
                <div><a class="links" href="banco.jsp" style="color:white; text-decoration: none;">Banco</a></div>
                <div><a class="links" href="conta.jsp" style="color:white; text-decoration: none;">Conta</a></div>
                <div><a class="links" href="cartao.jsp" style="color:white; text-decoration: none;">Cartão</a></div>

            </div>

            <div class="content-nav">
                <div><a class="links" href="#" style="color:white; text-decoration: none;">Despeza</a></div>
                <div><a class="links" href="receita.jsp" style="color:white; text-decoration: none;">Receita</a></div>
            </div>
        </div>


        <footer class="bg-light text-center text-lg-start">
            <!-- Copyright -->
            <div class="text-center p-3" style="background-color: rgba(131, 112, 148, 0.822);">
                <!-- 131, 112, 148, 0.37 -->
                © 202 Copyright:
                <P>MyCash financeiro</P>
            </div>
            <!-- Copyright -->
        </footer>
    </body>

</html>
