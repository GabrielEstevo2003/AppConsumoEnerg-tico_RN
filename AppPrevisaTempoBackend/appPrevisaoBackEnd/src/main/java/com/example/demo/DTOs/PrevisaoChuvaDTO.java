package com.example.demo.DTOs;

import lombok.Data;


public class PrevisaoChuvaDTO {
    private String dataHora;
    private String precitacao;
    private String descricao;

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getPrecitacao() {
        return precitacao;
    }

    public void setPrecitacao(String precitacao) {
        this.precitacao = precitacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
