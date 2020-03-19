package br.com.sysmac.util;

import br.com.sysmac.entitys.Produto;

import javax.swing.*;

public class DefaultList {

    private DefaultListModel model;


    public DefaultList() {
        this.model = new DefaultListModel();
    }

    public void inseriItemLista(JList jList, Produto produto, double qtde) {
        jList.setModel(model);
        int seq = 1;
        StringBuilder builder = new StringBuilder();
        seq += model.size();
        builder.append(seq)
                .append("             ").append(produto.getId())
                .append("             ")
                .append(produto.getDescricao())
                .append("             ").append(produto.getValorUn())
                .append("             ").append(qtde);
        model.addElement(builder);
    }

    public boolean deleteListaItemOneOne(JList idx) {

        if (!idx.getSelectedValuesList().isEmpty()) {
            model.remove(idx.getSelectedIndex());
            idx.setModel(model);
            return true;
        }
        return false;
    }


    public boolean deleteListaAll(JList list) {
        if (!list.getSelectedValuesList().isEmpty()) {
            model.clear();
            list.setModel(model);
            return true;
        }
        return false;
    }
}
