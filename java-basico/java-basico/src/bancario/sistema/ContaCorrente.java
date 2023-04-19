package bancario.sistema;

public class ContaCorrente {

    int numeroConta;
    int numeroAgencia;
    double saldoConta;
    String nomeCliente;
    String dataNascimento;

    public ContaCorrente(double saldoConta) {
        this.saldoConta = saldoConta;
    }

    public void sacar(double valorSaque) {
        saldoConta = saldoConta - valorSaque;
    }

    public void depositar(double valorDeposito) {
        saldoConta += valorDeposito;
    }

    public void transferir(double valorTransferencia, ContaCorrente contaReceber){
        saldoConta -= valorTransferencia;
        contaReceber.saldoConta += valorTransferencia;
    }


}