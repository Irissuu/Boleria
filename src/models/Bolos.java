package models;

import enums.TipoBolo;

public class Bolos {
    private TipoBolo sabor;
    private String fabricacao;
    private String validade;
    private double preco;
    private String codigo;
    private String nome;

    public void exibirFichaTecnica() {
        System.out.println("Sabor: " + sabor);
        System.out.println("Preço: " + preco);
        System.out.println("Código do Produto: " + codigo);
        System.out.println("Data de Fabricação: " + fabricacao);
        System.out.println("Data de Validade: " + validade);
    }

    public TipoBolo getSabor() {
        return sabor;
    }

    public void setSabor(TipoBolo sabor) {
        this.sabor = sabor;
    }

    public String getFabricacao() {
        return fabricacao;
    }

    public void setFabricacao(String fabricacao) {
        this.fabricacao = fabricacao;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}