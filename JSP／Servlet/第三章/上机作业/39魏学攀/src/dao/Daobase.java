package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javabean.User;


public class Daobase {

	public Connection huoQuLianJie() throws SQLException{
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/newsmanagersystem", "root", "123456");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public void guanBi(Statement st,ResultSet re,Connection co){
		if(re!=null){
			try {
				re.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(st!=null){
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if(co!=null){
			try {
				co.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
 	public ArrayList<User> selectUser() throws SQLException{
 		ArrayList<User> al=new ArrayList<>();
 		Connection co = huoQuLianJie();
 		Statement st = co.createStatement();
 		String sql="select * from news_users";
		ResultSet re = st.executeQuery(sql);
		while(re.next()){
			String name = re.getString(2);
			String ps = re.getString(3);
			User u=new User(name, ps);
			al.add(u);
		}
		guanBi(st, re, co);
		return al;
 	}
	
	
}
