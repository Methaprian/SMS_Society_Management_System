package com.SM.SocialManagementSystem.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {

	Connection con=null;
	
	/**
	 * @author METHAPRIAN S.K
	 * @throws Throwable
	 */
	public void connectToDatabase() throws Throwable {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IPathConstants.dBURL, IPathConstants.dBUSERNAME, IPathConstants.dBPASSWORD);
	}
	
	/**
	 * @author METHAPRIAN S.K
	 * @param query
	 * @param colIndex
	 * @param expData
	 * @return
	 * @throws Throwable
	 */
	public String executeQueryAndGetData(String query, int colIndex, String expData) throws Throwable {
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag=false;
		while (result.next()) {
			String data = result.getString(colIndex);
			System.out.println(data);
			if(data.equalsIgnoreCase(expData)) {
				flag=true;
				break;
			}
		}
		if(flag) {
			System.out.println(expData +" project is created.");
			return expData;
		}else {
			System.out.println("Project not created.");
			return "";
		}
	}
	
	/**
	 * Desc - To Close the Database 
	 * @author METHAPRIAN S.K
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable {
		con.close();
	}
}
