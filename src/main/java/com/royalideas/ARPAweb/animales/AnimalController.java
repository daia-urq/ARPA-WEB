package com.royalideas.ARPAweb.animales;

import com.royalideas.ARPAweb.protectora.ProtectoraRepository;
import java.util.LinkedHashMap;
import java.util.List;
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
public class AnimalController {

    @Autowired
    AnimalService animalservice;

    @Autowired
    ProtectoraRepository protectoraRepository;

    @Autowired
    PerroRepository perroRepository;

    @PostMapping("animal/crearperro")
    public ResponseEntity<?> crearAnimal(@RequestBody @Valid Perro animal) {
        Map<String, Object> response = new LinkedHashMap<>();
        animal.setProtectora(protectoraRepository.findByNombre(animal.getProtectora().getNombre()));
        animal = (Perro) animalservice.guardarAnimal(animal);
        response.put("mensaje", "creado con exito");
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PostMapping("animal/creargato")
    public ResponseEntity<?> crearAnimal(@RequestBody Gato animal) {
        Map<String, Object> response = new LinkedHashMap<>();
        animal.setProtectora(protectoraRepository.findByNombre(animal.getProtectora().getNombre()));
        animal = (Gato) animalservice.guardarAnimal(animal);
        response.put("mensaje", "creado con exito");
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("animales")
    public List<Animal> listarAnimales() {
        List<Animal> animales = animalservice.listarAnimales();
        return animales;
    }

    @GetMapping("animal")
    public Animal buscarAnimalID(@RequestParam Integer id) {
        Animal animal = animalservice.buscarAnimal(id).get();
        return animal;
    }

    @DeleteMapping("/animal/eliminar/{id}")
    public String deleteAnimal(@PathVariable Integer id) {
        animalservice.borrarAnimal(id);
        return "el animal fue eliminado correctamente";
    }

    @GetMapping("animal/perro")
    public List<Perro> listarPerros() {
        return perroRepository.findAll();
    }
    
    @GetMapping("animal/nombre")
    public ResponseEntity<?> buscarPorNombres(@RequestParam String nombre) {
        return new ResponseEntity(animalservice.buscarPorNombres(nombre), HttpStatus.OK);
    }
    
    @GetMapping("animal/castrado")
    public ResponseEntity<?> buscarPorCastrado(@RequestParam Boolean castrado) {
        return new ResponseEntity(animalservice.buscarPorCastrado(castrado), HttpStatus.OK);
    }
    
    @GetMapping("animal/tipo")
    public ResponseEntity<?> buscarPorTipo(@RequestParam String tipo) {
        return new ResponseEntity(animalservice.buscarPorTipo(tipo), HttpStatus.OK);
    }
    
    @GetMapping("animal/raza")
    public ResponseEntity<?> buscarPorRaza(@RequestParam String raza) {
        return new ResponseEntity(animalservice.buscarPorRaza(raza), HttpStatus.OK);
    }    

    @GetMapping("animal/genero")
    public ResponseEntity<?> buscarPorGenero(@RequestParam String genero) {
        return new ResponseEntity(animalservice.buscarPorGenero(genero), HttpStatus.OK);
    }        
    
    @GetMapping("animal/tamano")
    public ResponseEntity<?> buscarPorTamano(@RequestParam String tamano) {
        return new ResponseEntity(animalservice.buscarPorTamano(tamano), HttpStatus.OK);
    } 
}
