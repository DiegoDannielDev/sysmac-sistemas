///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package br.com.view;
//
//import br.com.dao.ConexaoDAO;
//import java.sql.Connection;
//import javax.swing.JOptionPane;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.view.JasperViewer;
//
///**
// *
// * @author Diego Danniel
// */
//public class FormRelatorioUsuario extends javax.swing.JInternalFrame {
//   ConexaoDAO conect = new ConexaoDAO();
//   Connection conexao;
//    public FormRelatorioUsuario() {
//        initComponents();
//        conexao = conect.conector();
//        conect.conexao();
//
//    }
//
//    private void gerarRelatorio(){
//
////          int confirma = JOptionPane.showConfirmDialog(null, "confirma a impressão desse relatorio?", "ATENÇÃO", JOptionPane.YES_NO_OPTION);
////        if (confirma == JOptionPane.YES_OPTION);
//        //imprimindo o relatorio com a framework
//        int report = 0;
//        JasperPrint print = new JasperPrint();
//
//        try {
//            //usando a classe JasperPrint para preparar a impressão de um relatorio
//
//            print = JasperFillManager.fillReport("C:\\SysMac\\Relatorios/Usuarios.jasper",null, conexao);//passando o caminho para o relatorio.
//            //a linha abaixo exibe um relatorio atraves da classe jasperViewer
//            if(print == null){
//               dispose();
//
//            }
//            else{
//                JasperViewer.viewReport(print, false);
//            }
//
//        } catch (JRException e) {
//            JOptionPane.showMessageDialog(null,""+e.getMessage());
//            //JasperViewer.viewReport(print, false);
//
//        }
//    }
//
//    /**
//     * This method is called from within the constructor to initialize the form.
//     * WARNING: Do NOT modify this code. The content of this method is always
//     * regenerated by the Form Editor.
//     */
//    @SuppressWarnings("unchecked")
//    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
//    private void initComponents() {
//
//        jButton1 = new javax.swing.JButton();
//
//        setClosable(true);
//        setIconifiable(true);
//        setTitle("Relátorios");
//
//        jButton1.setText("Gerar");
//        jButton1.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jButton1ActionPerformed(evt);
//            }
//        });
//
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addGap(103, 103, 103)
//                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
//                .addContainerGap(120, Short.MAX_VALUE))
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addGap(122, 122, 122)
//                .addComponent(jButton1)
//                .addContainerGap(155, Short.MAX_VALUE))
//        );
//
//        setBounds(380, 100, 314, 330);
//    }// </editor-fold>//GEN-END:initComponents
//
//    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//        // TODO add your handling code here:
//        gerarRelatorio();
//    }//GEN-LAST:event_jButton1ActionPerformed
//
//
//    // Variables declaration - do not modify//GEN-BEGIN:variables
//    private javax.swing.JButton jButton1;
//    // End of variables declaration//GEN-END:variables
//}
