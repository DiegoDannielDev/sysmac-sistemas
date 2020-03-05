/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import br.com.controller.UsuarioControler;
import br.com.model.Usuario;
import br.com.view.FormUsuarios;
import br.com.view.FormLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Danniel
 */
public class UsuarioDAO {

    ConexaoDAO conect = new ConexaoDAO();
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    UsuarioControler user;
    FormUsuarios codigoUsuario;
    Usuario cad;
    FormLogin login = new FormLogin();
    public UsuarioDAO() {
    }

    public boolean insert(Usuario usuario) {
        int adicionado;
        conect.conexao();
        String sql = "INSERT INTO `usuarios` (`NOME`,\n"
                + "  `LOGIN`,\n"
                + "  `SENHA`,\n"
                + "  `EMAIL`) VALUES (?,?,?,?) ";

        try {
            pst = conect.conn.prepareStatement(sql);
            pst.setString(1, usuario.getNomeUser());
            pst.setString(2, usuario.getLoginUser());
            pst.setString(3, usuario.getSenhaUser());
            pst.setString(4, usuario.getEmailUser());
            adicionado = pst.executeUpdate();

            if (adicionado > 0) {
                JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
            }

            return true;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar\n " + e.getMessage());
               login.barra.setVisible(false);
            return false;
        } finally {
            conect.desconecta();
        }
    }

    public boolean update(Usuario usuario) {
        return false;

    }

    public boolean delete(int codigo) {
        return false;

    }

    public List<Usuario> findAll() throws SQLException {
        List<Usuario> usuario = new ArrayList<>();
        conect.conexao();
        user = new UsuarioControler();
        codigoUsuario = new FormUsuarios();
        try {
            String sql = "SELECT * FROM USUARIOS";
            pst = conect.conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                usuario.add(new Usuario(
                        rs.getInt("codigo"),
                        rs.getString("nome"),
                        rs.getString("login"),
                        rs.getString("email")));
            }
            return usuario;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return usuario;
        }
    }

    public void listarPrimeiro() {
        cad = new Usuario();

        try {
            conect.executasql("select * from usuarios");
            conect.rs.next();
            cad.setCodigoUser(rs.getInt("CODIGO"));
            cad.setNomeUser(rs.getString("NOME"));
            cad.setLoginUser(rs.getString("LOGIN"));
            cad.setEmailUser(rs.getString("EMAIL"));

            pst.executeQuery();

            //model.setSenhaUser(conect.rs.getString());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }

    public List<Usuario> listarProximo() {
        List<Usuario> users = new ArrayList<>();

        try {

            conect.rs.last();

            users.add(new Usuario(
                    rs.getInt("CODIGO"),
                    rs.getString("nome"),
                    rs.getString("LOGIN"),
                    rs.getString("EMAIL")));

            //model.setSenhaUser(conect.rs.getString());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return users;
    }
}
