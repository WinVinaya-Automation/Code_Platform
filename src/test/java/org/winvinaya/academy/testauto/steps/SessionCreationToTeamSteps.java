package org.winvinaya.academy.testauto.steps;

import org.openqa.selenium.WebDriver;
import org.winvinaya.academy.testauto.AcadamyWebBasePage;
import org.winvinaya.academy.testauto.AcadamyWebSteps;
import org.winvinaya.academy.testauto.pages.LoginPage;
import org.winvinaya.academy.testauto.pages.SessionCreationToTeamPage;

public class SessionCreationToTeamSteps extends AcadamyWebSteps {
	SessionCreationToTeamPage  page=null;
	AcadamyWebBasePage excel=null;
	LoginPage login=null;
	public SessionCreationToTeamSteps(WebDriver driver) {
		page=new SessionCreationToTeamPage(driver);
		login=new LoginPage(driver);
	}

	public boolean searchItem( ) {
		try{		
			if(page.searchItem()==true && page.loop==false && page.move==true) { 
				result="PASSED";
				return true;
			}
		}catch(Exception e) {
			result="FAILED";
		}
		return false;
	}


	public void clickOnlblScheduleSession() {
		try{
			if(page.clickOnlblScheduleSession()==true && page.loop==false && page.move==true) {  
				result="PASSED";
			}
		}catch(Exception e) {
			result="FAILED";
		}
	}

	public void selectModuleOptions() {
		try{result="FAILED";
		if(page.selectModuleOptions()==true && page.loop==false && page.move==true) { 
			result="PASSED";
		}
		}catch(Exception e) {
			result="FAILED";
		}
	}

	public void selectSessionOptions() {
		try{result="FAILED";
		if(page.selectSessionOptions()==true && page.loop==false && page.move==true) { 
			result="PASSED";
		}
		}catch(Exception e) {
			result="FAILED";
		}
	}

	public void selectTeamOptions() {
		try{result="FAILED";
		if(page.selectTeamOptions()==true && page.loop==false && page.move==true) { 
			result="PASSED";
		}
		}catch(Exception e) {
			result="FAILED";
		}
	}
	public void selectTopic() {
		try{result="FAILED";
		if(page.selectTopic()==true && page.loop==false && page.move==true) { 
			result="PASSED";
		}
		}catch(Exception e) {
			result="FAILED";
		}
	}
	public void clickSchudleSessionBtn() {
		try{result="FAILED";
		if(page.clickSchudleSessionBtn()==true && page.loop==false && page.move==true) { 
			result="PASSED";
		}
		}catch(Exception e) {
			result="FAILED";
		}
	}

	public void enterSessionEndDate() {
		try{result="FAILED";
		if(page.enterSessionEndDate()==true && page.loop==false && page.move==true) {
			result="PASSED";
		}
		}catch(Exception e) {
			result="FAILED";
		}
	}
	public void clickSaveBtn() {
		try{result="FAILED";
		if(page.clickSaveBtn()==true && page.loop==false && page.move==true){
			result="PASSED";
		}
		}catch(Exception e) {
			result="FAILED";
		}
	}
	public void clickHome() {
		try{result="FAILED";
		if(page.clickHome()==true && page.loop==false && page.move==true){
			result="PASSED";
		}
		}catch(Exception e) {
			result="FAILED";
		}
	}
	public void commonmtd() {
		try {
			if(searchItem()==true) {
				clickOnlblScheduleSession();
				selectModuleOptions();
				selectSessionOptions();
				selectTeamOptions();
				selectTopic();
				clickSchudleSessionBtn();
				enterSessionEndDate();
				clickSaveBtn();
				//			clickHome();
				wait(10);
			}
			else {
				result="FAILED";
				print("Course is NOT found.");
			}
			login.goToURL();
		}catch (Exception e) {
			result="FAILED";
			print("common method is failed");
			login.goToURL(); 
		}
	}
}