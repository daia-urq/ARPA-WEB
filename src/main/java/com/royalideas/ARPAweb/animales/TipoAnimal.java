package com.royalideas.ARPAweb.animales;

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
public class TipoAnimal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tipoAnimalid;
    private Tipo descripcion;
    
    enum Tipo{
        GATO,PERRO;
    }
}
