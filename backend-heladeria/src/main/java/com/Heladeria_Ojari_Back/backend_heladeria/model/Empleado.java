package com.Heladeria_Ojari_Back.backend_heladeria.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "empleados") // nombre tabla
public class Empleado{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)

    private Long id;

    @NotBlank(message = "El nombre del empleado no puede estar vacío.")
    @Size(min = 2, max = 50, message = "El nombre debe tener entre 2 y 50 caracteres.")
    private String nombre;

    //quedan pendientes los validadores de vacio y longitud

    //constructor vacio que requiere JPA

    public Empleado() {
    }
   
    //getters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
   //setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
}
