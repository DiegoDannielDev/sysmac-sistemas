package br.com.sysmac.util;

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

    public void abrirJanelas2(JFrame frame, JDesktopPane desktopPane) {
        int indexDeskgetWidth = desktopPane.getWidth();
        int indexDeskgetHeight = frame.getHeight();
        int indexJanela1 = frame.getWidth();
        int indexJanela2 = frame.getHeight();
        frame.setLocation(indexDeskgetWidth / 2 - indexJanela1 / 2, indexDeskgetHeight / 2 - indexJanela2 / 2);
        if (frame.isVisible()) {
            frame.toFront();
            frame.requestFocus();
        } else {
            desktopPane.add(frame);
            frame.setVisible(true);
        }
    }
}
