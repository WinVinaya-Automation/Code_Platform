package org.winvinaya.academy.testauto.test.testsuites;

import java.io.IOException;

import org.testng.annotations.Test;
import org.winvinaya.academy.testauto.AcadamyWebBasePage;
import org.winvinaya.academy.testauto.DataManager;
import org.winvinaya.academy.testauto.steps.SessionCreationToTeamSteps;
import org.winvinaya.academy.testauto.test.WebTestAcadamyBase;
import org.wv.auto.framework.BrowserFactory;
import org.wv.auto.framework.utils.Reporter;

public class WebTestSessionCreationToTeam extends WebTestAcadamyBase {
	public static int TC=1;
	public int NumberOfCourse=2; //Before start the execution, Depends on excel sheet.
	@Test(dataProviderClass=DataManager.class, dataProvider = "browsers", groups= {"pilot"}, enabled= true, 
			description="")
	public void AcdemyLoginTest(String row, String strBrowserName) throws IOException  {
		driver = BrowserFactory.getBrowser(strBrowserName);
		TrainerLogin(driver);
		SessionCreationToTeamSteps creation=new SessionCreationToTeamSteps(driver);
		for(int i=1;i<=NumberOfCourse; i++) {
			AcadamyWebBasePage.ReadExcelCellData(i);
			if(AcadamyWebBasePage.courseName!=null) {
				creation.commonmtd();
				Reporter.writeSummary(TC++ +","+AcadamyWebBasePage.courseName+" , " +AcadamyWebBasePage.teamName+" ,"+AcadamyWebBasePage.sEndDate+" ,"+  creation.getResult());
			print("_______________________________________NEXT_COURSE/ENDED_____________________________________________________");
			}
			else {
				break;
			}
		}
	}
}