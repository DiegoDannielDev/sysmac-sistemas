package br.com.sysmac.servico;

import br.com.sysmac.entitys.Cliente;
import br.com.sysmac.entitys.Produto;
import br.com.sysmac.entitys.Venda;
import br.com.sysmac.repositorys.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class VendaService {
    private Venda venda;
    @Autowired
    private VendaRepository vendaRepository;
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private ClienteService clienteService;
    private VendaItemServico itemServico;
    private Produto produto;

    public VendaService(VendaItemServico itemServico) {
        this.itemServico = itemServico;
    }

    public Venda iniciaCodigoVenda(Venda venda, String tipo, String status) {
        venda.setDataVenda(new Date());
        venda.setTipo(tipo);
        venda.setCliente(clienteService.getCliente());
        venda.setStatus(status);
        this.venda = venda;
        this.vendaRepository.save(venda);
        return venda;
    }

    public void insertVendaItens(double qtde, double ValorAcrescimo, double valorDesconto) {
        this.itemServico.insertVendaItem(produto, qtde, produto.getValorUn(), ValorAcrescimo, valorDesconto, venda);
    }

    public void deleteByVendaId(Long id) {
        this.vendaRepository.deleteById(id);
    }


    public Cliente getCliente(Long id) {
        Optional<Cliente> optional = Optional.ofNullable(this.clienteService.findClienteId(id));
        return optional.get();
    }

    public Produto getProdutos(Long id) {
        Optional<Produto> produto = Optional.ofNullable(this.produtoService.findProdutoId(id));
        return this.produto = produto.get();
    }

    public void deleteItensById(Long id) {
        this.itemServico.deleteProdutoById(id);

    }

    public Venda getVenda() {
        return venda;
    }

}
