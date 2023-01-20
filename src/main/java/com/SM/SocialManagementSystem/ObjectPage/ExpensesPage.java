package com.SM.SocialManagementSystem.ObjectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExpensesPage {
	
	//Declaration
	
	@FindBy(id = "add_expenses")
	private WebElement addExpensesButton;
	
	@FindBy(xpath = "//label[.='Search:']//input[@type='search']")
	private WebElement  searchExpenseTF;
	
	@FindBy(name = "table_length")
	private WebElement expenseTabLenDD;
	
	//Initialization
	public ExpensesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getAddExpensesButton() {
		return addExpensesButton;
	}

	public WebElement getSearchExpenseTF() {
		return searchExpenseTF;
	}

	public WebElement getExpenseTabLenDD() {
		return expenseTabLenDD;
	}
	
	//Business Libraries
	
	
}
