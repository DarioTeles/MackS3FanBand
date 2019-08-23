
package com.outlook.darioteles.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.outlook.darioteles.entidades.Fan;
import com.outlook.darioteles.interfaces.ConexaoInterface;
import com.outlook.darioteles.interfaces.FanDaoInterface;

/**
 *
 * @author Dário Teles de Oliveira TIA: 41582391
 * 
 * Define o DAO da entidade Fan.
 */
public class FanDao implements FanDaoInterface 
{
    private ConexaoInterface conexao;

    //Construtor sem parâmetros
    public FanDao(){}
    
    /**
     * Constrói um DAO da entidade Fan.
     * @param conexao 
     */
    public FanDao(ConexaoInterface conexao) 
    {
        this.conexao = conexao;
    }
    
    /**
     * Retorna a consulta de todas os fans registrados no banco de dados.
     * @return fans
     */
    @Override
    public List<Fan> listarTudo() 
    {
        List<Fan> fans = new ArrayList<>();
        try 
        {
            Connection conectado = conexao.getConnection();
            Statement st = conectado.createStatement();
            String sql = "SELECT * FROM fan";
            ResultSet resultados = st.executeQuery(sql);
            while (resultados.next()) 
            {
                //Instânciar o fan e adicioná-la a lista de fans
                Fan x = new Fan(
                        resultados.getString("email"),
                        resultados.getString("pass"),
                        resultados.getString("nick"),
                        resultados.getInt("cod_fan"),
                        resultados.getString("nom_fan"),
                        resultados.getDate("dta_nasc"));
                fans.add(x);
            }
        } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return fans;
    }
    
    /**
     * Inseri um novo registro de fan no banco de dados.
     * @param novo 
     */
    @Override
    public void adicionarFan(Fan novo) 
    {
        try 
        {
            Connection conectado = conexao.getConnection();
            String sql = "INSERT INTO fan (nick, email, pass, nom_fan, "
                    + "dta_nasc, ban_fav)  VALUES(?,?,?,?,?,?)";
            PreparedStatement pstmt = conectado.prepareStatement(sql);
            pstmt.setString(1, novo.getApelido());
            pstmt.setString(2, novo.getEmail());
            pstmt.setString(3, novo.getSenha());
            pstmt.setString(4, novo.getNome());
            pstmt.setDate(5, new java.sql.Date(novo.getDataNascimento().getTime()));
            pstmt.setString(6, null);
            pstmt.executeUpdate();
        } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
    }
    
    /**
     * Retorna a consulta de um registro de fan 
     * a partir de um determinado código.
     * @param codigo
     * @return fan
     */
    @Override
    public Fan pesquisarFan(int codigo) 
    {
        Fan fan = null;
        try 
        {
            Connection conectado = conexao.getConnection();
            Statement st = conectado.createStatement();
            String sql = "SELECT * FROM fan WHERE cod_fan=" + codigo;
            ResultSet resultados = st.executeQuery(sql);
            while (resultados.next()) 
            {
                fan = new Fan(
                        resultados.getString("email"),
                        resultados.getString("pass"),
                        resultados.getString("nick"),
                        resultados.getInt("cod_fan"),
                        resultados.getString("nom_fan"),
                        resultados.getDate("dta_nasc"));
            }
        } catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return fan;
    }
}
