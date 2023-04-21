package bancario.sistema;
import java.util.ArrayList;
import java.util.Date;
public class SistemaBancario {

    public static void main(String[] args) {
        ContaCorrente conta1 = new ContaCorrente(100.50);
        ContaCorrente conta2 = new ContaCorrente(332.45);
        conta1.sacar(100.45, "Saque para uma consulta");
        conta1.sacar(20.45, "Saque para uma construção");
        conta1.depositar(20.00, "Deposito para poupança");
        conta1.transferir(20.00, conta2, "Tranferencia para mercado");

        conta1.obterHistorico();
    }

}
