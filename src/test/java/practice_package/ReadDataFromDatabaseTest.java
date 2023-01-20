package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabaseTest {

	public static void main(String[] args) throws SQLException  {
		
		Connection con=null;
		
		try {
			Driver driver = new Driver();
			
			//Step 1: Register the Database
			DriverManager.registerDriver(driver);
			
			//Step 2: Get Connection for the Database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45", "root", "root");
			
			//Step 3: Issue Create Statement
			Statement state = con.createStatement();
			String query = "select * from studentInfo;";
			
			//Step 4: Execute Query
			ResultSet result = state.executeQuery(query);
			
			
			while(result.next()) {
				System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
			}
		} 
		catch (Exception e) {
			
		}
		finally {
			
			//Step 5: Close the Database
			con.close();
			System.out.println("Connection to the Database is Closed");
		}
	}
}
