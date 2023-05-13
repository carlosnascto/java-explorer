package com.digytal.contacorrente.model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Movimentacao {
    LocalDate dataMov;
    Double valorMov;
    String descricao;
    String tipoMovimentacao;
    Integer numeroConta;


    public LocalDate getDataMov() {
        return dataMov;
    }

    public void setDataMov(LocalDate dataMov) {
        this.dataMov = dataMov;
    }

    public Integer getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(Integer numeroConta) {
        this.numeroConta = numeroConta;
    }
    public LocalDate dataMov() {
        return dataMov;
    }


    public double getValorMov() {
        return valorMov;
    }

    public void setValorMov(double valorMov) {
        this.valorMov = valorMov;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }
}
