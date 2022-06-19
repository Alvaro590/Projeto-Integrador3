<%-- 
    Document   : login.jps
    Created on : 17 de jun. de 2022, 12:20:31
    Author     : Usuário
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pratica JSP</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap.min.css.map">
    <link rel="stylesheet" href="css_puro/style.css">
     </head>
    
<body>
    <div class="container">
        <header>
            <nav>
               
                <ul class="nav nav-tabs">

                    <li class="nav-item"><a class="nav-link" style="color:whitesmoke ;" href="cadastro.jsp">Cadastro</a></li>
                </ul>
            </nav>
        </header>
        <div class="content_form">
            <div id="form">
                <form method="POST" action="Controller">
                    <legend>Login</legend>
                    <div class="form-group">
                        <label id="lbllogin" name="lbllogin">Login</label>
                        <input type="text" id="login" name="login" value="<c:out value="${login}"/>"/>
                    </div>
                    <div class="form-group">
                        <label id="lblsenha" name="lblsenha">Senha</label>
                        <input type="password" id="senha" name="senha" value="<c:out value="${senha}"/>"/>
                    </div>


                    <button id="btnLogin" name="botaologin" class="btn btn-primary">Login</button>


                    <c:choose>
                        <c:when test="${data2==false}">
                            <script language="JavaScript">

                                alert("Dados de login ou usuário incorretos");
                            </script>
                        </c:when>

                    </c:choose>


                </form>
            </div>
        </div>
    </div>
</body>
</html>

