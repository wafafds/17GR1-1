package org.news.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.news.util.ConfigManager;


public class BaseDao {
    private static String driver = ConfigManager.getProperty("driver");
    private static String url = ConfigManager.getProperty("url");
    private static String user = ConfigManager.getProperty("user"); 
    private static String password = ConfigManager.getProperty("password"); 

    protected Connection conn;

    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
         
            e.printStackTrace();
        }
    }

  
    public Connection getConnection() {

        try {
            if (conn == null || conn.isClosed())
                conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

     public void closeAll(Connection conn, Statement stmt, ResultSet rs) {
      
        try {
            if (rs != null && !rs.isClosed())
                rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (stmt != null && !stmt.isClosed())
                stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
   
        try {
            if (conn != null && !conn.isClosed())
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  
    protected int executeUpdate(String sql, Object... params) {
        int result = 0;
        conn = this.getConnection();
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(null, pstmt, null);
        }
        return result;
    }

  
    protected ResultSet executeQuery(String sql, Object... params) {
        conn = this.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
            rs = pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
