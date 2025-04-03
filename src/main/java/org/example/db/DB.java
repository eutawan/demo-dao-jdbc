package org.example.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection conn = null;

    // Metodo para obter a conexão
    public static Connection getConn() {
        if (conn == null) {
            try {
                Properties props = loadProperties();  // Carrega as configurações
                String url = props.getProperty("db.url");  // URL do banco
                String user = props.getProperty("db.user");  // Usuário
                String password = props.getProperty("db.password");  // Senha

                // Obtendo a conexão
                conn = DriverManager.getConnection(url, user, password);
            }
            catch (SQLException e) {
                throw new DbException("Erro ao conectar ao banco de dados: " + e.getMessage());
            }
        }
        return conn;
    }

    // Metodo para fechar a conexão
    public static void closeConn() {
        try {
            if (conn != null) {
                conn.close();
            }
        }
        catch (SQLException e) {
            throw new DbException("Erro ao fechar a conexão: " + e.getMessage());
        }
    }

    // Metodo para carregar as propriedades do arquivo db.properties
    private static Properties loadProperties() {
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties props = new Properties();
            props.load(fs);  // Carrega as propriedades do arquivo
            return props;
        }
        catch (IOException e) {
            throw new DbException("Erro ao carregar as propriedades: " + e.getMessage());
        }
    }

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            }
            catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            }
            catch (SQLException e) {
                throw new DbException(e.getMessage());
            }
        }
    }
}

