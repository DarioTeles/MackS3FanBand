<!-- 
    Document   : musicaadd.jsp
    Created on : 15/11/2016
    Author     : Dário Teles de Oliveira

    Página responsável pelo cadastro de músicas.
        -Action "musicaAdd" no qual direciona para repertoriocrud.jsp.
-->
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
                if (form.compositor.value == "" && verificacao == true) {
                    alert('Por favor, preecha o campo Compositor.');
                    document.getElementById("compositor").focus();
                    verificacao = false;
                }
                if (form.genero.value == "" && verificacao == true) {
                    alert('Por favor, preecha o campo Gênero.');
                    document.getElementById("genero").focus();
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
                <h1 class="h3 mb-3 font-weight-normal">Insira os dados da música:</h1>
            </header>
            <article>
                <form action="Controller" method="POST" name="form" onsubmit="return validacao_form()">
                    <label class="sr-only">Nome: </label>
                    <input class="form-control" type="text" id="nome" name="nome"  placeholder="Nome" autofocus/>
                    <label class="sr-only">Compositor: </label>
                    <input class="form-control" type="text" id="compositor" name="compositor"  placeholder="Compositor"/>
                    <label class="sr-only">Gênero: </label>
                    <input class="form-control" type="text" id="genero" name="genero"  placeholder="Gênero"/>
                    <input type="hidden" name="action" value="musicaAdd"/>
                    <input class="btn btn-lg btn-primary btn-block" type="submit" value="Enviar"/>
                </form>
            </article>
            <footer>
            </footer>
        </div>
    </body>
</html>