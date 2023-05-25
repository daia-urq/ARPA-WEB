package com.royalideas.ARPAweb.protectora;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
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
public class Capacidad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer capacidadid;
    @NotNull(message="debe completar la capacidad")
    @Min(message = "la capacidad debe ser mayor a 0", value = 1)
    private Integer capTotal;
    private Boolean ocupado;

}
