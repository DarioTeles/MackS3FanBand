
package com.outlook.darioteles.testes;

import java.util.List;
import com.outlook.darioteles.dao.BandaDao;
import com.outlook.darioteles.entidades.Banda;
import com.outlook.darioteles.entidades.ConexaoJavaDb;
import com.outlook.darioteles.entidades.Evento;
import com.outlook.darioteles.interfaces.BandaDaoInterface;
import com.outlook.darioteles.interfaces.ConexaoInterface;
import com.outlook.darioteles.parameters.bdParameters;

/**
 *
 * @author Dário Teles de Oliveira TIA: 41582391
 * 
 * Classe que testa o DAO da Banda.
 */
public class TesteDaoBanda {
    
    
    
    public static void main(String[] args) {
        
        final String usuario = bdParameters.USUARIO;
        final String senha = bdParameters.SENHA;
        final String hostname = bdParameters.HOSTNAME;
        final int porta = bdParameters.PORTA;
        final String baseDeDados = bdParameters.BASE_DE_DADOS;
    
        ConexaoInterface conexao = new ConexaoJavaDb(usuario, senha, 
                hostname, porta, baseDeDados);

        BandaDaoInterface daoBanda = new BandaDao(conexao);

        //Adicionar Banda - Testado
        //Banda banda = new Banda("Banda06@123", "123", "Banda06", 6, "Banda06",
        //      "Teste", "Teste", "94444-8888");    
        //daoBanda.adicionarBanda(banda);
        
        //Listar Bandas - Testado
        //List<Banda> bandas = daoBanda.listarTudo();
        //        
        //for (Banda x : bandas) {
        //    System.out.println(x.getNome());
        //}
        //System.out.println();

        //Pesquisar Banda e Adicionar um Evento (Já criado)- Testado
        //Banda bandaEncontrada = daoBanda.pesquisarBanda(23);
        //
        //if (bandaEncontrada != null) {
        //    System.out.println(bandaEncontrada.getNome() + "|| Primeiro Repertorio:" + bandaEncontrada.getRepertorios().get(0).getNome() + "|| Primeiro evento:" + bandaEncontrada.getEventos().get(0).getNome());
        //} else {
        //    System.out.println("Banda não existente");
        //}
        
        //Evento evento = new Evento();
        //evento.setCodigo(20);
        //daoBanda.adicionarEvento(bandaEncontrada, evento);
    }
}