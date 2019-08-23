<!-- 
    Document   : musicacrud.jsp
    Created on : 15/11/2016
    Author     : Dário Teles de Oliveira

    Página responsável por apresentar a lista de musicas de um determinado 
repertorio e a opção de adicionar uma nova música no repertorio.
        -Action musicaadd.jsp;
        -Action "logoff" no qual direciona para página inicial do sistema.
-->
<%@page import="com.outlook.darioteles.entidades.Repertorio"%>
<%@page import="com.outlook.darioteles.entidades.Musica"%>
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
    <body class="text-center">
        <div class="form-front" style="max-width: 600px;">
        <header>
            <% Repertorio repertorio = (Repertorio) 
                    session.getAttribute("repertorio");%>
            <h1>Gerencie as musicas do repertório <%= repertorio.getNome()%>:</h1>
        </header>
        <article>
            <div style="overflow-x:auto;">
                <table style="display: inline-block; position: relative;text-align: left">
                    <tr>
                        <td>Nome: </td>
                        <td>Compositor:</td>
                        <td>Gênero: </td>
                    </tr>
            <%
                List<Musica> musicas = (List<Musica>) 
                        session.getAttribute("musicas");
                for (Musica x : musicas) {
                    out.println("<tr style='border-bottom: 1px solid #ddd;'><td>" + x.getNome() + "</td><td>" 
                            + x.getCompositor()+ "</td><td>" 
                            + x.getGenero()+ "</td></tr>");
                }
            %>
                </table>
            </div>
            <div class="form-front">
                <form name="formulario" method="get" action="musicaadd.jsp">
                    <input class="btn btn-lg btn-primary btn-block" type="Submit" name="botaoAddMus" value="Adicionar Musica">
                </form>
                <form name="formulario" method="get" action="index.jsp">
                    <input class="btn btn-lg btn-primary btn-block" type="Submit" name="botaoEdiMus" value="Editar Música" disabled>
                </form> 
                <form name="formulario" method="get" action="index.jsp">
                    <input class="btn btn-lg btn-primary btn-block" type="Submit" name="botaoDelMus" value="Deletar Música" disabled>
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