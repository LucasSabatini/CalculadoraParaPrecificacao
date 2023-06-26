package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class CalculadoraGastoFinal {

    public static BigDecimal calcularMateriaPrima(MateriaPrima materiaPrima){
        try {
            BigDecimal gastoFinalMP;
            gastoFinalMP = materiaPrima.getPrecoPagoMP().multiply(materiaPrima.getPesoUsadoFormulacaoMP())
                    .divide(materiaPrima.getPesoCompradoMP(),2, RoundingMode.UP);
            materiaPrima.setGastoFinalMP(gastoFinalMP);
            return gastoFinalMP;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return new BigDecimal("0"); //!!!!!!!
        }
    }
}
