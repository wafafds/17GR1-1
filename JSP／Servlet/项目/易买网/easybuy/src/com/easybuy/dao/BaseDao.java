package com.easybuy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.easybuy.web.ConfigManager;

/**
 * ���ݿ�������رչ����ࡣ
 * 
 * @author ��������
 */
public class BaseDao {
	
    private static String driver = ConfigManager.getProperty("driver");// ���ݿ������ַ���
    private static String url = ConfigManager.getProperty("url");// ����URL�ַ���
    private static String user = ConfigManager.getProperty("user"); // ���ݿ��û���
    private static String password = ConfigManager.getProperty("password"); // �û�����

    protected static Connection conn;
    protected PreparedStatement pstm;
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * ��ȡ���ݿ����Ӷ���
     */
    public static Connection getConnection() {
        // ��ȡ���Ӳ������쳣
        try {
            if (conn == null || conn.isClosed())
                conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;// �������Ӷ���
    }

    /**
     * �ر����ݿ����ӡ�
     * 
     * @param conn
     *            ���ݿ�����
     * @param stmt
     *            Statement����
     * @param rs
     *            �����
     */
    public  static void closeAll(Connection conn, Statement stmt, ResultSet rs) {
        // �����������Ϊ�գ���ر�
        try {
            if (rs != null && !rs.isClosed())
                rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // ��Statement����Ϊ�գ���ر�
        try {
            if (stmt != null && !stmt.isClosed())
                stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // �����ݿ����Ӷ���Ϊ�գ���ر�
        try {
            if (conn != null && !conn.isClosed())
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

  //��ɾ�Ĳ��� delete from news_detail where id=? and title=?
  	public int executeUpdate1(String sql,Object[] params){
  		int updateRows = 0;
  		try {
  			pstm = conn.prepareStatement(sql);
  			for(int i = 0; i < params.length; i++){
  				pstm.setObject(i+1, params[i]);
  			}
  			updateRows = pstm.executeUpdate();
  		} catch (Exception e) {
  			e.printStackTrace();
  			updateRows = -1;
  		}
  		
  		return updateRows;
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
    public int executeInsert(String sql, Object[] param) {
    	Long id = 0L;
		try {
			   pstm= conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			for(int i = 0; i < param.length; i++){
				pstm.setObject(i+1, param[i]);
			}
			pstm.executeUpdate();
			ResultSet rs = pstm.getGeneratedKeys(); 
			if (rs.next()) { 
				id = rs.getLong(1);
				System.out.println("����������" + id); 
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
			id =null;
		}
		
		return id.intValue();
	}

    public boolean closeResource(){
		if(pstm != null){
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
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
