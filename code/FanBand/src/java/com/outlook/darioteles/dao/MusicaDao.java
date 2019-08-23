
package com.outlook.darioteles.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.outlook.darioteles.entidades.Musica;
import com.outlook.darioteles.interfaces.ConexaoInterface;
import com.outlook.darioteles.interfaces.MusicaDaoInterface;

/**
 *
 * @author Dário Teles de Oliveira TIA: 41582391
 * 
 * Define o DAO da entidade Musica.
 */
public class MusicaDao implements MusicaDaoInterface 
{
    private ConexaoInterface conexao;
    
    //Construtor sem parâmetros
    public MusicaDao(){}
    
    /**
     * Constrói um DAO da entidade Musica.
     * @param conexao 
     */
    public MusicaDao(ConexaoInterface conexao) 
    {
        this.conexao = conexao;
    }
    
    /**
     * Retorna a consulta de todas as musicas registradas no banco de dados.
     * @return musicas
     */
    @Override
    public List<Musica> listarTudo() 
    {
        List<Musica> musicas = new ArrayList<>();
        try 
        {
            Connection conectado = conexao.getConnection();
            Statement st = conectado.createStatement();
            String sql = "SELECT * FROM musica";
            ResultSet resultados = st.executeQuery(sql);
            while (resultados.next()) 
            {
                //Instânciar a musica e adicioná-la a lista de musicas
                Musica x = new Musica(
                        resultados.getInt("cod_mus"),
                        resultados.getString("nom_mus"),
                        resultados.getString("comp"),
                        resultados.getString("gen"),
                        resultados.getInt("cont"));
                musicas.add(x);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return musicas;
    }
    
    /**
     * Inseri um novo registro de musica no banco de dados.
     * @param nova 
     */
    @Override
    public void adicionarMusica(Musica nova) 
    {
        try 
        {
            Connection conectado = conexao.getConnection();
            String sql = "INSERT INTO musica (nom_mus, comp, gen, cont)  VALUES(?,?,?,?)";
            PreparedStatement pstmt = conectado.prepareStatement(sql);
            pstmt.setString(1, nova.getNome());
            pstmt.setString(2, nova.getCompositor());
            pstmt.setString(3, nova.getGenero());
            pstmt.setInt(4, nova.getContador());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Retorna a consulta de um registro de musica 
     * a partir de um determinado código.
     * @param codigo
     * @return musica
     */
    @Override
    public Musica pesquisarMusica(int codigo) 
    {
        Musica musica = null;
        try 
        {
            Connection conectado = conexao.getConnection();
            Statement st = conectado.createStatement();
            String sql = "SELECT * FROM musica WHERE cod_mus=" + codigo;
            ResultSet resultados = st.executeQuery(sql);
            while (resultados.next()) 
            {
                musica = new Musica(
                        resultados.getInt("cod_mus"),
                        resultados.getString("nom_mus"),
                        resultados.getString("comp"),
                        resultados.getString("gen"),
                        resultados.getInt("cont"));
            }
        } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return musica;
    }
    
    /**
     * Retorna uma lista com os registros de musicas apartir de um código 
     * de repertorio.
     * @param codigoRepertorio
     * @return eventos
     */
    @Override
    public List<Musica> listarPorRepertorio(int codigoRepertorio) 
    {
        List<Musica> musicas = new ArrayList<>();
        try 
        {
            Connection conectado = conexao.getConnection();
            Statement st = conectado.createStatement();
            String sql = "SELECT m.* FROM repertorio r, repertorio_musica rm, musica m WHERE r.cod_rep = rm.cod_rep AND m.cod_mus = rm.cod_mus AND r.cod_rep =" + codigoRepertorio + "ORDER BY m.cont DESC";
            ResultSet resultados = st.executeQuery(sql);
            while (resultados.next()) 
            {
                //Instânciar a banda e adicioná-la a lista de musicas
                Musica x = new Musica(
                        resultados.getInt("cod_mus"),
                        resultados.getString("nom_mus"),
                        resultados.getString("comp"),
                        resultados.getString("gen"),
                        resultados.getInt("cont"));
                musicas.add(x);
            }
        } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return musicas;
    }
    
    /**
     * Altera o contador de votos de musica.
     * @param codigo
     * @param contador 
     */
    @Override
    public void atualizarContador(int codigo, int contador) 
    {
        try 
        {
            Connection conectado = conexao.getConnection();
            String sql = "UPDATE musica SET cont = ? WHERE cod_mus = ?";
            PreparedStatement pstmt = conectado.prepareStatement(sql);
            pstmt.setInt(1, contador);
            pstmt.setInt(2, codigo);
            pstmt.executeUpdate();
        } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
    }
    
    /**
     * Apagar um registo de uma música no banco de dados (Em andamento).
     * @param id 
     */
    @Override
    public void apagar(int id) 
    {
        List<Musica> listamusica = new ArrayList<>();
        listamusica = listarTudo();
        boolean existe = false;
        for (Musica m : listamusica) 
        {
            if (m.getCodigo() == id) 
            {
                existe = true;
            }
        }
        if (existe == true) 
        {
            try 
            {
                Connection conectado = conexao.getConnection();
                String sql = "DELETE * FROM musica WHERE cod_mus = ?";
                PreparedStatement pstmt = conectado.prepareStatement(sql);
                pstmt.setInt(1,id);
                pstmt.executeUpdate();
                System.out.println("Musica excluida!");
            } catch (SQLException ex) 
            {
                System.out.println("Erro ao tentar excluir musica.");
            }
        }
    }
}
