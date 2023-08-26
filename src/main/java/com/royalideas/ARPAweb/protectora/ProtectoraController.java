package com.royalideas.ARPAweb.protectora;

import com.royalideas.ARPAweb.personas.Encargado;
import com.royalideas.ARPAweb.personas.PersonaService;
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
public class ProtectoraController {

    @Autowired
    ProtectoraService protectoraService;

    @Autowired
    CapacidadRepository capacidadRepository;
    
    @Autowired
    PersonaService personaService;
    

    @PostMapping("nuevaprotectora")
    public ResponseEntity<?> crearProtectora(@RequestBody @Valid Protectora protectora) {
        Map<String, Object> respuesta = new LinkedHashMap<>();
        respuesta.put("Hora de registro", new Date());
        
        if (protectoraService.existsByMail(protectora)) {
            respuesta.put("mensaje", "Ya existe una protectora registrada con ese mail");
            return new ResponseEntity(respuesta, HttpStatus.BAD_REQUEST);
        }
        
        Capacidad capacidad = new Capacidad();
        capacidad.setCapTotal(protectora.getCapacidad().getCapTotal());
        capacidad.setCapacidadid(protectora.getCapacidad().getCapTotal());
        capacidad.setOcupado(false);
        capacidad = capacidadRepository.save(capacidad);
        protectora.setCapacidad(capacidad);
        protectoraService.crearProtectora(protectora);
        
        Encargado encargado = protectora.getEncargado();
        encargado.setProtectora(protectora);
        personaService.agregarPersona(encargado);
        
        respuesta.put("mensaje", "Protectora registrado con exito");
        return new ResponseEntity(respuesta, HttpStatus.OK);
    }

    @GetMapping("protectoras")
    public ResponseEntity<?> listarProtectoras() {
        return new ResponseEntity(protectoraService.listarProtectoras(), HttpStatus.OK);
    }

    @GetMapping("protectora")
    public ResponseEntity<?> verProtectora(@RequestParam String mail) {
        return new ResponseEntity(protectoraService.buscarPorMail(mail), HttpStatus.OK);
    }

    @DeleteMapping("protectora/eliminar/{id}")
    public String deleteProtectora(@PathVariable Integer id) {
        if (!protectoraService.existeById(id)) {
            return "No existe la protectora a eliminar";
        }

        protectoraService.borrarProtectora(id);
        return "La protectora fue eliminada correctamente";
    }
    
    @PostMapping("modificaprotectora")
    public ResponseEntity<?> modificar(@RequestBody @Valid Protectora protectora) {
        Map<String, Object> respuesta = new LinkedHashMap<>();
        System.out.println(protectora.getCapacidad().getCapacidadid());
        capacidadRepository.save(protectora.getCapacidad());
        respuesta.put("Hora de registro", new Date());
        protectoraService.crearProtectora(protectora);
        respuesta.put("mensaje", "Protectora registrado con exito");
        return new ResponseEntity(respuesta, HttpStatus.OK);
    }
    
    @GetMapping("protectora/ciudad")
    public ResponseEntity<?> protectorasPorCiudad(@RequestParam String ciudad) {
        return new ResponseEntity(protectoraService.buscarPorCiudad(ciudad), HttpStatus.OK);
    }
    
    @GetMapping("protectora/nombre")
    public ResponseEntity<?> protectoraPorNombres(@RequestParam String nombre) {
        return new ResponseEntity(protectoraService.buscarPorNombres(nombre), HttpStatus.OK);
    }
}
