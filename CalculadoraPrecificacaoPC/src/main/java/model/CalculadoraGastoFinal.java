package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class CalculadoraGastoFinal {

    public static BigDecimal calcularMateriaPrima(MateriaPrima materiaPrima){
        BigDecimal gastoFinalMP = new BigDecimal("0");
        try {
            gastoFinalMP = materiaPrima.getPrecoPagoMP().multiply(materiaPrima.getPesoUsadoFormulacaoMP())
                    .divide(materiaPrima.getPesoCompradoMP(),2, RoundingMode.UP);
            materiaPrima.setGastoFinalMP(gastoFinalMP);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return gastoFinalMP;
    }
}
