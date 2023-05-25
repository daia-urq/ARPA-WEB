package com.royalideas.ARPAweb.protectora;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Daia
 */
@Service
public class CapacidadService {
    @Autowired
    CapacidadRepository capacidadRepository;
    
    @Transactional
    public Capacidad crearCapacidad(Capacidad capacidad){
        return capacidadRepository.save(capacidad);
    }
    
    public Optional<Capacidad> buscarCapacidad(Integer id){
        Optional<Capacidad> capacidad = capacidadRepository.findById(id);
        return capacidad;
    }
    
    public List<Capacidad> listarCapacidad(){
        List<Capacidad> capacidades = capacidadRepository.findAll();
        return capacidades;
    }
    
    @Transactional
    public void borrarCapacidad(Integer id) {
        capacidadRepository.deleteById(id);
    }
        
    public boolean existeById(Integer id){
        return capacidadRepository.existsById(id);
    }
}
