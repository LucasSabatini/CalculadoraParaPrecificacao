package model;

public class Produto {
    private String nomeProduto; //Nome do seu produto final
    private double valorPorHora; //Valor por hora trabalhada;
    private double horasTrabalhadas; //Horas trabalhadas;
    private double qtdProdutosFeitos; //Qtd produtos feitos;
    private double custosAdicionais; //Custos adicionais

    public Produto() {
    }

    public Produto(String nomeProduto, double valorPorHora, double horasTrabalhadas, double qtdProdutosFeitos, double custosAdicionais) {
        this.nomeProduto = nomeProduto;
        this.valorPorHora = valorPorHora;
        this.horasTrabalhadas = horasTrabalhadas;
        this.qtdProdutosFeitos = qtdProdutosFeitos;
        this.custosAdicionais = custosAdicionais;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public double getQtdProdutosFeitos() {
        return qtdProdutosFeitos;
    }

    public void setQtdProdutosFeitos(double qtdProdutosFeitos) {
        this.qtdProdutosFeitos = qtdProdutosFeitos;
    }

    public double getCustosAdicionais() {
        return custosAdicionais;
    }

    public void setCustosAdicionais(double custosAdicionais) {
        this.custosAdicionais = custosAdicionais;
    }
}
