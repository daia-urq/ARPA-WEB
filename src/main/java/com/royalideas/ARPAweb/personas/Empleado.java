package com.royalideas.ARPAweb.personas;

import com.royalideas.ARPAweb.protectora.Protectora;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Daia
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Empleado extends Persona {

    @ManyToMany(mappedBy="empleados")
    private List<Protectora> protectora;
    private String horario;
    
}
