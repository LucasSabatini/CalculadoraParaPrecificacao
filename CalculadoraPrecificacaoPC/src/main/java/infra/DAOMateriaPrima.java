package infra;

import model.CalculadoraGastoFinal;
import model.MateriaPrima;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class DAOMateriaPrima {

    private static final DAO<MateriaPrima> dao = new DAO<>(MateriaPrima.class);
    private static final Scanner scanner = new Scanner(System.in);

    public static void adicionarMateriaPrima() {
        double precoPagoMP, pesoUsadoFormulacaoMP, pesoCompradoMP;
        String nomeMP;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");

        System.out.print("Digite o nome da matéria-prima: ");
        nomeMP = scanner.nextLine();
        System.out.print("Digite o valor pago na matéria-prima: R$");
        precoPagoMP = scanner.nextDouble();
        System.out.print("Digite o peso da matéria-prima usado na formulação: ");
        pesoUsadoFormulacaoMP = scanner.nextDouble();
        System.out.print("Digite o peso total, em gramas, da matéria-prima comprada: ");
        pesoCompradoMP = scanner.nextDouble();

        MateriaPrima materiaPrima = new MateriaPrima(nomeMP, precoPagoMP, pesoUsadoFormulacaoMP, pesoCompradoMP);
        double gastoFinal = CalculadoraGastoFinal.calcularMateriaPrima(materiaPrima);
        materiaPrima.setGastoFinalMP(gastoFinal);

        System.out.println("Valor da matéria-prima para esta formulação equivale a R$" + decimalFormat.format(gastoFinal) + "\n");

        for (MateriaPrima consulta : dao.consultarTodos()) {
            if (consulta.getNomeMP().equalsIgnoreCase(materiaPrima.getNomeMP())) {
                consulta.setPrecoPagoMP(materiaPrima.getPrecoPagoMP());
                consulta.setPesoUsadoFormulacaoMP(materiaPrima.getPesoUsadoFormulacaoMP());
                consulta.setPesoCompradoMP(materiaPrima.getPesoCompradoMP());
                consulta.setGastoFinalMP(CalculadoraGastoFinal.calcularMateriaPrima(consulta));
                dao.atualizarEntidade(consulta);
                return;
            }
        }
        dao.incluirCompleto(materiaPrima);
        System.out.println(materiaPrima);
    }

    public static List<MateriaPrima> consultarMateriasPrimas() {
        System.out.println(dao.consultarTodos());
        return dao.consultarTodos();
    }

    public static void atualizarMateriaPrima() {
        System.out.print("Digite o nome da matéria-prima que você deseja atualizar: ");
        String nome = scanner.nextLine();

        for (MateriaPrima consulta : dao.consultarTodos()) {
            if (consulta.getNomeMP().equalsIgnoreCase(nome)) {
                System.out.println("Qual atributo você deseja atualizar?");
                System.out.println("1 - Nome");
                System.out.println("2 - Preço pago na matéria-prima");
                System.out.println("3 - Peso usado na formulação");
                System.out.println("4 - Peso total comprado");
                System.out.print("Digite o número da opção: ");
                int opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1 -> {
                        System.out.print("Digite o novo nome: ");
                        consulta.setNomeMP(scanner.nextLine());
                        dao.atualizarEntidade(consulta);
                    }
                    case 2 -> {
                        System.out.print("Digite o novo preço pago: ");
                        consulta.setPrecoPagoMP(scanner.nextDouble());
                        consulta.setGastoFinalMP(CalculadoraGastoFinal.calcularMateriaPrima(consulta));
                        dao.atualizarEntidade(consulta);
                    }
                    case 3 -> {
                        System.out.print("Digite o novo peso usado na formulação: ");
                        consulta.setPesoUsadoFormulacaoMP(scanner.nextDouble());
                        consulta.setGastoFinalMP(CalculadoraGastoFinal.calcularMateriaPrima(consulta));
                        dao.atualizarEntidade(consulta);
                    }
                    case 4 -> {
                        System.out.print("Digite o novo peso total comprado: ");
                        consulta.setPesoCompradoMP(scanner.nextDouble());
                        consulta.setGastoFinalMP(CalculadoraGastoFinal.calcularMateriaPrima(consulta));
                        dao.atualizarEntidade(consulta);
                    }
                }
                System.out.println(consulta); //exibir produto atualizado
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
