package com.Heladeria_Ojari_Back.backend_heladeria.DTO;
import com.Heladeria_Ojari_Back.backend_heladeria.model.Estado;
import com.Heladeria_Ojari_Back.backend_heladeria.model.Pedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * DTO para devolver detalles de un pedido ya creado y calculado al frontend.
 * Incluye la información básica del pedido, cliente, estado y los ítems del pedido.
 */
public class PedidoResponseDTO {

    private Long id;
    private Long clienteId;
    private LocalDateTime fechaPedido;
    private BigDecimal total;
    private Estado estado;
    private List<ItemPedidoDTO> items;

    public PedidoResponseDTO() {}

    public PedidoResponseDTO(Long id, Long clienteId, LocalDateTime fechaPedido, BigDecimal total, Estado estado, List<ItemPedidoDTO> items) {
        this.id = id;
        this.clienteId = clienteId;
        this.fechaPedido = fechaPedido;
        this.total = total;
        this.estado = estado;
        this.items = items;
    }

    /**
     * Helper estático para mapear desde la entidad Pedido.
     */
    public static PedidoResponseDTO fromEntity(Pedido pedido) {
        if (pedido == null) return null;

        // Mapear los recibos a ItemPedidoDTO
        List<ItemPedidoDTO> items = pedido.getRecibos()
                .stream()
                .map(ItemPedidoDTO::fromEntity)
                .collect(Collectors.toList());

        return new PedidoResponseDTO(
                pedido.getId(),
                pedido.getCliente() != null ? pedido.getCliente().getId() : null,
                pedido.getFechaPedido(),
                pedido.getTotal(),
                pedido.getEstado(),
                items
        );
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }

    public LocalDateTime getFechaPedido() { return fechaPedido; }
    public void setFechaPedido(LocalDateTime fechaPedido) { this.fechaPedido = fechaPedido; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }

    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }

    public List<ItemPedidoDTO> getItems() { return items; }
    public void setItems(List<ItemPedidoDTO> items) { this.items = items; }

    @Override
    public String toString() {
        return "PedidoResponseDTO{" +
                "id=" + id +
                ", clienteId=" + clienteId +
                ", fechaPedido=" + fechaPedido +
                ", total=" + total +
                ", estado=" + estado +
                ", items=" + items +
                '}';
    }
}