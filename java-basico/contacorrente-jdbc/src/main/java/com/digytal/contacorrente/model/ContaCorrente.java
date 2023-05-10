package com.digytal.contacorrente.model;

import com.digytal.contacorrente.repository.MovimentacaoRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ContaCorrente {

    int numeroConta;
    int numeroAgencia;
    double saldoConta;
    String nomeCliente;
    String dataNascimento;

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

    public void setSaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public static ArrayList<Movimentacao> movimentacoes = new ArrayList<Movimentacao>();



    public ContaCorrente(double saldoConta) {
        this.saldoConta = saldoConta;
    }

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

    public void sacar(double valorSaque, String descricao) {
        saldoConta = saldoConta - valorSaque;

        Movimentacao mov = new Movimentacao();
        mov.setValorMov(valorSaque);
        mov.setDataMov(LocalDateTime.now());
        mov.setTipoMovimentacao("Saque");

        mov.setDescricao(descricao);

        movimentacoes.add(mov);

        MovimentacaoRepository movimentacaoRepository = new MovimentacaoRepository();
        movimentacaoRepository.salvar(mov);
    }

    public void depositar(double valorDeposito, String descricao) {
        saldoConta += valorDeposito;

        Movimentacao mov = new Movimentacao();
        mov.setValorMov(valorDeposito);
        mov.setDataMov(LocalDateTime.now());
        mov.setTipoMovimentacao("Depósito");

        mov.setDescricao(descricao);

        movimentacoes.add(mov);

        MovimentacaoRepository movimentacaoRepository = new MovimentacaoRepository();
        movimentacaoRepository.salvar(mov);
    }

    public void transferir(double valorTransferencia, ContaCorrente contaReceber, String descricao){

        saldoConta -= valorTransferencia;
        contaReceber.saldoConta += valorTransferencia;

        Movimentacao mov = new Movimentacao();
        mov.setValorMov(valorTransferencia);
        mov.setDataMov(LocalDateTime.now());
        mov.setTipoMovimentacao("Transferência");
        mov.setDescricao(descricao);

        movimentacoes.add(mov);
        MovimentacaoRepository movimentacaoRepository = new MovimentacaoRepository();
        movimentacaoRepository.salvar(mov);
    }

}