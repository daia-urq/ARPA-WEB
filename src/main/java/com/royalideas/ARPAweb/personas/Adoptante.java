package com.royalideas.ARPAweb.personas;

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
public class Adoptante extends Persona {

    private Boolean apto;
}
