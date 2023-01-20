package allModule_SMS_POM;

import org.testng.annotations.Test;

import com.SM.SocialManagementSystem.GenericUtility.BaseClass;
import com.SM.SocialManagementSystem.ObjectPage.ActivitiesPage;
import com.SM.SocialManagementSystem.ObjectPage.HomePage;

public class Tc_Activities_13_POM_Test extends BaseClass{
	
	@Test
	public void searchAndDeleteAct() throws Throwable {
		
		//Navigate to Activities Page
		HomePage home=new HomePage(driver);
		home.clickOnActivitiesLink();
		
		//Search and Delete the Activity
		String actName = eLib.readDataFromExcelFile("Activities_Tc_Activities_13", 0, 1);
		ActivitiesPage act=new ActivitiesPage(driver);
		act.searchAndDeleteActivity(driver, actName);
	}
}
