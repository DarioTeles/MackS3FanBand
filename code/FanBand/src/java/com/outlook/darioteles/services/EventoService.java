
package com.outlook.darioteles.services;

import java.util.List;
import com.outlook.darioteles.dao.BandaDao;
import com.outlook.darioteles.dao.EventoDao;
import com.outlook.darioteles.entidades.Banda;
import com.outlook.darioteles.entidades.ConexaoJavaDb;
import com.outlook.darioteles.entidades.Evento;
import com.outlook.darioteles.interfaces.BandaDaoInterface;
import com.outlook.darioteles.interfaces.ConexaoInterface;
import com.outlook.darioteles.interfaces.EventoDaoInterface;
import com.outlook.darioteles.parameters.bdParameters;

/**
 * @author Dário Teles de Oliveira TIA: 41582391
 * 
 * Descreve as regras de negócio da entidade Evento.
 */
public class EventoService 
{
    private final String USUARIO = bdParameters.USUARIO;
    private final String SENHA = bdParameters.SENHA;
    private final String HOSTNAME = bdParameters.HOSTNAME;
    private final int PORTA = bdParameters.PORTA;
    private final String BASE_DE_DADOS = bdParameters.BASE_DE_DADOS;
    
    /**
     * Cadastra um novo evento.
     * @param banda
     * @param novo
     * @return evento
     */
    public Evento cadastroEventoService(Banda banda, Evento novo) 
    {
        ConexaoInterface conexao = new ConexaoJavaDb(USUARIO, SENHA, HOSTNAME, 
                PORTA, BASE_DE_DADOS);
        EventoDaoInterface daoEvento = new EventoDao(conexao);
        BandaDaoInterface daoBanda = new BandaDao(conexao);
        daoEvento.adicionarEvento(novo);
        List<Evento> eventos = daoEvento.listarTudo();
        for (Evento x : eventos) 
        {
            if (novo.getNome().equalsIgnoreCase(x.getNome())) 
            {
                daoBanda.adicionarEvento(banda, x);
                return x;
            }
        }
        return null;
    }
    
    /**
     * Verifica se um evento existe.
     * @param evento
     * @return evento
     */
    public Evento verificarEvento(Evento evento)
    {
        ConexaoInterface conexao = new ConexaoJavaDb(USUARIO, SENHA, HOSTNAME, 
                PORTA, BASE_DE_DADOS);
        EventoDaoInterface daoEvento = new EventoDao(conexao);
        List<Evento> eventos = daoEvento.listarTudo();
        for (Evento x : eventos)
        {
           if(evento.getNome().equalsIgnoreCase(x.getNome()))
                return x;
        }
        return null;
    }
    
    /**
     * Lista os eventos de uma determinada banda.
     * @param codigo
     * @return eventos
     */
    public List<Evento> listarPorBanda(int codigo)
    {
        EventoDaoInterface daoEvento = new EventoDao(new ConexaoJavaDb(USUARIO, 
                SENHA, HOSTNAME, PORTA, BASE_DE_DADOS));
        List<Evento> eventos = daoEvento.listarPorBanda(codigo);
        return eventos;
    }
}