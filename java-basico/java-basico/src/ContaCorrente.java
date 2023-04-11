public class ContaCorrente {
        int numeroConta = 1;
        int numeroAgencia = 50;
        double saldoConta = 100.50;
        String nomeCliente = "Carlos Henrique";
        String dataNascimento = "16/04/2006";

    public static void main(String[] args) {
        ContaCorrente minhaConta = new ContaCorrente();
        minhaConta.sacar(14.40);
        System.out.println("O valor atual da conta é: " + minhaConta.saldoConta);
    }
    public void sacar(double valorSaque) {
        saldoConta = saldoConta - valorSaque;
    }
}
