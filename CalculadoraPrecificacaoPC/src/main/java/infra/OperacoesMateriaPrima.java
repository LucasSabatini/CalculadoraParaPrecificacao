package infra;

import model.MateriaPrima;

public class OperacoesMateriaPrima {

    public static void addMateriaPrima(MateriaPrima materiaPrima) {
        MateriaPrima.getMateriasPrimas().add(materiaPrima);
    }

    public static void consultarHistorico() {
        for(MateriaPrima materiaPrima : MateriaPrima.getMateriasPrimas()) {
            System.out.println(materiaPrima.toString());
        }
    }
}
