package view;

import infra.DAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Calculadora;
import model.MateriaPrima;

public class Main {
    public static void main(String[] args) {

        TelaPrincipal telaPrincipal = new TelaPrincipal();

        System.out.println("*** Seja bem-vinda! ***");
        MateriaPrima materiaPrima = new MateriaPrima("Oxido",35,300,500);
        MateriaPrima materiaPrima2 = new MateriaPrima("Soda",50,200,1000);
        MateriaPrima materiaPrima3 = new MateriaPrima("Argila",15,100,500);
        Calculadora.calcularMateriaPrima(materiaPrima);
        Calculadora.calcularMateriaPrima(materiaPrima2);
        Calculadora.calcularMateriaPrima(materiaPrima3);
        telaPrincipal.iniciarAplicativo();



    }
}
