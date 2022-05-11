package org.winvinaya.academy.testauto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.winvinaya.academy.testauto.WinVinayaAcadamyWebBasePage;

public class LoginPage extends WinVinayaAcadamyWebBasePage {
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
	 * Purpose: This function is using for navigation the URL and login with winvinayademouser01 user login credentials
	 */
	public void LoginTrinee() {
		goTo(getLabel("URL"));
		click(usernameFloat);
		//				enterData("winvinayademouser01",userName);
		enterData("baskaran.arumugam@winvinaya.com",userName);
		wait(2);
		click(passwordFloat);
		enterData("winvinaya",password);
		wait(2);
		click(btnLogin);
		//		wait(5);
		//		click(homeLogo);
		//		wait(5);
		//		print("Dashboard page is opened!");
	}

	/* Function Name: goToURL();
	 * Purpose: Open the URL
	 */
	public void goToURL() {
		goTo(getLabel("URL"));
	}
	/* Function Name: loginUser();
	 * Purpose: Login the User
	 */
	public boolean loginUser() {
		click(usernameFloat);
		enterData("winvinayademouser01",userName);
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
}