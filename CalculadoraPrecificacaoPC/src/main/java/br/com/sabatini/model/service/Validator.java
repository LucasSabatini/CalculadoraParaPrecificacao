package br.com.sabatini.model.service;

import br.com.sabatini.exception.EmptyFieldException;
import br.com.sabatini.model.entity.RawMaterial;

public class Validator {

    private Validator(){
    }

    public static boolean validateRawMaterial(RawMaterial rawMaterial) {
        if (rawMaterial.getPricePaid() == null) {
            throw new EmptyFieldException("preço pago");
        }
        if (rawMaterial.getWeightUsedInRecipe() == null) {
            throw new EmptyFieldException("peso usado na formulação");
        }
        if (rawMaterial.getWeightPurchased() == null) {
            throw new EmptyFieldException("peso comprado");
        }
        return true;
    }
}
