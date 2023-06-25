package view;

import infra.DAOMateriaPrima;

import java.util.Scanner;

public class TelaPrincipal {
    Scanner sc = new Scanner(System.in);

    public void iniciarAplicativo() {
        int opcao;
        int id;

        while (true) {
            System.out.println("Menu: ");
            System.out.println("1 - Calcular/Adicionar nova matéria-prima");
            System.out.println("2 - Consultar lista de matérias-primas");
            System.out.println("3 - Atualizar matéria-prima");
            System.out.println("4 - Excluir matéria-prima");
            System.out.println("0 - Encerrar aplicativo");
            System.out.print("Digite o número da opção desejada: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1 -> DAOMateriaPrima.adicionarMateriaPrima();
                case 2 -> DAOMateriaPrima.consultarMateriasPrimas();
                case 3 -> DAOMateriaPrima.atualizarMateriaPrima();
                case 4 -> {
                    System.out.print("Digite o nome da matéria-prima que você deseja excluir: ");
                    id = sc.nextInt();
                    DAOMateriaPrima.deletarMateriaPrima(id);
                }
                case 0 -> System.exit(0);
            }
        }
    }
}
