package br.com.sysmac.servico;

import br.com.sysmac.entitys.Produto;
import br.com.sysmac.repositorys.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {


    private ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
        saveProduto();
    }

    public void saveProduto() {
        List<Produto> produtoList = new ArrayList<>();
        produtoList.add(new Produto("Macarrão", 2.50));
        produtoList.add(new Produto("Feijão", 10.50));
        produtoList.add(new Produto("Arroz", 25.5));
        produtoList.add(new Produto("Leite", 12.0));
        this.produtoRepository.saveAll(produtoList);
    }

    public Optional<Produto> getProduto(Long id) {
        Optional<Produto> produto = this.produtoRepository.findById(id);
        return produto;
    }
}
