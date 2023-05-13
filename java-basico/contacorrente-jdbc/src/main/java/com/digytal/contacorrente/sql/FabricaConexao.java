package com.digytal.contacorrente.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
    static Connection conn = null;
    public static Connection criarConexao(){

        try {
            if(conn == null) {
                conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/contacorrente", "postgres", "postgres");
                System.out.println("CONEXÃO REALIZADA COM SUCESSO");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

}
