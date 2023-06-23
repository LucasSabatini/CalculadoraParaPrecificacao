package model;

import java.text.DecimalFormat;

public class Calculadora extends MateriaPrima{

    public Calculadora(MateriaPrima materiaPrima) {
        super(materiaPrima.getPrecoPagoMP(), materiaPrima.getPesoUsadoFormulacaoMP(), materiaPrima.getPesoCompradoMP());
    }

    private Calculadora(double precoPagoMP, double pesoUsadoFormulacaoMP, double pesoCompradoMP) {
        super(precoPagoMP, pesoUsadoFormulacaoMP, pesoCompradoMP);
    }

    public double calcularMateriaPrima(MateriaPrima materiaPrima){
        double gastoFinalMP = 0;
        try {
            gastoFinalMP = ((materiaPrima.getPrecoPagoMP() * materiaPrima.getPesoUsadoFormulacaoMP()) / materiaPrima.getPesoCompradoMP());
            materiaPrima.setGastoFinalMP(gastoFinalMP);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return gastoFinalMP;
    }
}
