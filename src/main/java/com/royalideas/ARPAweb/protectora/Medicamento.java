package com.royalideas.ARPAweb.protectora;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer medicamentoid;
    private String nombre;
    private Double dosis;
    private Unidad unidad;
    @ManyToOne
    @JoinColumn(name = "historiaClinicaid")
    private HistoriaClinica historiaClinicaid;

    enum Unidad {
        gramos, mililitros;
    }
}
