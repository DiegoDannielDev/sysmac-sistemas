package br.com.sysmac.util;

import javax.swing.*;

public class DefaultList {

    private DefaultListModel defaultListModel;

    public DefaultList(DefaultListModel defaultListModel) {
        this.defaultListModel = defaultListModel;
    }

    public DefaultListModel getDefaultListModel() {
        return defaultListModel;
    }

    public void setDefaultListModel(DefaultListModel defaultListModel) {
        this.defaultListModel = defaultListModel;
    }
}
