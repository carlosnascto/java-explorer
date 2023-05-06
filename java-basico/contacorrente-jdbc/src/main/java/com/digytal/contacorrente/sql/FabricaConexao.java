package com.digytal.contacorrente.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
    public static Connection criarConexao(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/contacorrente", "postgres", "postgres");
            System.out.println("CONEXÃO REALIZADA COM SUCESSO");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

}
