package br.com.sabatini.model.service;

import br.com.sabatini.exception.IdNotFoundException;
import br.com.sabatini.model.dto.RawMaterialRequestDTO;
import br.com.sabatini.model.dto.RawMaterialResponseDTO;
import br.com.sabatini.model.entity.RawMaterial;
import br.com.sabatini.model.repository.MateriaPrimaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RawMaterialService {

    @Autowired
    private MateriaPrimaRepository materiaPrimaRepository;

    public RawMaterialResponseDTO addRawMaterial(RawMaterialRequestDTO rawMaterialRequestDTO) {
        RawMaterial rawMaterial = new RawMaterial(rawMaterialRequestDTO);
        Validator.validateRawMaterial(rawMaterial);
        RawMaterialResponseDTO rawMaterialResponseDTO = new RawMaterialResponseDTO(rawMaterial);
        for(RawMaterialResponseDTO consulta : this.getAll()) {
            if(consulta.nameRawMaterial().equals(rawMaterialResponseDTO.nameRawMaterial())) {
                return this.updateRawMaterial(consulta.id(), rawMaterialRequestDTO);
            }
        }
        rawMaterial.setFinalCost();
        materiaPrimaRepository.save(rawMaterial);
        return new RawMaterialResponseDTO(rawMaterial);
    }

    public List<RawMaterialResponseDTO> getAll() {
        return materiaPrimaRepository.findAll().stream().map(RawMaterialResponseDTO::new).toList();
    }

    public RawMaterialResponseDTO getById(Long id) {
        return materiaPrimaRepository.findById(id)
                .map(RawMaterialResponseDTO::new).orElseThrow(() -> new IdNotFoundException(id));
    }

    public RawMaterialResponseDTO updateRawMaterial(Long id, RawMaterialRequestDTO rawMaterialRequestDTO) {
        RawMaterial rawMaterial = materiaPrimaRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(id));
        rawMaterial.setNameRawMaterial(rawMaterialRequestDTO.nameRawMaterial());
        rawMaterial.setPricePaid(rawMaterialRequestDTO.pricePaid());
        rawMaterial.setWeightUsedInRecipe(rawMaterialRequestDTO.weightUsedInRecipe());
        rawMaterial.setWeightPurchased(rawMaterialRequestDTO.weightPurchased());
        rawMaterial.setFinalCost();
        materiaPrimaRepository.save(rawMaterial);
        return new RawMaterialResponseDTO(rawMaterial);
    }

    public void deleteRawMaterial(Long id) {
        materiaPrimaRepository.findById(id).orElseThrow(() -> new IdNotFoundException(id));
        materiaPrimaRepository.deleteById(id);
    }
}
