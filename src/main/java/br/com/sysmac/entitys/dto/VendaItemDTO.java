package br.com.sysmac.entitys.dto;

import br.com.sysmac.emuns.TiṕoProduto;

public class VendaItemDTO {


    private Long idVenda;
    private long idProduto;
    private double qtdeVendida;
    private double valorUnProduto;
    private double valorAcrescimo;
    private double valorDesconto;
    private double valorTotalProduto;
    private TiṕoProduto tipoProduto;


    public VendaItemDTO(Long idVenda, long idProduto, double qtdeVendida, double valorUnProduto,
                        double valorAcrescimo, double valorDesconto, double valorTotalProduto, TiṕoProduto tipoProduto) {
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.qtdeVendida = qtdeVendida;
        this.valorUnProduto = valorUnProduto;
        this.valorAcrescimo = valorAcrescimo;
        this.valorDesconto = valorDesconto;
        this.valorTotalProduto = valorTotalProduto;
        this.tipoProduto = tipoProduto;
    }

    public Long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public double getQtdeVendida() {
        return qtdeVendida;
    }

    public void setQtdeVendida(double qtdeVendida) {
        this.qtdeVendida = qtdeVendida;
    }

    public double getValorUnProduto() {
        return valorUnProduto;
    }

    public void setValorUnProduto(double valorUnProduto) {
        this.valorUnProduto = valorUnProduto;
    }

    public double getValorAcrescimo() {
        return valorAcrescimo;
    }

    public void setValorAcrescimo(double valorAcrescimo) {
        this.valorAcrescimo = valorAcrescimo;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public double getValorTotalProduto() {
        return valorTotalProduto;
    }

    public void setValorTotalProduto(double valorTotalProduto) {
        this.valorTotalProduto = valorTotalProduto;
    }

    public TiṕoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TiṕoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
}
