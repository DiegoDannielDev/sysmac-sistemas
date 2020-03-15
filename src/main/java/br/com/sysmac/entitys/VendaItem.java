package br.com.sysmac.entitys;

import br.com.sysmac.emuns.TiṕoProduto;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "VENDA_ITEM")
public class VendaItem implements Serializable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false, name = "FK_ID_PRODUTO")
    private Produto produtoList;
    @Column(name = "QTDE_VENDIDA")
    private double qtdeVendida;
    @Column(name = "VALOR_UN_PRODUTO")
    private double valorUnProduto;
    @Column(name = "VALOR_AC_PRODUTO")
    private double valorAcrescimo;
    @Column(name = "VALOR_DESC_PRODUTO")
    private double valorDesconto;
    @Column(name = "VALOR_TOTAL_PRODUTO")
    private double valorTotalProduto;
    @Column(name = "TIPO_PRODUTO")
    private TiṕoProduto tipoProduto;
    @ManyToOne(optional = false)
    @JoinColumn(nullable = true, name = "FK_ID_VENDA")
    private Venda vendas;

    public VendaItem() {
    }

    public VendaItem(Produto produtoList, double qtdeVendida,
                     double valorUnProduto, double valorAcrescimo,
                     double valorDesconto, double valorTotalProduto, Venda vendas) {
        this.produtoList = produtoList;
        this.qtdeVendida = qtdeVendida;
        this.valorUnProduto = valorUnProduto;
        this.valorAcrescimo = valorAcrescimo;
        this.valorDesconto = valorDesconto;
        this.valorTotalProduto = valorTotalProduto;
        this.vendas = vendas;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProdutoList() {
        return produtoList;
    }

    public void setProdutoList(Produto produtoList) {
        this.produtoList = produtoList;
    }

    public Venda getVendas() {
        return vendas;
    }

    public void setVendas(Venda vendas) {
        this.vendas = vendas;
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

    public void setTipoProduto(TiṕoProduto tiṕoProduto) {
        this.tipoProduto = tiṕoProduto;
    }
}
