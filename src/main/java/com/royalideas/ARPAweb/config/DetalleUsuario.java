package com.royalideas.ARPAweb.config;

import com.royalideas.ARPAweb.personas.Persona;
import com.royalideas.ARPAweb.personas.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author mis_p
 */
@Service
public class DetalleUsuario implements UserDetailsService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Persona persona = personaRepository.findByMail(username);
        if (persona == null) {
            throw new UsernameNotFoundException(username);
        }
        UserDetails user = User.withUsername(persona.getMail()).password(persona.getContraseña()).authorities("USER").build();
        return user;
    }

}
