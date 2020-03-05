/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.dao.UsuarioDAO;
import br.com.model.Usuario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego Danniel
 */
public class UsuarioControler {

    private Usuario usuario;
    private List<Usuario> usuarios;
    private UsuarioDAO dao;
   
    

    public UsuarioControler() {
        dao = new UsuarioDAO();
        novo();

    }

    public boolean inserirUsuario() throws SQLException {
        return dao.insert(usuario);
    }

    public boolean atualizarUsuario() {
        return dao.update(usuario);
    }

    public boolean removerUsuario(int codigo) {
        return dao.delete(codigo);
    }

    public void listarUsuarios() throws SQLException {
        usuarios = dao.findAll();
    }
    
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    
    public Usuario getUsuario(){
        return usuario;
    }
    
    public void novo(){
        usuario = new Usuario();
        usuarios = new ArrayList<>();
    }
    public void  buscarIdPrimeiro(){
     dao.listarPrimeiro();
        
    }
    public void buscarIdProximo(){
       usuarios = dao.listarProximo();
    }
    
    public List<Usuario> getUsuarioModels(){
        
    return usuarios;
            }
}
