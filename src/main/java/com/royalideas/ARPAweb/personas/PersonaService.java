package com.royalideas.ARPAweb.personas;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mis_p
 */
@Service
public class PersonaService {

    @Autowired
    PersonaRepository repo;

    public Persona agregarPersona(Persona persona) {
        return repo.save(persona);
    }

    public boolean existePersona(Persona persona) {
        return repo.existsByMail(persona.getMail());
    }

    public Persona buscaPersona(int id) {
        return repo.findById(id).get();
    }

    public List<Persona> listarPersonas() {
        return repo.findAll();
    }

    public Persona buscarPorMail(String mail) {
        return repo.findByMail(mail);
    }

    public List<Persona> buscarPorNombre(String nombre) {
        return repo.findByNombre(nombre);
    }

    public boolean existsById(int id) {
        return repo.existsById(id);
    }

    public void deletePersona(int id) {
        repo.deleteById(id);
    }
   
}
