package com.digytal.contacorrente.repository;
import com.digytal.contacorrente.model.ContaCorrente;
import com.digytal.contacorrente.model.Movimentacao;
import com.digytal.contacorrente.sql.FabricaConexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovimentacaoRepository {
    private Connection conexao;

    public MovimentacaoRepository() {
        conexao = FabricaConexao.criarConexao();
    }

    public void salvar(Movimentacao movimentacao) {
        try {
            String sql = "INSERT INTO tab_movimentacao (data_mov, valor_mov, descricao_mov, tipo_mov, numero_conta) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement statement = conexao.prepareStatement(sql);
            java.sql.Date sqlDate = Date.valueOf(movimentacao.getDataMov());
            statement.setDate(1, sqlDate);
            statement.setDouble(2, movimentacao.getValorMov());
            statement.setString(3, movimentacao.getDescricao());
            statement.setString(4, movimentacao.getTipoMovimentacao());
            statement.setInt(5, movimentacao.getNumeroConta());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Movimentação salva com sucesso!");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //buscar um servico na base atraves do seu id ?
    public ContaCorrente buscar(Integer id) {
        ContaCorrente registroConta = null;
        try {
            String sql = "SELECT * FROM tab_conta WHERE numero_conta = " + id;
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                registroConta = new ContaCorrente();
                registroConta.setNumeroConta(result.getInt("numero_conta"));
                registroConta.setNumeroAgencia(result.getInt("numero_agencia"));
                registroConta.setNomeCliente(result.getString("nome_cliente"));
                java.sql.Date sqlDate = result.getDate("data_nascimento");
                registroConta.setDataNascimento(sqlDate.toLocalDate());

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return registroConta;
    }

    public List<Movimentacao> listar() {
        List<Movimentacao> registros = new ArrayList<>();
        String sql = "SELECT * FROM tab_movimentacao";
        try {
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                Movimentacao movimentacao = new Movimentacao();
                movimentacao.setDataMov(result.getDate("data_mov").toLocalDate());
                movimentacao.setValorMov(result.getDouble("valor_mov"));
                movimentacao.setDescricao(result.getString("descricao_mov"));
                movimentacao.setNumeroConta(result.getInt("numero_conta"));
                movimentacao.setTipoMovimentacao(result.getString("tipo_mov"));
                registros.add(movimentacao);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return registros;
    }
}
