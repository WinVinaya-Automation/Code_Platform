package org.winvinaya.academy.testauto.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.winvinaya.academy.testauto.CheckInternetSpeed;
import org.winvinaya.academy.testauto.SendAttachment;
import org.winvinaya.academy.testauto.steps.LoginSteps;

public class WebTestWinVinayaAcadamyBase extends WinVinayaAcadamyWebBaseTest {
	@BeforeMethod
	public void beforeMethod() {
		print("This is Winvinaya-Acadamy WebSite Load Test beforeMethod");

	}
	protected void UserLogin(WebDriver driver)  {
		CheckInternetSpeed speed=new CheckInternetSpeed(driver);
		speed.checkspeed();
		print("Inside testLogin");
		LoginSteps login = new LoginSteps(driver);
		print("Inside testLogin - Page Opened");
		login.goToURL();
		login.loginUser();
	}	



	//	@AfterMethod
	//	public void JenkisMail () {
	//		if(Reporter.jenkinsResult!=0) {
	////			Assert.assertTrue(Reporter.jenkinsMail==0);
	//			Assert.assertEquals(Reporter.jenkinsResult, 0, "FAILED");
	//		}
	//	}


	@AfterSuite
	public void afterMethod() {
		print("This is Winvinaya-Acadamy WebTest afterMethod");
		if(driver!=null)
			driver.quit();
	}

}
