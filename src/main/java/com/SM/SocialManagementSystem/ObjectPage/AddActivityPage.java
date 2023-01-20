package com.SM.SocialManagementSystem.ObjectPage;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.SM.SocialManagementSystem.GenericUtility.JavaUtility;

public class AddActivityPage {
	
	//Declaration
	
	@FindBy(id = "cancel_activity")
	private WebElement cancelButton;
	
	@FindBy(name = "title")
	private WebElement titleTF;
	
	@FindBy(name = "description")
	private WebElement descriptionTA;
	
	@FindBy(name = "start")
	private WebElement startDate;
	
	@FindBy(name = "end")
	private WebElement endDate;
	
	@FindBy(name = "save_activity")
	private WebElement saveButton;
	
	//Initialization
	public AddActivityPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//Utilization
	public WebElement getCancelButton() {
		return cancelButton;
	}

	public WebElement getTitleTF() {
		return titleTF;
	}

	public WebElement getDescriptionTA() {
		return descriptionTA;
	}

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	JavaUtility jLib=new JavaUtility();
	int rn = jLib.getRandomNo();
	
	//Business Library
	
	/**
	 * @author METHAPRIAN S.K
	 * Desc - To create New Activity
	 * @param driver
	 * @param hashMapList
	 */
	public void createActivity(WebDriver driver,  HashMap<String, String> hashMapList) {
		for (Entry<String, String> map : hashMapList.entrySet()) {
			if((map.getKey()).equals("title")) {
				driver.findElement(By.name(map.getKey())).sendKeys(map.getValue()+rn);
			}else {
				driver.findElement(By.name(map.getKey())).sendKeys(map.getValue());
			}
		}
		getSaveButton().click();
		System.out.println("Activity Created.");
		Reporter.log("Activity Created");
	}
	
	
	
}
