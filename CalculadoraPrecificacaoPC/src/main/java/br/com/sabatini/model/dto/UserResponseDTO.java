package br.com.sabatini.model.dto;

import br.com.sabatini.model.entity.RawMaterial;
import br.com.sabatini.model.entity.User;

import java.util.List;

public record UserResponseDTO(Long id, String firstName, String lastName, String email, List<RawMaterial> rawMaterials) {

    public UserResponseDTO(User user) {
        this(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getRawMaterials());
    }
}
