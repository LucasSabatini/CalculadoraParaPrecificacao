package br.com.sabatini.model.entity;

import java.math.BigDecimal;

public record MateriaPrimaResponseDTO(Long id, String nomeMP, BigDecimal precoPagoMP, BigDecimal pesoUsadoFormulacaoMP, BigDecimal pesoCompradoMP, BigDecimal gastoFinalMP) {

    public MateriaPrimaResponseDTO(MateriaPrima materiaPrima) {
        this(materiaPrima.getId(), materiaPrima.getNomeMP(), materiaPrima.getPrecoPagoMP(),
                materiaPrima.getPesoUsadoFormulacaoMP(), materiaPrima.getPesoCompradoMP(), materiaPrima.getGastoFinalMP());
    }
}
