package com.royalideas.ARPAweb.animales;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Daia
 */
@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
   
    public Animal findByNombre(String nombre);      

    public List<Animal> findDistinctAnimalByNombre(String nombre);
    
    public List<Animal> findByCastrado(Boolean castrado);
    
    public List<Animal> findByTipo(String tipo);
    
    public List<Perro> findByTamano(String tamano);
    
    public List<Animal> findByRaza(String raza);
    
    public List<Animal> findByGenero(String genero);
    
//   @Query("SELECT * FROM animal a  INNER JOIN protectora c ON a.protectoraid = c.protectoraid WHERE c.ciudad = :ciudad")
 // public List<Animal> buscarPorCiudad(@Param("ciudad") String ciudad); 
}
