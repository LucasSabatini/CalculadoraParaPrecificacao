package model;

import jakarta.persistence.*;

import java.math.BigDecimal;
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
//    private double precoPagoMP; //Preço pago na matéria-prima;
//    private double pesoUsadoFormulacaoMP; //Peso da matéria-prima usada na formulação;
//    private double pesoCompradoMP; //Peso comprado de matéria-prima;
//    private double gastoFinalMP; //Gasto da matéria-prima na formulação;
    private BigDecimal precoPagoMP = new BigDecimal("0");
    private BigDecimal pesoUsadoFormulacaoMP = new BigDecimal("0");
    private BigDecimal pesoCompradoMP = new BigDecimal("0");
    private BigDecimal gastoFinalMP = new BigDecimal("0");

    private static final List<MateriaPrima> materiasPrimas = new ArrayList<>();

    public MateriaPrima() {
    }

    public MateriaPrima(BigDecimal precoPagoMP, BigDecimal pesoUsadoFormulacaoMP, BigDecimal pesoCompradoMP) {
        this.precoPagoMP = precoPagoMP;
        this.pesoUsadoFormulacaoMP = pesoUsadoFormulacaoMP;
        this.pesoCompradoMP = pesoCompradoMP;
    }

    public MateriaPrima(String nomeMP, BigDecimal precoPagoMP, BigDecimal pesoUsadoFormulacaoMP, BigDecimal pesoCompradoMP) {
        this.nomeMP = nomeMP;
        this.precoPagoMP = precoPagoMP;
        this.pesoUsadoFormulacaoMP = pesoUsadoFormulacaoMP;
        this.pesoCompradoMP = pesoCompradoMP;
    }

    public int getId() {
        return id;
    }

    public String getNomeMP() {
        return nomeMP;
    }

    public void setNomeMP(String nomeMP) {
        this.nomeMP = nomeMP;
    }

    public BigDecimal getPrecoPagoMP(){
        return precoPagoMP;
    }

    public void setPrecoPagoMP(BigDecimal precoPagoMP){
        this.precoPagoMP = precoPagoMP;
    }

    public BigDecimal getPesoUsadoFormulacaoMP(){
        return pesoUsadoFormulacaoMP;
    }

    public void setPesoUsadoFormulacaoMP(BigDecimal pesoUsadoFormulacaoMP){
        this.pesoUsadoFormulacaoMP = pesoUsadoFormulacaoMP;
    }

    public BigDecimal getPesoCompradoMP(){
        return pesoCompradoMP;
    }

    public void setPesoCompradoMP(BigDecimal pesoCompradoMP){
        this.pesoCompradoMP = pesoCompradoMP;
    }

    public BigDecimal getGastoFinalMP(){
        return gastoFinalMP;
    }

    public void setGastoFinalMP(BigDecimal gastoFinalMP){
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
        return id == that.id && Objects.equals(nomeMP, that.nomeMP) && Objects.equals(precoPagoMP, that.precoPagoMP) && Objects.equals(pesoUsadoFormulacaoMP, that.pesoUsadoFormulacaoMP) && Objects.equals(pesoCompradoMP, that.pesoCompradoMP) && Objects.equals(gastoFinalMP, that.gastoFinalMP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeMP, precoPagoMP, pesoUsadoFormulacaoMP, pesoCompradoMP, gastoFinalMP);
    }
}