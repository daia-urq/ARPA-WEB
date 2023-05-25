package com.royalideas.ARPAweb.protectora;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Daia
 */
@RestController
@RequestMapping("/")
public class HistoriaController {
    @Autowired
    HistoriaService historiaService;
    
    @PostMapping("nuevahistoria")
    public ResponseEntity<?> crearHistoria(@RequestBody @Valid HistoriaClinica historia){
          Map<String, Object> respuesta = new LinkedHashMap<>();
          
          if(historiaService.existeHistoria(historia)){
              respuesta.put("mensaje","La histora clinica ya existe");
              return new ResponseEntity(respuesta, HttpStatus.OK);
          }
          
          historiaService.crearHistoria(historia);
          respuesta.put("mensaje", "La historia clinica se guardo con exito");
          return new ResponseEntity(respuesta, HttpStatus.OK);
    }
    
    @GetMapping("historias")
    public ResponseEntity<?> listarHistorias(){
        return new ResponseEntity(historiaService.listarHistorias(), HttpStatus.OK);
    }
    
    @GetMapping("historia")
    public ResponseEntity<?> verHistoria(@RequestParam Integer id){
        return new ResponseEntity(historiaService.buscarHistoria(id), HttpStatus.OK);
    }
    
    @DeleteMapping("historia/eliminar/{id}")
    public String deleteHistoria(@PathVariable Integer id){
        if(!historiaService.existeById(id)){
            return "No existe la historia clinica a eliminar";
        }
        
        historiaService.borrarHistoria(id);
        return "La historia clinica fue eliminada correctamente";
    }
    
}
