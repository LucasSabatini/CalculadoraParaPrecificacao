package br.com.sabatini.model.dao;

import br.com.sabatini.exception.IdNaoEncontradoException;
import br.com.sabatini.model.service.CalculadoraGastoFinal;
import br.com.sabatini.model.entity.MateriaPrima;
import br.com.sabatini.model.service.Validar;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class DAOMateriaPrima {

    private static final DAO<MateriaPrima> dao = new DAO<>(MateriaPrima.class);
    private static final Scanner scanner = new Scanner(System.in);

    public static MateriaPrima adicionarMateriaPrima() {
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
        scanner.nextLine();

        MateriaPrima materiaPrima = new MateriaPrima(nomeMP, precoPagoMP, pesoUsadoFormulacaoMP, pesoCompradoMP);
        Validar.validarMateriaPrima(materiaPrima);

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
                return consulta;
            }
        }
        dao.incluirCompleto(materiaPrima);
        System.out.println(materiaPrima);
        return materiaPrima;
    }

    public static List<MateriaPrima> consultarMateriasPrimas() {
        System.out.println(dao.consultarTodos());
        return dao.consultarTodos();
    }

    public static MateriaPrima atualizarMateriaPrima() {
        System.out.print("Digite o id da matéria-prima que você deseja atualizar: ");
        Long id = scanner.nextLong();
        scanner.nextLine();

        for (MateriaPrima consulta : dao.consultarTodos()) {
            if (consulta.getId().equals(id)) {
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
                return consulta;
            }
        }
        throw new IdNaoEncontradoException(id);
    }

    public static void excluirMateriaPrima() {
        System.out.print("Digite o id da matéria-prima que você deseja excluir: ");
        Long id = scanner.nextLong();

        for (MateriaPrima consulta : dao.consultarTodos()) {
            if (consulta.getId().equals(id)) {
                dao.excluirEntidade(consulta);
                System.out.println("Matéria-prima excluída com sucesso!");
                return;
            }
        }
        throw new IdNaoEncontradoException(id);
    }
}
