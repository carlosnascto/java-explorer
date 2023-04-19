package bancario.sistema;
public class SistemaBancario {

    public static void main(String[] args) {
        ContaCorrente conta1 = new ContaCorrente(100.50);
        ContaCorrente conta2 = new ContaCorrente(332.45);
        conta1.transferir(20.0, conta2);
        System.out.println(conta1.saldoConta);
        System.out.println(conta2.saldoConta);
    }

}
