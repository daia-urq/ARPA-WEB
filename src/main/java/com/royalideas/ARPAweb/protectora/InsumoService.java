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
public class InsumoService {
    @Autowired
    InsumoRepository insumoReposiroty;
    
    @Transactional
    public Insumo crearInsumo(Insumo insumo){
        return insumoReposiroty.save(insumo);
    }
    
    public Optional<Insumo> buscarInsumo(Integer id){
        Optional<Insumo> insumo = insumoReposiroty.findById(id);
        return insumo;
    }
    
    public List<Insumo> listarInsumos(){
        List<Insumo> insumos = insumoReposiroty.findAll();
        return insumos;
    }
    
    @Transactional
    public void borrarInsumo(Integer id) {
        insumoReposiroty.deleteById(id);
    }
        
    public boolean existeById(Integer id){
        return insumoReposiroty.existsById(id);
    }
    
}
