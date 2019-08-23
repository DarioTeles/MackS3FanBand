/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outlook.darioteles.testes;

import java.util.List;
import com.outlook.darioteles.dao.MusicaDao;
import com.outlook.darioteles.entidades.ConexaoJavaDb;
import com.outlook.darioteles.entidades.Musica;
import com.outlook.darioteles.interfaces.ConexaoInterface;
import com.outlook.darioteles.interfaces.MusicaDaoInterface;

/**
 *
 * @author Dário Teles de Oliveira TIA: 41582391
 * @author Gabriel Costa TIA: 41342690
 * @author Vinicius Soares Robles TIA: 31529283
 */
public class TesteDaoMusica {

    public static void main(String[] args) {

        ConexaoInterface conexao = new ConexaoJavaDb("app", "123", "127.0.0.1", 1527, "bd_projeto");

        MusicaDaoInterface daoMusica = new MusicaDao(conexao);

        //Adicionar Banda - Testado
        //Musica musica = new Musica(18, "Musica02", "Teste", "Teste", 0);    
        //daoMusica.adicionarMusica(musica);
        
        //Listar Bandas - Testado
        //List<Musica> musicas = daoMusica.listarTudo();

        //for (Musica x : musicas) {
        //    System.out.println(x.getNome());
        //}

        //System.out.println();

        //Pesquisar Banda - Testado
        //Musica musicaEncontrada = daoMusica.pesquisarMusica(7);

        //if (musicaEncontrada != null) {
        //    System.out.println(musicaEncontrada.getNome());
        //} else {
        //    System.out.println("Musica nao existe");
        //}
        
        //System.out.println();
        
        //Listar por Repertorio - Testado
        List<Musica> musicas2 = daoMusica.listarPorRepertorio(15);
        
        for (Musica x : musicas2) {
            System.out.println(x.getNome());
        }
        
        //Apagar musica - não funcionando
        //daoMusica.apagar(12);
    }
}
