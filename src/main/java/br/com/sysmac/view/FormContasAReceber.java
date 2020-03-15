/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sysmac.view;

/**
 * @author diego
 */
public class FormContasAReceber extends javax.swing.JInternalFrame {
    private static FormContasAReceber formContasAReceber;

    /**
     * Creates new form FormContasAReceber
     */
    public FormContasAReceber() {
        initComponents();
    }

//    public static FormContasAReceber getFormContasAReceber() {
//        if (formContasAReceber == null || formContasAReceber.isClosed() ) {
//            formContasAReceber = new FormContasAReceber();
//        }
//        
//        return formContasAReceber;
//    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setClosable(true);
        setIconifiable(true);
        setResizable(true);
        setTitle("Contas a Receber");
        setToolTipText("Contas a Receber");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 707, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 420, Short.MAX_VALUE)
        );

        setBounds(0, 0, 718, 446);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
