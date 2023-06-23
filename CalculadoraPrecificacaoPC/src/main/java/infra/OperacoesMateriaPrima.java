package infra;

import model.Calculadora;
import model.MateriaPrima;
import org.hibernate.dialect.MariaDBDialect;

import java.util.List;
import java.util.Scanner;

public class OperacoesMateriaPrima {

    public static void addMateriaPrima(MateriaPrima materiaPrima) {
        for (MateriaPrima consulta : MateriaPrima.getMateriaPrima()) {
            if (consulta.getNomeMP().equals(materiaPrima.getNomeMP())) {
                consulta.setPrecoPagoMP(materiaPrima.getPrecoPagoMP());
                consulta.setPesoUsadoFormulacaoMP(materiaPrima.getPesoUsadoFormulacaoMP());
                consulta.setPesoCompradoMP(materiaPrima.getPesoCompradoMP());
                consulta.setGastoFinalMP(Calculadora.calcularMateriaPrima(consulta));
                return;
            }
        }
        MateriaPrima.getMateriaPrima().add(materiaPrima);
    }

    public static List<MateriaPrima> consultarHistorico() {
        MateriaPrima.getMateriaPrima().forEach(System.out::println);
        return MateriaPrima.getMateriaPrima();
    }

    public static void atualizarMateriaPrima(String nome) {
        Scanner sc = new Scanner(System.in);

        for (MateriaPrima consulta : MateriaPrima.getMateriaPrima()) {
            if (consulta.getNomeMP().equals(nome)) {
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
                    }
                    case 2 -> {
                        System.out.print("Digite o novo preço pago: ");
                        consulta.setPrecoPagoMP(sc.nextDouble());
                        consulta.setGastoFinalMP(Calculadora.calcularMateriaPrima(consulta));
                    }
                    case 3 -> {
                        System.out.print("Digite o novo peso usado na formulação: ");
                        consulta.setPesoUsadoFormulacaoMP(sc.nextDouble());
                        consulta.setGastoFinalMP(Calculadora.calcularMateriaPrima(consulta));
                    }
                    case 4 -> {
                        System.out.print("Digite o novo peso total comprado: ");
                        consulta.setPesoCompradoMP(sc.nextDouble());
                        consulta.setGastoFinalMP(Calculadora.calcularMateriaPrima(consulta));
                    }
                }
            }
        }
    }

    public static void excluirMateriaPrima(String nome) {
        for (MateriaPrima consulta : MateriaPrima.getMateriaPrima()) {
            if (consulta.getNomeMP().equals(nome)) {
                MateriaPrima.getMateriaPrima().remove(consulta);
                System.out.println("Matéria-prima excluída co sucesso!");
            } else {
                System.out.println("Matéria-prima não encontrada.");
            }
            return;
        }
    }
}
