package br.com.sabatini.model.entity;

import java.math.BigDecimal;

public class Product {
    private String name; //Nome do seu produto final
    private BigDecimal valuePerHour; //Valor por hora trabalhada;
    private BigDecimal workedHours; //Horas trabalhadas;
    private BigDecimal quantityOfProductsMade; //Quantidade de produtos feitos;

    public Product() {
    }

    public Product(String name, BigDecimal valuePerHour, BigDecimal workedHours, BigDecimal quantityOfProductsMade) {
        this.name = name;
        this.valuePerHour = valuePerHour;
        this.workedHours = workedHours;
        this.quantityOfProductsMade = quantityOfProductsMade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(BigDecimal valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public BigDecimal getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(BigDecimal workedHours) {
        this.workedHours = workedHours;
    }

    public BigDecimal getQuantityOfProductsMade() {
        return quantityOfProductsMade;
    }

    public void setQuantityOfProductsMade(BigDecimal quantityOfProductsMade) {
        this.quantityOfProductsMade = quantityOfProductsMade;
    }
}
