package org.wv.auto.framework;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.wv.auto.framework.utils.Timer;

public abstract class  BasePage {
	public WebDriver driver;
	protected Actions actions;
	protected WebDriverWait wdWait=null;
	protected String pageName=null; 
	protected ArrayList<String> tabs;
	protected String windowsValue;
	protected int tabSize;

	public WebElement getObj(By objLoc) {
		WebElement we = driver.findElement(objLoc);
		//driver.manage().window().setSize(new Dimension(1024, 600));
		return we;
	}	
	public boolean compareStrings(String expValue, String actualValue) {
		if (expValue.equals(actualValue)) {
			print("PASSED : The expected string is " + expValue
					+ " , the actual string is " + actualValue);
			return true;
		} else {
			print("FAILED : The expected string is " + expValue
					+ " , the actual string is " + actualValue);
			return false;
		}
	}
	public void goTo(String Url) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(Url);
		wait(3);
	}
	public void print(String strToPrint) {
		System.out.println(strToPrint);
	}
	public void wait(int timeInSec){
		Timer.wait(timeInSec);
	}
	public void enterData(String dataToEnter, By objLoc) {
		enterData(dataToEnter, getObj(objLoc));
	}
	public void enterData(String dataToEnter, WebElement inpElement) {
		WebElement we = inpElement;
		we.clear();
		we.sendKeys(dataToEnter);
		print("ENTERED DATA: The data " + dataToEnter
				+ " is entered in input Element" + inpElement.toString());
	}
	public boolean verifyTitle(String expTitle) {
		return compareStrings(expTitle, driver.getTitle());
	}
	public boolean verifyText(String expText, By objLoc) {
		WebElement we = getObj(objLoc);
		return verifyText(expText, we);
	}
	public String getText(By objLoc) {
		WebElement we = getObj(objLoc);
		return we.getText();
	}
	public boolean verifyText(String expText, WebElement obj) {
		String actText = obj.getText();
		return compareStrings(expText, actText);
	}
	public void click(By objLoc) {
		click(getObj(objLoc));
	}
	public void click(WebElement obj) {
		obj.click();
		print("CLICKED: " + obj.toString());
	}
	public boolean elementExist(By objLoc) {
		WebElement obj = null;
		try {
			obj = getObj(objLoc);
			print("PASSED: ELEMENT" + obj.toString() +" The element exist");
			return true;
		}catch(NoSuchElementException ex) {
			print("FAILED: ELEMENT" + objLoc.toString() +" The element doesn't exist");
			return false;
		}
	}
	//	public boolean containsString(String expValue, String actualValue) {
	//		if (actualValue.contains(expValue)) {
	//			print("PASSED: The expected string is " + expValue
	//					+ " , the actual string is " + actualValue);
	//			return true;
	//		} else {
	//			print("FAILED: The expected string is " + expValue
	//					+ " , the actual string is " + actualValue);
	//			return false;
	//		}
	//	}
	public String getAttributeValue(By objLoc,String attribute) {
		String value = driver.findElement(objLoc).getAttribute(attribute);
		return value;
	}
	public void switchToNewTab() {
		tabs= new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window((String) tabs.get(tabs.size()-1));   
	} 
	public void closeNewTabandgoToMainTab() {
		driver.close();
		tabs= new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window((String) tabs.get(tabs.size()-1));
	}

	public void clear(By objLoc) {
		WebElement we = getObj(objLoc);
		we.clear();
		print("CLEARED DATA : The data " + " is cleared in input Element" + we.toString());
	}
	public boolean verifyText(String expText, String actText) {
		return compareStrings(expText, actText);
	}
	public void scrollToElement(By objPath) {
		WebElement element = driver.findElement(objPath);
		JavascriptExecutor jse = (JavascriptExecutor) driver;  wait(5);   
		jse.executeScript("arguments[0].scrollIntoView();", element);
	}
	public boolean compareStringsIgnorecase(String expValue, String actualValue) {
		if (expValue.equalsIgnoreCase(actualValue)) {
			print("PASSED: The expected string is " + expValue
					+ " , the actual string is " + actualValue);
			return true;
		} else {
			print("FAILED: The expected string is " + expValue
					+ " , the actual string is " + actualValue);
			return false;
		}
	}
	public boolean verifyTextIgnorecase(String expText, By objLoc) {
		WebElement we = getObj(objLoc);
		return verifyTextIgnorecase(expText, we);
	}
	public boolean verifyTextIgnorecase(String expText, WebElement obj) {
		String actText = obj.getText();
		return compareStringsIgnorecase(expText, actText);
	}
	public boolean isClickable(By locater)      
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.elementToBeClickable(locater));
			print("PASSED: The "+locater.toString()+" element is clickable");
			return true;
		}
		catch (Exception e)
		{
			print("FAILED: The "+locater.toString()+" element is NOT clickable");
			return false;
		}
	}
	public void moveElementFocus(By elementLoc) {
		wait(3);
		WebElement element=driver.findElement(elementLoc);
		Actions actions= new Actions(driver);
		actions.moveToElement(element).perform();
		wait(3);
	}
	
	public void moveElementFocusandClick(By elementLoc) {
		WebElement element=driver.findElement(elementLoc);
		actions= new Actions(driver);
		actions.moveToElement(element).perform();
		wait(3);
		click(elementLoc);
		print("The element: "+elementLoc+" is Clicked.");
		//		wait(2);
	}
	public boolean isDisplayed(By element) {
		if(driver.findElement(element).isDisplayed()) {
			print("PASSED: The "+ element+" is present.");
			return true;
		}
		else {
			print("FAILED: The "+ element+" is NOT present.");
			return false;
		}
	}
	public boolean containsText(String actualValue,String expectedValue) {
		if(actualValue.contains(expectedValue)) {
			print("PASSED: The actual value: "+actualValue+" and the expected value: "+ expectedValue);
			return true;
		}
		else {
			print("FAILED: The actual value: "+actualValue+" and the expected value: "+ expectedValue);
			return false;
		}
	}
}
