package practice_package;

import org.testng.annotations.Test;

public class TestNGTest {
	
	@Test(priority = -1)
	public void Login() {
		System.out.println("Logged In");
	}
	
	@Test(priority = -1,dependsOnMethods = "Login")
	public void Create() {
		System.out.println("Created");
	}
	
	@Test(invocationCount = 5,dependsOnMethods = "Create")
	public void Update() {
		System.out.println("Updated");
	}
	
	@Test(priority = 1, dependsOnMethods = "Create")
	public void Delete() {
		System.out.println("Deleted");
	}
	
	@Test(priority = 2, dependsOnMethods = "Login")
	public void LogOut() {
		System.out.println("Logged Out");
	}

}
