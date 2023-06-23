package model;

import java.util.Objects;

public class MateriaPrima {
    private String nomeMP; //Nome da matéria-prima
    private double precoPagoMP; //Preço pago na matéria-prima;
    private double pesoUsadoFormulacaoMP; //Peso da matéria-prima usada na formulação;
    private double pesoCompradoMP; //Peso comprado de matéria-prima;
    private double gastoFinalMP; //Gasto da matéria-prima na formulação;

    public MateriaPrima(double precoPagoMP, double pesoUsadoFormulacaoMP, double pesoCompradoMP) {
        this.precoPagoMP = precoPagoMP;
        this.pesoUsadoFormulacaoMP = pesoUsadoFormulacaoMP;
        this.pesoCompradoMP = pesoCompradoMP;
    }

    public MateriaPrima(String nomeMP, double precoPagoMP, double pesoUsadoFormulacaoMP, double pesoCompradoMP) {
        this.nomeMP = nomeMP;
        this.precoPagoMP = precoPagoMP;
        this.pesoUsadoFormulacaoMP = pesoUsadoFormulacaoMP;
        this.pesoCompradoMP = pesoCompradoMP;
    }

    public String getNomeMP() {
        return nomeMP;
    }

    public void setNomeMP(String nomeMP) {
        this.nomeMP = nomeMP;
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

    @Override
    public String toString() {
        return "MateriaPrima{" +
                "nomeMP='" + nomeMP + '\'' +
                ", precoPagoMP=" + precoPagoMP +
                ", pesoUsadoFormulacaoMP=" + pesoUsadoFormulacaoMP +
                ", pesoCompradoMP=" + pesoCompradoMP +
                ", gastoFinalMP=" + gastoFinalMP +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MateriaPrima that = (MateriaPrima) o;
        return Double.compare(that.precoPagoMP, precoPagoMP) == 0 && Double.compare(that.pesoUsadoFormulacaoMP, pesoUsadoFormulacaoMP) == 0 && Double.compare(that.pesoCompradoMP, pesoCompradoMP) == 0 && Double.compare(that.gastoFinalMP, gastoFinalMP) == 0 && Objects.equals(nomeMP, that.nomeMP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomeMP, precoPagoMP, pesoUsadoFormulacaoMP, pesoCompradoMP, gastoFinalMP);
    }
}
