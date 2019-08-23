<!-- 
    Document   : banda.jsp
    Created on : 15/11/2016
    Author     : Dário Teles de Oliveira

    Página responsável por apresentar o identificador da banda e as opções de 
gerenciamento para repertórios e eventos:
        -Action "repertorioGerenciar" no qual direciona para repertoriocrud.jsp;
        -Action "eventoGerenciar" no qual direciona para o eventocrud.jsp;
        -Action "logoff" no qual direciona para página inicial do sistema.
-->
<%@page import="com.outlook.darioteles.entidades.Banda"%>
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
            <h2>Seja bem vindo <% Banda banda;
                banda = (Banda) session.getAttribute("banda");
                out.println(banda.getApelido());
                %>!</h2>
        </header>    
        <article>
            <p>Gerencie os repertórios e os eventos da sua banda:</p>
            <form action="Controller" method="POST">
                <input type="hidden" name="action" value="repertorioGerenciar">
                <input type="hidden" name="banda" value="<%= session.getAttribute("banda")%>">
                <input class="btn btn-lg btn-primary btn-block" type="Submit" name="botaoRepertorio" value="Gerenciar Repertorio">
            </form> 
            <form action="Controller" method="POST">
                <input type="hidden" name="action" value="eventoGerenciar">
                <input type="hidden" name="banda" value="<%= session.getAttribute("banda")%>">
                <input class="btn btn-lg btn-primary btn-block" type="Submit" name="botaoEvento" value="Gerenciar Evento">
            </form>
            <form action="Controller" method="POST">
                <input type="hidden" name="action" value="logoff">
                <input class="btn btn-lg btn-primary btn-block" type="Submit" name="botaoSair" value="Sair">
            </form>
        </article>
        <footer>
        </footer>
        </div>
    </body>
</html>