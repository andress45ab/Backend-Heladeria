package com.Heladeria_Ojari_Back.backend_heladeria.Repository;


import com.Heladeria_Ojari_Back.backend_heladeria.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long>{
    
}
