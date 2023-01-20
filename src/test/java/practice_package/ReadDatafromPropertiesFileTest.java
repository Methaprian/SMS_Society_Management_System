package practice_package;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadDatafromPropertiesFileTest {

	public static void main(String[] args) throws Throwable {
		
		//Step 1: Create object for FileInputStream
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		
		//Step 2: Create Object for Properties
		Properties pobj = new Properties();
		
		//Step 3: Load the FIS
		pobj.load(fis);
		
		System.out.println(pobj.getProperty("browser"));
		System.out.println(pobj.getProperty("url"));
		System.out.println(pobj.getProperty("username"));
		System.out.println(pobj.getProperty("password"));
	}

}
