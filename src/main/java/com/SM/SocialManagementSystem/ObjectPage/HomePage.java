package com.SM.SocialManagementSystem.ObjectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	// Decalration
	
	@FindBy(linkText = "home.php")
	private WebElement homePageLink;
	
	@FindBy(xpath = "//a[.=' Accounts']")
	private WebElement accountsLink;
	
	@FindBy(xpath = "//a[.=' Administrator']")
	private WebElement administratorLink;
	
	@FindBy(xpath = "//a[.=' Student']")
	private WebElement studentLink;
	
	@FindBy(xpath = "//a[.=' Activities']")
	private WebElement activitiesLink;
	
	@FindBy(xpath = "//a[.=' Expenses']")
	private WebElement expansesLink;
	
	@FindBy(xpath = "//a[.=' Transaction']")
	private WebElement transactionLink;
	
	@FindBy(xpath = "//a[.=' Options']")
	private WebElement optionsLink;
	
	@FindBy(xpath = "//a[.=' Logout']")
	private WebElement logOutLink;
	
	//Initializaion
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	//Utilization
	
	public WebElement getHomePageLink() {
		return homePageLink;
	}

	public WebElement getAccountsLink() {
		return accountsLink;
	}

	public WebElement getAdministratorLink() {
		return administratorLink;
	}

	public WebElement getStudentLink() {
		return studentLink;
	}

	public WebElement getActivitiesLink() {
		return activitiesLink;
	}

	public WebElement getExpansesLink() {
		return expansesLink;
	}

	public WebElement getTransactionLink() {
		return transactionLink;
	}

	public WebElement getOptionsLink() {
		return optionsLink;
	}

	public WebElement getLogOutLink() {
		return logOutLink;
	}
	
	
	//Business Library
	
	/**
	 * @author METHAPRIAN S.K
	 * Desc - Click on Home Link
	 */
	public void clickOnHome() {
		getHomePageLink().click();
	}
	
	/**
	 * @author METHAPRIAN S.K
	 * Desc - Click on Administrator Link
	 */
	public void clickOnAdministrator() {
		getAccountsLink().click();
		getAdministratorLink().click();
	}
	
	/**
	 * @author METHAPRIAN S.K
	 * Desc - Click on Student Link
	 */
	public void clickOnStudentLink() {
		getAccountsLink().click();
		getStudentLink().click();
	}
	
	/**
	 * @author METHAPRIAN S.K
	 * Desc - Click on Activities Link
	 */
	public void clickOnActivitiesLink() {
		getActivitiesLink().click();
	}
	
	/**
	 * @author METHAPRIAN S.K
	 * Desc - Click on Expenses Link
	 */
	public void clickOnExpensesLink() {
		getExpansesLink().click();
	}
	
	/**
	 * @author METHAPRIAN S.K
	 * Desc - Click on Transaction Link
	 */
	public void clickOnTransactionLink() {
		getTransactionLink().click();
	}
	
	/**
	 * @author METHAPRIAN S.K
	 * Desc - LogOut from the Application
	 */
	public void logOut() {
		getOptionsLink().click();
		getLogOutLink().click();
	}
	
	
}
