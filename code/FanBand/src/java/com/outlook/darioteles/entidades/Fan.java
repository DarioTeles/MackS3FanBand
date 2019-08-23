
package com.outlook.darioteles.entidades;

import java.util.Date;

/**
 *
 * @author Dário Teles de Oliveira TIA: 41582391
 * 
 * Define um fan no qual herda estados da classe Usuario.
 */
public class Fan extends Usuario 
{
    private int codigo;
    private String nome;
    private Date dataNascimento;
    private Banda bandaFavorita;
    
    //Método construtor sem parâmetros
    public Fan() {}
    
    /**
     * Constrói um fan. 
     * @param email
     * @param senha
     * @param apelido
     * @param codigo
     * @param nome
     * @param dataNascimento 
     */
    public Fan(String email, String senha, String apelido, int codigo, 
            String nome, Date dataNascimento) 
    {
        super.setEmail(email);
        super.setSenha(senha);
        super.setApelido(apelido);
        this.codigo = codigo;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.bandaFavorita = new Banda();
    }
    
    /**
     * Retorna o código do fan.
     * @return codigo
     */
    public int getCodigo() 
    {
        return codigo;
    }
    
    /**
     * Altera o código.
     * @param codigo 
     */
    public void setCodigo(int codigo) 
    {
        this.codigo = codigo;
    }
    
    /**
     * Retona no nome do fan.
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Altera o nome do fan.
     * @param nome 
     */
    public void setNome(String nome) 
    {
        this.nome = nome;
    }
    
    /**
     * Retorna a data de nascimento do fan.
     * @return dataNascimento
     */
    public Date getDataNascimento() 
    {
        return dataNascimento;
    }

    /**
     * Altera a data de nascimento do fan.
     * @param dataNascimento 
     */
    public void setDataNascimento(Date dataNascimento) 
    {
        this.dataNascimento = dataNascimento;
    }

    /**
     * Retorna a banda favorita do fan.
     * @return bandaFavorita
     */
    public Banda getBandaFavorita() 
    {
        return bandaFavorita;
    }
    
    /**
     * Altera a banda favorita do fan.
     * @param bandaFavorita 
     */
    public void setBandaFavorita(Banda bandaFavorita) 
    {
        this.bandaFavorita = bandaFavorita;
    }
}