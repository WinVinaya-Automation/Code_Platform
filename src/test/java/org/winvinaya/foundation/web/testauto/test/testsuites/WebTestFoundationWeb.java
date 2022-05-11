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
		Reporter.writeSummary("01,Verify the foundation Home Page is opening or not, " +  steps.getResult());
		steps.checkCareerPage();
		Reporter.writeSummary("02,Verify the foundation career Page is opening or not, " +  steps.getResult());
		steps.checklblManuBlog();
		Reporter.writeSummary("03,Verify the foundation Blog Page is opening or not, " +  steps.getResult());
		steps.checklblManuUtsav();
		Reporter.writeSummary("04,Verify the foundation Utsav Page is opening or not, " +  steps.getResult());
		steps.checklblManuContactUs();
		Reporter.writeSummary("05,Verify the foundation Contact us Page is opening or not, " +  steps.getResult());
		steps.checklblManuDonate();
		Reporter.writeSummary("06,Verify the foundation Donate Page is opening or not, " +  steps.getResult());
	}
}