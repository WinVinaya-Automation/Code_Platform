package org.winvinaya.academy.testauto.test.testsuites;

import org.testng.annotations.Test;
import java.io.IOException;

import org.winvinaya.academy.testauto.DataManager;
import org.winvinaya.academy.testauto.WinVinayaAcadamyWebSteps;
import org.winvinaya.academy.testauto.steps.UserLoadingTimeSteps;
import org.winvinaya.academy.testauto.test.WebTestWinVinayaAcadamyBase;
import org.wv.auto.framework.BrowserFactory;
import org.wv.auto.framework.utils.Reporter;
import org.wv.auto.framework.utils.TimeManager;

public class WebTestUserLoadingTime extends WebTestWinVinayaAcadamyBase {
	public static int TC=1;
	UserLoadingTimeSteps loadTime;
	public void resultTime() {
		if(Integer.parseInt(TimeManager.getTimeDiffFromPrevEventInSecs())>25) {
			WinVinayaAcadamyWebSteps.result="FAILED";
		}
	}
	public void  searchItem(String courseName) {
		loadTime.searchItem(courseName);
		if(TC>3){
			if(TC<10) {
				Reporter.writeSummary("0"+String.valueOf(TC++)+","+loadTime.getResult(),"NEXT COURSE - Verify the "+courseName+" loading time");
			}
			else {
				Reporter.writeSummary(String.valueOf(TC++)+","+loadTime.getResult(),"NEXT COURSE - Verify the "+courseName+" loading time ");
			}
		}
		else {
			if(TC<10) 
				Reporter.writeSummary("0"+String.valueOf(TC++)+","+loadTime.getResult(),"Verify the "+courseName+" loading time ");
			else
				Reporter.writeSummary(String.valueOf(TC++)+","+loadTime.getResult(),"Verify the "+courseName+" loading time ");
		}
	}
	public void ilearn() {
		loadTime.clickiLearnItem();
		loadTime.goBack();
		resultTime();
		if(TC<10)
			Reporter.writeSummary("0"+String.valueOf(TC++)+","+loadTime.getResult(),"Verify the sub topic - iLearning page loading time");
		else
			Reporter.writeSummary(String.valueOf(TC++)+","+loadTime.getResult(),"Verify the sub topic - iLearning page loading time");
	}
	public void iPratices() {
		loadTime.clickiPreteiceItem();
		loadTime.goBack();
				resultTime();
		if(TC<10)
			Reporter.writeSummary("0"+String.valueOf(TC++)+","+loadTime.getResult(),"Verify the sub topic - iPractice page loading time");
		else
			Reporter.writeSummary(String.valueOf(TC++)+","+loadTime.getResult(),"Verify the sub topic - iPractice page loading time");
	}
	public void iAccess() {
		loadTime.clickiAccessItem();
		loadTime.goBack();
		resultTime();
		if(TC<10)
			Reporter.writeSummary("0"+String.valueOf(TC++)+","+loadTime.getResult(),"Verify the sub topic - iAccess page loading time");
		else
			Reporter.writeSummary(String.valueOf(TC++)+","+loadTime.getResult(),"Verify the sub topic- iAccess page loading time");
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
		if(Integer.parseInt(TimeManager.getTimeDiffFromPrevEventInSecs())>30) {
			WinVinayaAcadamyWebSteps.result="FAILED";
		}
		loadTime=new UserLoadingTimeSteps(driver);
		Reporter.writeSummary("0"+String.valueOf(TC++)+","+loadTime.getResult(),"Verify the user login loading time");
		loadTime.checkHomeIsExisted();
		Reporter.writeSummary("0"+String.valueOf(TC++)+","+loadTime.getResult(),"Verify the clicking action of home button and the loading time of Home page");
		//		searchItem("WinVinaya – Complete MySQL Developer Course in ISL");
		//		courseLoadingTimeiLearn();
		//		loadTime.goBack();
		//		searchItem("Winvinaya Soft Skills - ISL");	
		//		courseLoadingTimeiLearn();
		//		loadTime.goBack();
		//		searchItem("WinVinaya – Learn HTML5 and CSS3 Basics - ISL");
		//		courseLoadingTimeiLearn();
		//		loadTime.goBack();
		searchItem("WinVinaya- Banking ISL");
		courseLoadingTimeiAccess();
		loadTime.goBack();
		searchItem("WinVinaya - English ISL V2.0 Course");
		courseLoadingTimeiAccess();
		loadTime.goBack();
		searchItem("WinVinaya-MS-Excel ISL");
		courseLoadingTimeiAccess();
		loadTime.goBack();
		searchItem("WinVinaya - English - ISL Course");
		courseLoadingTimeiAccess();
		loadTime.goBack();
	}
}