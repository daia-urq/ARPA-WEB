package com.royalideas.ARPAweb.animales;

import javax.persistence.Entity;
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
public class Gato extends Animal {

    private boolean aptoDepto;
}
