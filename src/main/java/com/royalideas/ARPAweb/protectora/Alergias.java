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
class Alergias {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer alergiasid;
    private Nivel nivel;
    private String sustancia;
    @ManyToOne
    @JoinColumn(name = "historiaClinicaid")
    private HistoriaClinica historiaClinicaid;

    enum Nivel {
        leve, severa;
    }
}
