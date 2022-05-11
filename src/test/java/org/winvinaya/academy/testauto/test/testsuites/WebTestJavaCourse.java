package org.winvinaya.academy.testauto.test.testsuites;

import java.io.IOException;

import org.testng.annotations.Test;
import org.winvinaya.academy.testauto.DataManager;
import org.winvinaya.academy.testauto.steps.JavaCourseSteps;
import org.winvinaya.academy.testauto.test.WebTestWinVinayaAcadamyBase;
import org.wv.auto.framework.BrowserFactory;
import org.wv.auto.framework.utils.Reporter;

public class WebTestJavaCourse extends WebTestWinVinayaAcadamyBase {
	@Test(dataProviderClass=DataManager.class, dataProvider = "browsers", groups= {"pilot"}, enabled= true, 
			description="")
	public void AcdemyLoginTest(String row, String strBrowserName) throws IOException  {
		driver = BrowserFactory.getBrowser(strBrowserName);
		UserLogin(driver);
		//javastep.checkJavaLHSCourse();
		//		Reporter.writeSummary("TC-001,Verify the Winvinaya - Java Programming in ISL course is working., " +  javastep.getResult() );
		JavaCourseSteps javastep=new JavaCourseSteps(driver);
		Reporter.writeSummary("TC-001,Verify the user login loading time, " +  javastep.getResult());
		javastep.checkHomeIsExisted();
		Reporter.writeSummary("TC-002,Verify the home button loading time, " +  javastep.getResult());
		javastep.searchItem();
		wait(10);
	}
}
