
package com.outlook.darioteles.entidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import com.outlook.darioteles.interfaces.ConexaoInterface;

/**
 *
 * @author Dário Teles de Oliveira TIA: 41582391
 * 
 * Define uma conexão ao banco de dados JavaDb.
 */
public class ConexaoJavaDb implements ConexaoInterface 
{
    private String usuario;
    private String senha;
    private String hostname;
    private int porta;
    private String baseDeDados;
    private Connection conexao = null;
    
    //Método constutor sem parâmetros.
    public ConexaoJavaDb() {}
    
    /**
     * Constrói uma conexão ao bando de dados JavaDb.
     * @param usuario
     * @param senha
     * @param hostname
     * @param porta
     * @param baseDeDados 
     */
    public ConexaoJavaDb(String usuario, String senha, String hostname, 
            int porta, String baseDeDados) 
    {
        this.usuario = usuario;
        this.senha = senha;
        this.hostname = hostname;
        this.porta = porta;
        this.baseDeDados = baseDeDados;      
    }
    
    /**
     * Método que inicia a conexão.
     * @return conexao
     */
    @Override
    public Connection getConnection() 
    {
        if (conexao == null) 
        {
            try 
            {                
                Class.forName("org.apache.derby.jdbc.ClientDriver");
                String url = "jdbc:derby://" + hostname + ":" + porta + "/" + baseDeDados;
                conexao = DriverManager.getConnection(url, usuario, senha);
            } catch (Exception ex) {}
        }else{
            
        }
        return conexao;
    }
    
    /**
     * Método que fecha a conexão.
     */
    @Override
    public void close() 
    {
        try 
        {
            conexao.close();
        } catch (SQLException ex) {}
        conexao = null;
    }
}
