package com.SM.SocialManagementSystem.ObjectPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.SM.SocialManagementSystem.GenericUtility.ExcelUtility;
import com.SM.SocialManagementSystem.GenericUtility.WebDriverUtility;

public class StudentPage {
	
	
	//Declaration
	@FindBy(id = "add_student")
	private WebElement addStudentButton;
	
	@FindBy(xpath = "//label[.='Search:']/..//input[@type='search']")
	private WebElement searchTF;
	
	@FindBy(name = "table_length")
	private WebElement tableLengthDD;
	
	//Initialization
	public StudentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	//Utilization
	
	public WebElement getAddStudentButton() {
		return addStudentButton;
	}

	public WebElement getSearchTF() {
		return searchTF;
	}

	public WebElement getTableLengthDD() {
		return tableLengthDD;
	}
	
	//Business Libraries
	
	/**
	 * @author METHAPRIAN S.K
	 * Desc - Click on Add Student Button
	 */
	public void clickAddStudent() {
		getAddStudentButton().click();
	}
	
	/**
	 * @author METHAPRIAN S.K
	 * Desc - Select the Table Length based on DropDwon Value
	 * @param wLib
	 * @param ddValue - DropDown Value
	 */
	public void selectStudTableLength(WebDriverUtility wLib, String ddValue) {
		wLib.selectValue(tableLengthDD, ddValue);
	}
	
	public void searchForStudent(WebDriver driver, ExcelUtility eLib, AddStudentPage addStud) throws Throwable {
		String expectedStudName=eLib.readDataFromExcelFile("Accounts_TC_Accounts_Stud", 0, 1)+addStud.rn;
		getSearchTF().sendKeys(expectedStudName);
		String actualStudName = driver.findElement(By.xpath("//th[.='Student ID']/../../..//td[.='"+expectedStudName+"']")).getText();
		if(expectedStudName.equals(actualStudName)) {
			System.out.println("Test Case Pass: Student created is present in the Student Page.");
			Reporter.log("Test Case Pass: Student created is present in the Student Page.");
		}else {
			System.out.println("Test Case Fail: Student is not present in the Student Page.");
			Reporter.log("Test Case Fail: Student is not present in the Student Page.");
		}
	}
}