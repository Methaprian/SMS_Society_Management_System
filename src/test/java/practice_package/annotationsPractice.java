package practice_package;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class annotationsPractice {
	
	@Test(priority = 0)
	public void createAdmin() {
		System.out.println("1. Navigate to Administrator Module");
		System.out.println("2. Create Admin");
	}
	
	@Test(priority = 1, invocationCount = 3, dependsOnMethods = "createAdmin" )
	public void createStudent() {
		System.out.println("1. Navigate to Students Module");
		System.out.println("2. Create Student");
	}
	
	@BeforeMethod
	public void configBeforeMethod() {
		System.out.println("--Login into Application--");
	}
	
	@AfterMethod
	public void configAfterMethod() {
		System.out.println("--Logout from the Application--");
	}
	
	@BeforeClass
	public void configBeforeClass() {
		System.out.println("---Launch The Browser---");
	}
	
	@AfterClass
	public void configAfterCLass() {
		System.out.println("---Terminate the Browser---");
	}
	
	@BeforeSuite
	public void configBeforeSuite() {
		System.out.println("----Connect To Database----");
	}
	
	@AfterSuite
	public void configAfterSuite() {
		System.out.println("----Disconnect from Database----");
	}
	
}
