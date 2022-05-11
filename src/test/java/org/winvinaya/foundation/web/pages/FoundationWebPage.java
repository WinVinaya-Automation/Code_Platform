package org.winvinaya.foundation.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.winvinaya.foundation.web.WinvinyaFoundationWebBasePage;

public class FoundationWebPage extends WinvinyaFoundationWebBasePage{
	public FoundationWebPage(WebDriver driver) {
		super(driver);
		pageName="foundation";
	}

	public By homeLogo=By.xpath("//*[@id='logo']");
	public By lblManuHome=By.xpath("//*[@title='Home']");
	public By lblManuCareers=By.xpath("//*[@id='top-menu']//a[text()='Careers']");
	public By lblJobOpporunities=By.xpath("//span[text()='Job Opportunities']");
	public By lblManuBlog=By.xpath("//*[@title='Blog']");
	public By btnReadMore=By.xpath("(//*[text()='Read More'])[1]");
	public By lblManuDonate=By.xpath("//*[@title='Donate']");
	public By lblManuContactUs=By.xpath("//*[@title='Contact​ Us']");
	public By lblManuUtsav=By.xpath("//*[@id='top-menu']//a[text()='Utsav']");

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	public boolean openFoundationURL() {
		goTo(getLabel("URL"));
		if(elementExist(homeLogo) && compareStrings(getLabel("URL"),getCurrentURL())) { 
			return true;
		}
		return false;
	}

	public boolean checklblManuCareer() {
		click(lblManuCareers);
		if(elementExist(lblJobOpporunities) && compareStrings(getLabel("career"),getCurrentURL())) { 
			return true;
		}
		return false;
	} 

	public boolean checklblManuBlog() {
		click(lblManuBlog);
		if(elementExist(btnReadMore) && compareStrings(getLabel("blog"),getCurrentURL())) { 
			return true;
		}
		return false;
	} 

	public boolean checklblManuUtsav() {
		click(lblManuUtsav);
		if(compareStrings(getLabel("ustav"),getCurrentURL())) { 
			return true;
		}
		return false;
	} 

	public boolean checklblManuContactUs() {
		click(lblManuContactUs);
		if(compareStrings(getLabel("contactus"),getCurrentURL())) { 
			return true;
		}
		return false;
	}

	public boolean checklblManuDonate() {
		click(lblManuDonate);
		if(compareStrings(getLabel("donate"),getCurrentURL())) { 
			return true;
		}
		return false;
	} 

}