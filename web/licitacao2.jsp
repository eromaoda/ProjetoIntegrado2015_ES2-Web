<%-- 
    Document   : licitacao
    Created on : 20/05/2015, 20:43:33
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.LicitacaoBean"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" type = "text/css" href = "style.css">
        <script src = "http://code.jquery.com/jquery-2.1.3.min.js"></script>
        <!-- colocar o jquery + ajax aqui -->
        <script>
            
        </script>
        <title>Tipo de Licitação | Resultados</title>
    </head>
    <body>
        <header class = "container">
            <h1><a href = "index.jsp">Tipo de Licitação</a></h1>
            <nav>
            	<ul>
                    <li><a class = "active" href = "index.jsp">Página Principal</a></li>
            	</ul>
            </nav>
        </header>       
        <%
          List<LicitacaoBean> lista = new ArrayList<LicitacaoBean>();
          lista = (List<LicitacaoBean>)request.getAttribute("LicitacaoBean"); 
          for(int i = 0; i < lista.size(); i++){
        %>
        ID:<%= lista.get(i).getId() %>
        Dominio:<%= lista.get(i).getDominio()%>
        SubDominio:<%= lista.get(i).getSubdominio()%>
        Cidade:<%= lista.get(i).getCidade()%>
        Ano:<%= lista.get(i).getAno()%>
        Mes:<%= lista.get(i).getMes()%>
        Natureza:<%= lista.get(i).getNatureza()%>
        Fonte:<%= lista.get(i).getFonte()%>
        Tipo de Licitação<%= lista.get(i).getTipoLicitacao() %>
        <p>
        <%}%>
        
        <section>
            <article>
                <h1>Resultados da busca:</h1>
            </article>
        </section>
        <footer class = "container">
            <p>Projeto Integrado - ES2 e Web - 2015 - Grupo 15</p>
	</footer>
    </body>
</html>
