    package br.com.sabatini.model.dto;

    import java.math.BigDecimal;

    public record RawMaterialRequestDTO(String nameRawMaterial, BigDecimal pricePaid, BigDecimal weightUsedInRecipe, BigDecimal weightPurchased) {
    }
