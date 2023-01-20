package allModule_SMS_POM;

import java.awt.Robot;
import java.util.HashMap;

import org.testng.annotations.Test;

import com.SM.SocialManagementSystem.GenericUtility.BaseClass;
import com.SM.SocialManagementSystem.ObjectPage.AddStudentPage;
import com.SM.SocialManagementSystem.ObjectPage.HomePage;
import com.SM.SocialManagementSystem.ObjectPage.StudentPage;

public class TC_ACC_02_POM_Test extends BaseClass{
	
	@Test
	public void createStudent() throws Throwable {

		//Click on Students Link
		HomePage home = new HomePage(driver);
		home.clickOnStudentLink();
		//Click on Add Student
		StudentPage stud= new StudentPage(driver);
		stud.clickAddStudent();
		//Create Student and Click on Save Button
		AddStudentPage addStud = new AddStudentPage(driver);
		String ddValue = eLib.readDataFromExcelFile("Accounts_TC_Accounts_Stud", 0, 10);
		HashMap<String, String> hashMapList = eLib.getList("Accounts_TC_Accounts_Stud", 0, 1, 0);
		String imgPath = eLib.readDataFromExcelFile("Accounts_TC_Accounts_Stud", 3, 7);
		Robot robot= new Robot();
		addStud.createStudent(hashMapList, driver, wLib, robot , ddValue, imgPath);
		//Select Table Length
		String tableLengthDD = eLib.readDataFromExcelFile("Accounts_TC_Accounts_Stud", 0, 16);
		stud.selectStudTableLength(wLib, tableLengthDD);
		//Search for the Student
		stud.searchForStudent(driver, eLib, addStud);
	}
}


