package model;

import java.text.DecimalFormat;

public class Calculadora extends MateriaPrima {

    public void calcularMateriaPrima(float precoMP, float pesoUsadoMP, float pesoCompradoMP){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        try {
            setPrecoPagoMP(precoMP);
            setPesoUsadoFormulacaoMP(pesoUsadoMP);
            setPesoCompradoMP(pesoCompradoMP);
            float gastoMP = ((precoMP * pesoUsadoMP) / pesoCompradoMP);
            setGastoFinalMP(gastoMP);
            System.out.println("Gasto desta Matéria-Prima: R$" + decimalFormat.format(gastoMP));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
