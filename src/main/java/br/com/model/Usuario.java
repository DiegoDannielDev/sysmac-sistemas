/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "USUARIOS")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long codigoUser;
    private String nomeUser;
    private String loginUser;
    private String senhaUser;
    private String emailUser;

    public Usuario() {
    }

    public Usuario(Long codigoUser, String nomeUser, String loginUser, String emailUser) {
        this.codigoUser = codigoUser;
        this.nomeUser = nomeUser;
        this.loginUser = loginUser;
        this.emailUser = emailUser;
    }


    public Long getCodigoUser() {
        return codigoUser;
    }

    public void setCodigoUser(Long codigoUser) {
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

    public String getSenhaUser() {
        return senhaUser;
    }

    public void setSenhaUser(String senhaUser) {
        this.senhaUser = senhaUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(codigoUser, usuario.codigoUser) &&
                Objects.equals(nomeUser, usuario.nomeUser) &&
                Objects.equals(loginUser, usuario.loginUser) &&
                Objects.equals(senhaUser, usuario.senhaUser) &&
                Objects.equals(emailUser, usuario.emailUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoUser, nomeUser, loginUser, senhaUser, emailUser);
    }
}
