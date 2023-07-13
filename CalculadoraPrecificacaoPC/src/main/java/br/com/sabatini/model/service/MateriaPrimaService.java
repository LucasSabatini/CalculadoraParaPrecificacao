package br.com.sabatini.model.service;

import br.com.sabatini.exception.IdNaoEncontradoException;
import br.com.sabatini.model.dto.MateriaPrimaRequestDTO;
import br.com.sabatini.model.dto.MateriaPrimaResponseDTO;
import br.com.sabatini.model.entity.MateriaPrima;
import br.com.sabatini.model.repository.MateriaPrimaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MateriaPrimaService {

    @Autowired
    private MateriaPrimaRepository materiaPrimaRepository;

    public MateriaPrimaResponseDTO adicionarMateriaPrima(MateriaPrimaRequestDTO materiaPrimaRequestDTO) {
        MateriaPrima materiaPrima = new MateriaPrima(materiaPrimaRequestDTO);
        Validar.validarMateriaPrima(materiaPrima);
        MateriaPrimaResponseDTO materiaPrimaResponseDTO = new MateriaPrimaResponseDTO(materiaPrima);
        for(MateriaPrimaResponseDTO consulta : this.consultarTodos()) {
            if(consulta.nomeMP().equals(materiaPrimaResponseDTO.nomeMP())) {
                return this.atualizarMateriaPrima(consulta.id(), materiaPrimaRequestDTO);
            }
        }
        CalculadoraGastoFinal.calcularMateriaPrima(materiaPrima);
        materiaPrimaRepository.save(materiaPrima);
        return new MateriaPrimaResponseDTO(materiaPrima);
    }

    public List<MateriaPrimaResponseDTO> consultarTodos() {
        return materiaPrimaRepository.findAll().stream().map(MateriaPrimaResponseDTO::new).toList();
    }

    public MateriaPrimaResponseDTO consultarPorId(Long id) {
        return materiaPrimaRepository.findById(id).map(MateriaPrimaResponseDTO::new).orElseThrow(() -> new IdNaoEncontradoException(id));
    }

    public MateriaPrimaResponseDTO atualizarMateriaPrima(Long id, MateriaPrimaRequestDTO materiaPrimaRequestDTO) {
        MateriaPrima materiaPrima = materiaPrimaRepository.findById(id).orElseThrow(() -> new IdNaoEncontradoException(id));
        materiaPrima.setNomeMP(materiaPrimaRequestDTO.nomeMP());
        materiaPrima.setPrecoPagoMP(materiaPrimaRequestDTO.precoPagoMP());
        materiaPrima.setPesoUsadoFormulacaoMP(materiaPrimaRequestDTO.pesoUsadoFormulacaoMP());
        materiaPrima.setPesoCompradoMP(materiaPrimaRequestDTO.pesoCompradoMP());
        CalculadoraGastoFinal.calcularMateriaPrima(materiaPrima);
        materiaPrimaRepository.save(materiaPrima);
        return new MateriaPrimaResponseDTO(materiaPrima);
    }

    public void deletarMateriaPrima(Long id) {
        materiaPrimaRepository.findById(id).orElseThrow(() -> new IdNaoEncontradoException(id));
        materiaPrimaRepository.deleteById(id);
    }
}
