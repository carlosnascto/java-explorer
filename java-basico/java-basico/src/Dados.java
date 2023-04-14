public class Dados {
    private String nome;
    private int idade;
    private boolean casado;

    public String getNome() {
        return nome;
    }
    public void setNome(String newNome) {
        this.nome = newNome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int newIdade) {
        this.idade = newIdade;
    }

    public boolean getCasado() {
        return casado;
    }
    public void setCasado(boolean newCasado) {
        this.casado = newCasado;
    }

    public static void main(String[] args) {
        Dados pessoa1 = new Dados();
        pessoa1.nome="Carlos Henrique";
        pessoa1.idade=16;
        pessoa1.casado=false;
        System.out.println(pessoa1.nome+ " possui "+ pessoa1.idade+" anos de idade.");
    }
}
