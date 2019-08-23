package com.outlook.darioteles.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.outlook.darioteles.dao.RepertorioDao;
import com.outlook.darioteles.entidades.Banda;
import com.outlook.darioteles.entidades.ConexaoJavaDb;
import com.outlook.darioteles.entidades.Evento;
import com.outlook.darioteles.entidades.Fan;
import com.outlook.darioteles.entidades.Musica;
import com.outlook.darioteles.entidades.Repertorio;
import com.outlook.darioteles.interfaces.ConexaoInterface;
import com.outlook.darioteles.interfaces.EventoDaoInterface;
import com.outlook.darioteles.interfaces.RepertorioDaoInterface;
import com.outlook.darioteles.services.BandaService;
import com.outlook.darioteles.services.EventoService;
import com.outlook.darioteles.services.FanService;
import com.outlook.darioteles.services.MusicaService;
import com.outlook.darioteles.services.RepertorioService;
import com.outlook.darioteles.services.loginService;

/**
 *
 * @author Dário Teles de Oliveira TIA: 41582391
 * 
 * Define a classe Controller no qual herda comportamentos de HttpServlet.
 */
public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String action = request.getParameter("action");
        System.out.println("Action: " + action);
        if (action.equalsIgnoreCase("bandaLogin")) 
        {
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            loginService service = new loginService();
            if (service.validaLoginBanda(login, senha) != null) 
            {
                System.out.println("Login Valido");
                request.getSession().setAttribute("usuario", login);
                request.getSession().setAttribute("banda", 
                        service.validaLoginBanda(login, senha));
                RequestDispatcher disp = 
                        request.getRequestDispatcher("banda.jsp");
                disp.forward(request, response);

            } else 
            {
                System.out.println("Login Invalido");
                //direciona o usuario para a tela login
                RequestDispatcher disp = 
                        request.getRequestDispatcher("bandalogin.jsp");
                disp.forward(request, response);
            }
        } else if (action.equalsIgnoreCase("fanLogin")) 
        {
            String login = request.getParameter("login");
            String senha = request.getParameter("senha");
            loginService service = new loginService();
            if (service.validaLoginFan(login, senha) != null) 
            {
                System.out.println("Login Valido");
                request.getSession().setAttribute("usuario", login);
                request.getSession().setAttribute("fan", 
                        service.validaLoginFan(login, senha));
                FanService service2 = new FanService();
                request.getSession().setAttribute("eventos", 
                        service2.listarEventos());

                RequestDispatcher disp = 
                        request.getRequestDispatcher("fan.jsp");
                disp.forward(request, response);
            } else 
            {
                System.out.println("Login Invalido");
                RequestDispatcher disp = 
                        request.getRequestDispatcher("fanlogin.jsp");
                disp.forward(request, response);
            }
        } else if (action.equalsIgnoreCase("bandaCadastro")) 
        {
            BandaService service = new BandaService();
            String apelido = request.getParameter("apelido");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String nome = request.getParameter("nome");
            String genero = request.getParameter("genero");
            String descricao = request.getParameter("descricao");
            String contato = request.getParameter("contato");
            Banda banda = new Banda();
            banda.setApelido(apelido);
            banda.setEmail(email);
            banda.setSenha(senha);
            banda.setNome(nome);
            banda.setGenero(genero);
            banda.setDescricao(descricao);
            banda.setContato(contato);
            if (service.cadastroBandaService(banda) != null) 
            {
                System.out.println("Cadastro realizado com sucesso.");
                request.getSession().setAttribute("banda", 
                        service.verificarBanda(banda));
                RequestDispatcher disp = 
                        request.getRequestDispatcher("banda.jsp");
                disp.forward(request, response);
            } else 
            {
                System.out.println("Erro no cadastro.");
                RequestDispatcher disp = 
                        request.getRequestDispatcher("cadastrobanda.jsp");
                disp.forward(request, response);
            }
        } else if (action.equalsIgnoreCase("fanCadastro")) 
        {
            FanService service = new FanService();
            String apelido = request.getParameter("apelido");
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            String nome = request.getParameter("nome");
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String data1 = request.getParameter("datanascimento");
            System.out.println("Data HTML: " + data1);
            Date data2 = null;
            try 
            {
                data2 = formatter.parse(data1);
            } catch (ParseException ex) 
            {
                ex.printStackTrace();
            }
            Fan fan = new Fan();
            fan.setApelido(apelido);
            fan.setEmail(email);
            fan.setSenha(senha);
            fan.setNome(nome);
            fan.setDataNascimento(data2);
            if (service.cadastroFanService(fan) != null) 
            {
                System.out.println("Cadastro realizado com sucesso.");
                request.getSession().setAttribute("fan", service.verificarFan(fan));
                request.getSession().setAttribute("eventos", service.listarEventos());
                RequestDispatcher disp = request.getRequestDispatcher("fan.jsp");
                disp.forward(request, response);
            } else 
            {
                System.out.println("Erro no cadastro.");
                RequestDispatcher disp = 
                        request.getRequestDispatcher("fancadastro.jsp");
                disp.forward(request, response);
            }
        } else if (action.equalsIgnoreCase("eventoGerenciar")) 
        {
            EventoService service = new EventoService();
            Banda banda = (Banda) request.getSession().getAttribute("banda");
            List<Evento> eventos = service.listarPorBanda(banda.getCodigo());
            request.getSession().setAttribute("eventos", eventos);
            RequestDispatcher disp = 
                    request.getRequestDispatcher("eventocrud.jsp");
            disp.forward(request, response);
        } else if (action.equalsIgnoreCase("eventoAdd")) 
        {
            EventoService service = new EventoService();
            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");
            String local = request.getParameter("local");
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            String data1 = request.getParameter("data");
            System.out.println("Data HTML: " + data1);
            Date data2 = null;
            try 
            {
                data2 = formatter.parse(data1);
            } catch (ParseException ex) 
            {
                ex.printStackTrace();
            }
            System.out.println("Data formatado para Date" + data1);
            Integer repertorio = Integer.parseInt(request.getParameter("repertorio"));
            Float valordoingresso = Float.parseFloat(request.getParameter("valoringresso"));
            ConexaoInterface conexao = new ConexaoJavaDb("app", "123", 
                    "127.0.0.1", 1527, "bd_projeto");
            RepertorioDaoInterface daoRepertorio = new RepertorioDao(conexao);
            Evento evento = new Evento();
            evento.setNome(nome);
            evento.setDescricao(descricao);
            evento.setLocal(local);
            evento.setData(data2);
            evento.setRepertorio(daoRepertorio.pesquisarRepertorio(repertorio));
            evento.setValorDoIngresso(valordoingresso);
            Banda banda = (Banda) request.getSession().getAttribute("banda");
            System.out.println("Teste" + banda.getCodigo());
            if (service.cadastroEventoService(banda, evento) != null) 
            {
                RequestDispatcher disp = request.getRequestDispatcher("banda.jsp");
                disp.forward(request, response);
            } else 
            {
                System.out.println("Erro no cadastro.");
                RequestDispatcher disp = request.getRequestDispatcher("criarevento.jsp");
                disp.forward(request, response);
            }
        } else if (action.equalsIgnoreCase("repertorioGerenciar")) 
        {
            RepertorioService service = new RepertorioService();
            Banda banda = (Banda) request.getSession().getAttribute("banda");
            List<Repertorio> repertorios = service.listarPorBanda(banda.getCodigo());
            request.getSession().setAttribute("repertorios", repertorios);
            RequestDispatcher disp = request.getRequestDispatcher("repertoriocrud.jsp");
            disp.forward(request, response);
        } else if (action.equalsIgnoreCase("repertorioAdd")) 
        {
            RepertorioService service = new RepertorioService();
            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");
            ConexaoInterface conexao = new ConexaoJavaDb("app", "123", "127.0.0.1", 1527, "bd_projeto");
            RepertorioDaoInterface daoRepertorio = new RepertorioDao(conexao);
            Banda banda = (Banda) request.getSession().getAttribute("banda");
            Repertorio repertorio = new Repertorio();
            repertorio.setNome(nome);
            repertorio.setDescricao(descricao);
            repertorio.setBanda(banda);
            if (service.cadastroRepertorioService(banda, repertorio) != null) 
            {
                //request.getSession().setAttribute("evento", service.verificarEvento(evento));

                RequestDispatcher disp = request.getRequestDispatcher("banda.jsp");
                disp.forward(request, response);
            } else 
            {
                System.out.println("Erro no cadastro.");
                RequestDispatcher disp = request.getRequestDispatcher("repertorioadd.jsp");
                disp.forward(request, response);
            }
        } else if (action.equalsIgnoreCase("musicaGerenciar")) 
        {
            MusicaService service = new MusicaService();
            Integer codigoRepertorio = Integer.parseInt(request.getParameter("repertorio"));
            System.out.print(request.getParameter("repertorio"));
            List<Musica> musicas = service.listarPorRepertorio(codigoRepertorio);
            request.getSession().setAttribute("musicas", musicas);
            RepertorioService service2 = new RepertorioService();
            Repertorio repertorio = service2.pesquisarRepertorio(codigoRepertorio);
            request.getSession().setAttribute("repertorio", repertorio);
            RequestDispatcher disp = request.getRequestDispatcher("musicacrud.jsp");
            disp.forward(request, response);
        } else if (action.equalsIgnoreCase("musicaAdd")) 
        {
            MusicaService service = new MusicaService();
            String nome = request.getParameter("nome");
            String compositor = request.getParameter("compositor");
            String genero = request.getParameter("genero");
            Repertorio repertorio = (Repertorio) request.getSession().getAttribute("repertorio");
            Musica musica = new Musica();
            musica.setNome(nome);
            musica.setCompositor(compositor);
            musica.setGenero(genero);
            if (service.cadastroMusicaService(repertorio, musica) != null) 
            {
                RequestDispatcher disp = request.getRequestDispatcher("repertoriocrud.jsp");
                disp.forward(request, response);
            } else 
            {
                System.out.println("Erro no cadastro.");
                RequestDispatcher disp = request.getRequestDispatcher("criarrepertorio.jsp");
                disp.forward(request, response);
            }
        } else if (action.equalsIgnoreCase("eventoDetalhes")) 
        {
            MusicaService service = new MusicaService();
            Integer codigoRepertorio = Integer.parseInt(request.getParameter("codigorepertorio"));
            List<Musica> musicas = service.listarPorRepertorio(codigoRepertorio);
            request.getSession().setAttribute("musicas", musicas);
            RepertorioService service2 = new RepertorioService();
            Repertorio repertorio = service2.pesquisarRepertorio(codigoRepertorio);
            request.getSession().setAttribute("repertorio", repertorio);
            RequestDispatcher disp = request.getRequestDispatcher("musicavotar.jsp");
            disp.forward(request, response);
        } else if (action.equalsIgnoreCase("votar")) 
        {
            FanService service = new FanService();
            int codigo = Integer.parseInt(request.getParameter("codigomusica"));
            if (service.votarMusica(codigo)) {
                RequestDispatcher disp = request.getRequestDispatcher("fan.jsp");
                disp.forward(request, response);
            } else 
            {
                RequestDispatcher disp = request.getRequestDispatcher("musicavotar.jsp");
                disp.forward(request, response);
            }
        } else if (action.equalsIgnoreCase("Logoff")) 
        {
            request.getSession().invalidate();
            RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
            disp.forward(request, response);
        }
    }

    private EventoDaoInterface EventoDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private EventoDaoInterface RepertorioDao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
