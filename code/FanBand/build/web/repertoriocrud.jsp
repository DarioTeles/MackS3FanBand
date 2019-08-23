<!-- 
    Document   : repertoriocrud.jsp
    Created on : 15/11/2016
    Author     : Dário Teles de Oliveira

    Página responsável por apresentar a lista de repertórios da banda, a opção 
de você vizualizar os detalhes do repertório ou adicionar um novo repertório.
        -Action "musicaGerenciar" no qual direciona para musicacrud.jsp;
        -Action repertorioadd.jsp;
        -Action "logoff" no qual direciona para página inicial do sistema.
-->
<%@page import="com.outlook.darioteles.entidades.Repertorio"%>
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
                <h1> Gerencie os seus repertórios: </h1>
            </header>
            <article>
                <div style="overflow-x:auto;">
                    <form action="Controller" method="POST" style="display: inline-block; position: relative;text-align: left">
                        <table>
                            <tr>
                                <td>Nome: </td>
                                <td>Descrição: </td>
                            </tr>
            <%
                List<Repertorio> repertorios = (List<Repertorio>) 
                        session.getAttribute("repertorios");
                int codigo = 0;
                for (Repertorio x : repertorios) {
                    out.println("<tr style='border-bottom: 1px solid #ddd;'>"
                            + "<td>" + x.getNome() + "  </td>"
                                    + "<td>" + x.getDescricao()+ "</td>");
                    codigo = x.getCodigo();
            %>
                            
                                <td>
                                    <input style="margin-bottom:0px;" class="btn btn-lg btn-primary btn-block" type="Submit" name="repertorio" value="<%= codigo%>">
                                </td>
            <%
                out.println("</tr>");
                }
            %>              
                            <input type="hidden" name="banda" value="<%= session.getAttribute("banda")%>"/>
                            <input type="hidden" name="action" value="musicaGerenciar"/>
                        </table>
                    </form>
                </div>
                <div class="form-front">
                    <form name="formulario" method="get" action="repertorioadd.jsp">
                        <input class="btn btn-lg btn-primary btn-block" type="Submit" name="botaoCriRep" value="Adicionar Repertório">
                    </form>
                    <form name="formulario" method="get" action="index.jsp">
                        <input class="btn btn-lg btn-primary btn-block" type="Submit" name="botaoEdiRep" value="Editar Repertório" disabled>
                    </form> 
                    <form name="formulario" method="get" action="index.jsp">
                        <input class="btn btn-lg btn-primary btn-block" type="Submit" name="botaoDelRep" value="Deletar Repertório" disabled>
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