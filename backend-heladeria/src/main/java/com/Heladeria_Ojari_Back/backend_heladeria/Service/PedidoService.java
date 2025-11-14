package com.Heladeria_Ojari_Back.backend_heladeria.Service;

import com.Heladeria_Ojari_Back.backend_heladeria.Repository.ClienteRepository;
import com.Heladeria_Ojari_Back.backend_heladeria.Repository.PedidoRepository;
import com.Heladeria_Ojari_Back.backend_heladeria.Repository.ProductoRepository;
import com.Heladeria_Ojari_Back.backend_heladeria.DTO.PedidoRequestDTO;
import com.Heladeria_Ojari_Back.backend_heladeria.DTO.PedidoResponseDTO;
import com.Heladeria_Ojari_Back.backend_heladeria.DTO.ItemPedidoRequestDTO;
import com.Heladeria_Ojari_Back.backend_heladeria.model.Cliente;
import com.Heladeria_Ojari_Back.backend_heladeria.model.Pedido;
import com.Heladeria_Ojari_Back.backend_heladeria.model.Producto;
import com.Heladeria_Ojari_Back.backend_heladeria.model.Recibo;
import com.Heladeria_Ojari_Back.backend_heladeria.model.Estado;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final ProductoRepository productoRepository;

    public PedidoService(PedidoRepository pedidoRepository,
                         ClienteRepository clienteRepository,
                         ProductoRepository productoRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.productoRepository = productoRepository;
    }

    @Transactional
    public PedidoResponseDTO crearPedido(PedidoRequestDTO pedidoRequest) {
        Cliente cliente = clienteRepository.findById(pedidoRequest.getClienteId())
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con ID: " + pedidoRequest.getClienteId()));

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setEstado(Estado.PENDIENTE);
        pedido.setFechaPedido(LocalDateTime.now());

        for (ItemPedidoRequestDTO item : pedidoRequest.getItems()) {
            Producto producto = productoRepository.findById(item.getProductoId())
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + item.getProductoId()));
            Recibo recibo = new Recibo(pedido, producto, item.getCantidad());
            recibo.setPedido(pedido);
            pedido.agregarRecibo(recibo);
        }

        pedido.calcularTotal();
        Pedido guardado = pedidoRepository.save(pedido);
        return PedidoResponseDTO.fromEntity(guardado);
    }

    @Transactional(readOnly = true)
    public PedidoResponseDTO obtenerPedido(Long id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pedido no encontrado con ID: " + id));
        return PedidoResponseDTO.fromEntity(pedido);
    }
}