public class Calculadora {
    static double valorFinal; // o local da variável define seu tipo de escopo

    public static void main(String[] args) {
        Calculadora calculo1 = new Calculadora();
        calculo1.calcular(5, 10, "/");

        System.out.println(valorFinal);
    }


    public void calcular(double valor1, double valor2, String operador){
        switch (operador){
            case "+": {
                valorFinal = valor1 + valor2;
                break;
            }
            case "-": {
                valorFinal = valor1 - valor2;
                break;
            }
            case "*": {
                valorFinal = valor1 * valor2;
                break;
            }
            case "/": {
                valorFinal = valor1 / valor2;
                break;
            }
        }
    }
}
