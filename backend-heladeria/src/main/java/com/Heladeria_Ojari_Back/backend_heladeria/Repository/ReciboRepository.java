package com.Heladeria_Ojari_Back.backend_heladeria.Repository;

import com.Heladeria_Ojari_Back.backend_heladeria.model.Recibo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ReciboRepository extends JpaRepository<Recibo,Long>{
    
}