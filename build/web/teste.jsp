<%-- 
    Document   : teste.jsp
    Created on : 19 de jun. de 2022, 17:19:28
    Author     : Usuário
--%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pratica JSP</title>
        <link rel="stylesheet" href="css/style.css" />
    </head>
    <header>    
        <nav>
          <div class="mobile-menu">
          <div class="line1"></div>
          <div class="line2"></div>
          <div class="line3"></div>
        </div>
        <ul class="nav-list">
          <li><a href="menu.jsp">Menu</a></li>          
          <li><a href="banco.jsp">Banco</a></li>
          <li><a href="conta.jsp">Conta</a></li>       
          <li><a href="cartao.jsp">Cartao</a></li>
          <li><a href="receita.jsp">Receita</a></li>
        </ul>
        </nav>
    </header>
    <body>
       <h1>Despesa</h1>
        <form method="POST" action="Controller">
            <div>
                <label id="lbliddespesa" name="lbliddespesa">Identificador</label>
                <input type="number" id="iddespesa" name="iddespesa" value="<c:out value="${id}"/>"/>
                <label id="lbldescricao" name="lbldescricao">Descricao</label>
                <input type="text" id="descricao" name="descricao" value="<c:out value="${descricao}"/>"/>
                <label id="lblvalor" name="lblvalor">Valor</label>
                <input type="number" id="valor" name="valor" value="<c:out value="${valor}"/>"/>
                <label id="lbldata" name="lbldata">Data</label>
                <input type="date" id="data" name="data" value="<c:out value="${data}"/>"/>
                <label id="lblnumconta" name="lblnumconta">Número da conta</label>
                <input type="number" id="numconta" name="numconta" value="<c:out value="${numConta}"/>"/>
                <label id="lblnumcartao" name="lblnumcartao">Número do cartão</label>
                <input type="number" id="numcartao" name="numcartao" value="<c:out value="${numCartao}"/>"/>
                
                <button name="botaoDespesa" value="c">Inserir</button>
                <button name="botaoDespesa" value="r">Consultar</button>
                <button name="botaoDespesa" value="u">Alterar</button>
                <button name="botaoDespesa" value="d">Remover</button>
               
            </div>
            
        </form>
    </body>
</html>