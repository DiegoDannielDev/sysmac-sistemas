package br.com.sysmac.servico;

import br.com.sysmac.entitys.Cliente;
import br.com.sysmac.entitys.Produto;
import br.com.sysmac.entitys.Venda;
import br.com.sysmac.entitys.VendaItem;
import br.com.sysmac.repositorys.ClienteRepository;
import br.com.sysmac.repositorys.ProdutoRepository;
import br.com.sysmac.repositorys.VendaItemRepository;
import br.com.sysmac.repositorys.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VendaService {
    private Venda venda;
    private VendaRepository vendaRepository;
    private ProdutoService produtoService;
    private ClienteRepository clienteRepository;
    private ProdutoRepository produtoRepository;
    private VendaItemRepository vendaItemRepository;

    @Autowired
    public VendaService(VendaRepository vendaRepository,
                        ProdutoService produtoService,
                        ClienteRepository clienteRepository,
                        ProdutoRepository produtoRepository,
                        VendaItemRepository vendaItemRepository
    ) {
        this.vendaRepository = vendaRepository;
        this.produtoService = produtoService;
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
        this.vendaItemRepository = vendaItemRepository;
    }

    public Venda iniciaCodigoVenda(Venda venda, String tipo) {
        venda.setDataVenda(new Date());
        venda.setTipo(tipo);
        this.venda = venda;
        return this.vendaRepository.save(venda);
    }



    public void deleteByVendaId(Long id) {
        deleteById(id);
    }


    public Cliente getCliente(Long id) {
        Optional<Cliente> optional = this.clienteRepository.findById(id);
        return optional.get();
    }

    public Produto getProdutos(Long id) {
        Optional<Produto> produto = this.produtoRepository.findById(id);
        return produto.get();
    }


    public void deleteById(Long id) {
        this.vendaRepository.deleteById(id);
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public void iniciaVendaItem(Produto produto, double qtdeProdutoValue, double parseDouble,
                                double valorUnProduto, double valorAc, double valoDesc, double valorTotal) {
        VendaItem vendaItem = new VendaItem();

        getVenda().setItemList(Arrays.asList(new VendaItem(produto, qtdeProdutoValue,
                valorUnProduto, valorAc,
                valoDesc, valorTotal, venda)));

        this.vendaItemRepository.save(vendaItem);

    }
}
