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
public class ProtectoraService {
    @Autowired
    ProtectoraRepository protectoraRepository;
    
    @Transactional
    public Protectora crearProtectora(Protectora protectora){
        return protectoraRepository.save(protectora);
    }
    
    public Optional<Protectora> buscarProtectora(Integer id){
        Optional<Protectora> protectora = protectoraRepository.findById(id);
        return protectora;
    }
    
    public List<Protectora> listarProtectoras(){
        List<Protectora> protectoras = protectoraRepository.findAll();
        return protectoras;
    }
    
    @Transactional
    public void borrarProtectora(Integer id){
        protectoraRepository.deleteById(id);
    }
    
    public boolean existeProtectora(Protectora protectora){
        return protectoraRepository.existsByMail(protectora.getMail());
    }
    
    public Protectora buscarPorMail(String mail){
        return protectoraRepository.findByMail(mail);
    }
    
    public Protectora buscarPorNombre(String nombre){
        return protectoraRepository.findByNombre(nombre);
    }
    
     public List<Protectora> buscarPorNombres(String nombre){
        List<Protectora> protectoras = protectoraRepository.findDistinctProtectoraByNombre(nombre);
        return protectoras;
    }
    
    public boolean existeById(Integer id){
        return protectoraRepository.existsById(id);
    }
    
    public Protectora modificarProtectora(Protectora protectora){
        return protectoraRepository.save(protectora);
    }
    
    public List<Protectora> buscarPorCiudad(String ciudad){
        return protectoraRepository.findByCiudad(ciudad);
    }
       
}


