package com.Heladeria_Ojari_Back.backend_heladeria.Service;

import com.Heladeria_Ojari_Back.backend_heladeria.Repository.EmpleadoRepository;
import com.Heladeria_Ojari_Back.backend_heladeria.model.Empleado;
import com.Heladeria_Ojari_Back.backend_heladeria.DTO.EmpleadoResponseDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpleadoService {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    @Transactional
    public EmpleadoResponseDTO registrarEmpleado(String nombre) {
        Empleado empleado = new Empleado();
        empleado.setNombre(nombre);
        Empleado guardado = empleadoRepository.save(empleado);
        return EmpleadoResponseDTO.fromEntity(guardado);
    }

    @Transactional(readOnly = true)
    public EmpleadoResponseDTO obtenerPorId(Long id) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado con ID: " + id));
        return EmpleadoResponseDTO.fromEntity(empleado);
    }
}