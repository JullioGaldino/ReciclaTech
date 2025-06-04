package com.reciclatech.cadastroFuncionario.model;

import jakarta.persistence.*;

@Entity
@Table(name = "caixa")
public class Caixa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "saldoID")
    private Integer saldoID;

    @Column(name = "saldoTotal")
    private Float saldoTotal;

    @Column(name = "valor")
    private Float valor;

    @Column(name = "responsavel", length = 20)
    private String responsavel;

    @Column(name = "metodoPg", length = 20)
    private String metodoPg;

    // Getters and Setters

    public Integer getSaldoID() {
        return saldoID;
    }

    public void setSaldoID(Integer saldoID) {
        this.saldoID = saldoID;
    }

    public Float getSaldoTotal() {
        return saldoTotal;
    }

    public void setSaldoTotal(Float saldoTotal) {
        this.saldoTotal = saldoTotal;
    }

    public Float getValor() {
        return valor;
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

