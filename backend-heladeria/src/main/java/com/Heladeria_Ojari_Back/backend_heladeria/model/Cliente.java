package com.Heladeria_Ojari_Back.backend_heladeria.model;
//importamos lo que necesito para crear esta entidad

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "clientes")//nombre tabla
public class Cliente{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    //aqui van los atributos del cliente

    private long id;

    //Validadores de vacio y longitud pendientes
    @NotBlank(message = "El nombre no puede estar vacío.")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres.")
    private String nombre;

    @Size(max = 50, message = "El apellido no debe exceder los 50 caracteres.")

    private String apellido;
    

    @Size(max = 20, message = "El teléfono no debe exceder los 20 caracteres.")

    private String telefono;


    @Size(max = 255, message = "La dirección no debe exceder los 255 caracteres.")

    private String direccion;

    //constructor vacio que requiere JPA
    public Cliente() {
    }
    //getters

    public long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    //setters

    public void setId(long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
