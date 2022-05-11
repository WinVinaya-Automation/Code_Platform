package org.winvinaya.academy.testauto.test.testsuites;

import org.testng.annotations.Test;
import java.io.IOException;

import org.winvinaya.academy.testauto.DataManager;
import org.winvinaya.academy.testauto.steps.UserLoadingTimeSteps;
import org.winvinaya.academy.testauto.test.WebTestWinVinayaAcadamyBase;
import org.wv.auto.framework.BrowserFactory;
import org.wv.auto.framework.utils.Reporter;

public class WebTestUserLoadingTime extends WebTestWinVinayaAcadamyBase {
	public static int TC=1;
	UserLoadingTimeSteps loadTime;
	public void  searchItem(String courseName) {
		loadTime.searchItem(courseName);
		if(TC>3){
			Reporter.writeSummary(TC++ +",NEXT COURSE - Verify the "+courseName+" loading time, " +  loadTime.getResult());
		}
		else {
			Reporter.writeSummary(TC++ +",Verify the "+courseName+" loading time, " +  loadTime.getResult());
		}
	}
	public void ilearn() {
		loadTime.clickiLearnItem();
		loadTime.goBack();
		Reporter.writeSummary(TC+++",Verify the sub topic - iLearning page loading time, " +  loadTime.getResult());
	}
	public void iPratices() {
		loadTime.clickiPreteiceItem();
		loadTime.goBack();
		Reporter.writeSummary(TC+++",Verify the sub topic - iPractice page loading time, " +  loadTime.getResult());
	}
	public void iAccess() {
		loadTime.clickiAccessItem();
		loadTime.goBack();
		Reporter.writeSummary(TC+++",Verify the sub topic- iAccess page loading time, " +  loadTime.getResult());
	}
	public void courseLoadingTimeiLearn() {
		ilearn();
	}

	public void courseLoadingTimeiPretice() {
		ilearn();
		iPratices();
	}

	public void courseLoadingTimeiAccess() {
		ilearn();
		iPratices();
		iAccess();

	}

	@Test(dataProviderClass=DataManager.class, dataProvider = "browsers", groups= {"pilot"}, enabled= true, 
			description="", priority=1)
	public void AcdemyLoginTest(String row, String strBrowserName) throws IOException  {
		driver = BrowserFactory.getBrowser(strBrowserName);
		UserLogin(driver);
		loadTime=new UserLoadingTimeSteps(driver);
		Reporter.writeSummary(TC+++",Verify the user login loading time, " +  loadTime.getResult());
		loadTime.checkHomeIsExisted();
		Reporter.writeSummary(TC+++",Verify the clicking action of home button and the loading time of Home page (View All courses button), " +  loadTime.getResult());
		//		searchItem("WinVinaya – Complete MySQL Developer Course in ISL");
		//		courseLoadingTimeiLearn();
		//		loadTime.goBack();
		//		searchItem("Winvinaya Soft Skills - ISL");	
		//		courseLoadingTimeiLearn();
		//		loadTime.goBack();
		searchItem("WinVinaya – Learn HTML5 and CSS3 Basics - ISL");
		courseLoadingTimeiLearn();
		loadTime.goBack();
		searchItem("WinVinaya- Banking ISL");
		courseLoadingTimeiAccess();
		loadTime.goBack();
		searchItem("WinVinaya - English ISL V2.0 Course");
		courseLoadingTimeiAccess();
		loadTime.goBack();
		searchItem("Winvinaya- MS- Excel ISL");
		courseLoadingTimeiAccess();
		loadTime.goBack();
		searchItem("WinVinaya - English - ISL Course");
		courseLoadingTimeiAccess();
		loadTime.goBack();
	}
}