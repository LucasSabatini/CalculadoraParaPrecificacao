package br.com.sabatini.model.entity;

import java.math.BigDecimal;

public class Fees {
    private BigDecimal laborForceValue = new BigDecimal("0.15"); //.15% (real.: taxa variável) de taxas da força de trabalho;
    private BigDecimal administrativeCosts = new BigDecimal("0.15"); //.15% (real.: taxa variável) de taxas de custos administrativos;
    private BigDecimal desiredProfit = new BigDecimal("0.15"); //.Lucro desejado %;

    public BigDecimal getLaborForceValue(){
        return laborForceValue;
    }

    public void setLaborForceValue(BigDecimal laborForceValue){
        this.laborForceValue = laborForceValue;
    }

    public BigDecimal getAdministrativeCosts(){
        return administrativeCosts;
    }

    public void setAdministrativeCosts(BigDecimal administrativeCosts){
        this.administrativeCosts = administrativeCosts;
    }

    public BigDecimal getDesiredProfit(){
        return desiredProfit;
    }

    public void setDesiredProfit(BigDecimal desiredProfit){
        this.desiredProfit = desiredProfit;
    }
}
