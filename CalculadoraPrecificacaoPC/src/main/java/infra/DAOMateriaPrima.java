package controller;

import infra.DAO;
import model.Calculadora;
import model.MateriaPrima;

import java.util.List;
import java.util.Scanner;

public class MateriaPrimaController {

    private static final DAO<MateriaPrima> dao = new DAO<>(MateriaPrima.class);

    public static void adicionarMateriaPrima(MateriaPrima materiaPrima) {
        for (MateriaPrima consulta : dao.consultarTodos()) {
            if (consulta.getNomeMP().equalsIgnoreCase(materiaPrima.getNomeMP())) {
                consulta.setPrecoPagoMP(materiaPrima.getPrecoPagoMP());
                consulta.setPesoUsadoFormulacaoMP(materiaPrima.getPesoUsadoFormulacaoMP());
                consulta.setPesoCompradoMP(materiaPrima.getPesoCompradoMP());
                consulta.setGastoFinalMP(Calculadora.calcularMateriaPrima(consulta));
                dao.atualizarMateriaPrima(consulta);
                return;
            }
        }
        dao.incluirCompleto(materiaPrima);
        System.out.println(MateriaPrima.getMateriaPrima());
    }

    public static List<MateriaPrima> consultarMateriasPrimas() {
        return dao.consultarTodos();
    }

    public static void atualizarMateriaPrima(String nome) {
        Scanner sc = new Scanner(System.in);

        for (MateriaPrima consulta : dao.consultarTodos()) {
            if (consulta.getNomeMP().equalsIgnoreCase(nome)) {
                System.out.println("Qual atributo você deseja atualizar?");
                System.out.println("1 - Nome");
                System.out.println("2 - Preço pago na matéria-prima");
                System.out.println("3 - Peso usado na formulação");
                System.out.println("4 - Peso total comprado");
                System.out.print("Digite o número da opção: ");
                int opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1 -> {
                        System.out.print("Digite o novo nome: ");
                        consulta.setNomeMP(sc.nextLine());
                        dao.atualizarMateriaPrima(consulta);
                    }
                    case 2 -> {
                        System.out.print("Digite o novo preço pago: ");
                        consulta.setPrecoPagoMP(sc.nextDouble());
                        consulta.setGastoFinalMP(Calculadora.calcularMateriaPrima(consulta));
                        dao.atualizarMateriaPrima(consulta);
                    }
                    case 3 -> {
                        System.out.print("Digite o novo peso usado na formulação: ");
                        consulta.setPesoUsadoFormulacaoMP(sc.nextDouble());
                        consulta.setGastoFinalMP(Calculadora.calcularMateriaPrima(consulta));
                        dao.atualizarMateriaPrima(consulta);
                    }
                    case 4 -> {
                        System.out.print("Digite o novo peso total comprado: ");
                        consulta.setPesoCompradoMP(sc.nextDouble());
                        consulta.setGastoFinalMP(Calculadora.calcularMateriaPrima(consulta));
                        dao.atualizarMateriaPrima(consulta);
                    }
                }
            }
        }
    }

    public static void deletarMateriaPrima(int id) {
        for (MateriaPrima consulta : MateriaPrima.getMateriaPrima()) {
            if (consulta.getId() == id) {
                MateriaPrima.getMateriaPrima().remove(consulta);
                //dao. // imple. método delete
                System.out.println("Matéria-prima excluída com sucesso!");
            } else {
                System.out.println("Matéria-prima não encontrada.");
            }
            return;
        }
    }
}
