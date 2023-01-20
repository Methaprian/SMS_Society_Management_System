package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class StudInfoInstertTest {

	public static void main(String[] args) throws Throwable {
		
		Driver driver=new Driver();
		Connection con = null;
		//int result=0;
		try {
			// Step 1: Register the DataBase
			DriverManager.registerDriver(driver);
			
			//Step 2: Get Connection for the DataBase
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45", "root", "root");
			
			//Step 3: Issue Create Statement
			Statement state = con.createStatement();
			//String query = "insert into studinfo values('Metha',1,'BTR','API',3),('Nida',2,'BTR','Manual',2),('Mano',3,'BTR','Selenium',3),('Anup',4,'BTM','Appium',2);";
			String query1="select* from studinfo;";
			
			//Step 4: Update Query
			 ResultSet result1 = state.executeQuery(query1);
			//result = state.executeUpdate(query);
			 while(result1.next()) {
				 System.out.println(result1.getString(1)+" "+result1.getString(2)+" "+result1.getString(3)+" "+result1.getString(4)+" "+result1.getString(5));
			 }
		}
		catch (SQLException e) {
			
		}
		finally {
//			if (result==4) {
//				System.out.println("Data Updated Successfully");
//			} else {
//				System.out.println("Data Updation Failed");
//			}
			
			//Step 5: Close the DataBase
			con.close();
		}
		
		
	}

}
