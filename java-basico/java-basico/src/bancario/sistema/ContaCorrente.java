package bancario.sistema;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ContaCorrente {

    int numeroConta;
    int numeroAgencia;
    double saldoConta;
    String nomeCliente;
    String dataNascimento;

    ArrayList<Movimentacao> movimentacoes = new ArrayList<Movimentacao>();


    public ContaCorrente(double saldoConta) {
        this.saldoConta = saldoConta;
    }

    public void sacar(double valorSaque) {
        saldoConta = saldoConta - valorSaque;

        Movimentacao mov = new Movimentacao();
        mov.setValorMov(valorSaque);
        mov.setDataMov(LocalDateTime.now());
        mov.setDescricao("Saque para manutenção");
        mov.setTipoMovimentacao("Saque");

        movimentacoes.add(mov);
    }

    public void depositar(double valorDeposito) {
        saldoConta += valorDeposito;

        Movimentacao mov = new Movimentacao();
        mov.setValorMov(valorDeposito);
        mov.setDataMov(LocalDateTime.now());
        mov.setDescricao("Depósito para poupança");
        mov.setTipoMovimentacao("Depósito");

        movimentacoes.add(mov);
    }

    public void transferir(double valorTransferencia, ContaCorrente contaReceber){

        saldoConta -= valorTransferencia;
        contaReceber.saldoConta += valorTransferencia;

        //todas as transações precisam criar uma movimentação
        //aonde mais este código precisa ser replicado
        Movimentacao mov = new Movimentacao();
        mov.setValorMov(valorTransferencia);
        mov.setDataMov(LocalDateTime.now());
        mov.setDescricao("Transferência para construção");
        mov.setTipoMovimentacao("Transferência");

        movimentacoes.add(mov);

        //vc precisa identificar aonde e quando vai imprimir as movimentações

    }


}