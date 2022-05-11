package org.winvinaya.academy.testauto.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.winvinaya.academy.testauto.steps.LoginSteps;


public class WebTestAcadamyBase extends AcadamyWebBaseTest {
	@BeforeMethod
	public void beforeMethod() {
		print("This is Winvinaya-Acadamy WebApp Load Test beforeMethod");

	}
	protected void TrainerLogin(WebDriver driver)  {
		print("Inside testLogin");
		print("Inside testLogin - Page Opened");
		print("Inside testLogin");
		LoginSteps login = new LoginSteps(driver);
		print("Inside testLogin - Page Opened");
		login.LoginAsTrainer();
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
		print("This is Winvinaya-Acadamy WebApp Load Test afterMethod");
		if(driver!=null)
			driver.quit();
	}

}
