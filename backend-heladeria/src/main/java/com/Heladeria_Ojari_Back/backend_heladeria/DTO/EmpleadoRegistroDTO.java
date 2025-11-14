package com.Heladeria_Ojari_Back.backend_heladeria.DTO;


import com.Heladeria_Ojari_Back.backend_heladeria.model.Empleado;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EmpleadoRegistroDTO {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 80)
    private String nombre;

    public EmpleadoRegistroDTO() {}

    public EmpleadoRegistroDTO(String nombre) {
        this.nombre = nombre;
    }

    public Empleado toEmpleadoEntity() {
        Empleado e = new Empleado();
        e.setNombre(this.nombre);
        return e;
    }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    @Override
    public String toString() {
        return "EmpleadoRegistroDTO{ nombre='" + nombre + "' }";
    }
} 

