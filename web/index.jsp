<%-- 
    Document   : index
    Created on : 10-Apr-2015, 5:30:03 PM
    Author     : eduardo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel = "stylesheet" type = "text/css" href = "style.css">
        <script src = "http://code.jquery.com/jquery-2.1.3.min.js"></script>
        <script>
        	<%--Implementando as verificacoes de entrada, utilizando JavaScript com jQuery--%>
        	$(document).ready(function(){
        		var numero = document.getElementById('numero');
        		var erro = document.getElementById('erro');
        		var msgErro = document.getElementById('msgErro');
        		
        		$(numero).keyup(function(){
        			var element = $(this);
        			var soNumeros = /[^0-9]/;
        			var replaced;
        			
        			if(soNumeros.test(element.val())){
        				$(erro).fadeIn('slow', function(){
        					$(this).html('Erro: ');
        				});
        				$(msgErro).fadeIn('slow', function(){
        					$(this).html('somente numeros sao permitidos');
        				});
        			}
        			replaced = element.val().replace(soNumeros, '');
        			element.val(replaced);
        		});
        		$(numero).focusOut(function(){
        			$(erro).fadeOut(1000, function(){
        				$(this).html('');
        			});
        			$(msgErro).fadeOut(1000, function(){
        				$(this).html('');
        			});
        		});
        	});
        </script>
        <title>Tipo de Licitacao</title>
    </head>
    <body>
        <header class = "container">
            <h1><a href = "index.jsp">Tipo de Licitacao</a></h1>
            <nav>
            	<ul>
            		<li><a class = "active" href = "index.jsp">Pagina Principal</a></li>
            	</ul>
            </nav>
        </header>
        <section class = "container">
            		<article>
            			<h1>Informacoes para a busca:</h1>
            			<form>
            				<p><label for = "numero">Numero da Licitacao:</label><input type = "text" id = "numero"></p>
            				<p id = "error_box"><span id = "erro"></span><span class = "right" id = "msgErro"></span></p>
            				<p><input type = "submit" value = "Buscar Licitacao"></p>
            			</form>
            		</article>
		</section>
		<footer class = "container">
			<p>Projeto Integrado - ES2 e Web - 2015 - Grupo 15</p>
		</footer>
    </body>
</html>
