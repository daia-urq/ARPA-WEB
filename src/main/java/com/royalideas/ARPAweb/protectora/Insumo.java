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
 * @author Daia
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Insumo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer insumoid;
    private String descripcion;
    private int cantidad;
    @ManyToOne
    @JoinColumn(name="protctoraid")
    private Protectora protectora;
}
