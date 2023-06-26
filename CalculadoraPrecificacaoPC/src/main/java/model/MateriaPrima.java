package model;

import jakarta.persistence.*;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class MateriaPrima {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nomeMP; //Nome da matéria-prima
    private double precoPagoMP; //Preço pago na matéria-prima;
    private double pesoUsadoFormulacaoMP; //Peso da matéria-prima usada na formulação;
    private double pesoCompradoMP; //Peso comprado de matéria-prima;
    private double gastoFinalMP; //Gasto da matéria-prima na formulação;

    private static final List<MateriaPrima> materiasPrimas = new ArrayList<>();

    public MateriaPrima() {
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public static List<MateriaPrima> getMateriaPrima() {
        return materiasPrimas;
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return "\nMateriaPrima{" +
                "id=" + id +
                ", nomeMP='" + nomeMP + '\'' +
                ", precoPagoMP=" + decimalFormat.format(precoPagoMP) +
                ", pesoUsadoFormulacaoMP=" + decimalFormat.format(pesoUsadoFormulacaoMP) +
                ", pesoCompradoMP=" + decimalFormat.format(pesoCompradoMP) +
                ", gastoFinalMP=" + decimalFormat.format(gastoFinalMP) +
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