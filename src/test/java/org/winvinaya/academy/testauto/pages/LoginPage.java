package org.winvinaya.academy.testauto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.winvinaya.academy.testauto.AcadamyWebBasePage;

public class LoginPage extends AcadamyWebBasePage {
	public By usernameFloat=By.xpath("//*[text()='Email or Username *']");
	public By passwordFloat=By.xpath("//*[text()='Password *']");
	public By userName=By.xpath("//input[@id='username']");
	public By password=By.xpath("//input[@id='password']");
	public By btnLogin=By.xpath("//input[@id='login-submit']");
	public By homeLogo=By.xpath("(//a)[1]");
	public LoginPage(WebDriver driver) { 
		super(driver);
		pageName="academy";
	}

	/* Function Name: UserLogin();
	 * Purpose: This function is using for navigation the URL and login the credentials
	 */
	public boolean LoginAsTrainer() {
		goTo(getLabel("URL"));
		click(usernameFloat);
//		enterData("baskaran.arumugam@winvinaya.com",userName);
		enterData("wvademotrainer02@winvinayafoundation.org",userName);
		wait(2);
		click(passwordFloat);
		enterData("winvinaya",password);
		wait(2);
		click(btnLogin);
		if(elementExist(homeLogo)) {
			return true;
		}
		return false;
	}

	/* Function Name: goToURL();
	 * Purpose: Open the URL
	 */
	public void goToURL() {
		goTo(getLabel("URL"));
	}
}