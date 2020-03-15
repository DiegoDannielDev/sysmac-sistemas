package br.com.sysmac.repositorys;

import br.com.sysmac.entitys.Venda;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepositoryImplementation<Venda, Long> {
}
