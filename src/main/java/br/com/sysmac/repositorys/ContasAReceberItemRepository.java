package br.com.sysmac.repositorys;

import br.com.sysmac.entitys.ContasAReceberItem;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasAReceberItemRepository extends JpaRepositoryImplementation<ContasAReceberItem, Long> {
}
