package com.royalideas.ARPAweb.animales;

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
public class AnimalService {

    @Autowired
    AnimalRepository animalrepository;

    @Transactional()
    public Animal guardarAnimal(Perro animal) {
        animalrepository.save(animal);
        return animal;
    }

    @Transactional()
    public Animal guardarAnimal(Gato animal) {
        animalrepository.save(animal);
        return animal;
    }

    public Optional<Animal> buscarAnimal(Integer id) {
        Optional<Animal> animal = animalrepository.findById(id);
        return animal;
    }

    public List<Animal> listarAnimales() {
        List<Animal> animales = animalrepository.findAll();
        return animales;
    }

    @Transactional()
    public void borrarAnimal(Integer id) {
        animalrepository.deleteById(id);
    }
    
    public Animal buscarPorNombre(String nombre) {
        Animal animal = animalrepository.findByNombre(nombre);
        return animal;
    }       
    
    public  List<Animal> buscarPorCastrado(Boolean castrado){
        List<Animal> animales = animalrepository.findByCastrado(castrado);
        return animales;
    }
    
    public  List<Animal> buscarPorTipo(String tipo){
        List<Animal> animales = animalrepository.findByTipo(tipo);
        return animales;
    }
    
    public  List<Perro> buscarPorTamano(String tamano){
        List<Perro> perros = animalrepository.findByTamano(tamano);
        return perros;
    }
    
    public  List<Animal> buscarPorRaza(String raza){
        List<Animal> animales = animalrepository.findByRaza(raza);
        return animales;
    }
    
    public  List<Animal> buscarPorGenero(String genero){
        List<Animal> animales = animalrepository.findByGenero(genero);
        return animales;
    }
    
    
    public List<Animal> buscarPorNombres(String nombre){
        List<Animal> animales = animalrepository.findDistinctAnimalByNombre(nombre);
        return animales;
    }
//    public  List<Animal> buscarPorCiudad(String ciudad){
//        List<Animal> animales = animalrepository.buscarPorCiudad(ciudad);
//        return animales;
//    }

}
