
package com.outlook.darioteles.entidades;

/**
 *
 * @author Dário Teles de Oliveira TIA: 41582391
 * 
 * Define uma música.
 */
public class Musica 
{
    private int codigo;
    private String nome;
    private String compositor;
    private String genero;
    private int contador = 0;

    //Método construtor sem parêmetros
    public Musica() {}

    /**
     * Contrói uma música.
     * @param codigo
     * @param nome
     * @param compositor
     * @param genero
     * @param contador 
     */
    public Musica(int codigo, String nome, String compositor, String genero, int contador) 
    {
        this.codigo = codigo;
        this.nome = nome;
        this.compositor = compositor;
        this.genero = genero;
        this.contador = contador;
    }

    /**
     * Retorna o código da música.
     * @return codigo
     */
    public int getCodigo() 
    {
        return codigo;
    }

    /**
     * Altera o código da música.
     * @param codigo 
     */
    public void setCodigo(int codigo) 
    {
        this.codigo = codigo;
    }

    /**
     * Retorna o nome da música.
     * @return nome
     */
    public String getNome() 
    {
        return nome;
    }

    /**
     * Altera o nome da música.
     * @param nome 
     */
    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    /**
     * Retorna o compositor da música.
     * @return compositor
     */
    public String getCompositor() 
    {
        return compositor;
    }

    /**
     * Altera o compositor da música.
     * @param compositor 
     */
    public void setCompositor(String compositor) 
    {
        this.compositor = compositor;
    }

    /**
     * Retorna o genero da música.
     * @return genero
     */
    public String getGenero() 
    {
        return genero;
    }

    /**
     * Altera o genero da música.
     * @param genero 
     */
    public void setGenero(String genero) 
    {
        this.genero = genero;
    }

    /**
     * Retorna o contatador de votos.
     * @return contador
     */
    public int getContador() 
    {
        return contador;
    }

    /**
     * Altera o contador de votos.
     * @param contador 
     */
    public void setContador(int contador) 
    {
        this.contador = contador;
    }
}