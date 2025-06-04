package com.example.reciclatechapp.models;

import com.google.gson.annotations.SerializedName;

public class Caixa {

    @SerializedName("saldoID")
    private Integer saldoID;

    @SerializedName("saldoTotal")
    private Float saldoTotal;

    @SerializedName("valor")
    private Float valor;

    @SerializedName("responsavel")
    private String responsavel;

    @SerializedName("metodoPg")
    private String metodoPg;

    public Caixa() {
    }

    public Caixa(Float valor, String responsavel, String metodoPg) {
        this.valor = valor;
        this.responsavel = responsavel;
        this.metodoPg = metodoPg;
    }

    public Integer getSaldoID() {
        return saldoID;
    }

    public void setSaldoID(Integer saldoID) {
        this.saldoID = saldoID;
    }

    public Float getSaldoTotal() {
        return saldoTotal != null ? saldoTotal : 0.0f;
    }

    public void setSaldoTotal(Float saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    public Float getValor() {
        return valor != null ? valor : 0.0f;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getMetodoPg() {
        return metodoPg;
    }

    public void setMetodoPg(String metodoPg) {
        this.metodoPg = metodoPg;
    }
}

