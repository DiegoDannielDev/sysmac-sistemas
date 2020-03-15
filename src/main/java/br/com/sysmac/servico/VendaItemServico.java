package br.com.sysmac.servico;

import br.com.sysmac.entitys.Produto;
import br.com.sysmac.entitys.Venda;
import br.com.sysmac.entitys.VendaItem;
import br.com.sysmac.entitys.dto.VendaItemDTO;
import br.com.sysmac.repositorys.VendaItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class VendaItemServico {

    private static final Logger LOGGER = LoggerFactory.getLogger(VendaItemServico.class);
    private VendaItemRepository vendaItemRepository;
    private VendaService vendaService;
    private ProdutoService produtoService;

    public VendaItemServico(VendaItemRepository vendaItemRepository,
                            VendaService vendaService, ProdutoService produtoService) {
        this.vendaItemRepository = vendaItemRepository;
        this.vendaService = vendaService;
        this.produtoService = produtoService;
    }

    public static VendaItem converteItemDto(VendaItemDTO vendaItemDTO, List<Produto> produtoList, Venda venda) {

        LOGGER.info("Convertendo VendaItemDTO em VendaItem");
        VendaItem vd = new VendaItem();
        vd.setQtdeVendida(vendaItemDTO.getQtdeVendida());
        vd.setTipoProduto(vendaItemDTO.getTipoProduto());
        vd.setValorAcrescimo(vendaItemDTO.getValorAcrescimo());
        vd.setValorDesconto(vendaItemDTO.getValorDesconto());
        vd.setValorTotalProduto(vendaItemDTO.getValorTotalProduto());
        vd.setValorUnProduto(vendaItemDTO.getValorUnProduto());
        vd.setVendas(venda);
        vd.setProdutoList(produtoList.get(0));
        return vd;

    }

    public VendaItem saveVendaItem() {
        Venda venda = this.vendaService.getVenda();
        Produto produto = produtoService.getProduto().get();


    }

}
