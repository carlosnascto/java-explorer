package bancario.sistema;
import java.time.LocalDateTime;

public class Movimentacao {
    LocalDateTime dataMov = LocalDateTime.now();
    double valorMov;
    String descricao;

    String tipoMovimentacao;

    public LocalDateTime getDataMov() {
        return dataMov;
    }

    public void setDataMov(LocalDateTime dataMov) {
        this.dataMov = dataMov;
    }

    public double getValorMov() {
        return valorMov;
    }

    public void setValorMov(double valorMov) {
        this.valorMov = valorMov;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(String tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }
}
