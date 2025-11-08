package com.Heladeria_Ojari_Back.backend_heladeria.Repository;

import com.Heladeria_Ojari_Back.backend_heladeria.model.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CuentaRepository extends JpaRepository<Cuenta,Long>{
     // Buscar la cuenta por el nombre de usuario (o email) para el login
    Optional<Cuenta> findByUsuario(String usuario);

    // Verificar si ya existe un usuario (útil al registrar)
    boolean existsByUsuario(String usuario);
}