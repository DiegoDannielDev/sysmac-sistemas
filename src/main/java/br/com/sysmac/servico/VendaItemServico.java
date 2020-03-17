package br.com.sysmac.servico;

import br.com.sysmac.entitys.Produto;
import br.com.sysmac.entitys.Venda;
import br.com.sysmac.entitys.VendaItem;
import br.com.sysmac.repositorys.VendaItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.Optional;

@Service
public class VendaItemServico {

    private static final Logger LOGGER = LoggerFactory.getLogger(VendaItemServico.class);
    private VendaItemRepository vendaItemRepository;


    public VendaItemServico(VendaItemRepository vendaItemRepository) {
        this.vendaItemRepository = vendaItemRepository;

    }

    public VendaItem insertVendaItem(Optional<Produto> produto, Venda venda, double qtde) {
        try {
            VendaItem vendaItem = new VendaItem();
            vendaItem.setProduto(produto.get());
            vendaItem.setVendas(venda);
            vendaItem.setValorUnProduto(produto.get().getValorUn());
            vendaItem.setQtdeVendida(qtde);
            JOptionPane.showMessageDialog(null, "Item inserido");
            return this.vendaItemRepository.save(vendaItem);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }

    }

    public void deleteItensById(Long id) {
        this.vendaItemRepository.deleteById(id);

    }

}
