package com.reciclatech.RegistroSaida.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "registro_de_saida")
public class Saida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "registroId", nullable = false, unique = true)
    private Long registroId;


    @JsonProperty("Valor")
    @Column(name = "Valor", nullable = true)
    private Float Valor;

    @JsonProperty("Desc_produto")
    @Column(name = "desc_produto", nullable = false)
    private String Desc_produto;


    @JsonProperty("Forma_de_Pg")
    @Column(name = "form_de_pg", nullable = false)
    private String Forma_de_Pg;


    @JsonProperty("Funcionario")
    @Column(name = "funcionario", nullable = false)
    private String Funcionario;


    public Long getRegistroId() {
        return registroId;
    }

    public void setRegistroId(Long registroId) {
        this.registroId = registroId;
    }

    public Float getValor() {
        return Valor;
    }

    public void setValor(Float valor) {
        this.Valor = valor;
    }

    public String getDesc_produto() {
        return Desc_produto;
    }

    public void setDesc_produto(String desc_produto) {
        this.Desc_produto = desc_produto;
    }

    public String getForma_de_Pg() {
        return Forma_de_Pg;
    }

    public void setForma_de_Pg(String forma_de_Pg) {
        this.Forma_de_Pg = forma_de_Pg;
    }

    public String getFuncionario() {
        return Funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.Funcionario = funcionario;
    }
}

