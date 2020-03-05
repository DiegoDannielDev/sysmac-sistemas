/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

/**
 *
 * @author Diego Danniel
 */
public class Usuario {

    private int codigoUser;
    private String nomeUser;
    private String loginUser;
    private String senhaUser;
    private String emailUser;
  

    public Usuario() {

    }

    public Usuario(String nomeUser, String loginUser, String senhaUser,
            String emailUser) {
        this.nomeUser = nomeUser;
        this.loginUser = loginUser;
        this.senhaUser = senhaUser;
        this.emailUser = emailUser;
    }

    public Usuario(int codigoUser, String nomeUser, String loginUser,
            String emailUser) {
        this.codigoUser = codigoUser;
        this.nomeUser = nomeUser;
        this.loginUser = loginUser;
        this.emailUser = emailUser;
        
     
    }

    public int getCodigoUser() {
        return codigoUser;
    }

    public void setCodigoUser(int codigoUser) {
        this.codigoUser = codigoUser;
    }

    public String getNomeUser() {
        return nomeUser;
    }

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }

    public String getLoginUser() {
      
        return loginUser;
    }

    public void setLoginUser(String loginUser) {
        this.loginUser = loginUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

  

    public String getSenhaUser() {
       
        return senhaUser;
    }

    public void setSenhaUser(String senhaUser) {
        this.senhaUser = senhaUser;
    }

}
