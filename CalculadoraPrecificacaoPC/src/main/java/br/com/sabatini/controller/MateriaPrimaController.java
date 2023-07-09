package br.com.sabatini.controller;

import br.com.sabatini.model.repository.MateriaPrimaRepository;
import br.com.sabatini.model.entity.MateriaPrimaRequestDTO;
import br.com.sabatini.model.entity.MateriaPrimaResponseDTO;
import br.com.sabatini.model.entity.MateriaPrima;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/materiaprima")
public class MateriaPrimaController {

    @Autowired
    private MateriaPrimaRepository materiaPrimaRepository;

    @PostMapping
    public @ResponseBody MateriaPrima adicionarMateriaPrima(@RequestBody MateriaPrimaRequestDTO materiaPrimaRequestDTO) {
        MateriaPrima materiaPrima = new MateriaPrima(materiaPrimaRequestDTO);
        materiaPrimaRepository.save(materiaPrima);
        return materiaPrima;
    }

    @GetMapping
    public List<MateriaPrimaResponseDTO> consultarTodos() {
        return materiaPrimaRepository.findAll().stream().map(MateriaPrimaResponseDTO::new).toList();
    }

    @GetMapping(path = "/{id}")
    public Optional<MateriaPrima> consultarPorId(@PathVariable Long id) {
        return materiaPrimaRepository.findById(id);
    }

    @PutMapping
    public void atualizarMateriaPrima() {

    }
}
