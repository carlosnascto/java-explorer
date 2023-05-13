package com.digytal.contacorrente;
import com.digytal.contacorrente.model.ContaCorrente;
import com.digytal.contacorrente.model.Movimentacao;
import com.digytal.contacorrente.repository.ContaRepository;
import com.digytal.contacorrente.repository.MovimentacaoRepository;
import com.digytal.contacorrente.service.ContaService;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ContaCorrenteAplication {

    public static void main(String[] args) {
      //etapaCriarContas();
      //etapaCriarMovimentacoes();
      imprimirExtrato();
    }

    static void etapaCriarContas(){
        ContaCorrente conta1 = new ContaCorrente();
        ContaCorrente conta2 = new ContaCorrente();
        conta1.setNumeroConta(1);
        conta1.setNumeroAgencia(1);
        conta1.setNomeCliente("Carlos Henrique");
        conta1.setDataNascimento(LocalDate.of(2006, 4, 16));

        conta2.setNumeroConta(2);
        conta2.setNumeroAgencia(2);
        conta2.setNomeCliente("Gleyson Sampaio");
        conta2.setDataNascimento(LocalDate.of(1984, 6, 30));

        ContaRepository contaRepository = new ContaRepository();
        contaRepository.salvar(conta1);
        contaRepository.salvar(conta2);
    }

    static void etapaCriarMovimentacoes(){
        ContaRepository contaRepository = new ContaRepository();
        ContaService contaService = new ContaService();

        ContaCorrente conta1 = contaRepository.buscar(1);
        ContaCorrente conta2 = contaRepository.buscar(2);

        contaService.depositar(conta1, 500.0, "Deposito - pagamento");
        contaService.sacar(conta2, 150.0, "Saque - comida");
        contaService.depositar(conta1, 350.0, "Deposito - salario");
        contaService.sacar(conta2, 30.0, "Saque - especie");
    }

    static void imprimirExtrato(){
        MovimentacaoRepository movimentacaoRepository = new MovimentacaoRepository();
        List<Movimentacao> movimentacoes = movimentacaoRepository.listar();
        StringBuilder sb = new StringBuilder("----- HISTÓRICO DE MOVIMENTAÇÕES -----\n");
        sb.append("Data | Descrição | Valor | Tipo\n");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

        for(Movimentacao mov: movimentacoes){
            sb.append(formatter.format(mov.getDataMov()) +
                    " | " + mov.getDescricao() +
                    " | " + nf.format(mov.getValorMov()) +
                    " | " + mov.getTipoMovimentacao() + "\n");
        }
        System.out.println(sb);

    }}
