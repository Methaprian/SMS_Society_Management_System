package allModule_SMS_POM;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SM.SocialManagementSystem.GenericUtility.BaseClass;
import com.SM.SocialManagementSystem.ObjectPage.ActivitiesPage;
import com.SM.SocialManagementSystem.ObjectPage.HomePage;
@Listeners(com.SM.SocialManagementSystem.GenericUtility.ListnerImplementationClass.class)
public class Tc_Activities_13_POM_Test extends BaseClass{
	
	@Test(groups = "regression")
	public void searchAndDeleteAct() throws Throwable {
		
		//Navigate to Activities Page
		HomePage home=new HomePage(driver);
		Assert.assertTrue(home.getActivitiesLink().isEnabled(), "The Element is Enabled");
		home.clickOnActivitiesLink();
		
		//Search and Delete the Activity
		String actName = eLib.readDataFromExcelFile("Activities_Tc_Activities_13", 0, 1);
		ActivitiesPage act=new ActivitiesPage(driver);
		act.searchAndDeleteActivity(driver, actName);
	}
}
