package com.Heladeria_Ojari_Back.backend_heladeria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

@Entity
@Table(name = "productos") // nombre tabla

public class Producto{
     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Long id;
    
   //todo esto es para que no haya nada nulo
   //y todo este organizaco dentro del producto
   @NotBlank(message="No puede haber un nombre de producto Vacio")
   @Size(min=2,max=200,message="debe tener entre 100 y 200 caracteres")
   @Column(nullable=false,length=200)
   private String nombre;

    @NotNull(message="El precio no puede ser nulo")
    @Column(nullable=false,precision=10,scale=2)
    private BigDecimal precio;

    @Size(max=500,message="La descripcion no puede tener mas de 500 caracteres"
    )
    @Column(length=500)
    private String descripcion;

    @Column(length=800)
    private String imagenUrl;

    //constructor vacio que requiere JPA
    public Producto() {
    }

    //aqui hacemos un pequeño constructor lleno para 
    //facilitar la creacion de productos
    public Producto(String nombre, BigDecimal precio, String descripcion, String imagenUrl) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.imagenUrl = imagenUrl;
    }
    //getters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }
    //setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }
}
