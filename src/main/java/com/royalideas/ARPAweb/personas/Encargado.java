package com.royalideas.ARPAweb.personas;

import com.royalideas.ARPAweb.protectora.Protectora;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
public class Encargado extends Persona {

    private int genteAcargo;
    @OneToOne
    @JoinColumn(name = "protectoraid")
    private Protectora protectora;          
}
