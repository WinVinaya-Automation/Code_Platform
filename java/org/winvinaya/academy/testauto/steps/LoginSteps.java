package org.winvinaya.academy.testauto.steps;

import org.openqa.selenium.WebDriver;
import org.winvinaya.academy.testauto.WinVinayaAcadamyWebSteps;
import org.winvinaya.academy.testauto.pages.LoginPage;

public class LoginSteps extends WinVinayaAcadamyWebSteps {
	LoginPage login=null;
	public LoginSteps(WebDriver driver){
		login= new LoginPage(driver);
	}

	/* Function Name: UserLogin();
	 * Purpose: This function is using for navigation the URL and login with winvinayademouser01 user login credentials
	 */
	public void LoginTrinee() {
		try {
			login.LoginTrinee();
		}catch (Exception e) {
			print("User login is issue" + e);
		}
	}

	/* Function Name: goToURL();
	 * Purpose: Open the URL
	 */
	public void goToURL() {
		try {
			login.goToURL();
		}catch (Exception e) {
			print("URL doesn't open" + e);
		}
	}

	/* Function Name: loginUser();
	 * Purpose: Login the User
	 */
	public void loginUser() {
		result="FAILED";
		try {
			if(login.loginUser()==true) {
				result="PASSED";
			}
		}catch (Exception e) {
			print("User login issue" + e);
			result="FAILED";
		}
	}
}
