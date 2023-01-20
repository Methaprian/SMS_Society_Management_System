package com.SM.SocialManagementSystem.ObjectPage;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.SM.SocialManagementSystem.GenericUtility.WebDriverUtility;

public class AddExpensePage {
	
	//Declaration
	
	@FindBy(id = "cancel_expenses")
	private WebElement cancelExpenseButton;
	
	@FindBy(name = "detail")
	private WebElement detailTF;
	
	@FindBy(name = "price")
	private WebElement priceTF;
	
	@FindBy(name = "ay1")
	private WebElement startAY1;
	
	@FindBy(name = "ay2")
	private WebElement endAY2;
	
	@FindBy(name = "sem")
	private WebElement semDD;
	
	@FindBy(name = "deadline")
	private WebElement deadLine;
	
	@FindBy(name = "save_expenses")
	private WebElement saveExpenseButton;
	
	//Initialization
	public AddExpensePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	//Utilization
	
	public WebElement getCancelExpenseButton() {
		return cancelExpenseButton;
	}

	public WebElement getDetailTF() {
		return detailTF;
	}

	public WebElement getPriceTF() {
		return priceTF;
	}

	public WebElement getStartAY1() {
		return startAY1;
	}

	public WebElement getEndAY2() {
		return endAY2;
	}

	public WebElement getSemDD() {
		return semDD;
	}

	public WebElement getDeadLine() {
		return deadLine;
	}

	public WebElement getSaveExpenseButton() {
		return saveExpenseButton;
	}
	
	//Business Libraries
	
	/**
	 * @author METHAPRIAN S.K
	 * Desc - To Create an Expense
	 * @param driver
	 * @param hashMapList
	 */
	public void createExpense(WebDriver driver,  HashMap<String, String> hashMapList) {
		for (Entry<String, String> map : hashMapList.entrySet()) {
				driver.findElement(By.name(map.getKey())).sendKeys(map.getValue());
		}
		getSaveExpenseButton().click();
		System.out.println("Expense Added");
		Reporter.log("Expense Added.");
	}
	
	/**
	 * @author METHAPRIAN S.K
	 * Desc - To select Sem DD by Value
	 * @param wLib
	 * @param ddValue
	 */
	public void SemDropDown(WebDriverUtility wLib, String ddValue) {
		wLib.selectValue(getSemDD(), ddValue);
	}
}
