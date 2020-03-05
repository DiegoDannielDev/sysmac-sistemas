/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Diego Danniel
 */
public class TeclasPermitidas extends PlainDocument {

    /**
     *
     * @param offset
     * @param str
     * @param attr
     * @throws javax.swing.text.BadLocationException
     */
    @Override
    public void insertString(int offset, String str, javax.swing.text.AttributeSet attr) throws BadLocationException  {
        super.insertString(offset, str.toUpperCase(), attr);
        
    }
    public void replace(int offset, String str, javax.swing.text.AttributeSet attr) throws BadLocationException  {
        super.insertString(offset, str.toUpperCase(), attr);
        
    }
    
    
}
