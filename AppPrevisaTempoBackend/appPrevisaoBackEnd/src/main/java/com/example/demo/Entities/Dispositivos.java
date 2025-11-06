package com.example.demo.Entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Dispositivos")
public class Dispositivos {
    @Id
    private String id;
    private String nome;
    private Double potencia;
    private Double consumoEstimado;
    private String categoria;
    private Double tempoDeUso;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPotencia() {
        return potencia;
    }

    public void setPotencia(Double potencia) {
        this.potencia = potencia;
    }

    public Double getConsumoEstimado() {
        return consumoEstimado;
    }

    public void setConsumoEstimado(Double consumoEstimado) {
        this.consumoEstimado = consumoEstimado;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getTempoDeUso() {
        return tempoDeUso;
    }

    public void setTempoDeUso(Double tempoDeUso) {
        this.tempoDeUso = tempoDeUso;
    }
}
