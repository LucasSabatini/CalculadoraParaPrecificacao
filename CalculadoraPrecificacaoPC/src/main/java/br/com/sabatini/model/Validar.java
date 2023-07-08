package br.com.sabatini.model;

import br.com.sabatini.infrastructure.exceptions.CampoVazioException;
import br.com.sabatini.model.entity.MateriaPrima;

public class Validar {

    private Validar(){

    }

    public static boolean materiaPrima(MateriaPrima materiaPrima) {
        if (materiaPrima.getPrecoPagoMP() == null) {
            throw new CampoVazioException("preço pago");
        }
        if (materiaPrima.getPesoUsadoFormulacaoMP() == null) {
            throw new CampoVazioException("peso usado na formulação");
        }
        if (materiaPrima.getPesoCompradoMP() == null) {
            throw new CampoVazioException("peso comprado");
        }
        return true;
    }

}
