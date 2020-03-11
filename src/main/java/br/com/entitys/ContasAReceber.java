package br.com.entitys;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;


@Entity
public class ContasAReceber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private Cliente cliente;

    @Temporal(TemporalType.DATE)
    private Date dataEntrada;

    @Temporal(TemporalType.DATE)
    private Date dataFim;

    public ContasAReceber() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    @ManyToOne(optional = false)
    private ContasAReceberItem contasAReceberItems;

    public ContasAReceberItem getContasAReceberItems() {
        return contasAReceberItems;
    }

    public void setContasAReceberItems(ContasAReceberItem contasAReceberItems) {
        this.contasAReceberItems = contasAReceberItems;
    }

    @ManyToMany(mappedBy = "contasAReceber")
    private Collection<ContasAReceberItem> contasAReceberItems2;

    public Collection<ContasAReceberItem> getContasAReceberItems2() {
        return contasAReceberItems2;
    }

    public void setContasAReceberItems2(Collection<ContasAReceberItem> contasAReceberItems2) {
        this.contasAReceberItems2 = contasAReceberItems2;
    }
}
