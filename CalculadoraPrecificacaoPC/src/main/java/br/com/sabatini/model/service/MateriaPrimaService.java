package br.com.sabatini.model.service;

import br.com.sabatini.exception.IdNaoEncontradoException;
import br.com.sabatini.model.dto.MateriaPrimaRequestDTO;
import br.com.sabatini.model.dto.MateriaPrimaResponseDTO;
import br.com.sabatini.model.entity.MateriaPrima;
import br.com.sabatini.model.repository.MateriaPrimaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class MateriaPrimaService {

    @Autowired
    private MateriaPrimaRepository materiaPrimaRepository;

    public MateriaPrimaResponseDTO adicionarMateriaPrima(MateriaPrimaRequestDTO materiaPrimaRequestDTO){
        MateriaPrima materiaPrima = new MateriaPrima(materiaPrimaRequestDTO);
        Validar.validarMateriaPrima(materiaPrima);
        CalculadoraGastoFinal.calcularMateriaPrima(materiaPrima);
        materiaPrimaRepository.save(materiaPrima);

        return new MateriaPrimaResponseDTO(materiaPrima);
    }

    public List<MateriaPrimaResponseDTO> consultarTodos() {
        return materiaPrimaRepository.findAll().stream().map(MateriaPrimaResponseDTO::new).toList();
    }

    public MateriaPrimaResponseDTO consultarPorId(@PathVariable Long id) {
        return materiaPrimaRepository.findById(id).map(MateriaPrimaResponseDTO::new).orElseThrow(() -> new IdNaoEncontradoException(id));
    }
}
