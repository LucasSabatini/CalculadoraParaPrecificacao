package br.com.sabatini.model.entity;

import java.math.BigDecimal;

public record MateriaPrimaRequestDTO(String nomeMP, BigDecimal precoPagoMP, BigDecimal pesoUsadoFormulacaoMP, BigDecimal pesoCompradoMP, BigDecimal gastoFinalMP) {
}
