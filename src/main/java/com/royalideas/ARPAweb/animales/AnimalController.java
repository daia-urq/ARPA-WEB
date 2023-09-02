package com.royalideas.ARPAweb.animales;

import com.royalideas.ARPAweb.commons.Compatible;
import com.royalideas.ARPAweb.commons.Condicion;
import com.royalideas.ARPAweb.protectora.HistoriaClinica;
import com.royalideas.ARPAweb.protectora.HistoriaRepository;
import com.royalideas.ARPAweb.protectora.Protectora;
import com.royalideas.ARPAweb.protectora.ProtectoraRepository;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
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
    
    @Autowired
    HistoriaRepository historiaRepository;

    @Transactional
    @PostMapping("animal/crearperro")
    public ResponseEntity<?> crearAnimal(@RequestBody PerroDTO animal) {
        Map<String, Object> response = new LinkedHashMap<>();
        
        HistoriaClinica historiaClinica = new HistoriaClinica();
        historiaRepository.save(historiaClinica);
        
        Protectora protectora = protectoraRepository.findById(animal.getProtectora()).orElse(null);
        
        Condicion condicion = Condicion.valueOf(animal.getCondicion().toUpperCase());        
        Compatible compatible = Compatible.valueOf(animal.getCompatibilidad().toUpperCase());
          
        Perro perro = new Perro(
        animal.getTamano(),
        animal.getRaza(),
        animal.getEdad(),
        animal.getNombre(),
        animal.getGenero(),
        animal.getCastrado(),
        historiaClinica,
        condicion,
        compatible,
        protectora,
        animal.getTipo()
    );
        perroRepository.save(perro);
                
        response.put("mensaje", "Perro creado con exito");
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

//    @PostMapping("animal/creargato")
//    public ResponseEntity<?> crearAnimal(@RequestBody Gato animal) {
//        Map<String, Object> response = new LinkedHashMap<>();
//        animal.setProtectora(protectoraRepository.findByNombre(animal.getProtectora().getNombre()));
//        animal = (Gato) animalservice.guardarAnimal(animal);
//        response.put("mensaje", "creado con exito");
//        return new ResponseEntity(response, HttpStatus.CREATED);
//    }

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
