package com.SM.SocialManagementSystem.ObjectPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.SM.SocialManagementSystem.GenericUtility.ExcelUtility;

public class ActivitiesPage {

	//Declaration

	@FindBy(id = "add_activity")
	private WebElement addActivityButton;

	@FindBy(name = "table_length")
	private WebElement activityTableLengthDD;

	@FindBy(xpath = "//label[.='Search:']/..//input[@type='search']")
	private WebElement searchActivityTF;
	
//	@FindBy(xpath = "//th[text()='Action']/../../..//a[text()=' Delete']")
//	private WebElement deleteButton;

	//Initialization
	public ActivitiesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getAddActivityButton() {
		return addActivityButton;
	}

	public WebElement getActivityTableLengthDD() {
		return activityTableLengthDD;
	}

	public WebElement getSearchActivityTF() {
		return searchActivityTF;
	}

	//Business Library
	/**
	 * @author METHAPRIAN S.K
	 * Desc - Click on Add Activity Button
	 */
	public void clickOnAddActivity() {
		getAddActivityButton().click();
	}
	
	/**
	 * @author METHAPRIAN S.K
	 * Desc - To Search an Activity
	 * @param addAct
	 * @param eLib
	 * @param driver
	 * @throws Throwable
	 */
	public void searchActivity(AddActivityPage addAct, ExcelUtility eLib, WebDriver driver) throws Throwable {
		String expectedActName=eLib.readDataFromExcelFile("Activities_Tc_Activities_10", 0, 1)+addAct.rn;
		getSearchActivityTF().sendKeys(expectedActName);
		String actualActName = driver.findElement(By.xpath("//th[.='Title']/../../..//td[.='"+expectedActName+"']")).getText();
		if (expectedActName.equals(actualActName)) {
			System.out.println("Test Case Pass: Activity created is present in the Activity Page.");
			Reporter.log("Test Case Pass: Activity created is present in the Activity Page.");
		}else {
			System.out.println("Test Case Fail: Activity is not Created / present in the Activity Page.");
			Reporter.log("Test Case Fail: Activity is not Created / present in the Activity Page.");
		}
	}
	
	/**
	 * @author METHAPRIAN S.K
	 * Desc - To Search and Delete an Activity
	 * @param driver
	 * @param actName
	 */
	public void searchAndDeleteActivity(WebDriver driver, String actName) {
		getSearchActivityTF().sendKeys(actName);
		try {
			
			WebElement searchedTitle = driver.findElement(By.xpath("//td[.='"+actName+"']"));
			if (searchedTitle.isDisplayed()) {
				driver.findElement(By.xpath("//td[.='"+actName+"']/..//a[.=' Delete']")).click();
				driver.findElement(By.xpath("//a[.=' Yes']")).click();
				System.out.println("Test Case Pass: Title Deleted");
				Reporter.log("Test Case Pass: Title Deleted");
			} 
		}catch (Exception e) {
			WebElement noRecordMsg = driver.findElement(By.xpath("//td[.='No matching records found']"));
			if(noRecordMsg.isDisplayed()){
				System.out.println("Test Case Fail: "+noRecordMsg.getText());
				Reporter.log("Test Case Fail: "+noRecordMsg.getText());
			}
		}
	}
}