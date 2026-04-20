package BankManagementSystem;

import java.sql.*;
public class DBConnection {
	Connection c=null;
	Statement s;
	public DBConnection() {
		try {
			String url = "jdbc:mysql://localhost:3306/atm";
			String username = "root";
			String password = "pushkar1947";
			System.out.println("USER = " + username);
			Class.forName("com.mysql.cj.jdbc.Driver");
			c =  DriverManager.getConnection(url, username, password);
			s = c.createStatement();
			System.out.println("Connected ✅");
		}
		catch(Exception e) {
			System.out.println("Not Connected\n" + e);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
