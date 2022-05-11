package org.winvinaya.academy.testauto.steps;

import org.openqa.selenium.WebDriver;
import org.winvinaya.academy.testauto.AcadamyWebSteps;
import org.winvinaya.academy.testauto.pages.LoginPage;

public class LoginSteps extends AcadamyWebSteps {
	LoginPage login=null;
	public LoginSteps(WebDriver driver){
		login= new LoginPage(driver);
	}

	/* Function Name: UserLogin();
	 * Purpose: This function is using for navigation the URL and login with winvinayademouser01 user login credentials
	 */
	public void LoginAsTrainer() {
		result="FAILED";
		try {
			if(login.LoginAsTrainer()==true) {
				result="PASSED";
			}
		}catch (Exception e) {
			print("Login issue found" + e);
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
}