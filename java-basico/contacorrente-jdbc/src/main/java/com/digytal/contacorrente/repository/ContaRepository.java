package com.digytal.contacorrente.repository;

import com.digytal.contacorrente.model.ContaCorrente;
import com.digytal.contacorrente.sql.FabricaConexao;

import java.sql.*;

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
            java.sql.Date sqlDate = Date.valueOf(conta.getDataNascimento());
            statement.setDate(5,sqlDate);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Conta salva com sucesso!");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
    //buscar um servico na base atraves do seu id ?
    public ContaCorrente buscar(Integer id){
        ContaCorrente registroConta = null;
        try {
            String sql = "SELECT * FROM tab_conta WHERE numero_conta = " + id;
            Statement statement = conexao.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()){
                registroConta = new ContaCorrente();
                registroConta.setNumeroConta(result.getInt("numero_conta"));
                registroConta.setNumeroAgencia(result.getInt("numero_agencia"));
                registroConta.setSaldoConta(result.getDouble("saldo_conta"));
                registroConta.setNomeCliente(result.getString("nome_cliente"));
                java.sql.Date sqlDate = result.getDate("data_nascimento");
                registroConta.setDataNascimento(sqlDate.toLocalDate());

            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return registroConta;
    }
    public void alterarValor(ContaCorrente conta){
        try {
            String sql = "UPDATE tab_conta SET saldo_conta = ?  where numero_conta = ?";

            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(2, conta.getNumeroConta());
            statement.setDouble(1, conta.getSaldoConta());

            statement.executeUpdate();

        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
