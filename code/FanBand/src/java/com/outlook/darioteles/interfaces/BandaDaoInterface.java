
package com.outlook.darioteles.interfaces;

import java.util.List;
import com.outlook.darioteles.entidades.Banda;
import com.outlook.darioteles.entidades.Evento;
import com.outlook.darioteles.entidades.Repertorio;

/**
 *
 * @author Dário Teles de Oliveira TIA: 41582391
 * 
 * Descreve uma interface pra qualquer classe cujo objetos possam ser DAO de
 * banda.
 */
public interface BandaDaoInterface 
{    
    /**
     * Retorna a consulta de todas as bandas registradas no banco de dados.
     * @return bandas
     */
    public List<Banda> listarTudo();  
    
    /**
     * Inseri uma nova banda ao banco de dados.
     * @param nova 
     */
    public void adicionarBanda(Banda nova);
    
    /**
     * Retorna a consulta de um registro de banda 
     * a partir de um determinado código.
     * @param codigo
     * @return banda
     */
    public Banda pesquisarBanda(int codigo);
    
    /**
     * Inseri um novo registro na tabela de relacionamento banda_evento. 
     * @param banda
     * @param evento 
     */
    public void adicionarEvento(Banda banda, Evento evento);
    
    /**
     * Inseri um novo registro na tabela de relacionamento banda_repertorio. 
     * @param banda
     * @param repertorio 
     */
    public void adicionarRepertorio(Banda banda, Repertorio repertorio);
}