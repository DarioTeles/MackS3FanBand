<!-- 
    Document   : fan.jsp
    Created on : 15/11/2016
    Author     : Dário Teles de Oliveira

    Página responsável por listar os eventos do sistema e a opção de visualizar
os detalhes do evento.
        -Action "eventosDetalhes" no qual direciona para musicavotar.jsp;        
        -Action "logoff" no qual direciona para página inicial do sistema.
-->
<%@page import="com.outlook.darioteles.entidades.Evento"%>
<%@page import="java.util.List"%>
<%@page import="com.outlook.darioteles.entidades.Fan"%>
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
        <div class="form-front" style="max-width: 1000px;">
            <header>
                <h1>Seja bem-vindo <% Fan fan;
                    fan = (Fan) session.getAttribute("fan");
                    out.println(fan.getNome());
                    %></h1>
            </header>
            <article>
                <h1 class="h3 mb-3 font-weight-normal">Encontre o evento desejado e vote nas suas músicas preferidas:</h1>
                <div style="overflow-x:auto;">
                    <form action="Controller" method="POST" style="display: inline-block; position: relative;text-align: left">
                        <table >
                            <tr>
                                <td> Nome: </td>
                                <td> Descrição: </td>
                                <td> Local: </td>
                                <td> Data: </td>
                                <td> Repertorio: </td>
                                <td> Valor do Ingresso: </td>
                            </tr>
            <%
                List<Evento> eventos = (List<Evento>) session.getAttribute("eventos");
                int codigo = 0;
                for (Evento x : eventos) {
                    out.println("<tr style='border-bottom: 1px solid #ddd;'><td>" + x.getNome() + "</td><td>" + x.getDescricao() + "</td><td>" + x.getLocal() + "</td><td>" + x.getData() + "</td><td>" + x.getRepertorio().getNome() + "</td><td>" + x.getValorDoIngresso() + "</td>");
                    codigo = x.getRepertorio().getCodigo();
            %>
                                <td>
                                    <input style="margin-bottom:0px;" class="btn btn-lg btn-primary btn-block" type="Submit" name="codigorepertorio" value="<%= codigo%>" >
                                </td>
            
            <%
                out.println("</tr>");
                }
            %>
                        </table>
                        <input type="hidden" name="action" value="eventoDetalhes"/>
                        <!--<input type="hidden" name="codigorepertorio" value="<%= codigo%>">-->
                    </form> 
                </div>
                <div class="form-front">
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