package com.digytal.contacorrente.model;

import com.digytal.contacorrente.repository.MovimentacaoRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class ContaCorrente {
    MovimentacaoRepository movimentacaoRepository = new MovimentacaoRepository();

    Integer numeroConta;
    Integer numeroAgencia;
    Double saldoConta;
    String nomeCliente;
    LocalDate dataNascimento;

    public int getNumeroConta() {
        return numeroConta;
    }



    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    public void setNumeroAgencia(int numeroAgencia) {
        this.numeroAgencia = numeroAgencia;
    }

    public double getSaldoConta() {
        return saldoConta;
    }

    public void setSaldoConta(Double saldoConta) {
        this.saldoConta = saldoConta;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public static ArrayList<Movimentacao> movimentacoes = new ArrayList<Movimentacao>();





    /* public void obterHistorico() {
        DateTimeFormatter formatar = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        StringBuilder sb = new StringBuilder("----- HISTÓRICO DE MOVIMENTAÇÕES -----\n");


        sb.append("Tipo" + " | Valor" +" | Data" +" | Descrição" + "\n");
        for(Movimentacao mov : movimentacoes) {
            String dataFormatada = mov.dataMov.format(formatar);
            sb.append( mov.getTipoMovimentacao() +
                    " | " + mov.getValorMov() +
                    " | " + dataFormatada +
                    " | " +mov.getDescricao() + "\n");
        }
        System.out.println(sb.toString());
    } */


}