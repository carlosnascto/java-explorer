package com.digytal.contacorrente;
import com.digytal.contacorrente.model.ContaCorrente;
import com.digytal.contacorrente.repository.MovimentacaoRepository;

public class ContaCorrenteAplication {

    public static void main(String[] args) {
        ContaCorrente conta1 = new ContaCorrente(100.50);
        ContaCorrente conta2 = new ContaCorrente(332.45);
        conta1.sacar(20.45, "Saque para uma construção");
        conta1.depositar(20.00, "Deposito para poupança");
        conta1.transferir(20.00, conta2, "Tranferencia para mercado");

        MovimentacaoRepository movimentacaoRepository = new MovimentacaoRepository();
        movimentacaoRepository.salvar(ContaCorrente.movimentacoes);
    }
}
