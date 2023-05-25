package com.royalideas.ARPAweb.protectora;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.royalideas.ARPAweb.animales.Animal;
import com.royalideas.ARPAweb.personas.Empleado;
import com.royalideas.ARPAweb.personas.Encargado;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
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
public class Protectora {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer protectoraid;
    @NotBlank(message = "Ingrese un nombre")
    private String nombre;
    private String ciudad;
    @NotBlank(message = "Ingrese un domicilio")
    private String domicilio;
    @NotNull(message = "ingrese un telefono")
    private Integer telefono;
    @Email(message = "ingrese un mail valido")
    @Column(unique = true)
    private String mail;
    @OneToOne
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "personaid")
    private Encargado encargada;
    @ManyToMany
    @JoinTable(
            name = "protectora_empleado",
            joinColumns = {
                @JoinColumn(name = "empleadoid")},
            inverseJoinColumns = {
                @JoinColumn(name = "protectoraid")}
    )
    private List<Empleado> empleados;
    @OneToMany(mappedBy = "protectora")
    @JsonIdentityInfo(
            generator = ObjectIdGenerators.PropertyGenerator.class,
            property = "animalid")
    private List<Animal> animales;
    @OneToMany(mappedBy = "protectora")
    private List<Insumo> insumos;
    @OneToOne
    @JoinColumn(name = "capacidadid")
    @NotNull(message = "ingrese una capacidad")
    private Capacidad capacidad;
    private String horario;

}
