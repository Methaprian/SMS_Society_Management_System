package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class RMGTestingServerProjectLoginTest {

	public static void main(String[] args) throws Throwable {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://rmgtestingserver:8084/");
		
//		driver.findElement(By.xpath("//span[text()='RMG YANTRA Application']")).click();
		
		String username = "rmgyantra";
		
		WebElement usernameTextField = driver.findElement(By.name("username"));
		usernameTextField.clear();
		usernameTextField.sendKeys(username);
		
		String password="rmgy@9999";
		
		WebElement passwordTextField = driver.findElement(By.id("inputPassword"));
		passwordTextField.clear();
		passwordTextField.sendKeys(password);
		
		driver.findElement(By.xpath("//button[text()='Sign in']")).submit();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		
		Thread.sleep(2000);
		String projectName = "TYSS_Project_77";
		WebElement projectTextField = driver.findElement(By.name("projectName"));
		projectTextField.sendKeys(projectName);
		
		String projectManagerName="SKM";
		Thread.sleep(2000);
		WebElement projectManagerTextField = driver.findElement(By.name("createdBy"));
		projectManagerTextField.sendKeys(projectManagerName);
		Thread.sleep(2000);
		WebElement projectStatusDropdown = driver.findElement(By.xpath("//label[text()='Project Status ']/..//select[@name='status']"));
		Select select=new Select(projectStatusDropdown);
		String projectStatus = "Created";
		Thread.sleep(2000);
		select.selectByValue(projectStatus);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Add Project']")).submit();
		
		//JDBC
		Driver driver1=new Driver();
		
		Connection con=null;
		try {
			DriverManager.registerDriver(driver1);
			con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
			
			Statement state = con.createStatement();
			String query = "select * from project";
			
			ResultSet result = state.executeQuery(query);
					
			while(result.next()) {
				System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
				}
			if (projectName.equals(result.getString(4))) {
				System.out.println("The Project has been Created and Added to the Database");
			}
			else {
				System.out.println("The Project is not created in the Database");
			}
		} catch (SQLException e) {

		}
		finally {
			con.close();
			
		}
		
	}

}
