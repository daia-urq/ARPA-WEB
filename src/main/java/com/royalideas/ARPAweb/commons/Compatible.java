package com.royalideas.ARPAweb.commons;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author Daia
 */
//@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Compatible {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer compatibleid;
    Compatibilidad compatible;

}

enum Compatibilidad {
    GATO, PERRO, GATOPERRO;
}
