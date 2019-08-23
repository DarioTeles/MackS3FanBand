<!-- 
    Document   : fanlogin.jsp
    Created on : 15/11/2016
    Author     : Dário Teles de Oliveira

    Página responsável por realizar o login do fan:
        -Action "fanLogin" no qual direciona para fan.jsp;
        -fancadastro.jsp.
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>FanBand</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
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
    <body class="text-center">
        <div class="form-front">
            <header>
                <h1>Sing in: </h1>
            </header>
            <article>
                <form action="Controller" method="POST">
                    <h1 class="h3 mb-3 font-weight-normal">Selecione as músicas favoritas para os eventos! </h1>
                    <label class="sr-only">E-mail: </label>
                    <input class="form-control" type="text" name="login" placeholder="Email" autofocus/>
                    <label class="sr-only">Senha: </label>
                    <input class="form-control" type="password" name="senha" placeholder="Senha" />
                    <input type="hidden" name="action" value="fanLogin"/>
                    <input class="btn btn-lg btn-primary btn-block" type="submit" value="Login"/>
                </form>
                <form action="fancadastro.jsp" method="POST">
                    <input class="btn btn-lg btn-primary btn-block" type="submit" value="Cadastrar"> 
                </form>
        </article>
        <footer>
        </footer>
        </div>
    </body>
</html>