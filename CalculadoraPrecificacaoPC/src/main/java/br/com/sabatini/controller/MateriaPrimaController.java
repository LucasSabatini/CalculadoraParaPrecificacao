package br.com.sabatini.controller;

import br.com.sabatini.model.repository.MateriaPrimaRepository;
import br.com.sabatini.model.entity.MateriaPrimaRequestDTO;
import br.com.sabatini.model.entity.MateriaPrimaResponseDTO;
import br.com.sabatini.model.entity.MateriaPrima;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/materiaprima")
public class MateriaPrimaController {

    @Autowired
    private MateriaPrimaRepository materiaPrimaRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public @ResponseBody MateriaPrima adicionarMateriaPrima(@RequestBody MateriaPrimaRequestDTO materiaPrimaRequestDTO) {
        MateriaPrima materiaPrima = new MateriaPrima(materiaPrimaRequestDTO);
        materiaPrimaRepository.save(materiaPrima);
        return materiaPrima;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<MateriaPrimaResponseDTO> consultarTodos() {
        return materiaPrimaRepository.findAll().stream().map(MateriaPrimaResponseDTO::new).toList();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping
    public void atualizarMateriaPrima() {

    }
}
