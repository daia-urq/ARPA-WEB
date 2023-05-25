package com.royalideas.ARPAweb.protectora;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Daia
 */
@Repository
public interface ProtectoraRepository extends JpaRepository<Protectora, Integer> {

    public boolean existsByMail(String mail);

    public Protectora findByMail(String mail);
    
    public Protectora findByNombre(String nombre);
    
    public List<Protectora> findDistinctProtectoraByNombre(String nombre);
     
    public List<Protectora> findByCiudad(String ciudad);    
    
}
