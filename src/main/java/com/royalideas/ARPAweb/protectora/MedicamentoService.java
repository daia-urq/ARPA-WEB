package com.royalideas.ARPAweb.protectora;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Daia
 */
@Service
public class MedicamentoService {

    @Autowired
    MedicamentoRepository medicamentoRepository;

    @Transactional
    public Medicamento crearMedicamento(Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    public Optional<Medicamento> buscarMedicamento(Integer id) {
        Optional<Medicamento> medicamento = medicamentoRepository.findById(id);

        return medicamento;
    }

    public List<Medicamento> listarMedicamentos() {
        List<Medicamento> medicamentos = medicamentoRepository.findAll();
        return medicamentos;
    }

    @Transactional
    public void borrarMedicamento(Integer id) {
        medicamentoRepository.deleteById(id);
    }

    public boolean existeMedicamentoById(Integer id) {
        return medicamentoRepository.existsById(id);
    }

//    public boolean exiseteMedicamentoPorNombre(String nombre) {
//        return medicamentoRepository.existByName(nombre);
//    }
}
