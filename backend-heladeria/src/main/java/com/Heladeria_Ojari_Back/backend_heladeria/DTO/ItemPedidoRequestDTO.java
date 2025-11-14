// c:\Users\A.Suarez\OneDrive\Documents\Proyecto Back\Backend-Heladeria\backend-heladeria\src\main\java\com\Heladeria_Ojari_Back\backend_heladeria\DTO\ItemPedidoRequestDTO.java
package com.Heladeria_Ojari_Back.backend_heladeria.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ItemPedidoRequestDTO {
    @NotNull
    private Long productoId;

    @Min(1)
    private int cantidad;

    public ItemPedidoRequestDTO() {}

    public ItemPedidoRequestDTO(Long productoId, int cantidad) {
        this.productoId = productoId;
        this.cantidad = cantidad;
    }

    public Long getProductoId() { return productoId; }
    public void setProductoId(Long productoId) { this.productoId = productoId; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}