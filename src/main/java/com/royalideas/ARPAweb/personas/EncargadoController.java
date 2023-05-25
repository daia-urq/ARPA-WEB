package com.royalideas.ARPAweb.personas;

import com.royalideas.ARPAweb.animales.AnimalService;
import com.royalideas.ARPAweb.animales.Perro;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mis_p
 */
@RestController
@RequestMapping("/")
public class EncargadoController {

    @Autowired
    AnimalService animalServicio;
    @Autowired
    PersonaService personaService;

    @PostMapping("asignarMascota/{id}")
    public ResponseEntity<?> asignarMascota(@RequestBody @Valid Perro animal, Integer id) {
        Map<String, Object> respuesta = new LinkedHashMap<>();

        Adoptante adoptante = (Adoptante) personaService.buscaPersona(id);
        animal.setAdoptante(adoptante);

        animalServicio.guardarAnimal(animal);
        respuesta.put("mensaje", "Animal adoptado con exito");
        return new ResponseEntity(respuesta, HttpStatus.OK);
    }

    public void aceptarEmpleado() {

    }

    public void aceptarTransito() {

    }

    public void agregarAdoptante() {

    }

}
