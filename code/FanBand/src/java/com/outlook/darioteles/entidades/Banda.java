
package com.outlook.darioteles.entidades;

import java.util.List;

/**
 *
 * @author Dário Teles de Oliveira TIA: 41582391
 * 
 * Define um banda musical no qual herda estados da classe Usuario.
 */
public class Banda extends Usuario 
{
    private int codigo;
    private String nome;
    private String genero;
    private String descricao;
    private String contato;
    private List<Repertorio> repertorios;
    private List<Evento> eventos;
    
    //Método construtor sem parâmetros
    public Banda() {}
    
    /**
     * Constrói uma banda.
     * @param email
     * @param senha
     * @param apelido
     * @param codigo
     * @param nome
     * @param genero
     * @param descricao
     * @param contato
     * @param repertorios
     * @param eventos 
     */
    public Banda(String email, String senha, String apelido, int codigo, 
            String nome, String genero, String descricao, String contato, 
            List<Repertorio> repertorios, List<Evento> eventos) 
    {
        super.setEmail(email);
        super.setSenha(senha);
        super.setApelido(apelido);
        this.codigo = codigo;
        this.nome = nome;
        this.genero = genero;
        this.descricao = descricao;
        this.contato = contato;
        this.repertorios = repertorios;
        this.eventos = eventos;
    }
    
    /**
     * Constrói uma banda sem listas de repertórios e de eventos.
     * @param email
     * @param senha
     * @param apelido
     * @param codigo
     * @param nome
     * @param genero
     * @param descricao
     * @param contato 
     */
    public Banda(String email, String senha, String apelido, int codigo, 
            String nome, String genero, String descricao, String contato) 
    {
        super.setEmail(email);
        super.setSenha(senha);
        super.setApelido(apelido);
        this.codigo = codigo;
        this.nome = nome;
        this.genero = genero;
        this.descricao = descricao;
        this.contato = contato;
    }
    
    /**
     * Retorna o código da banda.
     * @return codigo
     */
    public int getCodigo() 
    {
        return codigo;
    }
    
    /**
     * Altera o código da banda.
     * @param codigo 
     */
    public void setCodigo(int codigo) 
    {
        this.codigo = codigo;
    }
    
    /**
     * Retorna o nome da banda.
     * @return nome
     */
    public String getNome() 
    {
        return nome;
    }
    
    /**
     * Altera o nome da banda.
     * @param nome 
     */
    public void setNome(String nome) 
    {
        this.nome = nome;
    }
    
    /**
     * Retorna o gênero musical da banda.
     * @return genero
     */
    public String getGenero() 
    {
        return genero;
    }
    
    /**
     * Altera o gênero musical da banda.
     * @param genero 
     */
    public void setGenero(String genero) 
    {
        this.genero = genero;
    }
    
    /**
     * Retorna a descrição da banda.
     * @return descricao
     */
    public String getDescricao() 
    {
        return descricao;
    }
    
    /**
     * Altera a descrição.
     * @param descricao 
     */
    public void setDescricao(String descricao) 
    {
        this.descricao = descricao;
    }
    
    /**
     * Retorna o contato da banda.
     * @return contato
     */
    public String getContato() 
    {
        return contato;
    }
    
    /**
     * Altera o contato da banda.
     * @param contato 
     */
    public void setContato(String contato) 
    {
        this.contato = contato;
    }
    
    /**
     * Retorna a lista da repertórios.
     * @return repertorios
     */
    public List<Repertorio> getRepertorios() 
    {
        return repertorios;
    }
    
    /**
     * Altera a lista de repertórios.
     * @param repertorios 
     */
    public void setRepertorios(List<Repertorio> repertorios) 
    {
        this.repertorios = repertorios;
    }
    
    /**
     * Retorna a lista de eventos.
     * @return eventos
     */
    public List<Evento> getEventos() 
    {
        return eventos;
    }
    
    /**
     * Altera a lista de eventos.
     * @param eventos 
     */
    public void setEventos(List<Evento> eventos) 
    {
        this.eventos = eventos;
    }
}