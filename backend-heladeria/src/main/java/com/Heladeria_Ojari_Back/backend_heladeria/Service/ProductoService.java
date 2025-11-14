package com.Heladeria_Ojari_Back.backend_heladeria.Service;

import com.Heladeria_Ojari_Back.backend_heladeria.Repository.ProductoRepository;
import com.Heladeria_Ojari_Back.backend_heladeria.DTO.ProductoDTO;
import com.Heladeria_Ojari_Back.backend_heladeria.model.Producto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Transactional
    public ProductoDTO guardarProducto(ProductoDTO dto) {
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setPrecio(dto.getPrecio());
        producto.setDescripcion(dto.getDescripcion());
        producto.setImagenUrl(dto.getImagenUrl());
        Producto guardado = productoRepository.save(producto);
        return ProductoDTO.fromEntity(guardado);
    }

    @Transactional
    public List<ProductoDTO> guardarTodos(List<ProductoDTO> dtos) {
        List<Producto> entidades = dtos.stream().map(dto -> {
            Producto p = new Producto();
            p.setNombre(dto.getNombre());
            p.setPrecio(dto.getPrecio());
            p.setDescripcion(dto.getDescripcion());
            p.setImagenUrl(dto.getImagenUrl());
            return p;
        }).collect(Collectors.toList());
        List<Producto> guardados = productoRepository.saveAll(entidades);
        return guardados.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProductoDTO obtenerPorId(Long id) {
        Producto producto = productoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + id));
        return mapToDTO(producto);
    }

    @Transactional(readOnly = true)
    public List<ProductoDTO> obtenerTodos() {
        return productoRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Transactional
    public void eliminarProducto(Long id) {
        if (!productoRepository.existsById(id)) {
            throw new IllegalArgumentException("Producto no encontrado con ID: " + id);
        }
        productoRepository.deleteById(id);
    }

    private ProductoDTO mapToDTO(Producto producto) {
        return new ProductoDTO(
                producto.getId(),
                producto.getNombre(),
                producto.getPrecio(),
                producto.getDescripcion(),
                producto.getImagenUrl()
        );
    }
}
