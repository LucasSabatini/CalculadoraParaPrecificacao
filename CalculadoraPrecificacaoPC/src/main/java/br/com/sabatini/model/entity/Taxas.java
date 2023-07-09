package br.com.sabatini.model;

public class Taxas {
    private float forcaDeTrabalho = 0.15F; //.15% (real.: taxa variável) de taxas da força de trabalho;
    private float custosAdm = 0.15F; //.15% (real.: taxa variável) de taxas de custos administrativos;
    private float lucroDesejado = 0.15F; //.Lucro desejado %;

    public float getForcaDeTrabalho(){
        return forcaDeTrabalho;
    }

    public void setForcaDeTrabalho(float forcaDeTrabalho){
        this.forcaDeTrabalho = forcaDeTrabalho;
    }

    public float getCustosAdm(){
        return custosAdm;
    }

    public void setCustosAdm(float custosAdm){
        this.custosAdm = custosAdm;
    }

    public float getLucroDesejado(){
        return lucroDesejado;
    }

    public void setLucroDesejado(float lucroDesejado){
        this.lucroDesejado = lucroDesejado;
    }
}
