package model;

public class MateriaPrima {
    private float precoPagoMP; //Preço pago na matéria-prima;
    private float pesoUsadoFormulacaoMP; //Peso da matéria-prima usada na formulação;
    private float pesoCompradoMP; //Peso comprado de matéria-prima;
    private float gastoFinalMP; //Gasto da matéria-prima na formulação;

    public float getPrecoPagoMP(){
        return precoPagoMP;
    }

    public void setPrecoPagoMP(float precoPagoMP){
        this.precoPagoMP = precoPagoMP;
    }

    public float getPesoUsadoFormulacaoMP(){
        return pesoUsadoFormulacaoMP;
    }

    public void setPesoUsadoFormulacaoMP(float pesoUsadoFormulacaoMP){
        this.pesoUsadoFormulacaoMP = pesoUsadoFormulacaoMP;
    }

    public float getPesoCompradoMP(){
        return pesoCompradoMP;
    }

    public void setPesoCompradoMP(float pesoCompradoMP){
        this.pesoCompradoMP = pesoCompradoMP;
    }

    public float getGastoFinalMP(){
        return gastoFinalMP;
    }

    public void setGastoFinalMP(float gastoFinalMP){
        this.gastoFinalMP = gastoFinalMP;
    }
}
