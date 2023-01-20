package com.SM.SocialManagementSystem.GenericUtility;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {
	/**
	 * @author METHAPRIAN S.K
	 * Desc - Launches Browser based on the Requirement (Chrome / Firefox / Edge)
	 * @param driver
	 * @param fLib
	 * @throws Throwable
	 */
	public void launchBrowser(WebDriver driver) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.edgedriver().setup();
	}

	/**
	 * Desc - Maximize Window
	 * @author METHAPRIAN S.K
	 * @param driver
	 */
	public void maxWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * Desc - To Quit Browser
	 * @author METHAPRIAN S.K
	 * @param driver
	 */
	public void quitBrowser(WebDriver driver) {
		driver.quit();
	}

	/**
	 * Desc - findElement and findElements Load Time
	 * @author METHAPRIAN S.K
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * Desc - Element Visibility
	 * @author METHAPRIAN S.K
	 * @param ele
	 */
	public void eleToBeVisible(WebDriver driver,WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void eleToBeInvisible(WebDriver driver, WebElement ele) {
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	/**
	 * desc - Dropdown Select by Value
	 * @author METHAPRIAN S.K
	 * @param ele
	 * @param value
	 */
	public void selectValue(WebElement ele, String value) {
		Select sel=new Select(ele);
		sel.selectByValue(value);
	}

	/**
	 * desc - Dropdown Select by Index
	 * @author METHAPRIAN S.K
	 * @param ele
	 * @param index
	 */
	public void selectIndex(WebElement ele, int index) {
		Select sel=new Select(ele);
		sel.selectByIndex(index);
	}

	/**
	 * Desc - Dropdown Select by Visible text
	 * @author METHAPRIAN S.K
	 * @param visibleText
	 * @param ele
	 */
	public void selectVisText(String visibleText,WebElement ele) {
		Select sel=new Select(ele);
		sel.selectByVisibleText(visibleText);
	}

	/**
	 * Desc - To Switch between Windows(Parent - Child)
	 * @author METHAPRIAN S.K
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchToWindow(WebDriver driver , String partialWindowTitle) {
		Set<String> winIDS = driver.getWindowHandles();
		Iterator<String> it = winIDS.iterator();
		while(it.hasNext()) {
			String wID = it.next();
			driver.switchTo().window(wID);
			String currentWinTitle = driver.getTitle();
			if(currentWinTitle.contains(partialWindowTitle)) {
				break;
			}
		}
	}
	/**
	 * @author METHAPRIAN S.K
	 * Desc - Click on WebElement
	 * @param ele
	 */
	public void clickOnEle(WebElement ele) {
		ele.click();
	}

	public void clickOnEle(WebDriver driver,WebElement ele, int xOffSet, int yOffSet) {
		Actions action = new Actions(driver);
		action.moveToElement(ele, xOffSet, yOffSet);
	}

	/**
	 * Desc - Action Class - Mouse Hover
	 * @author METHAPRIAN S.K
	 * @param ele
	 */
	public void mouseHoverAction(WebDriver driver, WebElement ele) {
		Actions action = new Actions(driver);
		action.moveToElement(ele).perform();;
	}

	/**
	 * Desc - Action Class - Drag And Drop (Src-Dest) 
	 * @author METHAPRIAN S.K
	 * @param src
	 * @param dest
	 */
	public void dragAndDropAction(WebDriver driver,WebElement src,WebElement dest) {
		Actions action = new Actions(driver);
		action.dragAndDrop(src, dest).perform();
	}

	/**
	 * Desc - Action Class - DoubleClick
	 * @author METHAPRIAN S.K
	 * @param ele
	 */
	public void doubleClickAction(WebDriver driver) {
		Actions action = new Actions(driver);
		action.doubleClick().perform();
	}

	/**
	 * Desc - Action Class - DoubleClick (Element)
	 * @author METHAPRIAN S.K
	 * @param ele
	 */
	public void doubleClickAction(WebDriver driver,WebElement ele) {
		Actions action = new Actions(driver);
		action.doubleClick(ele).perform();
	}

	/**
	 * Desc - Action CLass - RightClick
	 * @author METHAPRIAN S.K
	 * @param ele
	 */
	public void rightClickAction(WebDriver driver) {
		Actions action = new Actions(driver);
		action.contextClick().perform();
	}

	/**
	 * Desc - Action CLass - RightClick (Element)
	 * @author METHAPRIAN S.K
	 * @param ele
	 */
	public void rightClickAction(WebDriver driver,WebElement ele) {
		Actions action = new Actions(driver);
		action.contextClick(ele).perform();
	}

	/**
	 * Desc - Action Class - ENTER
	 * @author METHAPRIAN S.K
	 */
	public void enterKeyPressAction(WebDriver driver) {
		Actions action = new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}

	/**
	 * Desc - Robot Class - ENTER_KEY PRESS
	 * @author METHAPRIAN S.K
	 * @throws Throwable
	 */
	public void enterKeyPressRobot() throws Throwable {
		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_ENTER);
	}

	/**
	 * Desc - Robot Class - ENTER_KEY RELEASE
	 * @author METHAPRIAN S.K
	 * @throws Throwable
	 */
	public void enterKeyReleaseRobot() throws Throwable {
		Robot rbt = new Robot();
		rbt.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * Desc - Switch the Frame - by INDEX
	 * @author METHAPRIAN S.K
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * Desc - Switch the Frame - by Name or ID
	 * @author METHAPRIAN S.K
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	/**
	 * Desc - Switch the Frame - by Address(Element)
	 * @author METHAPRIAN S.K
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver,WebElement eleAdd) {
		driver.switchTo().frame(eleAdd);
	}

	/**
	 * Desc - Switch the Frame - Parent Frame
	 * @author METHAPRIAN S.K
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	/**
	 * Desc - Alert PopUp - Accept
	 * @author METHAPRIAN S.K
	 * @param driver
	 */
	public void acceptAlertPopUp(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * Desc - Alert PopUp - Dismiss
	 * @author METHAPRIAN S.K
	 * @param driver
	 */
	public void dismissAlertPopUp(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * Desc - Switch between Windows
	 * @author METHAPRIAN S.K
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchWindow(WebDriver driver, String partialWinTitle) {
		//Get all Window IDs
		Set<String> windowIds = driver.getWindowHandles();

		//Iterate through Windows
		Iterator<String> it = windowIds.iterator();

		//Check whether next window is present
		while(it.hasNext()) {

			//Capture the Current Window ID
			String winId = it.next();

			//Switch to Current Window and Capture the Title
			String currentWinTitle = driver.switchTo().window(winId).getTitle();

			//Chech whether the Current Window is Expected
			if(currentWinTitle.contains(partialWinTitle)) {
				break;
			}
		}
	}

	/**
	 * Desc - Takes Screenshot and Stores in screenshot folder
	 * @author METHAPRIAN S.K
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws Throwable
	 */
	public String getScreenShot(WebDriver driver, String screenShotName) throws Throwable  {

		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String path = "./screenshot" + screenShotName +".png";
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}
	/**
	 * @author METHAPRIAN S.K
	 * Desc - screenShot for Listener Class
	 * @return 
	 * @throws Throwable
	 */
	public void errorShot(ITestResult result) throws Throwable  {
		String FailedScript = result.getMethod().getMethodName();
		String fs = FailedScript+"-"+new JavaUtility().getSystemDate();
		EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseClass.edriver);
		File src = eDriver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./ErrorShots/"+fs +".png");
		FileUtils.copyFile(src, dest);
		
	}
	/**
	 * Desc - Scroll the Webpage - by ( xOffSet / yOffSet )
	 * @author METHAPRIAN S.K
	 * @param driver
	 * @param xOffSet
	 * @param yOffSet
	 */
	public void scrollBarAction(WebDriver driver,int xOffSet,int yOffSet) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy("+xOffSet+","+yOffSet+")");
	}

	/**
	 * Desc - Scrolls the Webpage until element is Visible
	 * @author METHAPRIAN S.K
	 * @param driver
	 * @param ele
	 */
	public void scollToEle(WebDriver driver, WebElement ele) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		int yLoc = ele.getLocation().getY();
		jse.executeScript("window.scrollBy(0,"+yLoc+")",ele);
	}
}
