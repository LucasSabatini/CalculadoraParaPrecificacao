package br.com.sabatini.controller;

import br.com.sabatini.exception.IdNaoEncontradoException;
import br.com.sabatini.model.repository.MateriaPrimaRepository;
import br.com.sabatini.model.dto.MateriaPrimaRequestDTO;
import br.com.sabatini.model.dto.MateriaPrimaResponseDTO;
import br.com.sabatini.model.entity.MateriaPrima;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public MateriaPrimaResponseDTO consultarPorId(@PathVariable Long id) {
        return materiaPrimaRepository.findById(id).map(MateriaPrimaResponseDTO::new).orElseThrow(() -> new IdNaoEncontradoException(id));
    }

    @PutMapping
    public MateriaPrima atualizarMateriaPrima(@RequestBody MateriaPrima materiaPrima) {
        materiaPrimaRepository.save(materiaPrima);
        return materiaPrima;
    }
}
