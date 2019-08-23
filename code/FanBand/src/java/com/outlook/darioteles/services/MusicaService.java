
package com.outlook.darioteles.services;

import java.util.List;
import com.outlook.darioteles.dao.MusicaDao;
import com.outlook.darioteles.dao.RepertorioDao;
import com.outlook.darioteles.entidades.ConexaoJavaDb;
import com.outlook.darioteles.entidades.Musica;
import com.outlook.darioteles.entidades.Repertorio;
import com.outlook.darioteles.interfaces.ConexaoInterface;
import com.outlook.darioteles.interfaces.MusicaDaoInterface;
import com.outlook.darioteles.interfaces.RepertorioDaoInterface;
import com.outlook.darioteles.parameters.bdParameters;

/**
 * @author Dário Teles de Oliveira TIA: 41582391
 * 
 * Descreve as regras de negócio da entidade Musica.
 */
public class MusicaService 
{
    private final String USUARIO = bdParameters.USUARIO;
    private final String SENHA = bdParameters.SENHA;
    private final String HOSTNAME = bdParameters.HOSTNAME;
    private final int PORTA = bdParameters.PORTA;
    private final String BASE_DE_DADOS = bdParameters.BASE_DE_DADOS;
    
    /**
     * Cadastra uma nova musica.
     * @param repertorio
     * @param nova
     * @return musica
     */
    public Musica cadastroMusicaService(Repertorio repertorio, Musica nova) 
    {
        ConexaoInterface conexao = new ConexaoJavaDb(USUARIO, SENHA, HOSTNAME, 
                PORTA, BASE_DE_DADOS);
        MusicaDaoInterface daoMusica = new MusicaDao(conexao);
        RepertorioDaoInterface daoRepertorio = new RepertorioDao(conexao);
        daoMusica.adicionarMusica(nova);
        List<Musica> musicas = daoMusica.listarTudo();
        for (Musica x : musicas) 
        {
            if (nova.getNome().equalsIgnoreCase(x.getNome())) 
            {
                daoRepertorio.adicionarMusica(repertorio, x);
                return x;
            }
        }
        return null;
    }
    
    /**
     * Verifica se uma música existe.
     * @param musica
     * @return musica
     */
    public Musica verificarMusica(Musica musica)
    {
        ConexaoInterface conexao = new ConexaoJavaDb(USUARIO, SENHA, HOSTNAME, 
                PORTA, BASE_DE_DADOS);
        MusicaDaoInterface daoMusica = new MusicaDao(conexao);
        List<Musica> musicas = daoMusica.listarTudo();
        for (Musica x : musicas) 
        {
           if(musica.getNome().equalsIgnoreCase(x.getNome()))
                return x;
        }
        return null;
    }
    
    /**
     * Lista todas as musicas de um determinado repertorio.
     * @param codigo
     * @return musicas
     */
    public List<Musica> listarPorRepertorio(int codigo)
    {
        MusicaDaoInterface daoMusica = new MusicaDao(new ConexaoJavaDb(USUARIO, 
                SENHA, HOSTNAME, PORTA, BASE_DE_DADOS));
        List<Musica> musicas = daoMusica.listarPorRepertorio(codigo);
        return musicas;
    }
}