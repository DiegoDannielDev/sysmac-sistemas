package br.com.sysmac.servico;

import br.com.sysmac.entitys.Produto;
import br.com.sysmac.entitys.Venda;
import br.com.sysmac.repositorys.ClienteRepository;
import br.com.sysmac.repositorys.ProdutoRepository;
import br.com.sysmac.repositorys.VendaItemRepository;
import br.com.sysmac.repositorys.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;


public class VendaItemServico {

    private Venda venda = new Venda();
    private ClienteRepository clienteRepository;
    private ProdutoRepository produtoRepository;
    private VendaItemRepository vendaItemRepository;
    private VendaRepository vendaRepository;
    private VendaService vendaService;
    Produto produto = new Produto();

    @Autowired
    public VendaItemServico(ClienteRepository clienteRepository,
                            ProdutoRepository produtoRepository,
                            VendaItemRepository vendaItemRepository,
                            VendaRepository vendaRepository,
                            VendaService vendaService) {
        this.clienteRepository = clienteRepository;
        this.produtoRepository = produtoRepository;
        this.vendaItemRepository = vendaItemRepository;
        this.vendaRepository = vendaRepository;
        this.vendaService = vendaService;
    }


//    public Venda venda(String tipo) {
//        venda.setTipo(tipo);
//        venda = this.vendaService.iniciaCodigoVenda(venda);
//        return venda;
//    }
//
//    public VendaItem iniciaVendaItem() {
//        vendaService.iniciaCodigoVenda(new Venda());
//        VendaItem vendaItem = new VendaItem();
//        venda.setItemList(Arrays.asList(new VendaItem(produto, 12,
//                12.2, 0,
//                0, 12.2, venda)));
//        this.vendaItemRepository.save(vendaItem);
//        return vendaItem;
//    }
//
//
//    public void deleteByVendaId(Long id) {
//        this.vendaService.deleteById(id);
//    }
//
//
//    public Cliente getCliente(Long id) {
//        Optional<Cliente> optional = this.clienteRepository.findById(id);
//        return optional.get();
//    }
//
//    public Produto getProdutos(Long id) {
//        Optional<Produto> produto = this.produtoRepository.findById(id);
//        return produto.get();
//    }
}
