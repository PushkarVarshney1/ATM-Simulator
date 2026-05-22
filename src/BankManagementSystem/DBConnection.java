package BankManagementSystem;
import java.sql.*;
public class DBConnection {
    public Connection c = null;
    public DBConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/atm";
            String user = "root";
            String pwd = "pushkar1947";
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}