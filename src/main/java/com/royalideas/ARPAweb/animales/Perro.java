package com.royalideas.ARPAweb.animales;

import com.royalideas.ARPAweb.commons.Compatible;
import com.royalideas.ARPAweb.commons.Condicion;
import com.royalideas.ARPAweb.protectora.HistoriaClinica;
import com.royalideas.ARPAweb.protectora.Protectora;
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
public class Perro extends Animal {

    private String tamano;

    public Perro(String tamano, String raza, Integer edad, String nombre, String genero, Boolean castrado, HistoriaClinica historiaClinica, Condicion condicion, Compatible compatibilidad, Protectora protectora, String tipo) {
        super(raza, edad, nombre, genero, castrado, historiaClinica, condicion, compatibilidad, protectora, tipo);
        this.tamano = tamano;
    }

    

   
}
