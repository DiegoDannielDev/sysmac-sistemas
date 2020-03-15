package br.com.sysmac.entitys;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "PRODUTO")
public class Produto {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String descricao;
    private double valorUn;


    public Produto(Long id) {
        this.id = id;
    }

    public Produto(String descricao, double valoUn) {
        this.descricao = descricao;
        this.valorUn = valoUn;
    }

    public Produto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorUn() {
        return valorUn;
    }

    public void setValorUn(double valorUn) {
        this.valorUn = valorUn;
    }


    @OneToMany(mappedBy = "produtoList")
    private Collection<VendaItem> vendaItem;

    public Collection<VendaItem> getVendaItem() {
        return vendaItem;
    }

    public void setVendaItem(Collection<VendaItem> vendaItem) {
        this.vendaItem = vendaItem;
    }
}
