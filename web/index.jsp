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
                var mes = document.getElementById('mes');
                var ano = document.getElementById('ano');
                var cidade = document.getElementById('cidade');
        		
        	$(numero).keyup(function(){
                    var element = $(this);
                    var soNumeros = /[^0-9]/;
                    var replaced;
        			
                    if(soNumeros.test(element.val())){
        		$(erro).fadeIn('slow', function(){
                            $(this).html('Erro: ');
        		});
        		$(msgErro).fadeIn('slow', function(){
                            $(this).html('somente números são permitidos');
        		});
                    }
                    replaced = element.val().replace(soNumeros, '');
                    element.val(replaced);
        	});
        	
                /*$(numero).focusOut(function(){
                    $(erro).fadeOut(1000, function(){
        		$(this).html('');
                    });
                    $(msgErro).fadeOut(1000, function(){
                        $(this).html('');
                    });
        	});*/
                 
                 /*
                $('#dominio').change(function(){
                    $.ajax({
                        type: "GET",
                        url: "SearchSubdomain",
                        dataType: "html",
                        data: { dominio: $('#dominio').val() },
                        success: function(data, textStatus, jqXHR) {
                            $('#subdom').html(data);
                        }
                    });
                });*/
                
                $('#dominio').change(function() {
                    //The above selector gets the State field by its ID

                    $.ajax({
                      type: "GET", 
                      url: "SearchSubdomain", 
                      dataType: "html", 
                      data: { dominio: $('#dominio').val() },
                      success: function(data, textStatus, jqXHR) {
                        $('#subdom').html(data);
                      }
                    });  

                  }); 
                
                
            });
        </script>
        <title>Tipo de Licitação | Busca</title>
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
        <section class = "container">
            <article>
            	<h1>Informações para a busca:</h1>
            	<form>
                    <p style = "text-align: center"><label for = "numero">Número da Licitação:</label><input type = "text" id = "numero"></p>
                    <p id = "error_box"><span id = "erro"></span><span class = "right" id = "msgErro"></span></p>
                                        
                    <p class = "row">
                        <label for = "dominio">Dominio da Consulta:</label>
                        <select class = "right" name = "dominio" id="dominio">
                        <option value = "" selected></option>
                        <option value = "Saude">Saude</option>
                        <option value = "Educacao">Educacao</option>
                        <option value = "Saneamento">Saneamento</option>
                        </select>
                    </p>
                                        
                    <p class = "row">
                        <label for = "subdom">Subdominio da Consulta:</label>
                        <select class = "right" name = "subdom" id="subdom">
                        </select>
                    </p>
                                        
                    <p class = "row">
                        <label for = "mes">Mês da licitação:<label>
                        <select class = "right" name = "mes" id = "mes">
                            <option value = "" selected></option>
                            <option value = "janeiro">Janeiro</option>
                            <option value = "fevereiro">Fevereiro</option>
                            <option value = "marco">Março</option>
                            <option value = "abril">Abril</option>
                            <option value = "maio">Maio</option>
                            <option value = "junho">Junho</option>
                            <option value = "julho">Julho</option>
                            <option value = "agosto">Agosto</option>
                            <option value = "setembro">Setembro</option>
                            <option value = "outubro">Outubro</option>
                            <option value = "novembro">Novembro</option>
                            <option value = "dezembro">Dezembro</option>
                        </select>
                    </p>
                                        
                    <p class = "row">
                        <label for = "ano">Ano da licitação:</label>
                        <select class = "right" name = "ano" id = "ano">
                            <option value = "" selected></option>
                            <option value = "a2013">2013</option>
                            <option value = "a2014">2014</option>
                        </select>
                    </p>
                                        
                    <p class = "row">
                        <label class = "left" for = "cidade">Cidade da licitação:</label>
                        <select class = "right" name = "cidade" id = "cidade">
                            <option value = "" selected></option>
                            <option value = "campinas">Campinas</option>
                        </select>
                    </p>
                    
                    <p style = "text-align: center"><input type = "submit" value = "Buscar Licitação"></p>
            	</form>
            </article>
	</section>
	<footer class = "container">
            <p>Projeto Integrado - ES2 e Web - 2015 - Grupo 15</p>
	</footer>
    </body>
</html>
