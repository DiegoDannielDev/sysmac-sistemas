/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.controller;

import br.com.dao.CasasDAO;
import br.com.model.Casas;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Diego Danniel
 */
public class CasaControle {

    private Casas casaCadastro;
    private List<Casas> casaCadastroModel;
    private CasasDAO dao;

    
    public CasaControle(){
        dao = new CasasDAO();
        novo();
    }
    
    private void novo() {
        casaCadastro = new Casas();
        casaCadastroModel = new ArrayList<>();

    }
    public void novoId() throws SQLException{
       casaCadastroModel = dao.novoId();
    }

    public boolean inserirCasa() throws ParseException {
        return dao.insert(casaCadastro);
    }
//    public void buscarCasas(){
//        dao.buscar(casaCadastro);
//    }

    public boolean atualizarCasa() throws ParseException {
        return dao.update(casaCadastro);
    }

    public boolean deletaCasas(int codigo) throws SQLException {
        return dao.deleteCasa(codigo);
    }

    public void listarCasas(int codigo) throws SQLException {
        casaCadastroModel = dao.findAll(codigo);
    }
    public void listarCasasProximo() throws SQLException {
        casaCadastroModel = dao.findAllProximo(casaCadastro);
    }
    public void listarCasasAnterior() throws SQLException {
        casaCadastroModel = dao.findAllAnterior(casaCadastro);
    }

    public Casas getCasaCadastro() {
        return casaCadastro;
    }

    public void setCasaCadastro(Casas casaCadastro) {
        this.casaCadastro = casaCadastro;
    }

    public List<Casas> getCasaCadastroModel() {
        return casaCadastroModel;
    }

    public void setCasaCadastroModel(List<Casas> casaCadastroModel) {
        this.casaCadastroModel = casaCadastroModel;
    }

    public CasasDAO getDao() {
        return dao;
    }

    public void setDao(CasasDAO dao) {
        this.dao = dao;
    }

}
