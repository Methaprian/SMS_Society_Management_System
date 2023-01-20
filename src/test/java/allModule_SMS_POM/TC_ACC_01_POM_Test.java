package allModule_SMS_POM;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.SM.SocialManagementSystem.GenericUtility.BaseClass;
import com.SM.SocialManagementSystem.ObjectPage.AddAdminPage;
import com.SM.SocialManagementSystem.ObjectPage.AdministratorPage;
import com.SM.SocialManagementSystem.ObjectPage.HomePage;

@Listeners(com.SM.SocialManagementSystem.GenericUtility.ListnerImplementationClass.class)
public class TC_ACC_01_POM_Test extends BaseClass{

	@Test(retryAnalyzer = com.SM.SocialManagementSystem.GenericUtility.RetryImplimentationClass.class)
	public void createAndSearchAdmin() throws Throwable {
		
		//Click on Administrator Link
		HomePage home=new HomePage(driver);
		home.clickOnAdministrator();
		//Click on Add Admin Button
		AdministratorPage admin=new AdministratorPage(driver);
		admin.clickOnAddAdmin();
		
		//Create Admin
		AddAdminPage addAdmin=new AddAdminPage(driver);
		HashMap<String, String> hashMapList = eLib.getList("Accounts_Tc_Accounts_01", 0, 1, 0);
		addAdmin.createAdmin(hashMapList, driver, eLib);
		Assert.fail();
		//Change the Table Length
		String tabLength = eLib.readDataFromExcelFile("Accounts_Tc_Accounts_01", 0, 7);
		admin.selectTableLength(wLib, tabLength);
		//Search for the Created Admin
		admin.searchAdmin(eLib, addAdmin, driver);
	}
}
