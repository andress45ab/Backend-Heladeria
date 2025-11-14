package com.Heladeria_Ojari_Back.backend_heladeria.DTO;

import java.math.BigDecimal;
import com.Heladeria_Ojari_Back.backend_heladeria.model.Producto;

//Esto va a serpara devolver los productos que queramos al
// front en vez de devolver todo el objeto producto

public class ProductoDTO{
    private Long id;
    private String nombre;
    private BigDecimal precio;
    private String descripcion;
    private String imagenUrl;

    public ProductoDTO(){

    }

    //Contructor lleno

    public ProductoDTO(Long id, String nombre, BigDecimal precio, String descripcion, String imagenUrl) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.imagenUrl = imagenUrl;
    }

    /*Helper para Mapear desde la entidad producto al DTO
     * 
     */
    public static ProductoDTO fromEntity(Producto producto){
        if (producto == null) return null;
        return new ProductoDTO(
            producto.getId(),
            producto.getNombre(),
            producto.getPrecio(),
            producto.getDescripcion(),
            producto.getImagenUrl()
        );
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
    
    /*Luego vamos con el Override y ek
     * toString
     */
    
    @Override
    public String toString(){
        return "ProductoDTO{" +
               "id=" + id +
               ", nombre='" + nombre + '\'' +
               ", precio=" + precio +
               ", descripcion='" + descripcion + '\'' +
               ", imagenUrl='" + imagenUrl + '\'' +
               '}';
    }
    
}