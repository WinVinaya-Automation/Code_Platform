package org.winvinaya.infosystems.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.winvinaya.infosystems.web.WinvinyaInfosystemsWebBasePage;

public class InfosystemsWebPage extends WinvinyaInfosystemsWebBasePage{
	public InfosystemsWebPage(WebDriver driver) {
		super(driver);
		pageName="infosystems";
	}

	public By homeLogo=By.xpath("//*[@id='main-logo']");
	public By lblManuHome=By.xpath("//*[@title='Home']");
	public By lblManuProduct=By.xpath("//*[@title='Product']");
	public By lblProductSpan=By.xpath("//*[span='Product - File Validator']");
	public By lblManuBlog=By.xpath("//*[@title='Blog']");
	public By blogSpan=By.xpath("//*[span='Blog']");
	public By lblManuAboutUs=By.xpath("//*[@title='About Us']");
	public By lblleaderName=By.xpath("//*[text()='Shiva Jayagopal']");
	public By lblManuContact=By.xpath("//*[@title='Contact']");
	public By buttonSendMsg=By.xpath("//*[@value='Send Message']");

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	public boolean openInfosystemURL() {
		goTo(getLabel("URL"));
		if(elementExist(homeLogo) && compareStrings(getLabel("URL"),getCurrentURL())) { 
			return true;
		}
		return false;
	}

	public boolean checklblManuProduct() {
		click(lblManuProduct);
		if(elementExist(lblProductSpan) && compareStrings(getLabel("product"),getCurrentURL())) { 
			return true;
		}
		return false;
	} 

	public boolean checklblManuBlog() {
		click(lblManuBlog);
		if(elementExist(blogSpan) && compareStrings(getLabel("blog"),getCurrentURL())) { 
			return true;
		}
		return false;
	} 

	public boolean checklblManuAboutUs() {
		click(lblManuAboutUs);
		if(compareStrings(getLabel("aboutus"),getCurrentURL())) { 
			return true;
		}
		return false;
	} 

	public boolean checklblManuContact() {
		click(lblManuContact);
		if(elementExist(buttonSendMsg) && compareStrings(getLabel("contact"),getCurrentURL())) { 
			return true;
		}
		return false;
	}

	

}