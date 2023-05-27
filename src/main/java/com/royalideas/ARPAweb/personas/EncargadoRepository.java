package com.royalideas.ARPAweb.personas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author daiau
 */
@Repository
public interface EncargadoRepository extends JpaRepository<Encargado, Integer>{
    
    public Encargado findById(int id);
    
    public Encargado findByMail(String email);
    
    public Encargado findByDni(int dni);
    
    public boolean existsById(int id);
    
    public boolean existsByMail(String email);

    public boolean existsByDni(int dni);
    
    
}
