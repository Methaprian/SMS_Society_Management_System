package com.SM.SocialManagementSystem.ObjectPage;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
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
import com.SM.SocialManagementSystem.GenericUtility.WebDriverUtility;

public class AddStudentPage extends ExcelUtility {

	//Declaration
	@FindBy(name = "student_id")
	private WebElement studentID_TF;

	@FindBy(name = "firstname")
	private WebElement firstNameTF;

	@FindBy(name = "middlename")
	private WebElement middleNameTF;

	@FindBy(name = "lastname")
	private WebElement lastNameTF;

	@FindBy(name = "year")
	private WebElement yearDD;

	@FindBy(name = "section")
	private WebElement sectionTF;

	@FindBy(name = "save_student")
	private WebElement saveButton;

	@FindBy(xpath = "//input[@name='image']")
	private WebElement chooseImgFileButton;

	@FindBy(id = "cancel_student")
	private WebElement cancelButton;

	//Initialization
	public AddStudentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Utilization
	public WebElement getStudentID_TF() {
		return studentID_TF;
	}


	public WebElement getChooseImgFileButton() {
		return chooseImgFileButton;
	}

	public JavaUtility getjLib() {
		return jLib;
	}

	public int getRn() {
		return rn;
	}

	public WebElement getFirstNameTF() {
		return firstNameTF;
	}

	public WebElement getMiddleNameTF() {
		return middleNameTF;
	}

	public WebElement getLastNameTF() {
		return lastNameTF;
	}

	public WebElement getYearDD() {
		return yearDD;
	}

	public WebElement getSectionTF() {
		return sectionTF;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	//Business Libraries

	/**
	 * @author METHAPRIAN S.K
	 * Desc - Click on Cancel Button
	 */
	public void clickCancel() {
		getCancelButton().click();
	}

	/**
	 * @author METHAPRIAN S.K
	 * Desc - Click on Save Button
	 */
	public void clickSave() {
		getSaveButton().click();
	}

	JavaUtility jLib=new JavaUtility();
	int rn = jLib.getRandomNo();

	/**
	 * @author METHAPRIAN S.K
	 * Desc - To Create Student
	 * @param hashMapList
	 * @param driver
	 * @param eLib
	 * @throws InterruptedException 
	 */
	public void createStudent(HashMap<String, String> hashMapList, WebDriver driver, WebDriverUtility wLib,Robot rbt ,String ddValue, String imgSrc) throws InterruptedException {
		
		//Robot Class - FileUpload
		StringSelection imgPath = new StringSelection(imgSrc);
		Toolkit toolKit = Toolkit.getDefaultToolkit();
		Clipboard clipBoard = toolKit.getSystemClipboard();
		clipBoard.setContents(imgPath, null);
		rbt.keyPress(KeyEvent.VK_TAB);
		rbt.keyRelease(KeyEvent.VK_TAB);
		rbt.keyPress(KeyEvent.VK_TAB);
		rbt.keyRelease(KeyEvent.VK_TAB);
		rbt.keyPress(KeyEvent.VK_ENTER);
		rbt.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
		rbt.keyPress(KeyEvent.VK_CONTROL);
		rbt.keyPress(KeyEvent.VK_V);
		Thread.sleep(1000);
		rbt.keyRelease(KeyEvent.VK_CONTROL);
		rbt.keyRelease(KeyEvent.VK_V);
		rbt.keyPress(KeyEvent.VK_TAB);
		rbt.keyRelease(KeyEvent.VK_TAB);
		rbt.keyPress(KeyEvent.VK_TAB);
		rbt.keyRelease(KeyEvent.VK_TAB);
		rbt.keyPress(KeyEvent.VK_ENTER);
		rbt.keyRelease(KeyEvent.VK_ENTER);

		for (Entry<String, String> string : hashMapList.entrySet()) {
			if((string.getKey()).contains("student_id")) {
				driver.findElement(By.name(string.getKey())).sendKeys(string.getValue()+rn);
			}else {
				driver.findElement(By.name(string.getKey())).sendKeys(string.getValue());
			}
		}
		wLib.selectValue(yearDD, ddValue);
		clickSave();
		System.out.println("Student Created.");
		Reporter.log("Student Created");
	}
}