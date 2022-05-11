package org.winvinaya.academy.testauto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.winvinaya.academy.testauto.WinVinayaAcadamyWebBasePage;

public class LoadingTimePage extends WinVinayaAcadamyWebBasePage{
	public By searchTab=By.xpath("//input[@id='inputSearch']");
	public By homeLogo=By.xpath("(//a)[2]");
	public By sideTopic=By.xpath("(//h4)[1]");
	public By iLearnItem=By.xpath("((//div[contains(@class,'sessioninfo')])[1]//a)[1]");
	public By iPracticeItem=By.xpath("((//div[contains(@class,'amphi-default-highlight')])[4]//a)[4]");
	public By iPractceLable=By.xpath("//h3[@class='primary-color'][contains(.,'i-Practice')]");
	public By iLearnLable=By.xpath("//h3[@class='primary-color'][contains(.,'i-Learn')]");
	
	public LoadingTimePage(WebDriver driver) {
		super(driver);
	}

	public boolean checkHomeIsExisted() {
		if(elementExist(homeLogo)) {
			click(homeLogo);
			return true;
		}else {
			return false;
		}
	}

	public void searchItem(String courseName) {
		wait(5);
		while(isDisplayed(searchTab)) {
			enterData(courseName,searchTab); 
			driver.findElement(searchTab).sendKeys(Keys.RETURN);
			By courseXpath=By.xpath("//*[@class='course-item-head']//*[contains(text(),'"+courseName+"')]");
			print(""+courseXpath);
			while(isDisplayed(courseXpath)){
				moveElementFocusandClick(courseXpath);
				break;
			}
			break;
		}
	}

	public void openTopic() {
		click(sideTopic); //first topic
			}
	
	public void iLearn() {
		if(elementExist(iLearnLable)) {
			click(iLearnItem);
		}
	}
	
	public void goBack() {
		driver.navigate().back();
	}
	
	public void iPratice() {
		if(elementExist(iPractceLable)) {
			click(iPracticeItem);
		}
	}
}
