package com.SM.SocialManagementSystem.ObjectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.SM.SocialManagementSystem.GenericUtility.FileUtility;

public class LoginPage {
	
	// Declaration
	
	@FindBy(id = "username")
	private WebElement adminUserNameTF;
	
	@FindBy(id="password")
	private WebElement AdminPassWordTF;
	
	@FindBy(id = "login")
	private WebElement loginButton;

	
	//Initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	
	public WebElement getUserNameTF() {
		return adminUserNameTF;
	}

	public WebElement getPassWordTF() {
		return AdminPassWordTF;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	//Business Libarary
	/**
	 * Desc - This Method is used to Login into Social Management System
	 * @author METHAPRIAN S.K
	 * @param fLib
	 * @throws Throwable
	 */
	public void Login(FileUtility fLib,String username, String password) throws Throwable {
		getUserNameTF().sendKeys(username);
		getPassWordTF().sendKeys(password);
		getLoginButton().click();
	}

}
