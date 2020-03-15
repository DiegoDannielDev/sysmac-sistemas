package br.com.sysmac.repositorys;

import br.com.sysmac.entitys.ContasAReceber;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasAReceberRepository extends JpaRepositoryImplementation<ContasAReceber, Long> {
}
