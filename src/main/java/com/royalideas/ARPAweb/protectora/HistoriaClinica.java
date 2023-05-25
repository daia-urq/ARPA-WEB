package com.royalideas.ARPAweb.protectora;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer historiaClinicaid;
    @OneToMany(mappedBy="historiaClinicaid")
    private List<Medicamento> medicamentosid;
    private boolean enfermedadCronica;
    private boolean movilidadCompleta;
    @OneToMany(mappedBy="historiaClinicaid")
    private List<Alergias> alergiasid;
}
