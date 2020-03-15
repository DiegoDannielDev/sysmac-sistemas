/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sysmac.view;


import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Diego Danniel
 */


public class Splash extends JWindow {


    FormLogin login;
    AbsoluteLayout absoluto;
    AbsoluteConstraints absImagem, absBarra, absLabel;
    // label2.setText("Iniciando Sistemas");
//label2.setBackground(Color.WHITE);
//  label2.setBounds(0, 20, 100, 30);

    //    ImageIcon imagem = new ImageIcon(this.getClass().getResource("/br/com/icon/logo.png"));
    JLabel label, label2;
    JProgressBar barra;

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;


    public Splash() {
//        telaSplash();
//        Thread();
    }

    public void telaSplash() {
        absoluto = new AbsoluteLayout();
        absImagem = new AbsoluteConstraints(0, 0);
        absBarra = new AbsoluteConstraints(0, 300);
        barra = new JProgressBar();
        barra.setPreferredSize(new Dimension(500, 50));
        barra.setBackground(Color.BLACK);
        //barra.setIndeterminate(true);
        barra.setForeground(new Color(255, 22, 51));

        barra.setStringPainted(true);
        label = new JLabel();
        label.setBounds(0, 400, 200, 30);
        label.setSize(500, 30);
        label.setOpaque(true);
        label.setBackground(Color.DARK_GRAY);

//        label.setIcon(imagem);
        getContentPane().setLayout(absoluto);
        this.getContentPane().add(label, absImagem);
        this.getContentPane().add(barra, absBarra);
        //this.getContentPane().add(label2, absLabel);

        this.pack();

        this.setVisible(true);
        this.setLocationRelativeTo(null);

        Thread();
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

//                        verificaConexao();
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


    public static void iniciarTela() {
        Splash splash = new Splash();
        splash.telaSplash();


    }


}
