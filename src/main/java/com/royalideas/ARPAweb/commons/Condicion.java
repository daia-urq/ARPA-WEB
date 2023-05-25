package com.royalideas.ARPAweb.commons;

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
 * @author Daia
 */
//@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Condicion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer condicionid;
    estadoAnimal estado;
}

enum estadoAnimal {
    ADOPTADO, TRANSITO, ENREFUGIO;
}
