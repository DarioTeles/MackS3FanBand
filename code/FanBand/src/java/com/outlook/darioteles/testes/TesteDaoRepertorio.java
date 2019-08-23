/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outlook.darioteles.testes;

import java.util.List;
import com.outlook.darioteles.dao.RepertorioDao;
import com.outlook.darioteles.entidades.Banda;
import com.outlook.darioteles.entidades.ConexaoJavaDb;
import com.outlook.darioteles.entidades.Repertorio;
import com.outlook.darioteles.interfaces.ConexaoInterface;
import com.outlook.darioteles.interfaces.RepertorioDaoInterface;

/**
 *
 * @author Dário Teles de Oliveira TIA: 41582391
 * @author Gabriel Costa TIA: 41342690
 * @author Vinicius Soares Robles TIA: 31529283
 */
public class TesteDaoRepertorio {
    public static void main(String[] args) {

        ConexaoInterface conexao = new ConexaoJavaDb("app", "123", "127.0.0.1", 1527, "bd_projeto");
        RepertorioDaoInterface daoRepertorio = new RepertorioDao(conexao);

        //Adicionar Repertorio - Testado
        //Banda banda = new Banda("Banda04@123", "123", "Banda04", 1, "Banda04", "Teste", "Teste", "94444-8888");
        //Repertorio repertorio = new Repertorio(5, "Repertorio02", "Teste", banda);    
        //daoRepertorio.adicionarRepertorio(repertorio);
        
        //Listar Repertorios - Testado
        List<Repertorio> repertorios = daoRepertorio.listarTudo();

        for (Repertorio x : repertorios) {
            System.out.println(x.getNome());
        }

        System.out.println();

        //Pesquisar Repertorio - Testado
        Repertorio repertorioEncontrado = daoRepertorio.pesquisarRepertorio(1);

        if (repertorioEncontrado != null) {
            System.out.println(repertorioEncontrado.getNome());
        } else {
            System.out.println("Banda não existente");
        }
        System.out.println();
        
        //Listar por Banda - Testado
        List<Repertorio> repertorios2 = daoRepertorio.listarPorBanda(1);
        
        for (Repertorio x : repertorios2) {
            System.out.println(x.getNome());
        }
    }
}
