package br.com.sysmac.repositorys;

import br.com.sysmac.entitys.VendaItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface VendaItemRepository extends JpaRepository<VendaItem, Long> {

	@Transactional
	@Modifying
	@Query(value = "DELETE FROM venda_item vi WHERE vi.id_produto =:id_produto and vi.id_venda =:idVenda", nativeQuery = true)
	void deleteVendaItemByByItem(@Param("id_produto") Long id_produto, @Param("idVenda") Long idVenda);

}
