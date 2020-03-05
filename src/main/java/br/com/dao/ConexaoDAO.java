/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego Danniel
 */
public class ConexaoDAO {
   
    public Connection conn;
    public PreparedStatement pst;
    public ResultSet rs = null;
    public Statement stm = null;
    private final String caminho = "jdbc:mysql://127.0.0.1:3306/db_imobiliaria";
    private final String driver = "com.mysql.jdbc.Driver";
    private final String usuario = "TECSYSMAC";
    private final String senha = "5715258";





    public void executasql(String sql) {
        try {
            stm = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO AO EXECUTAR SQL!\n erro!!!" + ex.getMessage());
        }
    }

    public void conexao() {

        try {
            System.setProperty("jdbc.drivers", driver);
            conn = DriverManager.getConnection(caminho, usuario, senha);

        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Conexão com o banco de dados mal sucedida\n"+ex.getMessage()+
                   "\nVerifique se a base de dados está ONLINE....");
           System.exit(0);
           
           
        }
    }

    public void desconecta() {
        try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao desconectar do banco de dados! \n" + ex);
        }

    }
    
       public static Connection conector() {
        java.sql.Connection conexao = null;
        // a linha abaixo chama o driver que foi importado para a bliblioteca
        String driver = "com.mysql.jdbc.Driver";
        // armazenddo informações referentes ao banco de dados
        String url = "jdbc:mysql://127.0.0.1:3306/db_imobiliaria";
        String user = "TECSYSMAC";
        String password = "5715258";
        
       
        
        //estabelecendo a conexão com o banco de dados.
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (ClassNotFoundException | SQLException e) {//a linha abaixo serve de apoio sobre o erro;
            // a linha abaixo serve de apoio para mostrar o erro
            //System.out.println(e);
            return null;
        }
    }
}
