/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Splash;

import br.com.dao.ConexaoDAO;
import br.com.view.FormLogin;
import java.awt.Color;
import java.awt.Dimension;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JWindow;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author Diego Danniel
 */
public class Splash extends JWindow {

    FormLogin login;
    AbsoluteLayout absoluto;
    AbsoluteConstraints absImagem, absBarra, absLabel;
    ImageIcon imagem;
    JLabel label, label2;
    JProgressBar barra;

    ConexaoDAO conect;
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public Splash() {
        telaSplash();
        Thread();
        conect = new ConexaoDAO();

    }

    public void telaSplash() {
        absoluto = new AbsoluteLayout();
        absImagem = new AbsoluteConstraints(0, 0);
        absBarra = new AbsoluteConstraints(0, 300);
        barra = new JProgressBar();
        barra.setPreferredSize(new Dimension(500, 20));
        barra.setBackground(Color.BLACK);
        //barra.setIndeterminate(true);
        barra.setForeground(new Color(255,115,28));
        
        barra.setStringPainted(true);
        label = new JLabel();
        label.setBounds(0, 400, 500, 30);
        label.setSize(500, 30);
        label.setOpaque(true);
        label.setBackground(Color.WHITE);
        // label2.setText("Iniciando Sistemas");
        //label2.setBackground(Color.WHITE);
        //  label2.setBounds(0, 20, 100, 30);

        imagem = new ImageIcon(this.getClass().getResource("logo.png"));

        label.setIcon(imagem);
        getContentPane().setLayout(absoluto);
        this.getContentPane().add(label, absImagem);
        this.getContentPane().add(barra, absBarra);
        //this.getContentPane().add(label2, absLabel);

        this.pack();

        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    public void Thread() {
        new Thread() {
            @Override
            public void run() {
                int i = 0;
                while (i < 101) {
                    barra.setValue(i);
                    i++;
                    if (i > 0) {
                        barra.setString("Carregando Metodos");
                    }
                    i++;
                    if (i > 20) {
                        barra.setString("Preparando Configurações");

                    }
                    i++;
                    if (i > 50) {
                        barra.setString("Verificando Conexão de Banco de dados");

                    }
                   i++;
                    if (i > 60) {
                        
                        verificaConexao();
                    }   
                   

                    if (i >= 100) {
                        barra.setString("Bem Vindo");

                    }
                    i++;
                    try {
                        sleep(101);
                    } catch (InterruptedException ex) {

                        
                    }
                }
                login = new FormLogin();
                login.setVisible(true);
                dispose();
            }

        }.start();
    }

    public static void main(String[] args) {
        new Splash().show();
    }

    public void verificaConexao() {
        Thread t = new Thread();
        conect.conexao();
       
        try {
            if (conexao != null) {
                barra.setString("Conexão com o banco de dados mal sucedida!");
                t.stop();
            }
            else{
                 
                 barra.setString("Conexão com o banco bem sucedida");
                 //JOptionPane.showMessageDialog(null,"Erro ao conectar ao banco de dados");
                 
                 
            }
        } catch (Exception e) {
           
        }

    }
}
