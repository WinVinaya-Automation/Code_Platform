package org.winvinaya.infosystems.web.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class WebTestWinVinayaInfosystemsBase extends WinVinayaInfosystemsWebBaseTest {
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
