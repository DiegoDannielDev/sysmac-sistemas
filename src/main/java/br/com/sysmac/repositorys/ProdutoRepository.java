package br.com.sysmac.repositorys;

import br.com.sysmac.entitys.Produto;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepositoryImplementation<Produto, Long> {
}
