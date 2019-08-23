
package com.outlook.darioteles.services;

import java.util.List;
import com.outlook.darioteles.dao.BandaDao;
import com.outlook.darioteles.dao.FanDao;
import com.outlook.darioteles.entidades.Banda;
import com.outlook.darioteles.entidades.ConexaoJavaDb;
import com.outlook.darioteles.entidades.Fan;
import com.outlook.darioteles.interfaces.BandaDaoInterface;
import com.outlook.darioteles.interfaces.ConexaoInterface;
import com.outlook.darioteles.interfaces.FanDaoInterface;
import com.outlook.darioteles.parameters.bdParameters;

/**
 * @author Dário Teles de Oliveira TIA: 41582391
 * 
 * Descreve as regras de negócio para o login.
 */
public class loginService 
{    
    private final String USUARIO = bdParameters.USUARIO;
    private final String SENHA = bdParameters.SENHA;
    private final String HOSTNAME = bdParameters.HOSTNAME;
    private final int PORTA = bdParameters.PORTA;
    private final String BASE_DE_DADOS = bdParameters.BASE_DE_DADOS;
    
    /**
     * Valida o login de banda.
     * @param login
     * @param senha
     * @return banda
     */
    public Banda validaLoginBanda(String login, String senha){
        ConexaoInterface conexao = new ConexaoJavaDb(USUARIO, SENHA, HOSTNAME, 
                PORTA, BASE_DE_DADOS);
        BandaDaoInterface daoBanda = new BandaDao(conexao);
        List<Banda> bandas = daoBanda.listarTudo();
        for (Banda x : bandas) {
           if(login.equalsIgnoreCase(x.getEmail())&& senha.equalsIgnoreCase(
                   x.getSenha()))
           return x;
        }       
        return null;                   
    }
    
    /**
     * Valida o login de fan.
     * @param login
     * @param senha
     * @return fan
     */
    public Fan validaLoginFan(String login, String senha){
        ConexaoInterface conexao = new ConexaoJavaDb(USUARIO, SENHA, HOSTNAME, 
                PORTA, BASE_DE_DADOS);
        FanDaoInterface daoFan = new FanDao(conexao);
        List<Fan> fans = daoFan.listarTudo();
        for (Fan x : fans) {
           if(login.equalsIgnoreCase(x.getEmail())&& senha.equalsIgnoreCase(
                   x.getSenha()))
           return x;
        }       
        return null;                   
    }
}