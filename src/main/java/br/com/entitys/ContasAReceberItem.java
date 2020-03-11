package br.com.entitys;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class ContasAReceberItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "FK_CONTAS_RECEBER", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ContasAReceber contasAReceber;

    private double valorTotal;
    private double valorRestante;
    private double valorJuros;
    private double desconto;

    public ContasAReceberItem() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContasAReceber getContasAReceber() {
        return contasAReceber;
    }

    public void setContasAReceber(ContasAReceber contasAReceber) {
        this.contasAReceber = contasAReceber;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getValorRestante() {
        return valorRestante;
    }

    public void setValorRestante(double valorRestante) {
        this.valorRestante = valorRestante;
    }

    public double getValorJuros() {
        return valorJuros;
    }

    public void setValorJuros(double valorJuros) {
        this.valorJuros = valorJuros;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
}
