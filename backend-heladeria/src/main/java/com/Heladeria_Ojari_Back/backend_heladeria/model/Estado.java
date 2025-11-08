package com.Heladeria_Ojari_Back.backend_heladeria.model;

public enum Estado {
    PENDIENTE,          // Recién creado
    EN_PREPARACION,     // Están preparando el pedido
    LISTO,             // Listo para entregar/recoger
    ENTREGADO,         // Ya entregado al cliente
    CANCELADO          // Pedido cancelado
}