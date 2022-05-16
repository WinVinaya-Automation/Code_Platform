package org.winvinaya.foundation.web.testauto.test.testsuites;

import org.testng.annotations.Test;
import java.io.IOException;

import org.winvinaya.foundation.web.DataManager;
import org.winvinaya.foundation.web.steps.FoundationWebSteps;
import org.winvinaya.foundation.web.test.WebTestWinVinayaFoundationBase;
import org.wv.auto.framework.BrowserFactory;
import org.wv.auto.framework.utils.Reporter;

public class WebTestFoundationWeb extends WebTestWinVinayaFoundationBase {
	@Test(dataProviderClass=DataManager.class, dataProvider = "browsers", groups= {"pilot"}, enabled= true, 
			description="", priority=1)
	public void AcdemyLoginTest(String row, String strBrowserName) throws IOException  {
		driver = BrowserFactory.getBrowser(strBrowserName);
		FoundationWebSteps steps =new FoundationWebSteps(driver);
		steps.openURL();
		Reporter.writeSummary("01,"+steps.getResult(),"Verify the foundation Home Page is opening or not");
		steps.checkCareerPage();
		Reporter.writeSummary("02,"+steps.getResult(),"Verify the foundation career Page is opening or not");
		steps.checklblManuBlog();
		Reporter.writeSummary("03,"+steps.getResult(),"Verify the foundation Blog Page is opening or not");
		steps.checklblManuUtsav();
		Reporter.writeSummary("04,"+steps.getResult(),"Verify the foundation Utsav Page is opening or not");
		steps.checklblManuContactUs();
		Reporter.writeSummary("05,"+steps.getResult(),"Verify the foundation Contact us Page is opening or not");
		steps.checklblManuDonate();
		Reporter.writeSummary("06,"+steps.getResult(),"Verify the foundation Donate Page is opening or not");
	}
}