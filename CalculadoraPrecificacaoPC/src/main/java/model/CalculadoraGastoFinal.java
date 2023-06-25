package model;

public abstract class Calculadora {

    public static double calcularMateriaPrima(MateriaPrima materiaPrima){
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
