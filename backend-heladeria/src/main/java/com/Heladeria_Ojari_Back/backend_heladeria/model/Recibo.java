package com.Heladeria_Ojari_Back.backend_heladeria.model;

//importaciones importantes

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "recibos") // nombre tabla

public class Recibo{
    //Id unico en cada pedido

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    //que pedido se esta facturando
    @NotNull(message="El pedido no puede ser nulo")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="pedido_id",nullable=false)
    private Pedido pedido;

    //que producto se esta comprando
    @NotNull(message="El producto no puede ser nulo")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="producto_id",nullable=false)
    private Producto producto;

    //cantidad de producto que se compra

    @Min(value=1,message="La cantidad minima es 1"
    )
    @Column(nullable=false)
    private int cantidad;

    //precio al momento de la compra
    //esto se guarda para historial

    @NotNull(message="El precio no puede ser nulo")
    @Column(nullable=false,precision=10,scale=2)
    private BigDecimal precioUnit;

    //constructor vacio que requiere JPA
    public Recibo() {
    }

    //Un constructor para dejarme de dolores de
    //cabeza al crear recibos 
    //cuando creo un item captura el precio actual del producto

    public Recibo(Pedido pedido, Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        //esto es lo que captura el precio actual
        this.precioUnit = producto.getPrecio();


    }
     
    //aqui dejo esto para calcular el subtotal de un produto
    public BigDecimal getSubtotal(){
        return precioUnit.multiply(BigDecimal.valueOf(cantidad));
    }
    //getters
    public Long getId() {
        return id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public BigDecimal getPrecioUnit() {
        return precioUnit;
    }
    //setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecioUnit(BigDecimal precioUnit) {
        this.precioUnit = precioUnit;
    }
     
} 