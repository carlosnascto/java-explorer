public class Dados {
    String nome;
    int idade;
    boolean casado;

    public static void main(String[] args) {
        Dados pessoa1 = new Dados();
        pessoa1.nome="Carlos Henrique";
        pessoa1.idade=16;
        pessoa1.casado=false;
        System.out.println(pessoa1.nome+ " possui "+ pessoa1.idade+" anos de idade.");
    }
}
