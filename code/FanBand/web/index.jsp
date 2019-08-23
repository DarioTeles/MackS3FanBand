<!-- 
    Document   : index.jsp
    Created on : 15/11/2016
    Author     : Dário Teles de Oliveira
 
    Página inicial do sistema, no qual é reponsável por segmentar o acesso de 
bandas do acesso de fans:
        - bandalogin.jsp;
        - fanlogin.jsp.
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
    </head>
    <body class="text-center">
        <div class="form-front">
            <header> 
                <h1>Bem-vindo ao FanBand</h1>
            </header>
            <article>
                <p>O serviço que aproxima sua banda aos seus fans!</p>
                <p>Selecione o seu acesso:</p>
                <form name="formulario" method="get" action="bandalogin.jsp">
                    <input class="btn btn-lg btn-primary btn-block" type="Submit" name="botaoBanda" value="Banda">
                </form>
                <form name="formulario" method="get" action="fanlogin.jsp">
                    <input class="btn btn-lg btn-primary btn-block" type="Submit" name="botaoFan" value="Fan">
                </form>
            </article>
        </div>
    </body>
</html>