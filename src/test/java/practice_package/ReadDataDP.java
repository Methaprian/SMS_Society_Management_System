package practice_package;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.SM.SocialManagementSystem.GenericUtility.ExcelUtility;

public class ReadDataDP {
	
	@Test(dataProvider = "dataProvider")
	public void readDataTest(String from, String to) {
		//System.out.println(from+" ----> "+to);
		Reporter.log(from+" ----> "+to);
	}
	
	@DataProvider
	public Object[][] dataProvider() throws Throwable {
		ExcelUtility eLib=new ExcelUtility();
		Object[][] value = eLib.readMultiDataDP("Activities_Tc_Activities_10");
		return value;
	}
}
