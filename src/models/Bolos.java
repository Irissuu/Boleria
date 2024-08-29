package models;

import enums.TipoBolo;

public class Bolos {
    private TipoBolo Sabor; // Alterado para TipoBolo
    private String Fabricacao;
    private String Validade;
    private double Preco;
    private String Codigo;
    private String Nome;

    public void exibirFichaTecnica() {
        System.out.println("Sabor: " + Sabor);
        System.out.println("Preço: " + Preco);
        System.out.println("Código do Produto: " + Codigo);
        System.out.println("Data de Fabricação: " + Fabricacao);
        System.out.println("Data de Validade: " + Validade);
    }

    public TipoBolo getSabor() {
        return Sabor;
    }

    public void setSabor(TipoBolo sabor) {
        Sabor = sabor;
    }

    public String getFabricacao() {
        return Fabricacao;
    }

    public void setFabricacao(String fabricacao) {
        Fabricacao = fabricacao;
    }

    public String getValidade() {
        return Validade;
    }

    public void setValidade(String validade) {
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

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        this.Nome = nome;
    }
}
