/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.outlook.darioteles.testes;

import java.util.Date;
import java.util.List;
import com.outlook.darioteles.dao.EventoDao;
import com.outlook.darioteles.entidades.Banda;
import com.outlook.darioteles.entidades.ConexaoJavaDb;
import com.outlook.darioteles.entidades.Evento;
import com.outlook.darioteles.entidades.Repertorio;
import com.outlook.darioteles.interfaces.ConexaoInterface;
import com.outlook.darioteles.interfaces.EventoDaoInterface;

/**
 *
 * @author Dário Teles de Oliveira TIA: 41582391
 * @author Gabriel Costa TIA: 41342690
 * @author Vinicius Soares Robles TIA: 31529283
 */
public class TesteDaoEvento {

    public static void main(String[] args) {
        ConexaoInterface conexao = new ConexaoJavaDb("app", "123", "127.0.0.1", 1527, "bd_projeto");
        EventoDaoInterface daoEvento = new EventoDao(conexao);

        //Adicionar Evento - Testado
        //Date data = new Date(2016, 11, -4+10);
        //Repertorio repertorio = new Repertorio(16, "Repertorio02", "Teste", new Banda()); 
        //Evento evento = new Evento(22, "Evento02", "Teste", "Rio de Janeiro", data, repertorio,(float) 100.00);    
        //daoEvento.adicionarEvento(evento);
        
        //Listar Eventos - Testado
        //List<Evento> eventos = daoEvento.listarTudo();

        //for (Evento x : eventos) {
        //    System.out.println(x.getNome());
        //}
        //System.out.println();

        //Pesquisar Banda - Testado
        //Evento eventoEncontrado = daoEvento.pesquisarEvento(19);

        // (eventoEncontrado != null) {
        //    System.out.println(eventoEncontrado.getNome());
        //} else {
        //    System.out.println("Evento não existente");
        //}
        //System.out.println();
        
        //Listar Eventos por Banda
        //List<Evento> eventos2 = daoEvento.listarPorBanda(23);
        
        //for (Evento x : eventos2) {
        //    System.out.println(x.getNome());
        //}
    }
}
