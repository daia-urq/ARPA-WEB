package com.royalideas.ARPAweb.protectora;

import java.util.LinkedHashMap;
import java.util.Map;
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
public class InsumoController {
    @Autowired
    InsumoService insumoService;
    
    @PostMapping("nuevoinsumo")
    public ResponseEntity<?> crearInsumo(@RequestBody Insumo insumo){
        Map<String, Object> respuesta = new LinkedHashMap<>();
        if(insumoService.existeById(insumo.getInsumoid())){
            respuesta.put("mensaje", "Ya existe el insumo");
            return new ResponseEntity(respuesta, HttpStatus.OK);
        }        
        insumoService.crearInsumo(insumo);
        respuesta.put("mensaje","Insumo registrado con exito");
        return new ResponseEntity(respuesta, HttpStatus.OK);
    }
    
    @GetMapping("insumos")
    public ResponseEntity<?> listarInsumos(){
        return new ResponseEntity(insumoService.listarInsumos(), HttpStatus.OK);
    }
    
    @GetMapping("insumo")
    public ResponseEntity<?> verInsumo(@RequestParam Integer id){
        return new ResponseEntity(insumoService.buscarInsumo(id), HttpStatus.OK);
    }
    
    @DeleteMapping("insumo/eliminar/{id}")
    public String deleteInsumo(@PathVariable Integer id){
        if(!insumoService.existeById(id)){
            return "No existe el insumo a eliminar";
        }
        
        insumoService.borrarInsumo(id);
        return "Insumo eliminado correctamente";
    }
}
