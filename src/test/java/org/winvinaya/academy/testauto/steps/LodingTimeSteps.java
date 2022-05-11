package org.winvinaya.academy.testauto.steps;

import org.openqa.selenium.WebDriver;
import org.winvinaya.academy.testauto.WinVinayaAcadamyWebSteps;
import org.winvinaya.academy.testauto.pages.LoadingTimePage;

public class LodingTimeSteps extends WinVinayaAcadamyWebSteps {
	LoadingTimePage  page=null;

	public LodingTimeSteps(WebDriver driver) {
		page=new LoadingTimePage(driver);
	}

	public void checkHomeIsExisted() {
		try{result="FAILED";
		page.checkHomeIsExisted();
		result="PASSED";
		}catch(Exception e) {
			print("Dashboard page is yet to opened!");
			result="FAILED";
		}
	}

	public void searchItem(String CourseName) {
		try{result="FAILED";
		page.searchItem(CourseName);
		result="PASSED";
		}catch(Exception e) {
			print("search a course is issue");
			result="FAILED";
		}
	}

	public void openTopic() {
		try{result="FAILED";
		page.openTopic();
		result="PASSED";
		}catch(Exception e) {
			print("open topic is issue");
			result="FAILED";
		}
	}
	
	public void iLearn() {
		try{result="FAILED";
		page.iLearn();
		result="PASSED";
		}catch(Exception e) {
			print("open iLearn is issue");
			result="FAILED";
		}
	}
	
	public void goBack() {
		try{result="FAILED";
		page.goBack();
		result="PASSED";
		}catch(Exception e) {
			print("Gobaak is issue");
			result="FAILED";
		}
	}
	
	public void iPratice() {
		try{result="FAILED";
		page.iPratice();
		result="PASSED";
		}catch(Exception e) {
			print("open iPratice is issue");
			result="FAILED";
		}
	}
}
