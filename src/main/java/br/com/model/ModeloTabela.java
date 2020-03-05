/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author SYSMAC
 */
public class ModeloTabela extends AbstractTableModel {

    private ArrayList linhas = null;
    private String[] colunas = null;
    private boolean marcar;

    public boolean isMarcar() {
        return marcar;
    }

    public void setMarcar(boolean marcar) {
        this.marcar = marcar;
    }

    public ModeloTabela(ArrayList lin, String[] col) {
        setLinhas(lin);
        setColunas(col);
    }

    public ArrayList getLinhas() {
        return linhas;
    }

    public final void setLinhas(ArrayList dados) {
        linhas = dados;
    }

    public String[] getColunas() {
        return colunas;
    }

    public final void setColunas(String[] nomes) {
        colunas = nomes;
    }

    /**
     *
     * @return
     */
    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return linhas.size();
    }

    

    @Override
    public String getColumnName(int column) {
        return colunas[column]; //To change body of generated methods, choose Tools | Templates.
        
    }
    
    /**
     *
     * @param numLin
     * @param numCol
     * @return
     */
    @Override
    public Object getValueAt(int numLin, int numCol) {
        Object[] linha = (Object[]) getLinhas().get(numLin);
        return linha[numCol];
    }

}
