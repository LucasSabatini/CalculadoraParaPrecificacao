package br.com.sabatini.model.entity;

import br.com.sabatini.model.dto.MateriaPrimaResponseDTO;
import br.com.sabatini.model.service.CalculadoraGastoFinal;
import br.com.sabatini.model.dto.MateriaPrimaRequestDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Objects;

@Table(name = "materia_prima")
@Entity
public class MateriaPrima {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomeMP", nullable = false)
    private String nomeMP; //Nome da matéria-prima

    @Column(name = "precoPagoMP")
    private BigDecimal precoPagoMP; //Preço pago na matéria-prima

    @Column(name = "pesoUsadoFormulacaoMP")
    private BigDecimal pesoUsadoFormulacaoMP; //Peso da matéria-prima usada na formulação

    @Column(name = "pesoCompradoMP")
    private BigDecimal pesoCompradoMP; //Peso comprado de matéria-prima

    @Column(name = "gastoFinalMP")
    private BigDecimal gastoFinalMP; //Gasto final da matéria-prima na formulação

    public MateriaPrima() {
    }

    public MateriaPrima(BigDecimal precoPagoMP, BigDecimal pesoUsadoFormulacaoMP, BigDecimal pesoCompradoMP) {
        this.precoPagoMP = precoPagoMP;
        this.pesoUsadoFormulacaoMP = pesoUsadoFormulacaoMP;
        this.pesoCompradoMP = pesoCompradoMP;
    }

    public MateriaPrima(MateriaPrimaRequestDTO materiaPrimaRequestDTO) {
        this.nomeMP = materiaPrimaRequestDTO.nomeMP();
        this.precoPagoMP = materiaPrimaRequestDTO.precoPagoMP();
        this.pesoUsadoFormulacaoMP = materiaPrimaRequestDTO.pesoUsadoFormulacaoMP();
        this.pesoCompradoMP = materiaPrimaRequestDTO.pesoCompradoMP();
    }

    public MateriaPrima(String nomeMP, BigDecimal precoPagoMP, BigDecimal pesoUsadoFormulacaoMP, BigDecimal pesoCompradoMP) {
        this.nomeMP = nomeMP;
        this.precoPagoMP = precoPagoMP;
        this.pesoUsadoFormulacaoMP = pesoUsadoFormulacaoMP;
        this.pesoCompradoMP = pesoCompradoMP;
    }

    public MateriaPrima(MateriaPrimaResponseDTO materiaPrimaResponseDTO) {
        this.nomeMP = materiaPrimaResponseDTO.nomeMP();
        this.precoPagoMP = materiaPrimaResponseDTO.precoPagoMP();
        this.pesoUsadoFormulacaoMP = materiaPrimaResponseDTO.pesoUsadoFormulacaoMP();
        this.pesoCompradoMP = materiaPrimaResponseDTO.pesoCompradoMP();
    }

    public Long getId() {
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
        CalculadoraGastoFinal.calcularMateriaPrima(this);
        return gastoFinalMP;
    }

    public void setGastoFinalMP(BigDecimal gastoFinalMP){
        this.gastoFinalMP = gastoFinalMP;
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
        return Objects.equals(id, that.id) && Objects.equals(nomeMP, that.nomeMP) && Objects.equals(precoPagoMP, that.precoPagoMP) && Objects.equals(pesoUsadoFormulacaoMP, that.pesoUsadoFormulacaoMP) && Objects.equals(pesoCompradoMP, that.pesoCompradoMP) && Objects.equals(gastoFinalMP, that.gastoFinalMP);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeMP, precoPagoMP, pesoUsadoFormulacaoMP, pesoCompradoMP, gastoFinalMP);
    }
}