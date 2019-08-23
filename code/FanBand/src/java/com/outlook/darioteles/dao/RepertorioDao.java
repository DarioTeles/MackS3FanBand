
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
import com.outlook.darioteles.entidades.Musica;
import com.outlook.darioteles.entidades.Repertorio;
import com.outlook.darioteles.interfaces.BandaDaoInterface;
import com.outlook.darioteles.interfaces.ConexaoInterface;
import com.outlook.darioteles.interfaces.MusicaDaoInterface;
import com.outlook.darioteles.interfaces.RepertorioDaoInterface;
import com.outlook.darioteles.parameters.bdParameters;

/**
 *
 * @author Dário Teles de Oliveira TIA: 41582391
 * 
 * Define o DAO da entidade Repertorio.
 */
public class RepertorioDao implements RepertorioDaoInterface 
{
    private ConexaoInterface conexao;
    private final String USUARIO = bdParameters.USUARIO;
    private final String SENHA = bdParameters.SENHA;
    private final String HOSTNAME = bdParameters.HOSTNAME;
    private final int PORTA = bdParameters.PORTA;
    private final String BASE_DE_DADOS = bdParameters.BASE_DE_DADOS;
    
    //Construtor sem parâmetros
    public RepertorioDao(){}

    /**
     * Constrói um DAO da entidade Repertorio.
     * @param conexao 
     */
    public RepertorioDao(ConexaoInterface conexao) 
    {
        this.conexao = conexao;
    }
    
    /**
     * Retorna a consulta de todas os repertorioS registrados no banco de dados.
     * @return repertorios
     */
    @Override
    public List<Repertorio> listarTudo() 
    {
        List<Repertorio> repertorios = new ArrayList<>();
        try 
        {
            Connection conectado = conexao.getConnection();
            Statement st = conectado.createStatement();
            String sql = "SELECT * FROM repertorio";
            ResultSet resultados = st.executeQuery(sql);
            while (resultados.next()) 
            {
                MusicaDaoInterface buscar = new MusicaDao(
                        new ConexaoJavaDb(USUARIO, SENHA, HOSTNAME, 
                                PORTA, BASE_DE_DADOS));
                List<Musica> musicas = buscar.listarPorRepertorio(
                        resultados.getInt("cod_rep"));
                /*Instânciar o repertorio e adicioná-lo a lista de repertorios*/
                BandaDaoInterface daoBanda = new BandaDao(
                        new ConexaoJavaDb(USUARIO, SENHA, HOSTNAME, 
                                PORTA, BASE_DE_DADOS));
                Banda bandaEncontrada = daoBanda.pesquisarBanda(
                        resultados.getInt("ban"));
                if (bandaEncontrada != null) 
                {
                    Repertorio x = new Repertorio(
                        resultados.getInt("cod_rep"),
                        resultados.getString("nom_rep"),
                        resultados.getString("descr"),
                        bandaEncontrada,
                        musicas);
                    repertorios.add(x);
                } 
            }
        } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return repertorios;
    }
    
    /**
     * Inseri um novo registro de repertorio no banco de dados.
     * @param novo 
     */
    @Override
    public void adicionarRepertorio(Repertorio novo) 
    {
        try 
        {
            Connection conectado = conexao.getConnection();
            String sql = "INSERT INTO repertorio (nom_rep, descr, ban)  "
                    + "VALUES(?,?,?)";
            PreparedStatement pstmt = conectado.prepareStatement(sql);
            pstmt.setString(1, novo.getNome());
            pstmt.setString(2, novo.getDescricao());
            pstmt.setInt(3, novo.getBanda().getCodigo());
            pstmt.executeUpdate();
        } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
    }
    
    /**
     * Inseri um novo registro de musica relacionado ao repertorio 
     * no banco de dados.
     * @param repertorio
     * @param musica
     */
    @Override
    public void adicionarMusica(Repertorio repertorio, Musica musica)
    {
        try 
        {
            Connection conectado = conexao.getConnection();
            String sql = "INSERT INTO repertorio_musica (cod_rep, cod_mus)  "
                    + "VALUES(?,?)";
            PreparedStatement pstmt = conectado.prepareStatement(sql);
            pstmt.setInt(1, repertorio.getCodigo());
            pstmt.setInt(2, musica.getCodigo());
            pstmt.executeUpdate();
        } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
    }
    
    /**
     * Retorna a consulta de um registro de repertorio 
     * a partir de um determinado código.
     * @param codigo
     * @return repertorio
     */
    @Override
    public Repertorio pesquisarRepertorio(int codigo) 
    {
        Repertorio repertorio = null;
        try 
        {
            Connection conectado = conexao.getConnection();
            Statement st = conectado.createStatement();
            String sql = "SELECT * FROM repertorio WHERE cod_rep=" + codigo;
            ResultSet resultados = st.executeQuery(sql);
            while (resultados.next()) 
            {
                MusicaDaoInterface buscar = new MusicaDao(
                        new ConexaoJavaDb(USUARIO, SENHA, HOSTNAME, 
                                PORTA, BASE_DE_DADOS));
                List<Musica> musicas = buscar.listarPorRepertorio(
                        resultados.getInt("cod_rep"));
                /*Instânciar a banda e adicioná-la a lista de bandas*/
                BandaDaoInterface daoBanda = new BandaDao(
                        new ConexaoJavaDb(USUARIO, SENHA, HOSTNAME, 
                                PORTA, BASE_DE_DADOS));                
                //Linha que está ocorrendo erro
                //Banda bandaEncontrada = daoBanda.pesquisarBanda(1);
                repertorio = new Repertorio(
                        resultados.getInt("cod_rep"),
                        resultados.getString("nom_rep"),
                        resultados.getString("descr"),
                        new Banda(),
                        musicas);
            }
        } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return repertorio;
    }
    
    /**
     * Retorna uma lista com os registros de repertorios apartir de um código 
     * de banda.
     * @param codigoBanda
     * @return eventos
     */
    @Override
    public List<Repertorio> listarPorBanda(int codigoBanda){
        List<Repertorio> repertorios = new ArrayList<>();
        try 
        {
            Connection conectado = conexao.getConnection();
            Statement st = conectado.createStatement();
            String sql = "SELECT r.* FROM banda b, banda_repertorio br, "
                    + "repertorio r WHERE b.cod_ban = br.cod_ban AND "
                    + "r.cod_rep = br.cod_rep AND b.cod_ban =" + codigoBanda;
            ResultSet resultados = st.executeQuery(sql);                                
            while (resultados.next()) 
            {
                MusicaDaoInterface buscar = new MusicaDao(
                        new ConexaoJavaDb(USUARIO, SENHA, HOSTNAME, PORTA, 
                                BASE_DE_DADOS));
                List<Musica> musicas = buscar.listarPorRepertorio(
                        resultados.getInt("cod_rep"));
                /*Instânciar a banda e adicioná-la a lista de bandas*/
                //BandaDaoInterface daoBanda = new BandaDao(
                //new ConexaoJavaDb(USUARIO, SENHA, HOSTNAME, PORTA, BASE_DE_DADOS));
                //Banda bandaEncontrada = daoBanda.pesquisarBanda(resultados.getInt("ban"));
                //if (bandaEncontrada != null) {
                    Repertorio x = new Repertorio(
                        resultados.getInt("cod_rep"),
                        resultados.getString("nom_rep"),
                        resultados.getString("descr"),
                        new Banda(),
                        musicas);

                    repertorios.add(x);
                //}
            }
        } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return repertorios;
    }
}