package com.SM.SocialManagementSystem.ObjectPage;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.SM.SocialManagementSystem.GenericUtility.ExcelUtility;
import com.SM.SocialManagementSystem.GenericUtility.JavaUtility;

public class AddAdminPage extends ExcelUtility {
	
	JavaUtility jLib=new JavaUtility();


	//Declaration

	@FindBy(name = "username")
	private WebElement usernameTF;

	@FindBy(name = "password")
	private WebElement passwordTF;

	@FindBy(name = "name")
	private WebElement nameTF;

	@FindBy(name = "save_admin")
	private WebElement saveButton;

	@FindBy(id = "cancel_admin")
	private WebElement cancelButton;


	//Initialization
	public AddAdminPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization

	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getNameTF() {
		return nameTF;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	//Business Libraries
	
	public void clickSave() {
		getSaveButton().click();
	}
	
	public void clickCancel() {
		getCancelButton().click();
	}
	
	int rn = jLib.getRandomNo();
	
	/**
	 * @author METHAPRIAN S.K
	 * Desc - Used to Create an Admin
	 * @param hashMapList
	 * @param driver
	 * @param eLib
	 * @throws Throwable
	 */
	public void createAdmin(HashMap<String, String> hashMapList, WebDriver driver, ExcelUtility eLib) throws Throwable {
		
		for (Entry<String, String> string : hashMapList.entrySet()) {
			if((string.getKey()).contains("username")) {
				driver.findElement(By.name(string.getKey())).sendKeys(string.getValue()+rn);
			}else {
				driver.findElement(By.name(string.getKey())).sendKeys(string.getValue());
			}
		}
		clickSave();
		System.out.println("Admin Created");
		Reporter.log("Admin Created");
	}
}
