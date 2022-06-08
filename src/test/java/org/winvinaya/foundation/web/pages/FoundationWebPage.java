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
	public By lblBlog=By.xpath("//strong[text()='Blog']");
	public By lblManuDonate=By.xpath("//*[@title='Donate']");
	public By lblManuContactUs=By.xpath("//*[@id=\"top-menu\"]/li[9]/a");
	public By lblManuUtsav=By.xpath("//*[@id='top-menu']//a[text()='Utsav']");
	public By bannerUtsav=By.xpath("//*[@id='post-5167']/div/div/div/div[2]/div/img");
	public By txtCountUS=By.xpath("//strong[contains(text(),'CONTACT US')]");
	public By txtoptions=By.xpath("//span[contains(text(),'Option')]");

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
		if(elementExist(lblBlog) && compareStrings(getLabel("blog"),getCurrentURL())) { 
			return true;
		}
		return false;
	} 

	public boolean checklblManuUtsav() {
		click(lblManuUtsav);
		if(compareStrings(getLabel("ustav"),getCurrentURL()) && elementExist(bannerUtsav)) { 
			return true;
		}
		return false;
	} 

	public boolean checklblManuContactUs() {
		click(lblManuContactUs);
		if(compareStrings(getLabel("contactus"),getCurrentURL()) && elementExist(txtCountUS)) { 
			return true;
		}
		return false;
	}

	public boolean checklblManuDonate() {
		click(lblManuDonate);
		if(compareStrings(getLabel("donate"),getCurrentURL())&& elementExist(txtoptions)) { 
			return true;
		}
		return false;
	} 

}