<%-- 
    Document   : licitacao
    Created on : 20/05/2015, 20:43:33
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "import model.LicitacaoBean" %>
<%@page import = "import java.util.*" %>
<%@page import = "import javax.servlet.http.*" %>
<%@page import = "import java.io.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" type = "text/css" href = "style.css">
        <script src = "http://code.jquery.com/jquery-2.1.3.min.js"></script>
        <!-- colocar o jquery + ajax aqui -->
        <script>
            $(document).ready{
                var xml = '${result}';
                var parsedXML = $.parseXML(xml);
                $xml = $(parsedXML);
            };
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
        <section>
            <%
                LicitacaoBean objLicitacao = (LicitacaoBean)request.getAttribute("result");
            %> 
            <article>
                <h1>Resultados da busca:</h1>
                <%
                
                %> 
            </article>
        </section>
        <footer class = "container">
            <p>Projeto Integrado - ES2 e Web - 2015 - Grupo 15</p>
	</footer>
    </body>
</html>
