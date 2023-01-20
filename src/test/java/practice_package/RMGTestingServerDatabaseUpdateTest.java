package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class RMGTestingServerDatabaseUpdateTest {

	public static void main(String[] args) throws Throwable {

		Driver driver=new Driver();
		Connection con=null;

		try {
			
			//Step 1: Register the Database
			DriverManager.registerDriver(driver);

			//Step 2: Get Connection from the Database
			con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");

			//Step 3: Issue Create Statement
			Statement state = con.createStatement();
			String query="insert into project values('TY_Project_786','SKM','21/12/2022','ETC','Created',3);";
			String query1="select * from project;";

			
			 ResultSet result1 = state.executeQuery(query1);
			 
			 while(result1.next()) {
				 System.out.println(result1.getString(1)+" "+result1.getString(2)+" "+result1.getString(3)+" "+result1.getString(4)+" "+result1.getString(5)+" "+result1.getString(6));
			 }
		
		} catch (Exception e) {

		}
		finally {
			con.close();
		}

	}

}
