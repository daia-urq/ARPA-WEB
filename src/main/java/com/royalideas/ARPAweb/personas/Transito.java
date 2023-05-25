package com.royalideas.ARPAweb.personas;

import com.royalideas.ARPAweb.protectora.Capacidad;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author mis_p
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transito extends Persona {

    @OneToOne
    @JoinColumn(name="capacidadid")
    private Capacidad capacidad;
    private boolean disponible; 

}
