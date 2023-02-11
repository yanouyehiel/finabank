/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finabank;

import java.net.Socket;
import java.sql.*;

/**
 *
 * @author Yepy
 */
public class BDD {
    Connection connection;
    Statement statement;
    String SQL;
    
    String url;
    String username;
    String password;
    Socket client;
    String Host;
    
    public BDD(String url, String username, String password, String Host) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.Host = Host;
    }
    
    public BDD() {
        
    }
    
    public Connection connexionDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
        return connection;
    }
    
    public Connection closeConnexion() {
        try {
            connection.close();
        } catch(SQLException e) {
            System.err.println(e.getMessage());
        }
        return connection;
    }
    
    public ResultSet executeQuery(String sql) {
        connexionDB();
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            System.out.println(sql);
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return resultSet;
    }
    
    public String executeUpdateFNB(String sql) {
        connexionDB();
        String result = "";
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            result = sql;
        } catch(SQLException ex) {
            result = ex.toString();
        }
        return result;
    }
    
    public ResultSet querySelectAll(String table) {
        connexionDB();
        SQL = "SELECT * FROM " + table;
        return this.executeQuery(SQL);
    }
    
    public ResultSet querySelectAllWithParam(String table, String param) {
        connexionDB();
        SQL = "SELECT * FROM " + table + " WHERE " + param;
        return this.executeQuery(SQL);
    }
    
    public ResultSet querySelect(String[] columns, String table) {
        connexionDB();
        int i;
        SQL = "SELECT ";
        for (i = 0; i <= columns.length - 1; i++) {
            SQL += columns[i];
            if (i < columns.length - 1) {
                SQL += ",";
            }
        }
            
        SQL += " FROM " + table;
        return this.executeQuery(SQL);
    }
    
    public ResultSet querySelectWithParam(String[] columns, String table, String param) {
        connexionDB();
        int i;
        SQL = "SELECT ";
        for (i = 0; i <= columns.length - 1; i++) {
            SQL += columns[i];
            if (i < columns.length - 1) {
                SQL += ",";
            }
        }
            
        SQL += " FROM " + table + " WHERE " + param;
        return this.executeQuery(SQL);
    }
    
    public String queryInsert(String table, Object[] contenuTable) {
        connexionDB();
        int i;
        SQL = "INSERT INTO " + table + " VALUES(";
        for (i = 0; i < contenuTable.length; i++) {
            SQL += "'" + contenuTable[i] + "'";
            if (i < contenuTable.length - 1) {
                SQL += ",";
            }
        }
        
        SQL += ")";
        return this.executeUpdateFNB(SQL);
    }
    
    public String queryInsertWithColumns(String table, String[] columns, String[] contenuTable) {
        connexionDB();
        int i;
        SQL = "INSERT INTO '" + table + "' (";
        for (i = 0; i <= columns.length - 1; i++) {
            SQL += columns[i];
            if (i < columns.length - 1) {
                SQL += ",";
            }
        }
        SQL += ") VALUES (";
        for (i = 0; i < contenuTable.length - 1; i++) {
            SQL += "'" + contenuTable[i] + "'";
            if (i < contenuTable.length - 1) {
                SQL += ",";
            }
        }
        SQL += ")";
        return this.executeUpdateFNB(SQL);
    }
    
    public String queryUpdateOne(String table, String column, String contenu, String param) {
        connexionDB();
        SQL = "UPDATE " + table + " SET " + column + "='" + contenu + "'" + " WHERE " + param;
        
        return this.executeUpdateFNB(SQL);
    }
    
    public String queryUpdateMore(String table, String[] columns, String[] contenuTable, String param) {
        connexionDB();
        int i;
        SQL = "UPDATE " + table + " SET ";
        for (i = 0; i < contenuTable.length - 1; i++) {
            SQL += "'" + columns[i] + "='" + contenuTable[i] + "'";
            if (i < columns.length - 1) {
                SQL += ",";
            }
        }
        
        SQL += " WHERE " + param;
        return this.executeUpdateFNB(SQL);
    }
    
    public String queryDelete(String table) {
        connexionDB();
        SQL = "DELETE FROM " + table;
        return this.executeUpdateFNB(SQL);
    }
    
    public String queryDeleteWithParan(String table, String param) {
        connexionDB();
        SQL = "DELETE FROM " + table + " WHERE " + param;
        return this.executeUpdateFNB(SQL);
    }
    
    //Sélection des tables multiples
    public ResultSet querySelectAllMultipleTable(String[] tables, String[] connect, String[] links, String param) {
        connexionDB();
        int i;
        SQL = "SELECT * FROM ";
        for (i = 0; i <= tables.length - 1; i++) {
            SQL += "'" + tables[i] + "'";
            if (i < tables.length - 1) {
                SQL = ",";
            }
        }
        SQL += " ON ";
        for (i = 0; i <= links.length - 1; i++) {
            SQL += "" + tables[i] + "." + connect[i] + "'='" + tables[i+1] + "." + links[i] + "'";
            if (i < links.length - 1) {
                SQL += " AND ";
            }
        }
            
        SQL += " WHERE " + param;
        return this.executeQuery(SQL);
    }
}
