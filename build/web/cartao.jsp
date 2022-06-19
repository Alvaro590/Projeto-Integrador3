<%-- 
    Document   : cartao.jsp
    Created on : 15 de jun. de 2022, 12:57:56
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
                    <li class="nav-item"><a style="color:whitesmoke;" class="nav-link" href="conta.jsp">Conta</a></li>
                   
                    <li class="nav-item"><a style="color:whitesmoke;" class="nav-link" href="receita.jsp">Receita</a></li>
                    <li class="nav-item"><a style="color:whitesmoke;" class="nav-link" href="despesa.jsp">Despesa</a></li>
                    </ul>
                </nav>
            </header>

            <div class="content_form" style="margin-top:30px ;">
                <div id="form">
                    <form method="POST" action="Controller" style="width:60% ;">
                        <legend>cartão</legend>
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label id="lblnumerocartao" name="lblnumerocartao">Numero</label>
                                <input type="number"  id="numerocartao" minlength="4" name="numerocartao"/>

                            </div>
                            <div class="form-group col-md-6">
                                <label id="lblnomecartao" name="lblnomecartao">Nome</label>
                                <input type="text"  id="nomecartao" minlength="3" name="nomecartao"/>

                            </div>

                            <div class="form-group col-md-6">
                                <label id="lblbandeira" name="lblbandeira">Bandeira</label>
                                <input type="text"  id="bandeira" name="bandeira" />

                            </div>
                            <div class="form-group col-md-6">
                                <label id="lbllimite" name="lbllimite">Limite</label>
                                <input type="number"  id="limite" name="limite" />

                            </div>
                            <div class="form-group col-md-6">
                                <label id="lblagencia" name="lblagencia">Agencia</label>
                                <input type="number"  id="agencia" minlength="4" maxlength="5" name="agencia" />

                            </div>
                            <div class="form-group col-md-6">
                                <label id="lblcontaid" name="lblcontaid">Numero da Conta</label>
                                <input type="number"  id="contaid" minlength="1" name="numeroconta" />

                            </div>



                            <div>
                                <button class="btn btn-primary" name="botaocartao" value="c">Inserir</button>
                                <button class="btn btn-primary" name="botaocartao" value="r">Consultar</button>
                                <button class="btn btn-primary" name="botaocartao" value="u">Alterar</button>
                                <button class="btn btn-primary" name="botaocartao" value="d">Remover</button>
                            </div>

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

                                        alert("O nome do cartão deve conter apenas letras");
                                    </script> 
                                </c:when>    

                            </c:choose>

                            <c:choose>
                                <c:when test="${data3==false}">
                                    <script language="JavaScript" >

                                        alert("Não há conta com o identificador(id) fornecido");
                                    </script> 
                                </c:when>    

                            </c:choose>

                            <c:choose>
                                <c:when test="${data4==false}">
                                    <script language="JavaScript" >

                                        alert("Já existe cartão cadastrado com esse número");
                                    </script> 
                                </c:when>    

                            </c:choose>
                            <c:choose>
                                <c:when test="${data5==false}">
                                    <script language="JavaScript" >

                                        alert("A agência só deve conter dígitos e de ter 5 ou 6 caracteres");
                                    </script> 
                                </c:when>    

                            </c:choose>
                            <c:choose>
                                <c:when test="${data6==false}">
                                    <script language="JavaScript" >

                                        alert("Não há cartão registrado com esse número");
                                    </script> 
                                </c:when>    

                            </c:choose>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
