package com.royalideas.ARPAweb.protectora;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Daia
 */
@Repository
public interface CapacidadRepository extends JpaRepository<Capacidad, Integer>{
    
}
