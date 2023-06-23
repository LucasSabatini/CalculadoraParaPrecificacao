package model;

public class Mercadoria {
    private float valorPorH; //Valor por hora trabalhada;
    private float horasTrabalhadas; //Horas trabalhadas;
    private float qtdProdutosFeitos; //Qtd produtos feitos;
    private float custosAdicionais; //Custos adicionais

        public float getValorPorH(){
        return valorPorH;
    }

        public void setValorPorH(float valorPorH){
        this.valorPorH = valorPorH;
    }

        public float getHorasTrabalhadas(){
        return horasTrabalhadas;
    }

        public void setHorasTrabalhadas(float horasTrabalhadas){
        this.horasTrabalhadas = horasTrabalhadas;
    }

        public float getQtdProdutosFeitos(){
        return qtdProdutosFeitos;
    }

        public void setQtdProdutosFeitos(float qtdProdutosFeitos){
        this.qtdProdutosFeitos = qtdProdutosFeitos;
    }

        public float getCustosAdicionais(){
        return custosAdicionais;
    }

        public void setCustosAdicionais(float custosAdicionais){
        this.custosAdicionais = custosAdicionais;
    }
}
