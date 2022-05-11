package org.winvinaya.academy.testauto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.winvinaya.academy.testauto.WinVinayaAcadamyWebBasePage;

public class UserLoadingTimePages extends WinVinayaAcadamyWebBasePage{
	public By homeLogo=By.xpath("//header/div[1]/div[2]/ul[1]/li[1]/a[1]");
	public By searchTab=By.xpath("//input[@id='inputSearch']");
	public By ilearnItem=By.xpath("((//*[@class='flex-col-layout'])[1]//div)[1]//div[@class='bottom-section']//a");
	public By ipracticeItem=By.xpath("((//*[@class='flex-col-layout'])[2]//div)[1]//div[@class='bottom-section']//a");
	public By iassessItem=By.xpath("((//*[@class='flex-col-layout'])[3]//div)[1]//div[@class='bottom-section']//a");
	public By lblViewAllCourse=By.xpath("//*[text()='View All Courses']");
	public UserLoadingTimePages(WebDriver driver) {
		super(driver);
	}
	public boolean checkHomeIsExisted() {
		if(elementExist(homeLogo)) {
			click(homeLogo);
			if(elementExist(lblViewAllCourse)) {
				return true;
			}
		}		
		return false;
	}

	/*
	 * Changed the mtd to boolean from void on 29-Mar-22
	 */
	public boolean searchItem(String courseName) {
		if(elementExist(searchTab)) {
			wait(3);
			enterData(courseName,searchTab); 
			driver.findElement(searchTab).sendKeys(Keys.RETURN);
			//			driver.findElement(searchTab).sendKeys(Keys.RETURN);
			By courseXpath=By.xpath("//*[@class='course-item-head']//*[contains(text(),'"+courseName+"')]");
			moveElementFocusandClick(courseXpath);
			return true;
		}
		return false;
	}

	public void clickiLearnItem() {
		if(elementExist(ilearnItem))
			click(ilearnItem);
	}

	public void clickiPreteiceItem() {
		if(elementExist(ipracticeItem))
			click(ipracticeItem);
	}

	public void clickiAccessItem() {
		if(elementExist(iassessItem))
			click(iassessItem);
	}

	public void goBack() {
		driver.navigate().back();
	}



}
