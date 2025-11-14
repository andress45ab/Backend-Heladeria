package com.Heladeria_Ojari_Back.backend_heladeria.Service;

import com.Heladeria_Ojari_Back.backend_heladeria.Repository.ClienteRepository;
import com.Heladeria_Ojari_Back.backend_heladeria.DTO.ClienteRegistroDTO;
import com.Heladeria_Ojari_Back.backend_heladeria.DTO.ClienteResponseDTO;
import com.Heladeria_Ojari_Back.backend_heladeria.model.Cliente;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Transactional
    public ClienteResponseDTO registrarCliente(ClienteRegistroDTO registroDTO) {
        Cliente cliente = registroDTO.toClienteEntity();
        Cliente guardado = clienteRepository.save(cliente);
        return ClienteResponseDTO.fromEntity(guardado);
    }

    @Transactional(readOnly = true)
    public ClienteResponseDTO obtenerPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con ID: " + id));
        return ClienteResponseDTO.fromEntity(cliente);
    }
}
