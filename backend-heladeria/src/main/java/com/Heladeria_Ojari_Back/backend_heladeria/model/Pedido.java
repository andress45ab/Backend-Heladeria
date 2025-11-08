package com.Heladeria_Ojari_Back.backend_heladeria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedidos") // nombre tabla

public class Pedido{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    //cliente que hizo el pedido
    @NotNull(message="El cliente no puede ser nulo")
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cliente_id",nullable=false)
    private Cliente cliente;

    //fecha y hora del pedido

    @Column(nullable=false)
    private LocalDateTime fechaPedido;

    //Que cosas tiene el pedido
    // - mappedBy = "pedido" → indica que PedidoItem tiene el campo "pedido"
    // - cascade = ALL → si borras el pedido, se borran sus items
    // - orphanRemoval → si quitas un item de la lista, se borra

    @OneToMany(mappedBy="pedido",cascade=CascadeType.ALL,orphanRemoval=true)
    private List<Recibo> recibos=new ArrayList<>();

    //Total del pedido(aqui sumamos subtotales)

    @NotNull(message="El total no puede ser nulo")
    @Column(nullable=false,precision=10,scale=2)
    private BigDecimal total;

    //Estado del Pedido(pues para que el cliente no le de imapciencia)
    @NotNull(message="El estado no puede ser nulo")
    @Enumerated(EnumType.STRING)
    @Column(nullable=false)
    private Estado estado;

    //constructor vacio que requiere JPA
    public Pedido() {
    }

    //constructor completo
    public Pedido(Cliente cliente, LocalDateTime fechaPedido, BigDecimal total, Estado estado) {
        this.cliente = cliente;
        this.fechaPedido = fechaPedido;
        this.total = total;
        this.estado = estado;
    }

    //metodos que nos facilitan el manejo de los recibos dentro del pedido

    public void agregarRecibo(Recibo recibo){
        recibos.add(recibo);
        recibo.setPedido(this);
        calcularTotal();
    }

    public void eliminarRecibo(Recibo recibo){
        recibos.remove(recibo);
        recibo.setPedido(null);
        calcularTotal();
    }

    //para calcular total del pedido

    public void calcularTotal(){
        this.total=recibos.stream()
        .map(Recibo::getSubtotal)
        .reduce(BigDecimal.ZERO,BigDecimal::add);
    }
  //getters
    public Long getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public List<Recibo> getRecibos() {
        return recibos;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public Estado getEstado() {
        return estado;
    }
    //setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setFechaPedido(LocalDateTime fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public void setRecibos(List<Recibo> recibos) {
        this.recibos = recibos;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
   
    
}