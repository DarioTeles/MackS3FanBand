
package com.outlook.darioteles.services;

import java.util.List;
import com.outlook.darioteles.dao.BandaDao;
import com.outlook.darioteles.entidades.Banda;
import com.outlook.darioteles.entidades.ConexaoJavaDb;
import com.outlook.darioteles.interfaces.BandaDaoInterface;
import com.outlook.darioteles.interfaces.ConexaoInterface;
import com.outlook.darioteles.parameters.bdParameters;

/**
 * @author Dário Teles de Oliveira TIA: 41582391
 * 
 * Descreve as regras de negócio da entidade Banda.
 */
public class BandaService 
{    
    private final String USUARIO = bdParameters.USUARIO;
    private final String SENHA = bdParameters.SENHA;
    private final String HOSTNAME = bdParameters.HOSTNAME;
    private final int PORTA = bdParameters.PORTA;
    private final String BASE_DE_DADOS = bdParameters.BASE_DE_DADOS;
    
    /**
     * Cadastra uma nova banda.
     * @param nova
     * @return banda
     */
    public Banda cadastroBandaService(Banda nova)
    {
        ConexaoInterface conexao = new ConexaoJavaDb(USUARIO, SENHA, HOSTNAME, 
                PORTA, BASE_DE_DADOS);
        BandaDaoInterface daoBanda = new BandaDao(conexao);
        daoBanda.adicionarBanda(nova);
        List<Banda> bandas = daoBanda.listarTudo();
        for (Banda x : bandas) 
        {
           if(nova.getNome().equalsIgnoreCase(x.getNome()))
                return x;
        } 
        return null;
    }
    
    /**
     * Verifica se uma banda existe.
     * @param nova
     * @return banda
     */
    public Banda verificarBanda(Banda banda)
    {
        ConexaoInterface conexao = new ConexaoJavaDb(USUARIO, SENHA, HOSTNAME, 
                PORTA, BASE_DE_DADOS);
        BandaDaoInterface daoBanda = new BandaDao(conexao);
        List<Banda> bandas = daoBanda.listarTudo();
        for (Banda x : bandas) 
        {
           if(banda.getNome().equalsIgnoreCase(x.getNome()))
                return x;
        }
        return null;
    }
}