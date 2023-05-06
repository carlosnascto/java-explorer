package com.digytal.contacorrente.repository;
import com.digytal.contacorrente.model.Movimentacao;
import com.digytal.contacorrente.sql.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class MovimentacaoRepository {
    private Connection conexao;
    public MovimentacaoRepository(){
        conexao = FabricaConexao.criarConexao();
    }
    public void salvar(Movimentacao movimentacao){
        try {
        String sql = "INSERT INTO tab_movimentacao (data_mov, valor_mov, descricao_mov, tipo_mov) VALUES (?, ?, ?, ?)";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setDouble(2, movimentacao.getValorMov());
            statement.setString(3, movimentacao.getDescricao());
            statement.setString(4, movimentacao.getTipoMovimentacao());

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("Movimentação salva com sucesso!");
        }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

}
