package bancario.sistema;

import java.util.ArrayList;
import java.util.Date;
public class SistemaBancario {

    public static void main(String[] args) {
        ContaCorrente conta1 = new ContaCorrente(100.50);
        ContaCorrente conta2 = new ContaCorrente(332.45);
        conta1.transferir(20.0, conta2);
        conta1.transferir(45.0, conta2);
        conta1.transferir(22.0, conta2);
        conta1.sacar(30);
    }

}
