
package com.outlook.darioteles.interfaces;

import java.sql.Connection;

/**
 *
 * @author Dário Teles de Oliveira TIA: 41582391
 * 
 * Descreve uma interface pra qualquer classe cujo objetos possam ser um DAO de 
 * Conexao de Banco de Dados.
 */
public interface ConexaoInterface {
    
    /**
     * Método que inicia a conexão.
     * @return conexao
     */
    Connection getConnection();
    
    /**
     * Método que fecha a conexão.
     */
    void close();
}
