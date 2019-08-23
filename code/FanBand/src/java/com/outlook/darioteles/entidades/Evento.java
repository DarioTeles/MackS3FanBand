
package com.outlook.darioteles.entidades;

import java.util.Date;

/**
 *
 * @author Dário Teles de Oliveira TIA: 41582391
 * 
 * Define um evento.
 */
public class Evento 
{
    private int codigo;
    private String nome;
    private String descricao;
    private String local;
    private Date data;
    private Repertorio repertorio;
    private Float valorDoIngresso;
    
    //Método construtor sem parâmetros
    public Evento() {}
    
    /**
     * Constrói um evento.
     * @param codigo
     * @param nome
     * @param descricao
     * @param local
     * @param data
     * @param repertorio
     * @param valorDoIngresso 
     */
    public Evento(int codigo, String nome, String descricao, String local, 
            Date data, Repertorio repertorio, Float valorDoIngresso) 
    {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.local = local;
        this.data = data;
        this.repertorio = repertorio;
        this.valorDoIngresso = valorDoIngresso;
    }
    
    /**
     * Retorna o código do evento.
     * @return codigo
     */
    public int getCodigo() 
    {
        return codigo;
    }
    
    /**
     * Altera o código do evento.
     * @param codigo 
     */
    public void setCodigo(int codigo) 
    {
        this.codigo = codigo;
    }

    /**
     * Retorna o nome do evento.
     * @return nome
     */
    public String getNome() 
    {
        return nome;
    }
    
    /**
     * Altera o nome do evento.
     * @param nome 
     */
    public void setNome(String nome) 
    {
        this.nome = nome;
    }
    
    /**
     * Retorna a descrição do evento.
     * @return descricao
     */
    public String getDescricao() 
    {
        return descricao;
    }
    
    /**
     * Altera a descrição do evento.
     * @param descricao 
     */
    public void setDescricao(String descricao) 
    {
        this.descricao = descricao;
    }
    
    /**
     * Retorna o local do evento.
     * @return local
     */
    public String getLocal() 
    {
        return local;
    }
    
    /**
     * Altera o local do evento.
     * @param local 
     */
    public void setLocal(String local) 
    {
        this.local = local;
    }
    
    /**
     * Retorn a data do evento.
     * @return data
     */
    public Date getData() 
    {
        return data;
    }

    /**
     * Altera a data do evento.
     * @param data 
     */
    public void setData(Date data) 
    {
        this.data = data;
    }
    
    /**
     * Retorna o repertorio a ser tocado no evento.
     * @return repertorio
     */
    public Repertorio getRepertorio() 
    {
        return repertorio;
    }
    
    /**
     * Altera o repertorio a ser tocado no evento.
     * @param repertorio 
     */
    public void setRepertorio(Repertorio repertorio) 
    {
        this.repertorio = repertorio;
    }
    
    /**
     * Retorna o valor do ingresso do evento.
     * @return valorDoIngresso
     */
    public double getValorDoIngresso() 
    {
        return valorDoIngresso;
    }
    
    /**
     * Altera o valor do evento.
     * @param valorDoIngresso 
     */
    public void setValorDoIngresso(Float valorDoIngresso) 
    {
        this.valorDoIngresso = valorDoIngresso;
    }
}