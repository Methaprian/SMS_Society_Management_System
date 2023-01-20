package com.SM.SocialManagementSystem.ObjectPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.SM.SocialManagementSystem.GenericUtility.ExcelUtility;
import com.SM.SocialManagementSystem.GenericUtility.WebDriverUtility;

public class AdministratorPage {
	
	//Declaration
	
	@FindBy(id = "add_admin")
	private WebElement addAdminButton;
	
	@FindBy(xpath = "//label[.='Search:']/..//input[@type='search']")
	private WebElement searchTF;
	
	@FindBy(name = "table_length")
	private WebElement tableLengthDD;
	
	//Initialization
	
	public AdministratorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//Utilization
	
	public WebElement getAddAdminButton() {
		return addAdminButton;
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
	 * Desc - Click on Add Admin Button
	 */
	public void clickOnAddAdmin() {
		getAddAdminButton().click();
	}
	
	/**
	 * @author METHAPRIAN S.K
	 * Desc - To select the Table Length from DropDown
	 * @param wLib
	 * @param value
	 */
	public void selectTableLength(WebDriverUtility wLib, String value) {
		wLib.selectValue(tableLengthDD, value);
	}
	
	/**
	 * @author METHAPRIAN S.K
	 * Desc - Search by Username
	 * @param username
	 * @throws Throwable 
	 */
	public void searchAdmin(ExcelUtility eLib,AddAdminPage addAdmin, WebDriver driver) throws Throwable {
		String expectedUN = eLib.readDataFromExcelFile("Accounts_Tc_Accounts_01", 0, 1)+addAdmin.rn;
		searchTF.sendKeys(expectedUN);
		String actualUserName = driver.findElement(By.xpath("//th[.='Username']/../../..//td[.='"+expectedUN+"']")).getText();
		if (expectedUN.equals(actualUserName)) {
			System.out.println("Test Case Pass: Username created is present in the Administrator Page.");
			Reporter.log("Test Case Pass: Username created is present in the Administrator Page.");
		}else {
			System.out.println("Test Case Fail: Username is not present in the Administrator Page.");
			Reporter.log("Test Case Fail: Username is not present in the Administrator Page.");
		}
	}
}
