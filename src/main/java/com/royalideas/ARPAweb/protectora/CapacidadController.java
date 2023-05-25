package com.royalideas.ARPAweb.protectora;

import java.util.Date;
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
public class CapacidadController {
    @Autowired
    CapacidadService capacidadService;
    
    @PostMapping("nuevacapacidad")
    public ResponseEntity<?> crearCapacidad(@RequestBody @Valid Capacidad capacidad){
        Map<String, Object> respuesta = new LinkedHashMap<>();
        
         if(capacidadService.existeById(capacidad.getCapacidadid())){
            respuesta.put("mensaje", "Ya existe la capacidad");
            return new ResponseEntity(respuesta, HttpStatus.OK);
        }        
        capacidadService.crearCapacidad(capacidad);
        respuesta.put("mensaje","Capacidad registrada con exito");
        return new ResponseEntity(respuesta, HttpStatus.OK);
    }
    
    @GetMapping("capacidades")
    public ResponseEntity<?> listarCapacidades(){
        return new ResponseEntity(capacidadService.listarCapacidad(), HttpStatus.OK);
    }
    
    @GetMapping("capacidad")
    public ResponseEntity<?> verCapacidad(@RequestParam Integer id){
        return new ResponseEntity(capacidadService.buscarCapacidad(id), HttpStatus.OK);
    }
    
    @DeleteMapping("capacidad/eliminar/{id}")
    public String deleteCapacidad(@PathVariable Integer id){
        if(!capacidadService.existeById(id)){
            return "No existe la capacidad a eliminar";
        }
        
        capacidadService.borrarCapacidad(id);
        return "Capacidad eliminada correctamente";
    }
}
