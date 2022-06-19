<%-- 
    Document   : despesa.jsp
    Created on : 16 de jun. de 2022, 13:48:29
    Author     : Usuário
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pratica JSP</title>
        <!--        <link rel="stylesheet" href="css/style.css" />-->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap.min.css.map">
        <link rel="stylesheet" href="css_puro/style.css">
    </head>
    <body>
        <div class="container">
            <header>
                <nav style="background: transparent;">
                    <ul class="nav nav-tabs">
                        <li class="nav-item"><a style="color: whitesmoke" class="nav-link" href="menu.jsp">Menu</a></li>
                        <li class="nav-item"><a style="color: whitesmoke" class="nav-link" href="banco.jsp">Banco</a></li>
                        <li class="nav-item"><a style="color: whitesmoke" class="nav-link" href="conta.jsp">Conta</a></li>
                        <li class="nav-item"><a style="color: whitesmoke" class="nav-link" href="cartao.jsp">Cartao</a></li>
                        <li class="nav-item"><a style="color: whitesmoke" class="nav-link" href="receita.jsp">Receita</a></li>
                    </ul>
                </nav>
            </header>

            <div class="content_form" style="margin-top:30px ;">
                <div id="form">
                    <form method="POST" action="Controller" style="width:60% ;">
                        <legend>Despesa</legend>
                        <div class="form-row">
                            <label id="lbliddespesa" name="lbliddespesa">Identificador</label>
                            <input type="number" id="id"  class="form-control" name="id" />
                        </div>
                        <div class="form-row">
                            <label id="lbldescricao" name="lbldescricao">Descricao</label>
                            <input type="text" id="descricao" class="form-control" name="descricao" />
                        </div>
                        <div class="form-row">
                            <label id="lblvalor" name="lblvalor">Valor</label>
                            <input type="number" id="valor" class="form-control" name="valor" />
                        </div>
                        <div class="form-row">
                            <label id="lbldata" name="lbldata">Data</label>
                            <input type="date" id="data" class="form-control" name="data" />
                        </div>
                        <div class="form-row">

                            <label id="lblnumconta" name="lblnumconta">Número da conta</label>
                            <input type="number" id="numconta" class="form-control" name="numconta" />
                        </div>
                        <div class="form-row">

                            <label id="lblnumcartao" name="lblnumcartao">Número do cartão</label>
                            <input type="number" id="numcartao" class="form-control" name="numcartao" />
                        </div>
                        <br>
                        <button name="botaoDespesa" class="btn btn-primary" value="c">Inserir</button>
                        <button name="botaoDespesa" class="btn btn-primary" value="r">Consultar</button>
                        <button name="botaoDespesa" class="btn btn-primary" value="u">Alterar</button>
                        <button name="botaoDespesa" class="btn btn-primary" value="d">Remover</button>

                        <c:choose>
                            <c:when test="${data1==false}">
                                <script language="JavaScript" >

                                    alert("O valor da despesa não pode ser nulo");
                                </script> 
                            </c:when>    

                        </c:choose>

                        <c:choose>
                            <c:when test="${data2==false}">
                                <script language="JavaScript" >

                                    alert("O identificador não pode ser 0");
                                </script> 
                            </c:when>    

                        </c:choose>

                        <c:choose>
                            <c:when test="${data3==false}">
                                <script language="JavaScript" >

                                    alert("Algum campo não foi preenchido");
                                </script> 
                            </c:when>    

                        </c:choose>

                        <c:choose>
                            <c:when test="${data4==false}">
                                <script language="JavaScript" >

                                    alert("Não há conta cadastrada com esse número");
                                </script> 
                            </c:when>    

                        </c:choose>

                        <c:choose>
                            <c:when test="${data5==false}">
                                <script language="JavaScript" >

                                    alert("Consta despesa cadastrada com esse identificador");
                                </script> 
                            </c:when>    

                        </c:choose>

                        <c:choose>
                            <c:when test="${data5==false}">
                                <script language="JavaScript" >

                                    alert("Não há cartão com esse número");
                                </script> 
                            </c:when>    

                        </c:choose>

                        <c:choose>
                            <c:when test="${data6==false}">
                                <script language="JavaScript" >

                                    alert("O identificador deve ser fornecido");
                                </script> 
                            </c:when>    

                        </c:choose>

                        <c:choose>
                            <c:when test="${data7==false}">
                                <script language="JavaScript" >

                                    alert("Não há despesa cadastrada com esse identificador");
                                </script> 
                            </c:when>    

                        </c:choose>


                    </form>
                </div>
            </div>
        </div>
    </body>
</html>

