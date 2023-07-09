package br.com.sabatini.model.dto;

import java.math.BigDecimal;

public record MateriaPrimaRequestDTO(String nomeMP, BigDecimal precoPagoMP, BigDecimal pesoUsadoFormulacaoMP, BigDecimal pesoCompradoMP) {
}
