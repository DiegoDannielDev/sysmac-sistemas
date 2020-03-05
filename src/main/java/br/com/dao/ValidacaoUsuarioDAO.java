/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.view.FormLogin;
import br.com.view.FormPrincipal;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Danniel
 */
public class ValidacaoUsuarioDAO {

    ConexaoDAO conect = new ConexaoDAO();
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    FormLogin login;
    FormPrincipal principal;

    public ValidacaoUsuarioDAO(FormLogin login) {
        this.login = login;
        principal = new FormPrincipal();
    }

    public ValidacaoUsuarioDAO() {
    }

    public void verificaUsuario(String usuario, String senha) {
        conect.conexao();

        String sql = "SELECT * FROM usuarios  WHERE login=? AND senha=?";
        try {

            pst = conect.conn.prepareStatement(sql);
            pst.setString(1, usuario);
            pst.setString(2, senha);
            rs = pst.executeQuery();

            if (rs.next()) {
                principal.setVisible(true);
                principal.jblUsuarioConectado.setText(rs.getString(2));
                principal.jblUsuarioConectado.setForeground(new Color(255, 115, 28));
                this.login.dispose();
                
            } else {
                //JOptionPane.showMessageDialog(null, "Usuario e senha invalidos verifique!!! ");
                login.barra.setString("Usuario ou senha inválido");
                login.txtUsuario.requestFocus();
                login.txtUsuario.selectAll();
                login.btnValida.setEnabled(true);
                login.btnSair.setEnabled(true);

            }

        } catch (SQLException ex) {

            JOptionPane.showMessageDialog(null, "Erro" + ex);
        }

    }
}
