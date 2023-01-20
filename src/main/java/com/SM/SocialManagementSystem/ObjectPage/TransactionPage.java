package com.SM.SocialManagementSystem.ObjectPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransactionPage {
	
	//Declaration
	
	@FindBy(id = "search")
	private WebElement searchTrancTF;
	
	@FindBy(id = "btn_search")
	private WebElement searchTrancButton;
	
	@FindBy(xpath = "//select[@class='form-control status']")
	private WebElement statusDD;
	
	@FindBy(xpath = "//label[.='Expenses:']/..//select[@class='form-control expenses']")
	private WebElement expensesDD;
	
	@FindBy(xpath = "//label[.='Payment:']/..//input[@type='number']")
	private WebElement paymentTF;
	
	@FindBy(id = "btn_cash")
	private WebElement cashInvoiceButton;
	

	//Initialization
	public TransactionPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Utilization
	public WebElement getSearchTrancTF() {
		return searchTrancTF;
	}

	public WebElement getSearchTrancButton() {
		return searchTrancButton;
	}

	public WebElement getStatusDD() {
		return statusDD;
	}

	public WebElement getPaymentTF() {
		return paymentTF;
	}
	
	public WebElement getCashInvoiceButton() {
		return cashInvoiceButton;
	}

	public WebElement getExpensesDD() {
		return expensesDD;
	}
	
	
	//Business Libraries
	
	
	
}
