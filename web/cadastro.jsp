<%-- 
    Document   : cadastro.jsp
    Created on : 15 de jun. de 2022, 07:14:26
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
                        <li class="nav-item"><a class="nav-link" href="index.jsp">Login</a></li>                       


                    </ul>
                </nav>
            </header>


            <div class="content_form">
                <div id="form">
                    <form method="POST" action="Controller" style="padding:10px;">
                        <legend>Cadastro</legend>
                        <div class="form-group">
                            <label id="lbluserlogin" name="lbluserlogin">Login</label>
                            <input type="text" id="userlogin" name="userlogin" maxlength="15" minlength="3"  class="form-control" required value="<c:out value="${login}" />"/>
                        </div>

                        <div class="form-group">
                            <label id="lblusersenha" name="lblusersenha">Senha</label>
                            <input type="password" id="usersenha" name="usersenha" maxlength="12" minlength="4"  class="form-control" required value="<c:out value="${senha}" />"/>
                        </div>
                        <br>
                        <button name="botaocadastro" value="c" class="btn btn-primary">Cadastrar</button>
                        <button name="botaovoltarlogin" value="c" class="btn btn-primary">Voltar</button>
                        <br>
                        <c:choose>
                            <c:when test="${data1==false}">
                                <script language="JavaScript" >

                                    alert("A senha deve ter, no mínimo:\n\
                                 um número \n\
                                 uma letra");
                                </script> 
                            </c:when>    

                        </c:choose>

                        <c:choose>
                            <c:when test="${data2==false}">
                                <script language="JavaScript" >
                                    alert("Usuário já registrado");
                                </script> 
                            </c:when>    

                        </c:choose>



                        <c:choose>
                            <c:when test="${data3==false}">
                                <script language="JavaScript" >
                                    alert("O nome de usuário deve ter entre 4 e 15 caracteres");
                                </script> 
                            </c:when>    

                        </c:choose>

                    </form>
                </div>
            </div>
        </div>
    </body>

</html>
