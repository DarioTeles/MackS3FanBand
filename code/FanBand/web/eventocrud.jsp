<!-- 
    Document   : eventocrud.jsp
    Created on : 15/11/2016
    Author     : Dário Teles de Oliveira

    Página responsável por apresentar a lista de eventos da banda e a opção de 
adicionar um novo evento.
        -Action eventoadd.jsp;
        -Action "logoff" no qual direciona para página inicial do sistema.
-->
<%@page import="com.outlook.darioteles.entidades.Evento"%>
<%@page import="java.util.List"%>
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
    <body  class="text-center">
        <div class="form-front" style="max-width: 900px;">
            <header>
                <h1> Gerencie os seus eventos: </h1>
            </header>
            <article>
                <div style="overflow-x:auto;">
                    <table style="display: inline-block; position: relative;text-align: left">
                        <tr>
                            
                            <td>Nome: </td>
                            <td>Descrição: </td>
                            <td>Local: </td>
                            <td>Data: </td>
                            <td>Repertorio: </td>
                            <td>Valor do Ingresso: </td>
                        </tr>
            <%
                List<Evento> eventos = (List<Evento>) 
                        session.getAttribute("eventos");

                for (Evento x : eventos) {
                    out.println("<tr style='border-bottom: 1px solid #ddd;'><td>" + 
                            x.getNome() + "</td><td>" + x.getDescricao() 
                            + "</td><td>" + x.getLocal() + "</td><td>" 
                            + x.getData() + "</td><td>" 
                            + x.getRepertorio().getNome() 
                            + "</td><td>" + x.getValorDoIngresso()+"</td></tr>");
                }
            %>
                    </table>
                </div>
                <div class="form-front">
                    <form name="formulario" method="get" action="eventoadd.jsp">
                        <input class="btn btn-lg btn-primary btn-block" type="Submit" name="botaoCriEve" value="Adicionar Evento">
                    </form>
                    <form name="formulario" method="get" action="index.jsp">
                        <input class="btn btn-lg btn-primary btn-block" type="Submit" name="botaoEdiEve" value="Editar Evento" disabled>
                    </form>
                    <form name="formulario" method="get" action="index.jsp">
                        <input class="btn btn-lg btn-primary btn-block" type="Submit" name="botaoDelEve" value="Deletar Evento" disabled>
                    </form>
                    <form action="Controller" method="POST">
                        <input type="hidden" name="action" value="logoff"/>
                        <input class="btn btn-lg btn-primary btn-block" type="Submit" name="botaoSair" value="Sair">
                    </form>
                </div>
            </article>
            <footer>
            </footer>
        </div>
    </body>
</html>