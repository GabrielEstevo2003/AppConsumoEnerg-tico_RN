package com.example.demo.DTOs;

import lombok.Data;

import java.util.List;

public class OpenWeatherDTO {
    private String cidade;
    private String pais;
    private Double temperatura;
    private Double sensacaoTermica;
    private Integer humidade;
    private Double velocidadeVento;
    private Double tempMinima;
    private Double tempMaxima;
    private List<PrevisaoChuvaDTO> previsoesChuva;

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getSensacaoTermica() {
        return sensacaoTermica;
    }

    public void setSensacaoTermica(Double sensacaoTermica) {
        this.sensacaoTermica = sensacaoTermica;
    }

    public Integer getHumidade() {
        return humidade;
    }

    public void setHumidade(Integer humidade) {
        this.humidade = humidade;
    }

    public Double getVelocidadeVento() {
        return velocidadeVento;
    }

    public void setVelocidadeVento(Double velocidadeVento) {
        this.velocidadeVento = velocidadeVento;
    }

    public Double getTempMinima() {
        return tempMinima;
    }

    public void setTempMinima(Double tempMinima) {
        this.tempMinima = tempMinima;
    }

    public Double getTempMaxima() {
        return tempMaxima;
    }

    public void setTempMaxima(Double tempMaxima) {
        this.tempMaxima = tempMaxima;
    }

    public List<PrevisaoChuvaDTO> getPrevisoesChuva() {
        return previsoesChuva;
    }

    public void setPrevisoesChuva(List<PrevisaoChuvaDTO> previsoesChuva) {
        this.previsoesChuva = previsoesChuva;
    }
}
