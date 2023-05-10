package com.digytal.contacorrente.repository;

import com.digytal.contacorrente.model.ContaCorrente;
import com.digytal.contacorrente.sql.FabricaConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ContaRepository {
    private Connection conexao;
    public ContaRepository(){
        conexao = FabricaConexao.criarConexao();
    }
    public void salvar(ContaCorrente conta){
        try {
            String sql = "INSERT INTO tab_conta (numero_conta, numero_agencia, saldo_conta, nome_cliente, data_nascimento) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, conta.getNumeroConta());
            statement.setInt(2, conta.getNumeroAgencia());
            statement.setDouble(3, conta.getSaldoConta());
            statement.setString(4, conta.getNomeCliente());
            statement.setString(5, conta.getDataNascimento());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Conta salva com sucesso!");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
