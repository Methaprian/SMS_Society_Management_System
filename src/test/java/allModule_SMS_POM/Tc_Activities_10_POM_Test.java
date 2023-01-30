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
public class Tc_Activities_10_POM_Test extends BaseClass{

	@Test(invocationCount = 3,groups = "smoke")
	public void createAct() throws Throwable {
		
		//Click on Activities Link
		HomePage home = new HomePage(driver);
		Assert.assertTrue(home.getActivitiesLink().isDisplayed(), "The Element is Displayed");
		home.clickOnActivitiesLink();
		
		//Click on Add Admin Button
		ActivitiesPage activity = new ActivitiesPage(driver);
		activity.clickOnAddActivity();
		
		//Create Activity by adding details
		AddActivityPage addAct = new AddActivityPage(driver);
		HashMap<String, String> hashMapList = eLib.getList("Activities_Tc_Activities_10", 0, 1, 0);
		addAct.createActivity(driver, hashMapList);
		System.out.println("Activity Created");
	}
}
