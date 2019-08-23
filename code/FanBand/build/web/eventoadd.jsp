<!-- 
    Document   : eventoadd.jsp
    Created on : 15/11/2016
    Author     : Dário Teles de Oliveira

    Página responsável pelo cadastro de eventos.
        -Action "eventoAdd" no qual direciona para banda.jsp.
-->
<%@page import="com.outlook.darioteles.entidades.Repertorio"%>
<%@page import="java.util.List"%>
<%@page import="com.outlook.darioteles.entidades.Banda"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>FanBand</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script type="text/javascript" language="javascript">
            function validacao_form() {
                verificacao = true;
                if (form.nome.value == "" && verificacao == true) {
                    alert('Por favor, preecha o campo Nome.');
                    document.getElementById("nome").focus();
                    verificacao = false;
                }
                if (form.descricao.value == "" && verificacao == true) {
                    alert('Por favor, preecha o campo Descrição.');
                    document.getElementById("descricao").focus();
                    verificacao = false;
                }
                if (form.local.value == "" && verificacao == true) {
                    alert('Por favor, preecha o campo Local.');
                    document.getElementById("local").focus();
                    verificacao = false;
                }
                if (form.repertorio.value == "" && verificacao == true) {
                    alert('Por favor, preecha o campo Repertório.');
                    document.getElementById("repertorio").focus();
                    verificacao = false;
                }
                if ((isNaN(form.repertorio.value)) && verificacao == true) {
                    alert("Insira somente números no campo Repertório.");
                    document.getElementById("repertorio").focus();
                    verificacao = false;
                }
                if (form.valoringresso.value == "" && verificacao == true) {
                    alert('Por favor, preecha o campo Valor do Ingresso.');
                    document.getElementById("valoringresso").focus();
                    verificacao = false;
                }
                if ((isNaN(form.valoringresso.value)) && verificacao == true) {
                    alert("Insira somente números no campo Valor do Ingresso.");
                    document.getElementById("valoringresso").focus();
                    verificacao = false;
                }
                return verificacao;
            }
        </script>
        
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/form.css">
        <script type="text/javascript" src="https://gc.kis.v2.scr.kaspersky-labs.com/FD126C42-EBFA-4E12-B309-BB3FDD723AC1/main.js" charset="UTF-8"></script>        
    
        <style>
            .bd-placeholder-img {
                font-size: 1.125rem;
                text-anchor: middle;
                -webkit-user-select: none;
                -moz-user-select: none;
                -ms-user-select: none;
                user-select: none;
            }

            @media (min-width: 768px) {
                .bd-placeholder-img-lg {
                    font-size: 3.5rem;
                }
            }
        </style> 
    </head>
    <body  class="text-center">
        <div class="form-front">
            <header>
                <h1 class="h3 mb-3 font-weight-normal">Insira os dados do evento:</h1>
            </header>
            <article>
                <form action="Controller" method="POST" name="form" onsubmit="return validacao_form()">
                    <label class="sr-only">Nome: </label>
                    <input class="form-control" type="text" id="nome" name="nome" placeholder="Nome" autofocus/>
                    <label class="sr-only">Descrição: </label> 
                    <input class="form-control" type="text" id="descricao" name="descricao" placeholder="Descrição"/>
                    <label class="sr-only">Local: </label> 
                    <input class="form-control" type="text" id="local" name="local" placeholder="Local"/>
                    <label class="sr-only">Data: </label> 
                    <input class="form-control" type="date" id="data" name="data" placeholder="Data">
                    <label class="sr-only">Repertorio: </label> 
                    <input class="form-control" list="repertorio" name="repertorio" size="10" placeholder="Repertorio">
                    <datalist id="repertorio">
                    <% Banda banda = (Banda) session.getAttribute("banda");
                        List<Repertorio> repertorios = banda.getRepertorios();
                        String imprime = "";
                        for (Repertorio x : repertorios) {
                            imprime = imprime + "<option value='" + x.getCodigo() + "'>";
                                    }
                                    out.println(imprime);%>
                    </datalist>
                    <label class="sr-only">Valor do ingresso: </label>  
                    <input class="form-control" type="text" id="valoringresso" name="valoringresso" placeholder="Valor do ingresso"/>
                    <input type="hidden" name="action" value="eventoAdd"/>
                    <input class="btn btn-lg btn-primary btn-block" type="submit" value="Enviar"/>
                </form>
            </article>
            <footer>
            </footer>
        </div>
    </body>
</html>