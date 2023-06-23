package view;

import model.Calculadora;

import java.util.Scanner;

public class TelaPrincipal {

    public void iniciarAplicativo() {
        Scanner sc = new Scanner(System.in);
        int opcao;
        while (true) {
            System.out.println("Menu: ");
            System.out.println("1 - Calcular nova matéria-prima");
            System.out.println("2 - Consultar histórico");
            System.out.println("0 - Encerrar aplicativo");
            System.out.print("Digite o número da opção desejada: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> Calculadora.iniciarCalculadora();
                case 2 -> Calculadora.consultarHistorico();
                case 0 -> System.exit(0);
            }
        }
    }

}
