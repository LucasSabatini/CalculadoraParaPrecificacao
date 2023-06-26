package view;

import infra.DAOMateriaPrima;

import java.util.Scanner;

public class TelaPrincipal {
    Scanner scanner = new Scanner(System.in);

    public void iniciarAplicativo(){
        while (true) {
            System.out.println("Menu: ");
            System.out.println("1 - Calcular/Adicionar nova matéria-prima");
            System.out.println("2 - Consultar lista de matérias-primas");
            System.out.println("3 - Atualizar matéria-prima");
            System.out.println("4 - Excluir matéria-prima");
            System.out.println("0 - Encerrar aplicativo");
            System.out.print("Digite o número da opção desejada: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1 -> DAOMateriaPrima.adicionarMateriaPrima();
                case 2 -> DAOMateriaPrima.consultarMateriasPrimas();
                case 3 -> DAOMateriaPrima.atualizarMateriaPrima();
                case 4 -> DAOMateriaPrima.excluirMateriaPrima();
                case 0 -> System.exit(0);
            }
        }
    }
}
