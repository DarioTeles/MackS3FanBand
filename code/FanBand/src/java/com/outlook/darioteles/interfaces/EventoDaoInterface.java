
package com.outlook.darioteles.interfaces;

import java.util.List;
import com.outlook.darioteles.entidades.Evento;

/**
 *
 * @author Dário Teles de Oliveira TIA: 41582391
 * 
 * Descreve uma interface pra qualquer classe cujo objetos possam ser um DAO de 
 * evento.
 */
public interface EventoDaoInterface 
{
    /**
     * Retorna a consulta de todas os eventos registrados no banco de dados.
     * @return eventos
     */
    public List<Evento> listarTudo();
    
    /**
     * Inseri um novo registro de evento no banco de dados.
     * @param novo 
     */
    public void adicionarEvento(Evento novo);
    
    /**
     * Retorna a consulta de um registro de evento 
     * a partir de um determinado código.
     * @param codigo
     * @return evento
     */
    public Evento pesquisarEvento(int codigo);
    
    /**
     * Retorna uma lista com os registros de eventos apartir de um código 
     * de banda.
     * @param codigoBanda
     * @return eventos
     */
    public List<Evento> listarPorBanda(int codigoBanda);
}
