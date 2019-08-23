
package com.outlook.darioteles.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.outlook.darioteles.entidades.ConexaoJavaDb;
import com.outlook.darioteles.entidades.Evento;
import com.outlook.darioteles.entidades.Repertorio;
import com.outlook.darioteles.interfaces.ConexaoInterface;
import com.outlook.darioteles.interfaces.EventoDaoInterface;
import com.outlook.darioteles.interfaces.RepertorioDaoInterface;
import com.outlook.darioteles.parameters.bdParameters;

/**
 *
 * @author Dário Teles de Oliveira TIA: 41582391
 * 
 * Define o DAO da entidade Evento.
 */
public class EventoDao implements EventoDaoInterface
{
    private ConexaoInterface conexao;
    private final String USUARIO = bdParameters.USUARIO;
    private final String SENHA = bdParameters.SENHA;
    private final String HOSTNAME = bdParameters.HOSTNAME;
    private final int PORTA = bdParameters.PORTA;
    private final String BASE_DE_DADOS = bdParameters.BASE_DE_DADOS;

    //Construtor sem parâmetros
    public EventoDao() {}

    /**
     * Constrói um DAO da entidade Evento.
     * @param conexao 
     */
    public EventoDao(ConexaoInterface conexao) 
    {
        this.conexao = conexao;
    }

    /**
     * Retorna a consulta de todas os eventos registrados no banco de dados.
     * @return eventos
     */
    @Override
    public List<Evento> listarTudo() 
    {
        List<Evento> eventos = new ArrayList<>();
        try {
            Connection conectado = conexao.getConnection();
            Statement st = conectado.createStatement();
            String sql = "SELECT * FROM evento";
            ResultSet resultados = st.executeQuery(sql);
            while (resultados.next()) 
            {
                //Instânciar a banda e adicioná-la a lista de bandas
                //Verificar o campo repertorio
                RepertorioDaoInterface daoRepertorio = new RepertorioDao(
                        new ConexaoJavaDb(USUARIO, SENHA, HOSTNAME, PORTA, 
                                BASE_DE_DADOS));   
                Repertorio repertorioEncontrado = 
                        daoRepertorio.pesquisarRepertorio(
                                resultados.getInt("rep"));
                Evento x = new Evento(
                        resultados.getInt("cod_eve"),
                        resultados.getString("nom_eve"),
                        resultados.getString("descr"),
                        resultados.getString("loc"),
                        resultados.getDate("dta"),
                        repertorioEncontrado,
                        resultados.getFloat("val_ing"));
                eventos.add(x);
            }
        } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return eventos;
    }

    /**
     * Inseri um novo registro de evento no banco de dados.
     * @param novo 
     */
    @Override
    public void adicionarEvento(Evento novo) 
    {
        try {
            Connection conectado = conexao.getConnection();
            String sql = "INSERT INTO evento (nom_eve, descr, loc, dta, "
                    + "rep, val_ing)  VALUES(?,?,?,?,?,?)";
            PreparedStatement pstmt = conectado.prepareStatement(sql);
            pstmt.setString(1, novo.getNome());
            pstmt.setString(2, novo.getDescricao());
            pstmt.setString(3, novo.getLocal());
            //Futuramente ajustar
            //String data = novo.getData().getYear() + "-" + 
            //novo.getData().getMonth() + "-" + novo.getData().getDay();
            //pstmt.setString(5, data);
            pstmt.setDate(4, new java.sql.Date(novo.getData().getTime()));
            pstmt.setInt(5, novo.getRepertorio().getCodigo());
            pstmt.setFloat(6, (float) novo.getValorDoIngresso());
            pstmt.executeUpdate();
        } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
    }
    
    /**
     * Retorna a consulta de um registro de evento 
     * a partir de um determinado código.
     * @param codigo
     * @return evento
     */
    @Override
    public Evento pesquisarEvento(int codigo) 
    {
        Evento evento = null;
        try {
            Connection conectado = conexao.getConnection();
            Statement st = conectado.createStatement();
            String sql = "SELECT * FROM evento WHERE cod_eve=" + codigo;
            ResultSet resultados = st.executeQuery(sql);
            while (resultados.next()) 
            {
                RepertorioDaoInterface daoRepertorio = new RepertorioDao(
                        new ConexaoJavaDb(USUARIO, SENHA, HOSTNAME, PORTA, 
                                BASE_DE_DADOS));   
                Repertorio repertorioEncontrado = 
                        daoRepertorio.pesquisarRepertorio(
                                resultados.getInt("rep"));
                //Verificar o campo repertorio
                evento = new Evento(
                        resultados.getInt("cod_eve"),
                        resultados.getString("nom_eve"),
                        resultados.getString("descr"),
                        resultados.getString("loc"),
                        resultados.getDate("dta"),
                        repertorioEncontrado,
                        resultados.getFloat("val_ing"));
            }
        } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return evento;
    }
    
    /**
     * Retorna uma lista com os registros de eventos apartir de um código 
     * de banda.
     * @param codigoBanda
     * @return eventos
     */
    @Override
    public List<Evento> listarPorBanda(int codigoBanda)
    {
        List<Evento> eventos = new ArrayList<>();
        try {
            Connection conectado = conexao.getConnection();
            Statement st = conectado.createStatement();
            String sql = "SELECT e.* FROM banda b, banda_evento be, evento e "
                    + "WHERE b.cod_ban = be.cod_ban AND e.cod_eve = be.cod_eve "
                    + "AND b.cod_ban =" + codigoBanda;
            ResultSet resultados = st.executeQuery(sql);
            while (resultados.next()) 
            {
                RepertorioDaoInterface daoRepertorio = new RepertorioDao(
                        new ConexaoJavaDb(USUARIO, SENHA, HOSTNAME, PORTA, 
                                BASE_DE_DADOS));
                Repertorio repertorioEncontrado = 
                        daoRepertorio.pesquisarRepertorio(
                                resultados.getInt("rep"));    
                //Instânciar a banda e adicioná-la a lista de bandas
                //Verificar o campo repertorio
                Evento x = new Evento(
                        resultados.getInt("cod_eve"),
                        resultados.getString("nom_eve"),
                        resultados.getString("descr"),
                        resultados.getString("loc"),
                        resultados.getDate("dta"),
                        repertorioEncontrado,
                        resultados.getFloat("val_ing"));
                eventos.add(x);
            }
        } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return eventos;
    }
}