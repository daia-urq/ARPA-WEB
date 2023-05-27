package com.royalideas.ARPAweb.personas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author daiau
 */
@Service
public class EncargadoService {
    
    @Autowired
    EncargadoRepository encargadoRepository;
    
    public Encargado findById(int id){
        return encargadoRepository.findById(id);    
    }
    
    public Encargado findByMail(String email){
        return encargadoRepository.findByMail(email);
    }
    
    public boolean existsById(int id){
        return encargadoRepository.existsById(id);
    }    
    
    public boolean existsByMail(String email){
        return encargadoRepository.existsByMail(email);
    }
    
    public boolean existsbyDni(int dni){
        return encargadoRepository.existsByDni(dni);
    }
    
    public Encargado findByDni(int dni){
        return encargadoRepository.findByDni(dni);
    }
}
