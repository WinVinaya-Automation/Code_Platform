package org.winvinaya.academy.testauto.test.testsuites;

import java.io.IOException;

import org.testng.annotations.Test;
import org.winvinaya.academy.testauto.DataManager;
import org.winvinaya.academy.testauto.steps.LodingTimeSteps;
import org.winvinaya.academy.testauto.test.WebTestWinVinayaAcadamyBase;
import org.wv.auto.framework.BrowserFactory;
import org.wv.auto.framework.utils.Reporter;

public class WebTestLodingTime extends WebTestWinVinayaAcadamyBase {
	static int TC=000;
	LodingTimeSteps loadTime=new LodingTimeSteps(driver);
	public void course(String courseName) {
		loadTime.searchItem(courseName);
		Reporter.writeSummary(TC++ +",Verify the "+courseName+" opening loading time, " +  loadTime.getResult());
		loadTime.openTopic();
		Reporter.writeSummary(TC+++",Verify the topic opening loading time, " +  loadTime.getResult());
		//		loadTime.iLearn();
		//		Reporter.writeSummary(TC+++",Verify the sub topic opening in iLearning loading time, " +  loadTime.getResult());
		//		loadTime.goBack();
		//		loadTime.openTopic();
		loadTime.iPratice();
		Reporter.writeSummary(TC+++",Verify the sub topic opening in iPractce loading time, " +  loadTime.getResult());
		loadTime.goBack();
		loadTime.goBack();
	}
	public void iLearn() {
		loadTime.iLearn();
		Reporter.writeSummary(TC+++",Verify the sub topic opening in iLearning loading time, " +  loadTime.getResult());
		loadTime.goBack();

	}
	public void iPratice() {

	}

	@Test(dataProviderClass=DataManager.class, dataProvider = "browsers", groups= {"pilot"}, enabled= true, 
			description="")
	public void AcdemyLoginTest(String row, String strBrowserName) throws IOException  {
		driver = BrowserFactory.getBrowser(strBrowserName);
		UserLogin(driver);
		LodingTimeSteps loadTime=new LodingTimeSteps(driver);
		Reporter.writeSummary(TC+++",Verify the user login loading time, " +  loadTime.getResult());
		loadTime.checkHomeIsExisted();
		Reporter.writeSummary(TC+++",Verify the home button loading time, " +  loadTime.getResult());
		//		loadTime.searchItem("WinVinaya - English ISL V2.0 Course");
		//		Reporter.writeSummary("TC-003,Verify the WinVinaya - English ISL V2.0 Course opening loading time, " +  loadTime.getResult());
		//		loadTime.openTopic();
		//		Reporter.writeSummary("TC-004,Verify the topic opening loading time, " +  loadTime.getResult());
		//		loadTime.iLearn();
		//		Reporter.writeSummary("TC-005,Verify the sub topic opening in iLearning loading time, " +  loadTime.getResult());
		//		loadTime.goBack();
		//		loadTime.openTopic();
		//		loadTime.iPratice();
		//		Reporter.writeSummary("TC-006,Verify the sub topic opening in iPractce loading time, " +  loadTime.getResult());
		//		loadTime.goBack();
		//		loadTime.goBack();
		//		loadTime.searchItem("Winvinaya - Java Programming in ISL");
		//		Reporter.writeSummary("TC-007,Verify the WinVinaya - Java Programming in ISL opening loading time, " +  loadTime.getResult());
		//		loadTime.openTopic();
		//		Reporter.writeSummary("TC-008,Verify the topic opening loading time, " +  loadTime.getResult());
		//		loadTime.iLearn();
		//		Reporter.writeSummary("TC-009,Verify the sub topic opening in iLearning loading time, " +  loadTime.getResult());
		//		loadTime.goBack();
		//		loadTime.openTopic();
		//		loadTime.iPratice();
		//		Reporter.writeSummary("TC-010,Verify the sub topic opening in iPractce loading time, " +  loadTime.getResult());
		//		loadTime.goBack();
		//		loadTime.goBack();

				course("WinVinaya - English ISL V2.0 Course");
				course("Winvinaya - Java Programming in ISL");
				course("WinVinaya – Learn HTML5 and CSS3 Basics - ISL");
//		course("Winvinaya- MS- Excel ISL");
		//		course("")

	}
}