package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class RMGTestingServerDatabaseReadTest {

	public static void main(String[] args) throws Throwable {
		Driver driver=new Driver();
		Connection con=null;
		int result=0;

		try {
			
			//Step 1: Register the Database
			DriverManager.registerDriver(driver);

			//Step 2: Get Connection from the Database
			con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");

			//Step 3: Issue Create Statement
			Statement state = con.createStatement();
			String query="insert into project values('TY_Project_1996','SKM','21/12/2022','ETC','Created',3);";
			
			//Step 4: Execute Query
			 result = state.executeUpdate(query);
			 
		}
		catch (Exception e) {

		}
		finally {
			if (result==1) {
				System.out.println("Data Updated Successfully");
			} else {
				System.out.println("Data Updation Failed");
			}

			//Step 5: Close the Database
			con.close();
		}
	}

}
