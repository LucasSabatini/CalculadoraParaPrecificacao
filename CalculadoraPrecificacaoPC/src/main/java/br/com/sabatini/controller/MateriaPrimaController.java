package br.com.sabatini.controller;

import br.com.sabatini.model.dto.MateriaPrimaRequestDTO;
import br.com.sabatini.model.dto.MateriaPrimaResponseDTO;
import br.com.sabatini.model.service.MateriaPrimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/materiaprima")
public class MateriaPrimaController {

    @Autowired
    private MateriaPrimaService materiaPrimaService;

    @PostMapping
    public @ResponseBody ResponseEntity<MateriaPrimaResponseDTO> adicionarMateriaPrima(@RequestBody MateriaPrimaRequestDTO materiaPrimaRequestDTO) {
        MateriaPrimaResponseDTO materiaPrima = materiaPrimaService.adicionarMateriaPrima(materiaPrimaRequestDTO);
        return ResponseEntity.ok(materiaPrima);
    }

    @GetMapping
    public ResponseEntity<List<MateriaPrimaResponseDTO>> consultarTodos() {
        List<MateriaPrimaResponseDTO> materiaPrimaResponseDTO = materiaPrimaService.consultarTodos();
        return ResponseEntity.ok(materiaPrimaResponseDTO);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<MateriaPrimaResponseDTO> consultarPorId(@PathVariable Long id) {
        MateriaPrimaResponseDTO materiaPrimaResponseDTO = materiaPrimaService.consultarPorId(id);
        return ResponseEntity.ok(materiaPrimaResponseDTO);
    }

//    @PutMapping
//    public MateriaPrima atualizarMateriaPrima(@RequestBody MateriaPrima materiaPrima) {
//        materiaPrimaService.save(materiaPrima);
//        return materiaPrima;
//    }
}
