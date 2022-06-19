<%-- 
    Document   : banco.jsp
    Created on : 14 de jun. de 2022, 13:38:30
    Author     : Usuário
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pratica JSP</title>
        <link rel="stylesheet" href="style.css" />
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/bootstrap.min.css.map">
        <link rel="stylesheet" href="css_puro/style.css">
    </head>
    <body>
        <div class="container">
            <header>
                <nav>
                    
                    <ul class="nav nav-tabs">  
                        <li class="nav-item"><a style="color: whitesmoke;" class="nav-link" href="menu.jsp">Menu</a></li>
                        
                        <li class="nav-item"><a style="color: whitesmoke;" class="nav-link" href="conta.jsp">Conta</a></li>
                        <li class="nav-item"><a style="color: whitesmoke;" class="nav-link" href="cartao.jsp">Cartao</a></li>
                        <li class="nav-item"><a style="color: whitesmoke;" class="nav-link" href="receita.jsp">Receita</a></li>
                        <li class="nav-item"><a style="color: whitesmoke;" class="nav-link" href="despesa.jsp">Despesa</a></li>
                    </ul>
                </nav>
            </header>
            <div class="content_form">
                <div id="form">

                    <form method="POST" action="Controller" style="padding:10px;">
                        <legend>BANCO</legend>
                        <div class="form-group">
                            <label id="lblidbanco" name="lblidbanco">ID:</label>
                            <input type="number" class="form-control" name="banco_id" maxlength="5"  />
                        </div>
                        <br>
                        <div class="form-group">
                            <label id="lbldescricao" name="lbldescricao">Descricao:</label>
                            <input type="text" class="form-control" name="descricaobanco"  maxlength="30" minlength="3" />
                        </div


                        <br>
                        <button class="btn btn-primary" name="botaoBanco" value="c">Inserir</button>
                        <button class="btn btn-primary" name="botaoBanco" value="r">Listar</button>
                        <button class="btn btn-primary" name="botaoBanco" value="u">Atualizar</button>
                        <button class="btn btn-primary" name="botaoBanco" value="d">Deletar</button>
                        <br>
                        <c:choose>
                            <c:when test="${data1==false}">
                                <script language="JavaScript" >

                                    alert("Banco cadastrado");
                                </script> 
                            </c:when>    

                        </c:choose>
                        <c:choose>
                            <c:when test="${data2==false}">
                                <script language="JavaScript" >

                                    alert("Banco com esse id ou descrição já cadastrado");
                                </script> 
                            </c:when>    

                        </c:choose>
                        <c:choose>
                            <c:when test="${data3==false}">
                                <script language="JavaScript" >

                                    alert("Nao há banco com esse identificador");
                                </script> 
                            </c:when>    

                        </c:choose>  

                        <c:choose>
                            <c:when test="${data4==false}">
                                <script language="JavaScript" >

                                    alert("A descrição do banco deve ter, no mínimo, 4 caracteres");
                                </script> 
                            </c:when>    

                        </c:choose>  

                        <c:choose>
                            <c:when test="${data5==false}">
                                <script language="JavaScript" >

                                    alert("O identificador do banco só pode conter números");
                                </script> 
                            </c:when>    

                        </c:choose>  



                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
