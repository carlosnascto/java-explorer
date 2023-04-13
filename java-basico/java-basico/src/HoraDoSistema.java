import java.util.Date; // importação da biblioteca de datas
public class HoraDoSistema {

    public static void main(String[] args) {
        Date relogio = new Date(); // criando um objeto data
        System.out.println("O relogio do sistema é:");
        System.out.println(relogio.toString());
    }
}
