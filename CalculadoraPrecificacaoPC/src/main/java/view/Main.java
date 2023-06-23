package view;

import model.MateriaPrima;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<MateriaPrima> materiasPrimas = new ArrayList<>();
        TelaPrincipal telaPrincipal = new TelaPrincipal();

        System.out.println("*** Seja bem-vinda ***");
        materiasPrimas.add(telaPrincipal.iniciarCalculadora());

        for(MateriaPrima materiaPrima : materiasPrimas) {
            System.out.println(materiaPrima);
        }

    }
}
