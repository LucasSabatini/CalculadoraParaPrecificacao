package br.com.sabatini;

import br.com.sabatini.view.TelaPrincipal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        SpringApplication.run(Main.class, args);

        TelaPrincipal telaPrincipal = new TelaPrincipal();

        System.out.println("*** Seja bem-vinda! ***");
        telaPrincipal.iniciarAplicativo();
    }
}