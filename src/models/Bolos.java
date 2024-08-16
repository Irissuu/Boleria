package models;

public class Bolos {
    private String Sabor;
    private int Fabricacao;
    private int Validade;
    private double Preco;
    private String Codigo;


    public void exibirFichaTecnica(){
        System.out.println("Sabor: " + Sabor);
        System.out.println("Preço: " + Preco);
        System.out.println("Código do Produto: " + Codigo);
        System.out.println("Data de Fabricação: " + Fabricacao);
        System.out.println("Data de Validade: " + Validade);
    }

    public String getSabor() {
        return Sabor;
    }

    public void setSabor(String sabor) {
        Sabor = sabor;
    }

    public int getFabricacao() {
        return Fabricacao;
    }

    public void setFabricacao(int fabricacao) {
        Fabricacao = fabricacao;
    }

    public int getValidade() {
        return Validade;
    }

    public void setValidade(int validade) {
        Validade = validade;
    }

    public double getPreco() {
        return Preco;
    }

    public void setPreco(double preco) {
        Preco = preco;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String codigo) {
        Codigo = codigo;
    }
}
