package infra;

import model.CalculadoraGastoFinal;
import model.MateriaPrima;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DAOMateriaPrima {

    private static final DAO<MateriaPrima> dao = new DAO<>(MateriaPrima.class);
    private static final Scanner scanner = new Scanner(System.in);

    public static void adicionarMateriaPrima() {
        try {
            BigDecimal precoPagoMP, pesoUsadoFormulacaoMP, pesoCompradoMP, gastoFinal;
            String nomeMP;
            DecimalFormat decimalFormat = new DecimalFormat("#.##");

            System.out.print("Digite o nome da matéria-prima: ");
            nomeMP = scanner.nextLine();
            System.out.print("Digite o valor pago na matéria-prima: R$");
            precoPagoMP = scanner.nextBigDecimal();
            System.out.print("Digite a quantidade, em gramas, da matéria-prima usada na formulação: ");
            pesoUsadoFormulacaoMP = scanner.nextBigDecimal();
            System.out.print("Digite quantidade total, em gramas, da matéria-prima comprada: ");
            pesoCompradoMP = scanner.nextBigDecimal();

            MateriaPrima materiaPrima = new MateriaPrima(nomeMP, precoPagoMP, pesoUsadoFormulacaoMP, pesoCompradoMP);

            gastoFinal = CalculadoraGastoFinal.calcularMateriaPrima(materiaPrima);
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
        } catch (InputMismatchException e) {
            System.out.println("Digite um valor válido. Use vírgulas para separar as casas decimais.");
        } catch (NullPointerException f) {
            System.out.println("Tente adicionar a matéria-prima novamente");
        } finally {
            scanner.nextLine();
        }
    }

    public static List<MateriaPrima> consultarMateriasPrimas() {
        System.out.println(dao.consultarTodos());
        return dao.consultarTodos();
    }

    public static void atualizarMateriaPrima() {
        try {
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
                            consulta.setPrecoPagoMP(scanner.nextBigDecimal());
                            consulta.setGastoFinalMP(CalculadoraGastoFinal.calcularMateriaPrima(consulta));
                            dao.atualizarEntidade(consulta);
                        }
                        case 3 -> {
                            System.out.print("Digite o novo peso usado na formulação: ");
                            consulta.setPesoUsadoFormulacaoMP(scanner.nextBigDecimal());
                            consulta.setGastoFinalMP(CalculadoraGastoFinal.calcularMateriaPrima(consulta));
                            dao.atualizarEntidade(consulta);
                        }
                        case 4 -> {
                            System.out.print("Digite o novo peso total comprado: ");
                            consulta.setPesoCompradoMP(scanner.nextBigDecimal());
                            consulta.setGastoFinalMP(CalculadoraGastoFinal.calcularMateriaPrima(consulta));
                            dao.atualizarEntidade(consulta);
                        }
                    }
                    System.out.println(consulta); //exibir produto atualizado
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Digite um valor válido. Use vírgulas para separar as casas decimais.");
        }
    }

    public static void excluirMateriaPrima() {
        try {
            System.out.print("Digite o id da matéria-prima que você deseja excluir: ");
            int id = scanner.nextInt();

            for (MateriaPrima consulta : dao.consultarTodos()) {
                if (consulta.getId() == id) {
                    dao.excluirEntidade(consulta);
                    System.out.println("Matéria-prima excluída com sucesso!");
                    return;
                }
            }
            System.out.println("Matéria-prima não encontrada!");
        } catch (InputMismatchException e) {
            System.out.println("Digite um valor válido. Use vírgulas para separar as casas decimais.");
        } finally {
            scanner.nextLine();
        }
    }
}
