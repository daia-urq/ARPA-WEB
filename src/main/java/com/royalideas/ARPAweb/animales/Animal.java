package com.royalideas.ARPAweb.animales;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.royalideas.ARPAweb.personas.Adoptante;
import com.royalideas.ARPAweb.protectora.HistoriaClinica;
import com.royalideas.ARPAweb.protectora.Protectora;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
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
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer animalid;
    private String raza;
    @NotNull(message = "Ingrese una edad")
    @Min(value = 1, message = "la edad no puede ser menor a 1")
    @Max(value = 25, message = "la edad no puede ser mayor a 25")
    private Integer edad;
    @NotBlank(message = "el nombre no puede estar vacio")
    private String nombre;
    private String genero;
    private Boolean castrado;
    @ManyToOne
    @JoinColumn(name = "aodptanteid")
    private Adoptante adoptante;
    @OneToOne
    @JoinColumn(name = "historiaClinicaid")
    private HistoriaClinica historiaClinica;
    private int condicion;
    private int compatibilidad;
    @ManyToOne
    @JoinColumn(name = "protectoraid")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "protectoraid")
    private Protectora protectora;
    private String tipo;
}
