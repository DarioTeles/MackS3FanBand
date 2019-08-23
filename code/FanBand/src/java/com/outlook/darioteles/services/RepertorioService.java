
package com.outlook.darioteles.services;

import java.util.List;
import com.outlook.darioteles.dao.BandaDao;
import com.outlook.darioteles.dao.RepertorioDao;
import com.outlook.darioteles.entidades.Banda;
import com.outlook.darioteles.entidades.ConexaoJavaDb;
import com.outlook.darioteles.entidades.Repertorio;
import com.outlook.darioteles.interfaces.BandaDaoInterface;
import com.outlook.darioteles.interfaces.ConexaoInterface;
import com.outlook.darioteles.interfaces.RepertorioDaoInterface;
import com.outlook.darioteles.parameters.bdParameters;

/**
 * @author Dário Teles de Oliveira TIA: 41582391
 * 
 * Descreve as regras de negócio da entidade Repertorio.
 */
public class RepertorioService 
{
    private final String USUARIO = bdParameters.USUARIO;
    private final String SENHA = bdParameters.SENHA;
    private final String HOSTNAME = bdParameters.HOSTNAME;
    private final int PORTA = bdParameters.PORTA;
    private final String BASE_DE_DADOS = bdParameters.BASE_DE_DADOS;
    
    /**
     * Cadastra um novo repertório
     * @param banda
     * @param novo
     * @return repertorio
     */
    public Repertorio cadastroRepertorioService(Banda banda, Repertorio novo) 
    {
        ConexaoInterface conexao = new ConexaoJavaDb(USUARIO, SENHA, HOSTNAME, 
                PORTA, BASE_DE_DADOS);
        RepertorioDaoInterface daoRepertorio = new RepertorioDao(conexao);
        BandaDaoInterface daoBanda = new BandaDao(conexao);
        daoRepertorio.adicionarRepertorio(novo);
        List<Repertorio> repertorios = daoRepertorio.listarTudo();
        for (Repertorio x : repertorios) 
        {
            if (novo.getNome().equalsIgnoreCase(x.getNome())) 
            {
                daoBanda.adicionarRepertorio(banda, x);
                return x;
            }
        }
        return null;
    }
    
    /**
     * Verifica se um repertório existe.
     * @param novo
     * @return repertorio
     */
    public Repertorio verificarRepertorio(Repertorio novo)
    {
        ConexaoInterface conexao = new ConexaoJavaDb(USUARIO, SENHA, HOSTNAME, 
                PORTA, BASE_DE_DADOS);
        RepertorioDaoInterface daoRepertorio = new RepertorioDao(conexao);
        List<Repertorio> repertorios = daoRepertorio.listarTudo();
        for (Repertorio x : repertorios) 
        {
           if(novo.getNome().equalsIgnoreCase(x.getNome()))
                return x;
        }
        return null;
    }
    
    /**
     * Lista todos os repertorios de uma banda.
     * @param codigo
     * @return repertorios
     */
    public List<Repertorio> listarPorBanda(int codigo)
    {
        RepertorioDaoInterface daoRepertorio = new RepertorioDao(
                new ConexaoJavaDb(USUARIO, SENHA, HOSTNAME,PORTA, 
                        BASE_DE_DADOS));
        List<Repertorio> repertorios = daoRepertorio.listarPorBanda(codigo);
        return repertorios;
    }
    
    /**
     * Pesquisa um repertório pelo código.
     * @param codigo
     * @return repertorio
     */
    public Repertorio pesquisarRepertorio(int codigo)
    {
        RepertorioDaoInterface daoRepertorio = new RepertorioDao(
                new ConexaoJavaDb(USUARIO, SENHA, HOSTNAME,PORTA, 
                        BASE_DE_DADOS));
        Repertorio repertorio = daoRepertorio.pesquisarRepertorio(codigo);
        return repertorio;
    }
}