package br.com.sabatini.model;

import br.com.sabatini.model.entity.MateriaPrima;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class CalculadoraGastoFinal {

    public static BigDecimal calcularMateriaPrima(MateriaPrima materiaPrima) {
        BigDecimal gastoFinalMP;
        gastoFinalMP = materiaPrima.getPrecoPagoMP().multiply(materiaPrima.getPesoUsadoFormulacaoMP())
                .divide(materiaPrima.getPesoCompradoMP(), 2, RoundingMode.UP);
        materiaPrima.setGastoFinalMP(gastoFinalMP);
        return gastoFinalMP;
    }
}
