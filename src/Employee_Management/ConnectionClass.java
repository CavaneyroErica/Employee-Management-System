package Employee_Management;

import java.sql.*;

public class ConnectionClass {
	Connection con;
	Statement stm;
	ConnectionClass(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employee_management", "root","aj231d89zzi@A");
			stm=con.createStatement();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ConnectionClass();
	}

}
