package org.winvinaya.academy.testauto.steps;

import org.openqa.selenium.WebDriver;
import org.winvinaya.academy.testauto.WinVinayaAcadamyWebSteps;
import org.winvinaya.academy.testauto.pages.UserLoadingTimePages;
import org.wv.auto.framework.utils.TimeManager;

public class UserLoadingTimeSteps extends WinVinayaAcadamyWebSteps {
	UserLoadingTimePages  page=null;
	public static boolean check=false;
	public UserLoadingTimeSteps(WebDriver driver) {
		page=new UserLoadingTimePages(driver);
	}
	public void ResultTime() {
		if(Integer.parseInt(TimeManager.getTimeDiffFromPrevEventInSecs())>25) {
			result="FAILED";
		}
	}
	public void checkHomeIsExisted() {
		try{result="FAILED";
		if(page.checkHomeIsExisted()==true) {
			result="PASSED";
			ResultTime();
		}
		}catch(Exception e) {
			print("Dashboard page is yet to opened!");
			result="FAILED";
		}
	}
	public void searchItem(String CourseName) {
		try{result="FAILED";
		if(page.searchItem(CourseName)==true) {
			result="PASSED";
			check=true;
			ResultTime();
		}
		}catch(Exception e) {
			print("search a course is issue");
			result="FAILED";
		}
	}

	public void goBack() {
		try{
			page.goBack();
		}catch(Exception e) {
			print("Goback is issue");
		}
	}

	public void clickiLearnItem() {
		result="FAILED";
		try{
			if(check==true){
				page.clickiLearnItem();
				result="PASSED";
				ResultTime();
			}
		}catch(Exception e) {
			print("open iLearn is issue");
			result="FAILED";
		}
	}

	public void clickiPreteiceItem() {
		result="FAILED";
		try{
			if(check==true){
				page.clickiPreteiceItem();
				result="PASSED";
				ResultTime();
			}
		}catch(Exception e) {
			print("open iPratice is issue");
			result="FAILED";
		}
	}

	public void clickiAccessItem() {
		result="FAILED";
		try{
			if(check==true){
				page.clickiAccessItem();
				result="PASSED";
				ResultTime();
			}
		}catch(Exception e) {
			print("open iAccess is issue");
			result="FAILED";
		}
	}
}