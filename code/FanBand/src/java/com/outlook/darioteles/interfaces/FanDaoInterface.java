
package com.outlook.darioteles.interfaces;

import java.util.List;
import com.outlook.darioteles.entidades.Fan;

/**
 *
 * @author Dário Teles de Oliveira TIA: 41582391
 * 
 * Descreve uma interface pra qualquer classe cujo objetos possam ser um DAO de 
 * fan.
 */
public interface FanDaoInterface 
{
    /**
     * Retorna a consulta de todas os fans registrados no banco de dados.
     * @return fans
     */
    public List<Fan> listarTudo();
    
    /**
     * Inseri um novo registro de fan no banco de dados.
     * @param novo 
     */
    public void adicionarFan(Fan novo);
    
    /**
     * Retorna a consulta de um registro de fan 
     * a partir de um determinado código.
     * @param codigo
     * @return fan
     */
    public Fan pesquisarFan(int codigo);
}
