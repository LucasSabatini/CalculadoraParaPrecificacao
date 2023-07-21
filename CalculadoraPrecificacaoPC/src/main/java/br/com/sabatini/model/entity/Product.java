package br.com.sabatini.model.entity;

public class Product {
    private String name; //Nome do seu produto final
    private double valuePerHour; //Valor por hora trabalhada;
    private double workedHours; //Horas trabalhadas;
    private double quantityOfProductsMade; //Quantidade de produtos feitos;

    public Product() {
    }

    public Product(String name, double valuePerHour, double workedHours, double quantityOfProductsMade) {
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

    public double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public double getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(double workedHours) {
        this.workedHours = workedHours;
    }

    public double getQuantityOfProductsMade() {
        return quantityOfProductsMade;
    }

    public void setQuantityOfProductsMade(double quantityOfProductsMade) {
        this.quantityOfProductsMade = quantityOfProductsMade;
    }
}
