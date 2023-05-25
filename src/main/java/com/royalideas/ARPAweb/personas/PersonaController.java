package com.royalideas.ARPAweb.personas;

import com.royalideas.ARPAweb.config.AuthRequest;
import com.royalideas.ARPAweb.config.AuthResponse;
import com.royalideas.ARPAweb.config.JwtTokenUtil;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mis_p
 */
@RestController
@RequestMapping("/")
public class PersonaController {

    @Autowired
    PersonaService service;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("nuevoencargado")
    public ResponseEntity<?> crearEncargado(@RequestBody @Valid Encargado persona) {
        Map<String, Object> respuesta = new LinkedHashMap<>();
        respuesta.put("Hora de registro", new Date());
        if (service.existePersona(persona)) {
            respuesta.put("mensaje", "Ya existe un uusario registrado con ese mail");
            return new ResponseEntity(respuesta, HttpStatus.BAD_REQUEST);
        }
        persona.setContraseña(encoder.encode(persona.getContraseña()));
        service.agregarPersona(persona);
        respuesta.put("mensaje", "Usuario registrado con exito");
        return new ResponseEntity(respuesta, HttpStatus.OK);
    }
    
//    @PostMapping("nuevoadoptante")
//    public ResponseEntity<?> crearAdoptante(@RequestBody  DtoAdoptante dtoAdop) {
//        Map<String, Object> respuesta = new LinkedHashMap<>();
//        
//        if((StringUtils.isBlank(dtoAdop.getNombre()))){
//             respuesta.put("mensaje", "Debe ingresar un nombre ");
//           return new ResponseEntity(respuesta, HttpStatus.BAD_REQUEST);
//        }
//        
//        
//        Adoptante adoptante = new Adoptante();
//        
//        adoptante.setNombre(dtoAdop.getNombre());
//        
//        
//        
//        
//        return null;
//    }
//    
    

    @GetMapping("personas")
    public ResponseEntity<?> verPersonas() {
        return new ResponseEntity(service.listarPersonas(), HttpStatus.OK);
    }

    @GetMapping("persona")
    public ResponseEntity<?> verPersona(@RequestParam String mail) {
        return new ResponseEntity(service.buscarPorMail("alandsn137@gmail.comg"), HttpStatus.OK);
    }

    @GetMapping("persona/nombre")
    public ResponseEntity<?> personaPorNombre(@RequestParam String nombre) {
        return new ResponseEntity(service.buscarPorNombre(nombre), HttpStatus.OK);
    }
    
    //queda afuera de persona
    //no
    public void registrarProtectora() {

    }

    //no
    public void solicitudAProtectora() {

    }

    //no
    public void registroDeTransito() {

    }

    //si
    public void login() {

    }

    //si
    public void logout() {

    }

    //si
    public void modificarDatosPropios() {

    }

    //si
    public void olvidoContraseña() {

    }
    /*
    creacion de protectoras: forumulario, notificacion por mail (acreditacion de protectora)
    alta de transito: formulario, aprueba una protectora
     */

//    @Autowired
//    AuthenticationManager authManager;
    @Autowired
    JwtTokenUtil jwtUtil;
    @Autowired
    AuthenticationManager authManager;

    @PostMapping("login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthRequest request) throws Exception {
        try {
            Authentication authentication = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(), request.getPassword())
            );

            User user = (User) authentication.getPrincipal();
            String accessToken = jwtUtil.generateAccessToken(user);
            AuthResponse response = new AuthResponse(user.getUsername(), accessToken);
            return ResponseEntity.ok().body(response);

        } catch (BadCredentialsException ex) {
            Map<String, Object> respuesta = new LinkedHashMap<>();
            respuesta.put("Hora de registro", new Date());
            respuesta.put("mensaje", "Datos incorrectos");
            return new ResponseEntity(respuesta, HttpStatus.UNAUTHORIZED);
        }
    }
}
