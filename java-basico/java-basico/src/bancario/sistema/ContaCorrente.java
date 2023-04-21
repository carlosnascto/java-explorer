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

    public void obterHistorico() {
        for(Movimentacao mov : movimentacoes) {
            System.out.println("Tipo: " + mov.getTipoMovimentacao() +
                    " | Valor: " + mov.getValorMov() +
                    " | Data: " + mov.getDataMov() +
                    " | Descrição: " + mov.getDescricao());
        }
    }
    public ContaCorrente(double saldoConta) {
        this.saldoConta = saldoConta;
    }

    public void sacar(double valorSaque, String descricao) {
        saldoConta = saldoConta - valorSaque;

        Movimentacao mov = new Movimentacao();
        mov.setValorMov(valorSaque);
        mov.setDataMov(LocalDateTime.now());
        mov.setTipoMovimentacao("Saque");

        mov.setDescricao(descricao);

        movimentacoes.add(mov);
    }

    public void depositar(double valorDeposito, String descricao) {
        saldoConta += valorDeposito;

        Movimentacao mov = new Movimentacao();
        mov.setValorMov(valorDeposito);
        mov.setDataMov(LocalDateTime.now());
        mov.setTipoMovimentacao("Depósito");

        mov.setDescricao(descricao);

        movimentacoes.add(mov);
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

    }

}