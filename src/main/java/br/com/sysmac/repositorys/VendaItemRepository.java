package br.com.sysmac.repositorys;

import br.com.sysmac.entitys.VendaItem;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaItemRepository extends JpaRepositoryImplementation<VendaItem, Long> {
}
