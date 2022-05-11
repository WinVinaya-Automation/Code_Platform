package org.winvinaya.infosystems.web.steps;

import org.openqa.selenium.WebDriver;
import org.winvinaya.infosystems.web.WinvinyaInfosystemsWebBaseStep;
import org.winvinaya.infosystems.web.pages.InfosystemsWebPage;

public class InfosystemsWebSteps extends WinvinyaInfosystemsWebBaseStep {
	InfosystemsWebPage  page=null;
	public static boolean check=false;
	public InfosystemsWebSteps(WebDriver driver) {
		page=new InfosystemsWebPage(driver);
	}

	public void openInfosystemURL() {
		result="FAILED";
		try {
			page.openInfosystemURL();
			result="PASSED";
		}catch(Exception e) {
			print("Home page is yet to open!");
			result="FAILED";
		}
	}
	public void checklblManuProduct() {
		try{result="FAILED";
		if(page.checklblManuProduct()==true) {
			result="PASSED";
		}
		}catch(Exception e) {
			print("Product page is yet to open!");
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
	public void checklblManuAboutUs() {
		try{result="FAILED";
		if(page.checklblManuAboutUs()==true) {
			result="PASSED";
		}
		}catch(Exception e) {
			print("About us page is yet to open!");
			result="FAILED";
		}
	}
	public void checklblManuContact() {
		try{result="FAILED";
		if(page.checklblManuContact()==true) {
			result="PASSED";
		}
		}catch(Exception e) {
			print("Contact page is yet to open!");
			result="FAILED";
		}
	}
	}