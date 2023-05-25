package com.royalideas.ARPAweb.excepciones;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author mis_p
 */
@ControllerAdvice
public class ExcepcionDeArgumentos extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Map<String, Object> respuesta = new LinkedHashMap<>();
        respuesta.put("Hora registro", new Date());
        respuesta.put("status", status.value());
        List<String> errores = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());
        respuesta.put("mensaje", errores);
        return new ResponseEntity<>(respuesta, headers, status);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> handleConstraintViolation(javax.validation.ConstraintViolationException ex, WebRequest request) {
        List<String> errors = new ArrayList<String>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.add(violation.getMessage());
        }
        Map<String, Object> respuesta = new LinkedHashMap<>();
        respuesta.put("Hora registro", new Date());
        respuesta.put("status", HttpStatus.BAD_REQUEST);
        respuesta.put("mensaje", errors);
        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler({SQLIntegrityConstraintViolationException.class})
    public ResponseEntity<Object> SQLIntegrityConstraintViolationException(javax.validation.ConstraintViolationException ex){
        List<String> errors = new ArrayList<String>();
        for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            errors.add(violation.getMessage());
        }
        Map<String, Object> respuesta = new LinkedHashMap<>();
        respuesta.put("Hora registro", new Date());
        respuesta.put("status", HttpStatus.BAD_REQUEST);
        respuesta.put("mensaje", errors);
        return new ResponseEntity<>(respuesta, HttpStatus.BAD_REQUEST);
    }
}
