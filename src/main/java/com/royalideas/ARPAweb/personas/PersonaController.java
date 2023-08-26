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
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
    EncargadoService encargadoService;

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("nuevoencargado")
    public ResponseEntity<?> crearEncargado(@RequestBody @Valid Encargado encargado) {
        Map<String, Object> respuesta = new LinkedHashMap<>();
        respuesta.put("Hora de registro", new Date());
        if (service.existePersona(encargado)) {
            respuesta.put("mensaje", "Ya existe un encargado registrado con ese email");
            return new ResponseEntity(respuesta, HttpStatus.BAD_REQUEST);
        }               
        encargado.setContrasenia(encoder.encode(encargado.getContrasenia()));
        service.agregarPersona(encargado);
        respuesta.put("mensaje", "Encargado registrado con exito");
        return new ResponseEntity(respuesta, HttpStatus.OK);
    }
    
    @PostMapping("nuevoadoptante")
    public ResponseEntity<?> crearAdoptante(@RequestBody @Valid Adoptante adoptante){
        
        Map<String, Object> respuesta = new LinkedHashMap<>();
        respuesta.put("Hora de registro", new Date());
        
        if (service.existePersona(adoptante)) {
            respuesta.put("mensaje", "Ya existe un adoptante registrado con ese email");
            return new ResponseEntity(respuesta, HttpStatus.BAD_REQUEST);
        }               
        adoptante.setContrasenia(encoder.encode(adoptante.getContrasenia()));
        service.agregarPersona(adoptante);
        respuesta.put("mensaje", "Adoptante registrado con exito");
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
    @DeleteMapping("deleteencargado/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        Map<String, Object> respuesta = new LinkedHashMap<>();
        if (!service.existsById(id)) {
            respuesta.put("mensaje", "No existe un encargado con ese id");
            return new ResponseEntity(respuesta, HttpStatus.BAD_REQUEST);
        }
        service.deletePersona(id);
        respuesta.put("mensaje", "Encargado eliminado");
        return new ResponseEntity(respuesta, HttpStatus.OK);
    }

    @PutMapping("/updateencargado/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Encargado encargado) {
        Map<String, Object> respuesta = new LinkedHashMap<>();

        if (!encargadoService.existsById(id)) {
            respuesta.put("mensaje", "No existe un encargado con este id");
            return new ResponseEntity(respuesta, HttpStatus.BAD_REQUEST);
        }

        Encargado aux = encargadoService.findById(id);

        if (encargadoService.existsByMail(encargado.getMail()) && aux.getPersonaid() != encargadoService.findByMail(encargado.getMail()).getPersonaid()) {
            respuesta.put("mensaje", "Ya existe un encargado con este email");
            return new ResponseEntity(respuesta, HttpStatus.BAD_REQUEST);
        }

        if (encargadoService.existsbyDni(encargado.getDni()) && aux.getPersonaid() != encargadoService.findByDni(encargado.getDni()).getPersonaid()) {
            respuesta.put("mensaje", "Ya existe un encargado con este dni");
            return new ResponseEntity(respuesta, HttpStatus.BAD_REQUEST);
        }

        aux.setNombre(encargado.getNombre());
        aux.setDni(encargado.getDni());
        aux.setTelefono(encargado.getTelefono());
        aux.setMail(encargado.getMail());
        aux.setDomicilio(encargado.getDomicilio());
        aux.setContrasenia(encoder.encode(encargado.getPassword()));
        aux.setFechaNacimiento(encargado.getFechaNacimiento());

        service.agregarPersona(aux);

        respuesta.put("mensaje", "Encargado modificado");
        return new ResponseEntity(respuesta, HttpStatus.OK);
    }

    @GetMapping("personas")
    public ResponseEntity<?> verPersonas() {
        return new ResponseEntity(service.listarPersonas(), HttpStatus.OK);
    }

    @GetMapping("persona")
    public ResponseEntity<?> verPersona(@RequestParam String mail) {
        return new ResponseEntity(service.buscarPorMail(mail), HttpStatus.OK);
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
