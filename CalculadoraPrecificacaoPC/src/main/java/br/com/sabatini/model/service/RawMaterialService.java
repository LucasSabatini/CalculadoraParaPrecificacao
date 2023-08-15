package br.com.sabatini.model.service;

import br.com.sabatini.exception.IdNotFoundException;
import br.com.sabatini.model.dto.RawMaterialRequestDTO;
import br.com.sabatini.model.dto.RawMaterialResponseDTO;
import br.com.sabatini.model.entity.RawMaterial;
import br.com.sabatini.model.entity.User;
import br.com.sabatini.model.repository.RawMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RawMaterialService {

    @Autowired
    private RawMaterialRepository rawMaterialRepository;

    @Autowired
    private UserService userService;

    @Transactional
    public RawMaterialResponseDTO addRawMaterial(RawMaterialRequestDTO rawMaterialRequestDTO) {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userService.getUserByEmail(userDetails.getUsername());
        RawMaterial rawMaterial = new RawMaterial(rawMaterialRequestDTO);
        rawMaterial.setUser(currentUser);
        Validator.validateRawMaterial(rawMaterial);
        RawMaterialResponseDTO rawMaterialResponseDTO = new RawMaterialResponseDTO(rawMaterial);
        for(RawMaterialResponseDTO consulta : this.getAllRawMaterials()) {
            if(consulta.nameRawMaterial().equals(rawMaterialResponseDTO.nameRawMaterial())) {
                return this.updateRawMaterial(consulta.id(), rawMaterialRequestDTO);
            }
        }
        rawMaterial.setFinalCost();
        rawMaterialRepository.save(rawMaterial);
        return new RawMaterialResponseDTO(rawMaterial);
    }

    public List<RawMaterialResponseDTO> getAllRawMaterials() {
        return rawMaterialRepository.findAll().stream().map(RawMaterialResponseDTO::new).toList();
    }

    public RawMaterialResponseDTO getRawMaterialById(Long id) {
        return rawMaterialRepository.findById(id)
                .map(RawMaterialResponseDTO::new).orElseThrow(() -> new IdNotFoundException(id));
    }

    @Transactional
    public RawMaterialResponseDTO updateRawMaterial(Long id, RawMaterialRequestDTO rawMaterialRequestDTO) {
        RawMaterial rawMaterial = rawMaterialRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException(id));
        rawMaterial.setNameRawMaterial(rawMaterialRequestDTO.nameRawMaterial());
        rawMaterial.setPricePaid(rawMaterialRequestDTO.pricePaid());
        rawMaterial.setWeightUsedInRecipe(rawMaterialRequestDTO.weightUsedInRecipe());
        rawMaterial.setWeightPurchased(rawMaterialRequestDTO.weightPurchased());
        rawMaterial.setFinalCost();
        rawMaterialRepository.save(rawMaterial);
        return new RawMaterialResponseDTO(rawMaterial);
    }

    public void deleteRawMaterial(Long id) {
        rawMaterialRepository.findById(id).orElseThrow(() -> new IdNotFoundException(id));
        rawMaterialRepository.deleteById(id);
    }
}
