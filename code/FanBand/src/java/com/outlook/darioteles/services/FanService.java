
package com.outlook.darioteles.services;

import java.util.List;
import com.outlook.darioteles.dao.EventoDao;
import com.outlook.darioteles.dao.FanDao;
import com.outlook.darioteles.dao.MusicaDao;
import com.outlook.darioteles.entidades.ConexaoJavaDb;
import com.outlook.darioteles.entidades.Evento;
import com.outlook.darioteles.entidades.Fan;
import com.outlook.darioteles.entidades.Musica;
import com.outlook.darioteles.interfaces.ConexaoInterface;
import com.outlook.darioteles.interfaces.EventoDaoInterface;
import com.outlook.darioteles.interfaces.FanDaoInterface;
import com.outlook.darioteles.interfaces.MusicaDaoInterface;
import com.outlook.darioteles.parameters.bdParameters;

/**
 * @author Dário Teles de Oliveira TIA: 41582391
 * 
 * Descreve as regras de negócio da entidade Fan.
 */
public class FanService 
{
    private final String USUARIO = bdParameters.USUARIO;
    private final String SENHA = bdParameters.SENHA;
    private final String HOSTNAME = bdParameters.HOSTNAME;
    private final int PORTA = bdParameters.PORTA;
    private final String BASE_DE_DADOS = bdParameters.BASE_DE_DADOS;
    
    /**
     * Cadastra um novo fan.
     * @param novo
     * @return fan
     */
    public Fan cadastroFanService(Fan novo)
    {
        ConexaoInterface conexao = new ConexaoJavaDb(USUARIO, SENHA, HOSTNAME, 
                PORTA, BASE_DE_DADOS);
        FanDaoInterface daoFan = new FanDao(conexao);
        daoFan.adicionarFan(novo);
        List<Fan> fans = daoFan.listarTudo();
        for (Fan x : fans) 
        {
           if(novo.getNome().equalsIgnoreCase(x.getNome()))
                return x;
        } 
        return null;
    }
    
    /**
     * Verifica se um fan existe.
     * @param fan
     * @return fan
     */
    public Fan verificarFan(Fan fan)
    {
        ConexaoInterface conexao = new ConexaoJavaDb(USUARIO, SENHA, HOSTNAME, 
                PORTA, BASE_DE_DADOS);
        FanDaoInterface daoFan = new FanDao(conexao);
        List<Fan> fans = daoFan.listarTudo();
        for (Fan x : fans) 
        {
           if(fan.getNome().equalsIgnoreCase(x.getNome()))
                return x;
        }
        return null;
    }
    
    /**
     * Lista todos os eventos.
     * @return eventos
     */
    public List<Evento> listarEventos()
    {
        ConexaoInterface conexao = new ConexaoJavaDb(USUARIO, SENHA, HOSTNAME, 
                PORTA, BASE_DE_DADOS);
        EventoDaoInterface daoEvento = new EventoDao(conexao);
        List<Evento> eventos = daoEvento.listarTudo();
        return eventos;
    }
    
    /**
     * Vota em uma musica.
     * @param codigo
     * @return boolean
     */
    public boolean votarMusica(int codigo)
    {
        ConexaoInterface conexao = new ConexaoJavaDb(USUARIO, SENHA, HOSTNAME, 
                PORTA, BASE_DE_DADOS);
        MusicaDaoInterface daoMusica = new MusicaDao(conexao);
        Musica musica = daoMusica.pesquisarMusica(codigo);
        daoMusica.atualizarContador(codigo, musica.getContador()+1);
        return true;
    }
}