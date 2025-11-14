// c:\Users\A.Suarez\OneDrive\Documents\Proyecto Back\Backend-Heladeria\backend-heladeria\src\main\java\com\Heladeria_Ojari_Back\backend_heladeria\DTO\EmpleadoResponseDTO.java
package com.Heladeria_Ojari_Back.backend_heladeria.DTO;

import com.Heladeria_Ojari_Back.backend_heladeria.model.Empleado;

public class EmpleadoResponseDTO {
    private Long id;
    private String nombre;

    public EmpleadoResponseDTO() {}

    public EmpleadoResponseDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public static EmpleadoResponseDTO fromEntity(Empleado empleado) {
        if (empleado == null) return null;
        return new EmpleadoResponseDTO(empleado.getId(), empleado.getNombre());
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}