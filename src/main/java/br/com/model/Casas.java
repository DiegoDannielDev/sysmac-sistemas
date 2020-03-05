/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.model;

import java.sql.Date;
import java.text.ParseException;

/**
 *
 * @author Diego Danniel
 */
public class Casas {
    private int codigoCasa;
    private String classificacao;
    private String tipoImovel;
    private String dataCadastro;
    private String endereco;
    private String numero_end;
    private int cep;
    private String bairro;
    private String cidade;
    private String uf;
    private String referencia;
    private float lote;
    private float quadra;
    private float medida;
    private float metroQuadrado;
    private int quantidadeSala;
    private int quantidadeQuartos;
    private int quantidadeBanheiros;
    private int quantidadeSuite;
    private int quantidadeGaragem;
    private String dataDeContrucao;
    private String observacao1;
  
    private Date dataReforma;

    public Casas() {

    }

    /**
     *
     * @param classificacao
     * @param tipoImovel
     * @param dataCadastro
     * @param endereco
     * @param bairro
     * @param cidade
     * @param uf
     * @param referencia
     * @param lote
     * @param quadra
     * @param medida
     * @param metroQuadrado
     * @param quantidadeSala
     * @param quantidadeQuartos
     * @param quantidadeBanheiros
     * @param quantidadeGaragem
     * @param dataDeContrucao
     * @param observacao1
     *
     */
    
    
    
    public Casas(String classificacao, String tipoImovel,
            String dataCadastro, String endereco, String bairro,
            String cidade, String uf, String referencia,
            int lote, float quadra, float medida,
            float metroQuadrado, int quantidadeSala,
            int quantidadeQuartos, int quantidadeBanheiros,
            int quantidadeGaragem, String dataDeContrucao,
            String observacao1) {
        this.classificacao = classificacao;
        this.tipoImovel = tipoImovel;
        this.dataCadastro = dataCadastro;
        this.endereco = endereco;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.referencia = referencia;
        this.lote = lote;
        this.quadra = quadra;
        this.medida = medida;
        this.metroQuadrado = metroQuadrado;
        this.quantidadeSala = quantidadeSala;
        this.quantidadeQuartos = quantidadeQuartos;
        this.quantidadeBanheiros = quantidadeBanheiros;
        this.quantidadeGaragem = quantidadeGaragem;
        this.dataDeContrucao = dataDeContrucao;
        this.observacao1 = observacao1;

    }

    public Casas(int codigoCasa, String classificacao, String tipoImovel, String endereco, String numero_end, int cep, String bairro, String cidade, String uf, String referencia, float lote, float quadra, float medida, float metroQuadrado, int quantidadeSala, int quantidadeQuartos, int quantidadeBanheiros, int quantidadeGaragem, String observacao1) {
        this.codigoCasa = codigoCasa;
        this.classificacao = classificacao;
        this.tipoImovel = tipoImovel;
        this.endereco = endereco;
        this.numero_end = numero_end;
        this.cep = cep;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.referencia = referencia;
        this.lote = lote;
        this.quadra = quadra;
        this.medida = medida;
        this.metroQuadrado = metroQuadrado;
        this.quantidadeSala = quantidadeSala;
        this.quantidadeQuartos = quantidadeQuartos;
        this.quantidadeBanheiros = quantidadeBanheiros;
       
        this.quantidadeGaragem = quantidadeGaragem;
        this.observacao1 = observacao1;
    }

    public Casas(int codigoCasa) {
        this.codigoCasa = codigoCasa;
    }

    
 
    

    public int getCodigoCasa() {
        return codigoCasa;
    }

    public void setCodigoCasa(int codigoCasa) {
        this.codigoCasa = codigoCasa;
    }
    

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getTipoImovel() {
        return tipoImovel;
    }

    public void setTipoImovel(String tipoImovel) {
        this.tipoImovel = tipoImovel;
    }

    public String getDataCadastro() throws ParseException {
       
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
      
        
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero_end() {
        return numero_end;
    }

    public void setNumero_end(String numero_end) {
        this.numero_end = numero_end;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public float getLote() {
        
        
        return lote;
    }

    public void setLote(float lote) {
        this.lote = lote;
    }

    public float getQuadra() {
        return quadra;
    }

    public void setQuadra(float quadra) {
        this.quadra = quadra;
    }

    public float getMedida() {
        return medida;
    }

    public void setMedida(float medida) {
        this.medida = medida;
    }

    public float getMetroQuadrado() {
        return metroQuadrado;
    }

    public void setMetroQuadrado(float metroQuadrado) {
        this.metroQuadrado = metroQuadrado;
    }

    public int getQuantidadeSala() {
        return quantidadeSala;
    }

    public void setQuantidadeSala(int quantidadeSala) {
        this.quantidadeSala = quantidadeSala;
    }

    public int getQuantidadeQuartos() {
        return quantidadeQuartos;
    }

    public void setQuantidadeQuartos(int quantidadeQuartos) {
        this.quantidadeQuartos = quantidadeQuartos;
    }

    public int getQuantidadeBanheiros() {
        return quantidadeBanheiros;
    }

    public void setQuantidadeBanheiros(int quantidadeBanheiros) {
        this.quantidadeBanheiros = quantidadeBanheiros;
    }

    public int getQuantidadeGaragem() {
        return quantidadeGaragem;
    }

    public void setQuantidadeGaragem(int quantidadeGaragem) {
        this.quantidadeGaragem = quantidadeGaragem;
    }

    public String getDataDeContrucao() {
        return dataDeContrucao;
    }

    public void setDataDeContrucao(String dataDeContrucao) {
        this.dataDeContrucao = dataDeContrucao;
    }

    public String getObservacao1() {
        return observacao1;
    }

    public void setObservacao1(String observacao1) {
        this.observacao1 = observacao1;
    }

    public int getQuantidadeSuite() {
        return quantidadeSuite;
    }

    public void setQuantidadeSuite(int quantidadeSuite) {
        this.quantidadeSuite = quantidadeSuite;
    }

 

    public Date getDataReforma() {
        return dataReforma;
    }

    public void setDataReforma(Date dataReforma) {
        this.dataReforma = dataReforma;
    }

    public int getCep() {
	return cep;
    }

    public void setCep(int cep) {
	this.cep = cep;
    }
    
    
    

    public void CadastrarCasa() {

    }

}
