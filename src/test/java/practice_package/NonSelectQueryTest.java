package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryTest {

	public static void main(String[] args) throws SQLException {
		
			Connection con=null;
			int result=0;
			
			try {
				Driver driver = new Driver();
				
				//Step 1: Register the Database
				DriverManager.registerDriver(driver);
				
				//Step 2: Get Connection for the Database
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45", "root", "root");
				
				//Step 3: Issue Create Statement
				Statement state = con.createStatement();
				String query = "insert into studentInfo values ('Nida','BTR','Manual',2);";
				
				//Step 4: Update Query
				result=state.executeUpdate(query);
			} catch (Exception e) {
			
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