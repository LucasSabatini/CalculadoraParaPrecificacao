package model;

public class MateriaPrima {
    private double precoPagoMP; //Preço pago na matéria-prima;
    private double pesoUsadoFormulacaoMP; //Peso da matéria-prima usada na formulação;
    private double pesoCompradoMP; //Peso comprado de matéria-prima;
    private double gastoFinalMP; //Gasto da matéria-prima na formulação;

    public MateriaPrima(double precoPagoMP, double pesoUsadoFormulacaoMP, double pesoCompradoMP) {
        this.precoPagoMP = precoPagoMP;
        this.pesoUsadoFormulacaoMP = pesoUsadoFormulacaoMP;
        this.pesoCompradoMP = pesoCompradoMP;
    }

    public double getPrecoPagoMP(){
        return precoPagoMP;
    }

    public void setPrecoPagoMP(double precoPagoMP){
        this.precoPagoMP = precoPagoMP;
    }

    public double getPesoUsadoFormulacaoMP(){
        return pesoUsadoFormulacaoMP;
    }

    public void setPesoUsadoFormulacaoMP(double pesoUsadoFormulacaoMP){
        this.pesoUsadoFormulacaoMP = pesoUsadoFormulacaoMP;
    }

    public double getPesoCompradoMP(){
        return pesoCompradoMP;
    }

    public void setPesoCompradoMP(double pesoCompradoMP){
        this.pesoCompradoMP = pesoCompradoMP;
    }

    public double getGastoFinalMP(){
        return gastoFinalMP;
    }

    public void setGastoFinalMP(double gastoFinalMP){
        this.gastoFinalMP = gastoFinalMP;
    }
}
