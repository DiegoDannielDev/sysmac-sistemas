package br.com.sysmac.repositorys;

import br.com.sysmac.entitys.Cliente;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepositoryImplementation<Cliente, Long> {
}
