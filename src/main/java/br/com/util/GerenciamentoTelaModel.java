package br.com.util;

import javax.swing.*;

public class GerenciamentoTelaModel {

    public void abrirJanelas(JInternalFrame jInternalFrame, JDesktopPane jDesktopPane) {

        int indexDeskgetWidth = jDesktopPane.getWidth();
        int indexDeskgetHeight = jDesktopPane.getHeight();
        int indexJanela1 = jInternalFrame.getWidth();
        int indexJanela2 = jInternalFrame.getHeight();
        jInternalFrame.setLocation(indexDeskgetWidth / 2 - indexJanela1 / 2, indexDeskgetHeight / 2 - indexJanela2 / 2);
        if (jInternalFrame.isVisible()) {
            jInternalFrame.toFront();
            jInternalFrame.requestFocus();
        } else {
            jDesktopPane.add(jInternalFrame);
            jInternalFrame.setVisible(true);
        }
    }
}
