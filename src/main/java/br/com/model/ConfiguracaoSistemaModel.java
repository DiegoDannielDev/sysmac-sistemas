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
public class ConfiguracaoSistemaModel {
    private String url, nome, senha, porta;

    public ConfiguracaoSistemaModel() {
        
    }

    public ConfiguracaoSistemaModel(String url, String nome, String senha, String porta) {
        this.url = url;
        this.nome = nome;
        this.senha = senha;
        this.porta = porta;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPorta() {
        return porta;
    }

    public void setPorta(String porta) {
        this.porta = porta;
    }

}
