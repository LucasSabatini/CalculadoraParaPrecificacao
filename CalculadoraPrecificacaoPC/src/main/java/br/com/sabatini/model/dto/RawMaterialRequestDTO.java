package br.com.sabatini.model.dto;

import br.com.sabatini.model.entity.User;

import java.math.BigDecimal;

public record RawMaterialRequestDTO(String nameRawMaterial, BigDecimal pricePaid, BigDecimal weightUsedInRecipe, BigDecimal weightPurchased, User user) {
}
