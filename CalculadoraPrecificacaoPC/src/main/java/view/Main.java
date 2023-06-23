package view;

import model.Calculadora;
import model.MateriaPrima;

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {

        MateriaPrima materiaPrima = new MateriaPrima(35.50f, 100f, 500f);
        Calculadora calculadora = new Calculadora(materiaPrima);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        System.out.println("Valor gasto de Matéria-Prima usada na formulação -> R$" +
                decimalFormat.format(calculadora.calcularMateriaPrima(materiaPrima)));

    }
}
