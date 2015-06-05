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
            	<form name = "formulario" action = "LicitacaoServlet" method = "POST">
                    <!--<p style = "text-align: center"><label for = "numero">Número da Licitação:</label><input type = "text" id = "numero"></p>
                    <p id = "error_box"><span id = "erro"></span><span class = "right" id = "msgErro"></span></p>-->
                    <p class = "row">
                        <label for = "licitacao">Tipo de Licitação:</label>
                        <select class = "right" name = "licitacao" id = "licitacao">
                            <option value = "" selected></option>
                            <option value = "Pessoal">Pessoal</option>
                            <option value = "Contrato de Obras">Contrato de Obras</option>
                            <option value = "Material Permanente">Contrato de Locação</option>
                            <option value = "Contrato de Termo de Parceria">Contrato de Locação</option>
                            <option value = "Contrato de Fornecimento de Serviços">Contrato de Locação</option>
                            <option value = "Registro de Preços">Registro de Preços</option>
                            <option value = "Serviços/Outros">Serviços/Outros</option>
                            <option value = "Contrato Outros">Contrato/Outros</option>
                            <option value = "Material de Consumo">Material de Consumo</option>
                            <option value = "Adiantamento">Adiantamento</option>
                            <option value = "Contrato de Locacação">Contrato de Locação</option>
                            <option value = "Contratos de Fornecimento de Material">Contratos de Fornec. de Material</option>
                        </select>
                    </p>
                    
                    <p class = "row">
                        <label for = "dominio">Domínio da Consulta:</label>
                        <select class = "right" name = "dominio" id="dominio">
                        <option value = "" selected></option>
                        <option value = "10 - SAUDE">Saúde</option>
                        <option value = "12 - EDUCACAO">Educação</option>
                        </select>
                    </p>
                                        
                    <p class = "row">
                        <label for = "subdom">Subdomínio:</label>
                        <select class = "right" name = "subdom" id="subdom">
                        </select>
                    </p>
                                        
                    <p class = "row">
                        <label for = "mes">Mês da licitação:<label>
                        <select class = "right" name = "mes" id = "mes">
                            <option value = "" selected></option>
                            <option value = "01">Janeiro</option>
                            <option value = "02">Fevereiro</option>
                            <option value = "03">Março</option>
                            <option value = "04">Abril</option>
                            <option value = "05">Maio</option>
                            <option value = "06">Junho</option>
                            <option value = "07">Julho</option>
                            <option value = "08">Agosto</option>
                            <option value = "09">Setembro</option>
                            <option value = "10">Outubro</option>
                            <option value = "11">Novembro</option>
                            <option value = "12">Dezembro</option>
                        </select>
                    </p>
                                        
                    <p class = "row">
                        <label for = "ano">Ano da licitação:</label>
                        <select class = "right" name = "ano" id = "ano">
                            <option value = "" selected></option>
                            <option value = "2013">2013</option>
                            <option value = "2014">2014</option>
                        </select>
                    </p>
                    
                    <p style = "text-align: center">
                        <input type = "submit" value = "Buscar Licitação">
                    </p>
            	</form>
            </article>
	</section>
	<footer class = "container">
            <p>Projeto Integrado - ES2 e Web - 2015 - Grupo 15</p>
	</footer>
    </body>
</html>
