package view;

import model.Calculadora;
import model.MateriaPrima;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TelaPrincipal {

    public MateriaPrima iniciarCalculadora() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        Scanner sc = new Scanner(System.in);
        double precoPagoMP, pesoUsadoFormulacaoMP, pesoCompradoMP;
        String nomeMP;

        System.out.print("Digite o nome da matéria-prima: ");
        nomeMP = sc.nextLine();
        System.out.print("Digite o valor pago na matéria-prima: R$");
        precoPagoMP = sc.nextDouble();
        System.out.print("Digite o peso da matéria-prima usado na formulação: ");
        pesoUsadoFormulacaoMP = sc.nextDouble();
        System.out.print("Digite o peso total, em gramas, da matéria-prima comprada: ");
        pesoCompradoMP = sc.nextDouble();

        MateriaPrima materiaPrima = new MateriaPrima(nomeMP, precoPagoMP, pesoUsadoFormulacaoMP, pesoCompradoMP);
        materiaPrima.setGastoFinalMP(Calculadora.calcularMateriaPrima(materiaPrima));

        System.out.println("Valor da matéria-prima para esta formulação equivale a R$" + decimalFormat.format(Calculadora.calcularMateriaPrima(materiaPrima)));

        return materiaPrima;
    }
}
