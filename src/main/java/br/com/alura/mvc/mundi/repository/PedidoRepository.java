package br.com.alura.mvc.mundi.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.alura.mvc.mundi.model.Pedido;
import br.com.alura.mvc.mundi.model.StatusPedido;

//@Repository
//public class PedidoRepository {
//	
//	@PersistenceContext
//	private EntityManager entityManager;
//	
//	public List<Pedido> recuperaTodosOsPedidos(){
//		Query query = entityManager.createQuery("select p from Pedido p", Pedido.class);
//		return query.getResultList();
//	}
//}

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
	@Cacheable("pedidos")
	List<Pedido> findByStatus(StatusPedido status, Pageable sort);

	@Query("select p from Pedido p join p.user u where u.username = :username")
	List<Pedido> findAllByUsuario(@Param("username") String username);

	@Query("select p from Pedido p join p.user u where u.username = :username and p.status = :status")
	List<Pedido> findByStatusAndUsuario(StatusPedido status, @Param("username") String username); 
	
}
