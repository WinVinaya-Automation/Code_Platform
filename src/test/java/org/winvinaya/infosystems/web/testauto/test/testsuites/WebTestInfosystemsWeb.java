package org.winvinaya.infosystems.web.testauto.test.testsuites;

import org.testng.annotations.Test;
import java.io.IOException;

import org.winvinaya.infosystems.web.DataManager;
import org.winvinaya.infosystems.web.steps.InfosystemsWebSteps;
import org.winvinaya.infosystems.web.test.WebTestWinVinayaInfosystemsBase;
import org.wv.auto.framework.BrowserFactory;
import org.wv.auto.framework.utils.Reporter;

public class WebTestInfosystemsWeb extends WebTestWinVinayaInfosystemsBase {
	@Test(dataProviderClass=DataManager.class, dataProvider = "browsers", groups= {"pilot"}, enabled= true, 
			description="", priority=1)
	public void AcdemyLoginTest(String row, String strBrowserName) throws IOException  {
		driver = BrowserFactory.getBrowser(strBrowserName);
		InfosystemsWebSteps steps =new InfosystemsWebSteps(driver);
		steps.openInfosystemURL();
		Reporter.writeSummary("01,"+steps.getResult(),"Verify the infosystem Home Page is opening or not");
		steps.checklblManuProduct();
		Reporter.writeSummary("02,"+steps.getResult(),"Verify the infosystem product Page is opening or not");
		steps.checklblManuBlog();
		Reporter.writeSummary("03,"+steps.getResult(),"Verify the infosystem Blog Page is opening or not");
		steps.checklblManuAboutUs();
		Reporter.writeSummary("04,"+steps.getResult(),"Verify the infosystem about us Page is opening or not");
		steps.checklblManuContact();
		Reporter.writeSummary("05,"+steps.getResult(),"Verify the infosystem Contact Page is opening or not");
	}
}