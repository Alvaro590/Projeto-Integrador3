<%-- 
    Document   : menu.jsp
    Created on : 17 de jun. de 2022, 19:55:29
    Author     : Usuário
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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



                <ul class="nav nav-tabs">                                            

             
                    <h2 style="margin-left: 8.5%;">Bem vindo ao sistema de controle financeiro MyCash</h2>

                </ul>



                <nav>
                    <!--                    <ul class="nav nav-tabs" style="display:flex; justify-content: center;">-->
                    
                    <!--                    </ul>-->
                </nav>
            </header>

            <div class="content-nav">
                <div><a class="links" href="banco.jsp" style="color:white; text-decoration: none;">Banco</a></div>
                <div><a class="links" href="conta.jsp" style="color:white; text-decoration: none;">Conta</a></div>
                <div><a class="links" href="cartao.jsp" style="color:white; text-decoration: none;">Cartão</a></div>

            </div>

            <div class="content-nav">
                <div><a class="links" href="despesa.jsp" style="color:white; text-decoration: none;">Despesa</a></div>
                <div><a class="links" href="receita.jsp" style="color:white; text-decoration: none;">Receita</a></div>
            </div>
        </div>


        <footer class="bg-light text-center text-lg-start">
            <!-- Copyright -->
            <div class="text-center p-3" style="background-color: rgba(131, 112, 148, 0.822);">
                <!-- 131, 112, 148, 0.37 -->
                © 202 Copyright:
                <P>MyCash Financeiro</P>
            </div>
            <!-- Copyright -->
        </footer>
    </body>
</html>
