package br.com.sabatini.model.entity;

public class Fees {
    private float laborForceValue = 0.15F; //.15% (real.: taxa variável) de taxas da força de trabalho;
    private float administrativeCosts = 0.15F; //.15% (real.: taxa variável) de taxas de custos administrativos;
    private float desiredProfit = 0.15F; //.Lucro desejado %;

    public float getLaborForceValue(){
        return laborForceValue;
    }

    public void setLaborForceValue(float laborForceValue){
        this.laborForceValue = laborForceValue;
    }

    public float getAdministrativeCosts(){
        return administrativeCosts;
    }

    public void setAdministrativeCosts(float administrativeCosts){
        this.administrativeCosts = administrativeCosts;
    }

    public float getDesiredProfit(){
        return desiredProfit;
    }

    public void setDesiredProfit(float desiredProfit){
        this.desiredProfit = desiredProfit;
    }
}
