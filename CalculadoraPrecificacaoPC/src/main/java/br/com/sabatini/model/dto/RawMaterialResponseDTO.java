package br.com.sabatini.model.dto;

import br.com.sabatini.model.entity.RawMaterial;
import br.com.sabatini.model.entity.User;

import java.math.BigDecimal;

public record RawMaterialResponseDTO(Long id, String nameRawMaterial, BigDecimal pricePaid, BigDecimal weightUsedInRecipe, BigDecimal weightPurchased, BigDecimal finalCost, User user) {

    public RawMaterialResponseDTO(RawMaterial rawMaterial) {
        this(rawMaterial.getId(), rawMaterial.getNameRawMaterial(), rawMaterial.getPricePaid(),
                rawMaterial.getWeightUsedInRecipe(), rawMaterial.getWeightPurchased(),
                rawMaterial.getFinalCost(), rawMaterial.getUser());
    }
}
