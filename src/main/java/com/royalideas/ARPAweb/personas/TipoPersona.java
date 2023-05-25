package com.royalideas.ARPAweb.personas;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author linux
 */

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TipoPersona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tipoPersonaid;
    private String descripcion;
}
