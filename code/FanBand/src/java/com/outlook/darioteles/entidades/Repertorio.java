
package com.outlook.darioteles.entidades;

import java.util.List;

/**
 *
 * @author Dário Teles de Oliveira TIA: 41582391
 * 
 * Define um repertório.
 */
public class Repertorio 
{
    private int codigo;
    private String nome;
    private String descricao;
    private Banda banda;
    List<Musica> musicas;

    //Método construtor sem parâmetros 
    public Repertorio() {}
    
    /**
     * Constrói um repertório.
     * @param codigo
     * @param nome
     * @param descricao
     * @param banda
     * @param musicas 
     */
    public Repertorio(int codigo, String nome, String descricao, Banda banda, 
            List<Musica> musicas) 
    {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.banda = banda;
        this.musicas = musicas;
    }
    
    /**
     * Constrói um repertório sem lista de músicas.
     * @param codigo
     * @param nome
     * @param descricao
     * @param banda 
     */
    public Repertorio(int codigo, String nome, String descricao, Banda banda) 
    {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.banda = banda;
    }
    
    /**
     * Retorna o código do repertório.
     * @return codigo
     */
    public int getCodigo() 
    {
        return codigo;
    }
    
    /**
     * Altera o código do repertório.
     * @param codigo 
     */
    public void setCodigo(int codigo) 
    {
        this.codigo = codigo;
    }

    /**
     * Retorna no nome do repertório.
     * @return nome
     */
    public String getNome() 
    {
        return nome;
    }

    /**
     * Altera o nome do repertório.
     * @param nome 
     */
    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    /**
     * Retorna a descrição do repertório.
     * @return descricao
     */
    public String getDescricao() 
    {
        return descricao;
    }

    /**
     * Altera a descrição do repertório.
     * @param descricao 
     */
    public void setDescricao(String descricao) 
    {
        this.descricao = descricao;
    }

    /**
     * Retorna a banda que toca o repertório.
     * @return banda
     */
    public Banda getBanda() 
    {
        return banda;
    }

    /**
     * Altera a banda que toca o repertório.
     * @param banda 
     */
    public void setBanda(Banda banda) 
    {
        this.banda = banda;
    }

    /**
     * Retorna a lista de músicas.
     * @return musicas
     */
    public List<Musica> getMusicas() 
    {
        return musicas;
    }

    /**
     * Altera a lista de músicas.
     * @param musicas 
     */
    public void setMusicas(List<Musica> musicas) 
    {
        this.musicas = musicas;
    }
}