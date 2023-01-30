package allModule_SMS_POM;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SM.SocialManagementSystem.GenericUtility.BaseClass;
import com.SM.SocialManagementSystem.ObjectPage.ActivitiesPage;
import com.SM.SocialManagementSystem.ObjectPage.AddActivityPage;
import com.SM.SocialManagementSystem.ObjectPage.HomePage;

@Listeners(com.SM.SocialManagementSystem.GenericUtility.ListnerImplementationClass.class)
public class TC_ACT_01_POM_Test extends BaseClass{

	@Test(groups = {"smoke","regression"})
	public void createActivity() throws Throwable {
		
		//Click on Activities Link
		HomePage home = new HomePage(driver);
		home.clickOnActivitiesLink();
		
		//Click on Add Admin Button
		ActivitiesPage activity = new ActivitiesPage(driver);
		Assert.assertTrue(activity.getAddActivityButton().isDisplayed(), "The Element is Displayed");
		activity.clickOnAddActivity();
		
		//Create Activity by adding details
		AddActivityPage addAct = new AddActivityPage(driver);
		HashMap<String, String> hashMapList = eLib.getList("Activities_Tc_Activities_10", 0, 1, 0);
		addAct.createActivity(driver,hashMapList);
		
		activity.searchActivity(addAct, eLib, driver);
	}
}
