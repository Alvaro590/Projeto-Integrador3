<%-- 
    Document   : conta.jsp
    Created on : 15 de jun. de 2022, 06:42:07
    Author     : Usuário
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pratica JSP</title>
        <link rel="stylesheet" href="css/style.css" />
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap.min.css.map">
        <link rel="stylesheet" href="css_puro/style.css">
    </head>
    <body>
        <div class="container">
            <header>
                <nav style="background-color: transparent;">
                    <ul class="nav nav-tabs">
                         <li class="nav-item"><a style="color:whitesmoke;" class="nav-link" href="menu.jsp">Menu</a></li>
                    <li class="nav-item"><a style="color:whitesmoke;" class="nav-link" href="banco.jsp">Banco</a></li>
         
                    <li class="nav-item"><a style="color:whitesmoke;" class="nav-link" href="cartao.jsp">Cartao</a></li>
                    <li class="nav-item"><a style="color:whitesmoke;" class="nav-link" href="receita.jsp">Receita</a></li>
                    <li class="nav-item"><a style="color:whitesmoke;" class="nav-link" href="despesa.jsp">Despesa</a></li>

                    </ul>
                </nav>
            </header>

            <div class="content_form">
                <div id="form">
                    <form method="POST" action="Controller" style="padding:10px;">
                        <legend>Conta</legend>

                        <div class="form-group">
                            <label id="lblnumeroconta" name="lblnumeroconta">Numero</label>
                            <input type="number" id="numeroconta" name="numeroconta"  class="form-control" minlength="5" maxlength="6" value="<c:out value="${numero}" />"/>
                        </div>
                        <div class="form-group">
                            <label id="lblcontasaldo"   name="lblcontasaldo">Saldo</label>
                            <input type="number" id="saldoconta" name="saldoconta"  class="form-control" minlength="1"  maxlength="10" value="<c:out value="${saldo}" />"/>

                        </div>
                        <div class="form-group">
                            <label id="lblcontalimite" name="lblcontalimite">Limite</label>
                            <input type="number" id="limiteconta" name="limiteconta"  class="form-control" minlength="1" minlength="7" value="<c:out value="${limite}" />"/>
                        </div>

                        <button name="botaoconta" class="btn btn-primary" value="c">Inserir</button>
                        <button name="botaoconta" class="btn btn-primary" value="r">Consultar</button>
                        <button name="botaoconta" class="btn btn-primary" value="u">Alterar</button>
                        <button name="botaoconta" class="btn btn-primary" value="d">Remover</button>

                        <c:choose>
                            <c:when test="${data1==false}">
                                <script language="JavaScript" >

                                    alert("Algum campo não foi preenchido");
                                </script> 
                            </c:when>    

                        </c:choose>

                        <c:choose>
                            <c:when test="${data2==false}">
                                <script language="JavaScript" >

                                    alert("Número do cartão já cadastrado");
                                </script> 
                            </c:when>    

                        </c:choose>
                        <c:choose>
                            <c:when test="${data3==false}">
                                <script language="JavaScript" >

                                    alert("Não há cartão registrado com esse número");
                                </script> 
                            </c:when>    

                        </c:choose>
                        <c:choose>
                            <c:when test="${data4==false}">
                                <script language="JavaScript" >

                                    alert("O campo do número da conta deve ter 5 dígitos numéricos");
                                </script> 
                            </c:when>    

                        </c:choose>

                        <c:choose>
                            <c:when test="${data6==false}">
                                <script language="JavaScript" >

                                    alert("Entrou");
                                </script> 
                            </c:when>    

                        </c:choose>

                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
