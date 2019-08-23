<%-- 
    Document   : musicavotar.jsp
    Created on : 15/11/2016,
    Author     : Dário Teles de Oliveira

    Página responsável por listar as músicas de um determinado repertório 
vinculado ao evento e a opção de votar nas músicas desejadas.
        -Action "votar" no qual direciona para fan.jsp;
        -fan.jsp.
--%>

<%@page import="com.outlook.darioteles.entidades.Musica"%>
<%@page import="java.util.List"%>
<%@page import="com.outlook.darioteles.entidades.Repertorio"%>
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
        <div class="form-front" style="max-width: 800px;">
            <header>
                <% Repertorio repertorio = (Repertorio) session.getAttribute("repertorio");%>
                <h1 class="h3 mb-3 font-weight-normal">Vote nas suas músicas favoritas do <%= repertorio.getNome()%>:</h1>
            </header>
            <article>
                <div style="overflow-x:auto;">
                    <form action="Controller" method="POST" style="display: inline-block; position: relative;text-align: left">
                        <table>
                            <tr>
                                <td>Nome: </td>
                                <td>Qtde. Votos: </td>
                            </tr>
            <%
                List<Musica> musicas = (List<Musica>) session.getAttribute("musicas");
                int codigo = 0;
                for (Musica x : musicas) {
                    out.println("<tr style='border-bottom: 1px solid #ddd;'><td>" + x.getNome() + "</td><td>" + x.getContador() + "</td>");
                    codigo = x.getCodigo();
            %>
                                <td>
                                     <input style="margin-bottom:0px;" class="btn btn-lg btn-primary btn-block" type="Submit" name="codigomusica" value="<%= codigo%>">
                                </td>                   
            <%
                out.println("</tr>");
                }
            %>
                        </table>
                        <input type="hidden" name="action" value="votar"/>
                    </form>
                </div>
                <div class="form-front">
                    <form action="fan.jsp" method="POST">
                        <input class="btn btn-lg btn-primary btn-block" type="Submit" name="botaoVoltar" value="Voltar">
                    </form>
                </div>
            </article>
            <footer>
            </footer>
        </div>
    </body>
</html>
