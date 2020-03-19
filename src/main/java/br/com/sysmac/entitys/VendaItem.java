package br.com.sysmac.entitys;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "VENDA_ITEM")
public class VendaItem implements Serializable {


    private static final long serialVersionUID = 286835277485526433L;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false, name = "ID_PRODUTO")
    private Produto produto;
    @Column(name = "QTDE_VENDIDA")
    private double qtdeVendida;
    @Column(name = "VALOR_UN_PRODUTO")
    private double valorUnProduto;
    @Column(name = "VALOR_AC_PRODUTO")
    private double valorAcrescimo;
    @Column(name = "VALOR_DESC_PRODUTO")
    private double valorDesconto;
    @ManyToOne(optional = false)
    @JoinColumn(nullable = true, name = "ID_VENDA")
    private Venda vendas;

    public VendaItem() {

    }


    public VendaItem(Produto produto, double qtdeVendida, double valorUnProduto, double valorAcrescimo,
                     double valorDesconto, Venda vendas) {
        this.produto = produto;
        this.qtdeVendida = qtdeVendida;
        this.valorUnProduto = valorUnProduto;
        this.valorAcrescimo = valorAcrescimo;
        this.valorDesconto = valorDesconto;
        this.vendas = vendas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
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


}
