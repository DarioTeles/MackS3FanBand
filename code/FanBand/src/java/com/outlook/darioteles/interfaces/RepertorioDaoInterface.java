
package com.outlook.darioteles.interfaces;

import java.util.List;
import com.outlook.darioteles.entidades.Musica;
import com.outlook.darioteles.entidades.Repertorio;

/**
 *
 * @author Dário Teles de Oliveira TIA: 41582391
 * 
 * Descreve uma interface pra qualquer classe cujo objetos possam ser um DAO de 
 * Interface.
 */
public interface RepertorioDaoInterface {
    /**
     * Retorna a consulta de todas os repertorioS registrados no banco de dados.
     * @return repertorios
     */
    public List<Repertorio> listarTudo();
    
    /**
     * Inseri um novo registro de repertorio no banco de dados.
     * @param novo 
     */
    public void adicionarRepertorio(Repertorio novo);
    
    /**
     * Retorna a consulta de um registro de repertorio 
     * a partir de um determinado código.
     * @param codigo
     * @return repertorio
     */
    public Repertorio pesquisarRepertorio(int codigo);
    
    /**
     * Retorna uma lista com os registros de repertorios apartir de um código 
     * de banda.
     * @param codigoBanda
     * @return eventos
     */
    public List<Repertorio> listarPorBanda(int codigoBanda);
    
    /**
     * Inseri um novo registro de musica relacionado ao repertorio 
     * no banco de dados.
     * @param repertorio
     * @param musica
     */
    public void adicionarMusica(Repertorio repertorio, Musica musica);
}
