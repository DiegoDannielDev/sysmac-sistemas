/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sysmac.entitys;


import javax.persistence.*;
import java.util.Objects;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoUser;
    private String nomeUser;
    private String loginUser;

    @Column(length = 255, nullable = false)
    private String senhaUser;
    private String emailUser;

    public Usuario() {
    }

    public Usuario(String nomeUser, String loginUser, String emailUser, String senha) {
        this.nomeUser = nomeUser;
        this.loginUser = loginUser;
        this.emailUser = emailUser;
        this.senhaUser = senha;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Usuario{");
        sb.append("codigoUser=").append(codigoUser);
        sb.append(", nomeUser='").append(nomeUser).append('\'');
        sb.append(", loginUser='").append(loginUser).append('\'');
        sb.append(", senhaUser='").append(senhaUser).append('\'');
        sb.append(", emailUser='").append(emailUser).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
