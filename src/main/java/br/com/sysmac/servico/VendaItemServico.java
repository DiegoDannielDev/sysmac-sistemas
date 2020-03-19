package br.com.sysmac.servico;

import br.com.sysmac.entitys.Produto;
import br.com.sysmac.entitys.Venda;
import br.com.sysmac.entitys.VendaItem;
import br.com.sysmac.repositorys.VendaItemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.swing.*;

@Service
public class VendaItemServico {

	private static final Logger LOGGER = LoggerFactory.getLogger(VendaItemServico.class);
	private VendaItemRepository vendaItemRepository;
	private VendaItem vendaItem;
	private Long idVenda;

	public VendaItemServico(VendaItemRepository vendaItemRepository) {
		this.vendaItemRepository = vendaItemRepository;

	}

	public void insertVendaItem(Produto produto, double qtdeVendida,
								double valorUnProduto, double valorAcrescimo,
								double valorDesconto, Venda vendas) {
		try {
			vendaItem = new VendaItem(
					produto,
					qtdeVendida,
					produto.getValorUn(),
					valorAcrescimo,
					valorDesconto,
					vendas);
			JOptionPane.showMessageDialog(null, "Item inserido");
			this.vendaItemRepository.save(vendaItem);
			idVenda = vendas.getId();

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

	}


	public void deleteProdutoById(Long idProduto) {

		this.vendaItemRepository.deleteVendaItemByByItem(idProduto, this.idVenda);
	}

}
