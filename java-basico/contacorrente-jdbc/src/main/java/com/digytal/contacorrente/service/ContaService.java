package com.digytal.contacorrente.service;

import com.digytal.contacorrente.model.ContaCorrente;
import com.digytal.contacorrente.model.Movimentacao;
import com.digytal.contacorrente.repository.ContaRepository;
import com.digytal.contacorrente.repository.MovimentacaoRepository;

import java.time.LocalDate;

public class ContaService {
    private ContaRepository repository;
    private MovimentacaoRepository movimentacaoRepository;
    public ContaService(){
        repository = new ContaRepository();
        movimentacaoRepository = new MovimentacaoRepository();
    }
    public void sacar(ContaCorrente contaCorrente, Double valorSolicitado, String descricao){
        contaCorrente.setSaldoConta(contaCorrente.getSaldoConta() - valorSolicitado);

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setValorMov(valorSolicitado);
        movimentacao.setDataMov(LocalDate.now());
        movimentacao.setTipoMovimentacao("Saque");
        movimentacao.setDescricao(descricao);
        movimentacao.setNumeroConta(contaCorrente.getNumeroConta());

        movimentacaoRepository.salvar(movimentacao);
        repository.alterarValor(contaCorrente);
    }
    public void depositar(ContaCorrente contaCorrente, Double valorDepositado, String descricao){
        contaCorrente.setSaldoConta(contaCorrente.getSaldoConta() + valorDepositado);

        Movimentacao mov = new Movimentacao();
        mov.setValorMov(valorDepositado);
        mov.setDataMov(LocalDate.now());
        mov.setTipoMovimentacao("Depósito");
        mov.setDescricao(descricao);
        mov.setNumeroConta(contaCorrente.getNumeroConta());


        movimentacaoRepository.salvar(mov);
        repository.alterarValor(contaCorrente);
    }
}
