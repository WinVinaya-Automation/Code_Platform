package org.winvinaya.foundation.web.test;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.winvinaya.foundation.web.SendAttachment;
import org.wv.auto.framework.BaseTest;
import org.wv.auto.framework.utils.Reporter;

public class WinVinayaFoundationWebBaseTest extends BaseTest {
	public String browser = "Chrome";
	@BeforeMethod
	public void beforeMethod() {
		print("This is winvinaya foundation WebSite Load Test beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		print("This is winvinaya foundation WebSite Load Test afterMethod");
		Assert.assertTrue(blnResult);
	}

	@BeforeSuite
	public void beforeSuite() throws IOException {
		Reporter.createReports();
	}

	@AfterSuite
	public void afterSuite() throws IOException {
		Reporter.closeReports();
		//Added a code for manually sending a report mail
		SendAttachment mail =new SendAttachment();
		mail.sendmail();
	}
}
