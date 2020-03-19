package br.com.sysmac.entitys;

import br.com.sysmac.emuns.FormaPagamento;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "VENDA")
public class Venda {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@PrimaryKeyJoinColumn(name = "ID_VENDA", referencedColumnName = "id")
	private Long id;
	private String tipo;
	@OneToOne
	private Cliente cliente;
	private FormaPagamento formaPagamento;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataVenda;
	@Column(name = "VALOR_TOTAL_VENDA")
	private double valorTotalVenda;
	@Column(name = "VALOR_ENTRADA")
	private double valorEntrada;
	private boolean troco;
	@Column(name = "VALOR_TROCO")
	private double valorTroco;
	@Column(name = "VALOR_ACRESCIMO")
	private double valorAcrescimo;
	@Column(name = "VALOR_DESCONTO")
	private double ValorDesconto;

	private String status;

	@OneToMany(mappedBy = "vendas", cascade = CascadeType.REMOVE)
	private final List<VendaItem> itemList = new ArrayList<>();

	public Venda() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente clienteList) {
		this.cliente = clienteList;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public double getValorTotalVenda() {
		for (VendaItem item : itemList) {
			valorTotalVenda += item.getProduto().getValorUn() * item.getQtdeVendida();
		}
		return valorTotalVenda;
	}

	public void setValorTotalVenda(double valorTotalVenda) {
		this.valorTotalVenda = valorTotalVenda;
	}

	public double getValorEntrada() {
		return valorEntrada;
	}

	public void setValorEntrada(double valorEntrada) {
		this.valorEntrada = valorEntrada;
	}

	public boolean isTroco() {
		return troco;
	}

	public void setTroco(boolean troco) {
		this.troco = troco;
	}

	public double getValorTroco() {
		return valorTroco;
	}

	public void setValorTroco(double valorTroco) {
		this.valorTroco = valorTroco;
	}

	public double getValorAcrescimo() {
		return valorAcrescimo;
	}

	public void setValorAcrescimo(double valorAcrescimo) {
		this.valorAcrescimo = valorAcrescimo;
	}

	public double getValorDesconto() {
		return ValorDesconto;
	}

	public void setValorDesconto(double valorDesconto) {
		ValorDesconto = valorDesconto;
	}

	public List<VendaItem> getItemList() {
		return itemList;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void adicionaItemLista(VendaItem item) {
		this.itemList.add(item);
	}

}
