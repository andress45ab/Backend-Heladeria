package com.Heladeria_Ojari_Back.backend_heladeria.DTO;

import com.Heladeria_Ojari_Back.backend_heladeria.model.Pedido;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

/**
 * DTO para recibir la orden de compra (pedido) desde el frontend.
 * Incluye el id del cliente (o se puede tomar del usuario autenticado)
 * y la lista de items a comprar (producto y cantidad).
 */
public class PedidoRequestDTO {

    @NotNull(message = "El ID del cliente no puede ser nulo")
    private Long clienteId; // Si trabajas con autenticación, este campo podría omitirse y obtenerse del contexto

    @Valid
    @NotEmpty(message = "Debe haber al menos un producto en el pedido")
    private List<ItemPedidoRequestDTO> items;

    public PedidoRequestDTO() { }

    public PedidoRequestDTO(Long clienteId, List<ItemPedidoRequestDTO> items) {
        this.clienteId = clienteId;
        this.items = items;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public List<ItemPedidoRequestDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemPedidoRequestDTO> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "PedidoRequestDTO{" +
                "clienteId=" + clienteId +
                ", items=" + items +
                '}';
    }
}