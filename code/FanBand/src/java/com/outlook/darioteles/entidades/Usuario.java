
package com.outlook.darioteles.entidades;

/**
 *
 * @author Dário Teles de Oliveira TIA: 41582391
 * 
 * Define um usuário abstrato.
 */
public abstract class Usuario 
{
    private String email;
    private String senha;
    private String apelido;
    
    /**
     * Retorna o e-mail do usuário.
     * @return email
     */
    public String getEmail() 
    {
        return email;
    }

    /**
     * Altera o e-mail do usuário.
     * @param email 
     */
    public void setEmail(String email) 
    {
        this.email = email;
    }

    /**
     * Retorna a senha do usuário.
     * @return senha
     */
    public String getSenha() 
    {
        return senha;
    }

    /**
     * Altera a senha do usuário.
     * @param senha 
     */
    public void setSenha(String senha) 
    {
        this.senha = senha;
    }

    /**
     * Retorna o apelido do usuário.
     * @return apelido
     */
    public String getApelido() 
    {
        return apelido;
    }

    /**
     * Altera o apelido do usuário.
     * @param apelido 
     */
    public void setApelido(String apelido) 
    {
        this.apelido = apelido;
    }
}