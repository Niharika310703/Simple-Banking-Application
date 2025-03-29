package banking;
import java.sql.*;
import java.util.*;
public class Connect {
  
	Connection c;
	Statement s;
	public Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			 c= DriverManager.getConnection("jdbc:mysql:///bankingdb","root","Niharika@3107");
			 s=c.createStatement();
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
}
