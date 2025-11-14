package com.Heladeria_Ojari_Back.backend_heladeria.DTO;

import com.Heladeria_Ojari_Back.backend_heladeria.model.Recibo;
import com.Heladeria_Ojari_Back.backend_heladeria.model.Producto;

import java.math.BigDecimal;

/**
 * DTO que representa un ítem dentro de un pedido.
 * Ideal para devolver al frontend los detalles de cada producto pedido.
 *
 * Campos incluidos:
 * - Identificador del ítem
 * - Referencia al producto (id) + datos mínimos (nombre, imagen)
 * - Cantidad solicitada
 * - Precio unitario "congelado" al momento del pedido
 * - Subtotal (precioUnitario * cantidad)
 */
public class ItemPedidoDTO {

    private Long id;
    private Long productoId;
    private String nombreProducto;
    private String imagenProducto;
    private Integer cantidad;
    private BigDecimal precioUnit;
    private BigDecimal subtotal;

    public ItemPedidoDTO() { }

    public ItemPedidoDTO(Long id,
                         Long productoId,
                         String nombreProducto,
                         String imagenProducto,
                         Integer cantidad,
                         BigDecimal precioUnit,
                         BigDecimal subtotal) {
        this.id = id;
        this.productoId = productoId;
        this.nombreProducto = nombreProducto;
        this.imagenProducto = imagenProducto;
        this.cantidad = cantidad;
        this.precioUnit = precioUnit;
        this.subtotal = subtotal;
    }

    /**
     * Helper para mapear desde la entidad PedidoItem a este DTO.
     */
    public static ItemPedidoDTO fromEntity(Recibo recibo) {
        if (recibo == null) return null;

        Producto prod = recibo.getProducto();
        Long prodId = prod != null ? prod.getId() : null;
        String prodNombre = prod != null ? prod.getNombre() : null;
        String prodImagen = prod != null ? prod.getImagenUrl() : null;

        Integer cant = Integer.valueOf(recibo.getCantidad());
        BigDecimal unit = recibo.getPrecioUnit();
        BigDecimal sub = recibo.getSubtotal();

        return new ItemPedidoDTO(
                recibo.getId(),
                prodId,
                prodNombre,
                prodImagen,
                cant,
                unit,
                sub
        );
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getProductoId() { return productoId; }
    public void setProductoId(Long productoId) { this.productoId = productoId; }

    public String getNombreProducto() { return nombreProducto; }
    public void setNombreProducto(String nombreProducto) { this.nombreProducto = nombreProducto; }

    public String getImagenProducto() { return imagenProducto; }
    public void setImagenProducto(String imagenProducto) { this.imagenProducto = imagenProducto; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public BigDecimal getPrecioUnit() { return precioUnit; }
    public void setPrecioUnit(BigDecimal precioUnit) { this.precioUnit = precioUnit; }

    public BigDecimal getSubtotal() { return subtotal; }
    public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }

    @Override
    public String toString() {
        return "ItemPedidoDTO{" +
                "id=" + id +
                ", productoId=" + productoId +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", imagenProducto='" + imagenProducto + '\'' +
                ", cantidad=" + cantidad +
                ", precioUnit=" + precioUnit +
                ", subtotal=" + subtotal +
                '}';
    }
}