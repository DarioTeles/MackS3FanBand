
package com.outlook.darioteles.interfaces;

import java.util.List;
import com.outlook.darioteles.entidades.Musica;

/**
 *
 * @author Dário Teles de Oliveira TIA: 41582391
 * 
 * Descreve uma interface pra qualquer classe cujo objetos possam ser um DAO de 
 * musica.
 */
public interface MusicaDaoInterface 
{
    /**
     * Retorna a consulta de todas as musicas registradas no banco de dados.
     * @return musicas
     */
    public List<Musica> listarTudo();
    
    /**
     * Inseri um novo registro de musica no banco de dados.
     * @param nova 
     */
    public void adicionarMusica(Musica nova);
    
    /**
     * Retorna a consulta de um registro de musica 
     * a partir de um determinado código.
     * @param codigo
     * @return musica
     */
    public Musica pesquisarMusica(int codigo);
    
    /**
     * Retorna uma lista com os registros de musicas apartir de um código 
     * de repertorio.
     * @param codigoRepertorio
     * @return eventos
     */
    public List<Musica> listarPorRepertorio(int codigoRepertorio);
    
    /**
     * Altera o contador de votos de musica.
     * @param codigo
     * @param contador 
     */
    public void atualizarContador (int codigo, int contador);
    
    /**
     * Apagar um registo de uma música no banco de dados (Em andamento).
     * @param id 
     */
    public void apagar(int id); 
}
