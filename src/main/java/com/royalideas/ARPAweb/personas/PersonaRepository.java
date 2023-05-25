package com.royalideas.ARPAweb.personas;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author mis_p
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer> {

    public boolean existsByMail(String mail);

    public Persona findByMail(String mail);
    
    public List<Persona> findByNombre(String nombre);
}
