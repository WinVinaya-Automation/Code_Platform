package org.winvinaya.foundation.web.steps;

import org.openqa.selenium.WebDriver;
import org.winvinaya.foundation.web.WinvinyaFoundationWebBaseStep;
import org.winvinaya.foundation.web.pages.FoundationWebPage;

public class FoundationWebSteps extends WinvinyaFoundationWebBaseStep {
	FoundationWebPage  page=null;
	public static boolean check=false;
	public FoundationWebSteps(WebDriver driver) {
		page=new FoundationWebPage(driver);
	}

	public void openURL() {
		result="FAILED";
		try {
			page.openFoundationURL();
			result="PASSED";
		}catch(Exception e) {
			print("Home page is yet to open!");
			result="FAILED";
		}
	}
	public void checkCareerPage() {
		try{result="FAILED";
		if(page.checklblManuCareer()==true) {
			result="PASSED";
		}
		}catch(Exception e) {
			print("carrer page is yet to open!");
			result="FAILED";
		}
	}
	public void checklblManuBlog() {
		try{result="FAILED";
		if(page.checklblManuBlog()==true) {
			result="PASSED";
		}
		}catch(Exception e) {
			print("Blog page is yet to open!");
			result="FAILED";
		}
	}
	public void checklblManuUtsav() {
		try{result="FAILED";
		if(page.checklblManuUtsav()==true) {
			result="PASSED";
		}
		}catch(Exception e) {
			print("Utsav page is yet to open!");
			result="FAILED";
		}
	}
	public void checklblManuContactUs() {
		try{result="FAILED";
		if(page.checklblManuContactUs()==true) {
			result="PASSED";
		}
		}catch(Exception e) {
			print("Contact us page is yet to open!");
			result="FAILED";
		}
	}
	public void checklblManuDonate() {
		try{result="FAILED";
		if(page.checklblManuDonate()==true) {
			result="PASSED";
		}
		}catch(Exception e) {
			print("Donate page is yet to open!");
			result="FAILED";
		}
	}
}