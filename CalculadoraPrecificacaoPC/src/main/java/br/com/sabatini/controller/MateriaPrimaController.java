package br.com.sabatini.controller;

import br.com.sabatini.model.dto.MateriaPrimaRequestDTO;
import br.com.sabatini.model.dto.MateriaPrimaResponseDTO;
import br.com.sabatini.model.service.MateriaPrimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody ResponseEntity<MateriaPrimaResponseDTO> adicionarMateriaPrima(@RequestBody MateriaPrimaRequestDTO materiaPrimaRequestDTO) {
        MateriaPrimaResponseDTO materiaPrima = materiaPrimaService.adicionarMateriaPrima(materiaPrimaRequestDTO);
        return ResponseEntity.ok().body(materiaPrima);
    }

    @GetMapping
    public ResponseEntity<List<MateriaPrimaResponseDTO>> consultarTodos() {
        List<MateriaPrimaResponseDTO> materiaPrimaResponseDTO = materiaPrimaService.consultarTodos();
        return ResponseEntity.ok().body(materiaPrimaResponseDTO);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<MateriaPrimaResponseDTO> consultarPorId(@PathVariable Long id) {
        MateriaPrimaResponseDTO materiaPrimaResponseDTO = materiaPrimaService.consultarPorId(id);
        return ResponseEntity.ok().body(materiaPrimaResponseDTO);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<MateriaPrimaResponseDTO> atualizarMateriaPrima(@PathVariable Long id, @RequestBody MateriaPrimaRequestDTO materiaPrimaRequestDTO) {
        MateriaPrimaResponseDTO materiaPrimaResponseDTO = materiaPrimaService.atualizarMateriaPrima(id, materiaPrimaRequestDTO);
        return ResponseEntity.ok().body(materiaPrimaResponseDTO);
    }

    @DeleteMapping(path="/{id}")
    public ResponseEntity<Void> deletarMateriaPrima(@PathVariable Long id) {
        materiaPrimaService.deletarMateriaPrima(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
