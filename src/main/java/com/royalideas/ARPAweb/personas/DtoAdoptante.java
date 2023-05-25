package com.royalideas.ARPAweb.personas;

import java.math.BigInteger;
import java.util.Date;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author daiau
 */
@Getter
@Setter
public class DtoAdoptante {
    
    @NotNull
    private String nombre;
    @NotNull
    private Integer dni;
    @NotNull
    private BigInteger telefono;
    @NotNull
    private String mail;
    @NotNull
    private String domicilio;
    @NotNull
    private String contraseña;
  
    @NotNull
    private Date fechaNacimiento;
    
}
