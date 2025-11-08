package com.Heladeria_Ojari_Back.backend_heladeria.Repository;

import com.Heladeria_Ojari_Back.backend_heladeria.model.Pedido;
import com.Heladeria_Ojari_Back.backend_heladeria.model.Estado;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
     // Listado paginado de pedidos de un cliente (más usado para "Mis pedidos")
    Page<Pedido> findByClienteIdOrderByFechaPedidoDesc(Long clienteId, Pageable pageable);

    // Listado paginado filtrando por estado
    Page<Pedido> findByClienteIdAndEstadoOrderByFechaPedidoDesc(Long clienteId, Estado estado, Pageable pageable);

    // Listado no paginado (todo) de un cliente
    List<Pedido> findByClienteIdOrderByFechaPedidoDesc(Long clienteId);

    // Rango por fecha (útil para reportes)
    List<Pedido> findByFechaPedidoBetween(LocalDateTime inicio, LocalDateTime fin);

    // Detalle de un pedido con sus recibos y productos (ideal para ver un pedido concreto)
    @Query("""
           select p
           from Pedido p
           left join fetch p.recibos r
           left join fetch r.producto prod
           where p.id = :id
           """)
    Optional<Pedido> findDetalleById(@Param("id") Long id);
}
