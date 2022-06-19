<%-- 
    Document   : receita.jsp
    Created on : 16 de jun. de 2022, 10:36:58
    Author     : Usuário
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                <nav>
                    <ul class="nav nav-tabs">
                        <li class="nav-item"><a style="color:whitesmoke;" class="nav-link" href="menu.jsp">Menu</a></li>
                        <li class="nav-item"><a style="color:whitesmoke;" class="nav-link" href="banco.jsp">Banco</a></li>
                        <li class="nav-item"><a style="color:whitesmoke;" class="nav-link" href="conta.jsp">Conta</a></li>
                        <li class="nav-item"><a style="color:whitesmoke;" class="nav-link" href="cartao.jsp">Cartao</a></li>

                        <li class="nav-item"><a style="color:whitesmoke;" class="nav-link" href="despesa.jsp">Despesa</a></li>
                    </ul>
                </nav>
            </header>

            <div class="content_form" style="margin-top:50px ;">
                <div id="form">
                    <form method="POST" action="Controller">
                        <legend>Receita</legend>

                        <div class="form-group">
                            <label id="lblid" name="lblid">Identificador</label>
                            <input type="number" class="form-control" id="idreceita" name="idreceita" value="<c:out value="${id}" />"/>
                        </div>

                        <div class="form-group">
                            <label id="lbldescricao" name="lbldescricao">Descricao</label>
                            <input type="text" class="form-control" id="descricao" name="descricao"/>
                        </div>

                        <div class="form-group">
                            <label id="lblvalor" name="lblvalor">Valor</label>
                            <input type="number" class="form-control" id="valor" name="valor" value="<c:out value="${valor}" />"/>
                        </div>
                        <div class="form-group">
                            <label id="lbldata" name="lbldata">Data</label>
                            <input type="date" class="form-control" id="data" name="data" value="<c:out value="${data_receita}" />"/>
                        </div>
                        <div class="form-group">
                            <label id="lblnumconta" name="lblnumconta">Numero conta</label>
                            <input type="number" class="form-control" id="numconta" name="numconta" value="<c:out value="${numConta}" />"/>

                        </div>



                        <button name="botaoReceita"  class="btn btn-primary" value="c">Inserir</button>
                        <button name="botaoReceita"  class="btn btn-primary" value="r">Consultar</button>
                        <button name="botaoReceita"  class="btn btn-primary" value="u">Alterar</button>
                        <button name="botaoReceita"  class="btn btn-primary" value="d">Remover</button>

                        <c:choose>
                            <c:when test="${data1==false}">
                                <script language="JavaScript" >

                                    alert("Preencha os campos obrigatórios");
                                </script> 
                            </c:when>    

                        </c:choose>
                        <c:choose>
                            <c:when test="${data2==false}">
                                <script language="JavaScript" >

                                    alert("O valor deve ser diferente de 0");
                                </script> 
                            </c:when>    

                        </c:choose>  
                        <c:choose>
                            <c:when test="${data3==false}">
                                <script language="JavaScript" >

                                    alert("O campo id deve ser preenchido");
                                </script> 
                            </c:when>    

                        </c:choose>    

                        <c:choose>
                            <c:when test="${data4==false}">
                                <script language="JavaScript" >

                                    alert("Não existe conta no cadastro esse número");
                                </script> 
                            </c:when>    

                        </c:choose>    

                        <c:choose>
                            <c:when test="${data5==false}">
                                <script language="JavaScript" >

                                    alert("Não existe receita no cadastro com esse identificador");
                                </script> 
                            </c:when>    

                        </c:choose>   

                        <c:choose>
                            <c:when test="${data6==false}">
                                <script language="JavaScript" >

                                    alert("Já existe receita no cadastro com esse identificador");
                                </script> 
                            </c:when>    

                        </c:choose>  

                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
