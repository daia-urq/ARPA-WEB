package com.royalideas.ARPAweb.protectora;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Daia
 */
@RestController
@RequestMapping("/")
public class MedicamentoController {

    @Autowired
    MedicamentoService medicamentoService;

//    @PostMapping("nuevomedicamento")
//    public ResponseEntity<?> crearProtectora(@RequestBody @Valid Medicamento medicamento){
//        Map<String, Object> respuesta = new LinkedHashMap<>();
//        if(medicamentoService.existeMedicamentoById( medicamento.getMedicamentoid()) || medicamentoService.exiseteMedicamentoPorNombre(medicamento.getNombre())){
//           respuesta.put("mensaje", "Ya existe este medicamento");
//           return new ResponseEntity(respuesta, HttpStatus.OK);
//        }
//   
//        medicamentoService.crearMedicamento(medicamento);
//        respuesta.put("mensaje", "Medicamento creado con exito");
//        return new ResponseEntity(respuesta, HttpStatus.OK);
//    }
    @GetMapping("medicamentos")
    public ResponseEntity<?> listarMedicamentos() {
        return new ResponseEntity(medicamentoService.listarMedicamentos(), HttpStatus.OK);
    }

    @GetMapping("medicamento")
    public ResponseEntity<?> verMedicamento(@RequestParam Integer id) {
        return new ResponseEntity(medicamentoService.buscarMedicamento(id), HttpStatus.OK);
    }

    @DeleteMapping("medicamento/eliminar/{id}")
    public String deleteMedicamento(@PathVariable Integer id) {
        if (!medicamentoService.existeMedicamentoById(id)) {
            return "No existe el insumo a eliminar";
        }
        medicamentoService.borrarMedicamento(id);
        return "Medicamento eliminado correctamente";
    }
}
