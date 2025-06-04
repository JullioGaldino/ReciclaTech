package com.example.reciclatechapp.models;

public class Saida {
    private String funcionario;
    private double valor;
    private String Forma_de_Pg;
    private String Desc_produto;

    public String getFuncionario() { return funcionario; }
    public void setFuncionario(String funcionario) { this.funcionario = funcionario; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    public String getForma_de_Pg() { return Forma_de_Pg; }
    public void setForma_de_Pg(String forma_de_Pg) { this.Forma_de_Pg = forma_de_Pg; }

    public String getDesc_produto() { return Desc_produto; }
    public void setDesc_produto(String desc_produto) { this.Desc_produto = desc_produto; }
}