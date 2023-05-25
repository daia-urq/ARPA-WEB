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
public class HistoriaService {
    @Autowired
    HistoriaRepository historiaRepository;
    
    @Transactional
    public HistoriaClinica crearHistoria(HistoriaClinica historia){
        return historiaRepository.save(historia);
    }
    
    public Optional<HistoriaClinica> buscarHistoria(Integer id){
        Optional<HistoriaClinica> historiaClinica = historiaRepository.findById(id);
        return historiaClinica;
    }
    
    public List<HistoriaClinica> listarHistorias(){
        List<HistoriaClinica> historias =  historiaRepository.findAll();
        return historias;
    }
    
    @Transactional
    public void borrarHistoria(Integer id){
        historiaRepository.deleteById(id);               
    }
    
    public boolean existeHistoria(HistoriaClinica historia){
        return historiaRepository.existsById(historia.getHistoriaClinicaid());
    }
    
    public boolean existeById(Integer id){
        return historiaRepository.existsById(id);
    }
    
    
}
