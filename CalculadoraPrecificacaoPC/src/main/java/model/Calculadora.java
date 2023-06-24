package model;

import infra.DAOMateriaPrima;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Calculadora {

    private Calculadora() {

    }

    public static void iniciarCalculadora() {
        Scanner sc = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

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

        System.out.println("Valor da matéria-prima para esta formulação equivale a R$" + decimalFormat.format(Calculadora.calcularMateriaPrima(materiaPrima)) + "\n");
        DAOMateriaPrima.adicionarMateriaPrima(materiaPrima);
    }

    public static double calcularMateriaPrima(MateriaPrima materiaPrima){
        double gastoFinalMP = 0;
        try {
            gastoFinalMP = ((materiaPrima.getPrecoPagoMP() * materiaPrima.getPesoUsadoFormulacaoMP()) / materiaPrima.getPesoCompradoMP());
            materiaPrima.setGastoFinalMP(gastoFinalMP);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return gastoFinalMP;
    }
}
