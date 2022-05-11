package org.winvinaya.foundation.web.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class WebTestWinVinayaFoundationBase extends WinVinayaFoundationWebBaseTest {
	@BeforeMethod
	public void beforeMethod() {
		print("This is Winvinaya-Foundation WebSite sanity Test beforeMethod");

	}

	@AfterSuite
	public void afterMethod() {
		print("This is Winvinaya-Foundation WebSite sanity test afterMethod");
		if(driver!=null)
			driver.quit();
	}

}
