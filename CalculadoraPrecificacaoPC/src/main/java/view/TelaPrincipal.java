package view;

import infra.OperacoesMateriaPrima;
import model.Calculadora;

import java.util.Scanner;

import static java.lang.System.in;

public class TelaPrincipal {
    Scanner sc = new Scanner(in);

    public void iniciarAplicativo() {
        int opcao;

        while (true) {
            System.out.println("Menu: ");
            System.out.println("1 - Calcular nova matéria-prima");
            System.out.println("2 - Consultar histórico");
            System.out.println("3 - Atualizar matéria-prima");
            System.out.println("4 - Excluir matéria-prima");
            System.out.println("0 - Encerrar aplicativo");
            System.out.print("Digite o número da opção desejada: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> Calculadora.iniciarCalculadora();
                case 2 -> OperacoesMateriaPrima.consultarHistorico();
                case 3 -> {
                    System.out.print("Digite o nome da matéria-prima que você deseja atualizar: ");
                    String nome = sc.nextLine();
                    OperacoesMateriaPrima.atualizarMateriaPrima(nome);
                }
                case 4 -> {
                    System.out.print("Digite o nome da matéria-prima que você deseja excluir: ");
                    String nome = sc.nextLine();
                    OperacoesMateriaPrima.deletarMateriaPrima(nome);
                }
                case 0 -> System.exit(0);
            }
        }
    }
}
