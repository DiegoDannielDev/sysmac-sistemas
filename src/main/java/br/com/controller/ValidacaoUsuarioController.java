/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.dao.ValidacaoUsuarioDAO;
import br.com.model.ValidacaoUsuarioModel;

/**
 *
 * @author Diego Danniel
 */
public class ValidacaoUsuarioController {
    private ValidacaoUsuarioModel validaUsuario;
    private ValidacaoUsuarioDAO dao;
    
    
    public ValidacaoUsuarioController(){
        dao = new ValidacaoUsuarioDAO();
       // novo();
    }
    
//    public boolean verifica() {
//        return dao.verificaUsuario(validaUsuario);
//    }
    
    
//    public void novo(){
//        validaUsuario = new ValidacaoUsuarioModel();
//    }
}
