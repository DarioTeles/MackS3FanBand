
package com.outlook.darioteles.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.outlook.darioteles.entidades.Banda;
import com.outlook.darioteles.entidades.ConexaoJavaDb;
import com.outlook.darioteles.entidades.Evento;
import com.outlook.darioteles.entidades.Repertorio;
import com.outlook.darioteles.interfaces.BandaDaoInterface;
import com.outlook.darioteles.interfaces.ConexaoInterface;
import com.outlook.darioteles.interfaces.EventoDaoInterface;
import com.outlook.darioteles.interfaces.RepertorioDaoInterface;
import com.outlook.darioteles.parameters.bdParameters;

/**
 *
 * @author Dário Teles de Oliveira TIA: 41582391
 * 
 * Define o DAO da entidade Banda.
 */
public class BandaDao implements BandaDaoInterface 
{
    private ConexaoInterface conexao;
    private final String USUARIO = bdParameters.USUARIO;
    private final String SENHA = bdParameters.SENHA;
    private final String HOSTNAME = bdParameters.HOSTNAME;
    private final int PORTA = bdParameters.PORTA;
    private final String BASE_DE_DADOS = bdParameters.BASE_DE_DADOS;
    
    //Construtor sem parâmetros
    public BandaDao() {}
    
    /**
     * Constrói um DAO da entidade Banda.
     * @param conexao 
     */
    public BandaDao(ConexaoInterface conexao) 
    {
        this.conexao = conexao;
    }
    
    /**
     * Retorna a consulta de todas as bandas registradas no banco de dados.
     * @return bandas
     */
    @Override
    public List<Banda> listarTudo() 
    {
        List<Banda> bandas = new ArrayList<>();
        try 
        {         
            Connection conectado = conexao.getConnection();
            Statement st = conectado.createStatement();
            String sql = "SELECT * FROM banda";
            ResultSet resultados = st.executeQuery(sql);
            while (resultados.next()) 
            {
                RepertorioDaoInterface buscar = new RepertorioDao(
                        new ConexaoJavaDb(USUARIO, SENHA, HOSTNAME, PORTA, 
                                BASE_DE_DADOS));
                List<Repertorio> repertorios = buscar.listarPorBanda(
                        resultados.getInt("cod_ban"));
                List<Evento> eventos = new ArrayList<>();

                //Instânciar a banda e adicioná-la a lista de bandas.
                Banda x = new Banda(
                        resultados.getString("email"),
                        resultados.getString("pass"),
                        resultados.getString("nick"),
                        resultados.getInt("cod_ban"),
                        resultados.getString("nom_ban"),
                        resultados.getString("gen"),
                        resultados.getString("descr"),
                        resultados.getString("tel"),
                        repertorios,
                        eventos);
                bandas.add(x);
            }
        } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return bandas;
    }
    
    /**
     * Inseri uma nova banda ao banco de dados.
     * @param nova 
     */
    @Override
    public void adicionarBanda(Banda nova) 
    {
        try 
        {
            Connection conectado = conexao.getConnection();
            String sql = "INSERT INTO banda (nick, email, pass, nom_ban, gen, "
                    + "descr, tel)  VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pstmt = conectado.prepareStatement(sql);
            pstmt.setString(1, nova.getApelido());
            pstmt.setString(2, nova.getEmail());
            pstmt.setString(3, nova.getSenha());
            pstmt.setString(4, nova.getNome());
            pstmt.setString(5, nova.getGenero());
            pstmt.setString(6, nova.getDescricao());
            pstmt.setString(7, nova.getContato());
            pstmt.executeUpdate();  
        } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
    }
    
    /**
     * Inseri um novo registro na tabela de relacionamento banda_evento. 
     * @param banda
     * @param evento 
     */
    @Override
    public void adicionarEvento(Banda banda, Evento evento)
    {
        try 
        {
            Connection conectado = conexao.getConnection();
            String sql = "INSERT INTO banda_evento (cod_ban, cod_eve) "
                    + "VALUES(?,?)";
            PreparedStatement pstmt = conectado.prepareStatement(sql);
            pstmt.setInt(1, banda.getCodigo());
            pstmt.setInt(2, evento.getCodigo());
            pstmt.executeUpdate();
        } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
    }
    
    /**
     * Inseri um novo registro na tabela de relacionamento banda_repertorio. 
     * @param banda
     * @param repertorio 
     */
    @Override
    public void adicionarRepertorio(Banda banda, Repertorio repertorio)
    {
        try {
            Connection conectado = conexao.getConnection();
            String sql = "INSERT INTO banda_repertorio (cod_ban, cod_rep) "
                    + "VALUES(?,?)";
            PreparedStatement pstmt = conectado.prepareStatement(sql);
            pstmt.setInt(1, banda.getCodigo());
            pstmt.setInt(2, repertorio.getCodigo());
            pstmt.executeUpdate();
        } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
    }
    
    /**
     * Retorna a consulta de um registro de banda 
     * a partir de um determinado código.
     * @param codigo
     * @return banda
     */
    @Override
    public Banda pesquisarBanda(int codigo) 
    {
        Banda banda = null;
        try 
        {
            Connection conectado = conexao.getConnection();
            Statement st = conectado.createStatement();
            String sql = "SELECT * FROM banda WHERE cod_ban=" + codigo;
            ResultSet resultados = st.executeQuery(sql);
            while (resultados.next()) {
                RepertorioDaoInterface buscar = new RepertorioDao(
                        new ConexaoJavaDb(USUARIO, SENHA, HOSTNAME, PORTA, 
                                BASE_DE_DADOS));
                List<Repertorio> repertorios = buscar.listarPorBanda(
                        resultados.getInt("cod_ban"));  
                EventoDaoInterface buscar1 = new EventoDao(
                        new ConexaoJavaDb(USUARIO, SENHA, HOSTNAME, PORTA, 
                                BASE_DE_DADOS));
                List<Evento> eventos = buscar1.listarPorBanda(
                        resultados.getInt("cod_ban")); 
                banda = new Banda(
                        resultados.getString("email"),
                        resultados.getString("pass"),
                        resultados.getString("nick"),
                        resultados.getInt("cod_ban"),
                        resultados.getString("nom_ban"),
                        resultados.getString("gen"),
                        resultados.getString("descr"),
                        resultados.getString("tel"),
                        repertorios,
                        eventos);
            }
        } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return banda;
    }
}