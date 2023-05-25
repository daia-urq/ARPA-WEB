package com.royalideas.ARPAweb.personas;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Daia
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Persona implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer personaid;
    @NotBlank(message = "Debe introducir un nombre")
    private String nombre;
    @NotNull(message = "Ingrese un DNI")
    @Min(value = 1000000, message = "ingrese un DNI valido")
    @Max(value = 100000000, message = "ingrese un DNI valido")
    private Integer dni;
    
    private BigInteger telefono;
    @Email(message = "Mail invalido")
    @NotBlank(message = "Debe introducir un mail")
    @Column(unique = true)
    private String mail;
  
    private String domicilio;
    @NotBlank(message = "Debe introducir una contraseña")
    private String contraseña;
    @Temporal(TemporalType.DATE)
//    @Past(message = "la fecha debe ser anterior a la actual")
    private Date fechaNacimiento;
//    @OneToOne
//    @JoinColumn(name = "tipopersonaid")
//    private TipoPersona tipo;
//    private Encargado encargado;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.getContraseña();
    }

    @Override
    public String getUsername() {
        return this.getMail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
//
//    public TipoPersona getTipo() {
//        return tipo;
//    }
//
//    public void setTipo(TipoPersona tipo) {
//        this.tipo = tipo;
//    }

}
