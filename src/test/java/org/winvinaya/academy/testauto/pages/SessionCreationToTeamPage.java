package org.winvinaya.academy.testauto.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.winvinaya.academy.testauto.AcadamyWebBasePage;

public class SessionCreationToTeamPage extends AcadamyWebBasePage{
	public By searchCourse=By.xpath("//input[@id='searchCourse']");
	public By lblScheduleSession=By.xpath("//*[@id='schedule-session-a']");
	public By lblModule=By.xpath("//*[@class='form-group']//*[text()='Module']");
	public By inputAreaModle=By.xpath("(//*[@class='CaptionCont SelectBox search'])[1]");
	public By lblSelectAllModule=By.xpath("(//*[@class='optWrapper selall multiple']//p[1])[1]");
	public By lblSession=By.xpath("//*[@class='form-group']//*[text()='Session']");
	public By inputAreaSession=By.xpath("(//*[@class='CaptionCont SelectBox search'])[2]");
	public By lblSelectAllSession=By.xpath("((//*[@class='optWrapper selall multiple'])[2]//p[1])[1]");
	public By lblTeam=By.xpath("//*[@class='form-group']//*[text()='Team']");
	public By inputAreaTeam=By.xpath("(//*[@class='CaptionCont SelectBox search'])[3]");
	public By topicTeam=By.xpath("//table[@id='moduleSessionTeamTimingTable']//thead//tr//th[3]//input");
	public By btnSchudleSession=By.xpath("//*[@onclick='showBulkSessionSchedulingCmModal()']");
	public By endDate=By.xpath("//input[@name='endDate']");
	public By btnSaveSchedule=By.xpath("//*[@id='saveScheduleButton']");
	public By lbltitleHome=By.xpath("//a[@id='cm-home']");
	public By popupLodingBlock =By.xpath("//*[@id='cmClockProcessing'][contains(@style,'display: block')]//*[@class='modal-body']");
	Actions act = new Actions(driver);
	long time; long endTime;
	public boolean loop=false;
	LoginPage login=null; 
	public boolean move;
	public SessionCreationToTeamPage(WebDriver driver) {
		super(driver);
		login=new LoginPage(driver);
	}

	public boolean loading() {
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if(elementExist(popupLodingBlock)) {
			print("Loading block is Exist");
			return true;
		}
		else {
			print("Loding block is NOT Exist");
			return false;
		}
	}

	public boolean searchItem() {
		try{ move=false;
		time= System.currentTimeMillis();
		endTime = time+60000;
		while(loading()==true) {
			print("Data collection process is/are Loading...");
			if(System.currentTimeMillis()>endTime) {
				print("Loading time takes more time");
				loop=true;
				break;
			}
		}
		if(loop==false) {
			clear(searchCourse);
			enterData(courseName,searchCourse); 
			driver.findElement(searchCourse).sendKeys(Keys.RETURN);
			By courseXpath=By.xpath("//*[@class='post-title'][contains(text(),'"+courseName+"')]");
			if(elementExist(courseXpath)) {
				moveElementFocusandClick(courseXpath);
			}else {
				return false;
			}
			move=true;
			return true;
		}
		}catch(Exception e) {
			print("searchItem method is failed");
			return false;
		}
		return false;
	}

	public boolean clickOnlblScheduleSession() {
		try{ wait(5); move=false;
		time= System.currentTimeMillis();
		endTime = time+60000;
		while(loading()==true) {
			print("Data collection process is/are Loading...");
			if(System.currentTimeMillis()>endTime) {
				print("Loading time takes more time");
				loop=true;
				break;
			}
		}
		if(loop==false) {
			click(lblScheduleSession);
			move=true;
			return true;
		}
		}catch(Exception e) {
			print("clickOnlblScheduleSession method is failed");
			return false;
		}
		return false;
	}

	public boolean selectModuleOptions() {
		try{ move=false;
		time= System.currentTimeMillis();
		endTime = time+60000;
		while(loading()==true) {
			print("Data collection process is/are Loading...");
			if(System.currentTimeMillis()>endTime) {
				print("Loading time takes more time");
				loop=true;
				break;
			}
		}
		if(loop==false) {
			moveElementFocusandClick(inputAreaModle);
			moveElementFocusandClick(lblSelectAllModule);	
			act.sendKeys(Keys.TAB).build().perform();
			move=true;
			return true;
		}
		}catch(Exception e) {
			print("selectModuleOptions method is failed");
			return false;
		}
		return false;
	}

	public boolean selectSessionOptions() {
		try{move=false;
		time= System.currentTimeMillis();
		endTime = time+60000;
		while(loading()==true) {
			print("Data collection process is/are Loading...");
			if(System.currentTimeMillis()>endTime) {
				print("Loading time takes more time");
				loop=true;
				break;
			}}
		if(loop==false) {
			moveElementFocusandClick(inputAreaSession);
			moveElementFocusandClick(lblSelectAllSession);
			act.sendKeys(Keys.TAB).build().perform();
			move=true;
			return true;
		}
		}catch(Exception e) {
			print("selectSessionOptions method is failed");
			return false;
		}
		return false;
	}

	public boolean selectTeamOptions() {
		try{move=false;
		time= System.currentTimeMillis();
		endTime = time+60000;
		while(loading()==true) {
			print("Data collection process is/are Loading...");
			if(System.currentTimeMillis()>endTime) {
				print("Loading time takes more time");
				loop=true;
				break;
			}
		}
		if(loop==false) {
			moveElementFocusandClick(inputAreaTeam);
			By selectTeam = By.xpath("//li//*[text()='"+teamName+"']"); 
			moveElementFocusandClick(selectTeam);
			act.sendKeys(Keys.TAB).build().perform();
			move=true;
			return true;
		}
		}catch(Exception e) {
			print("selectTeamOptions method is failed");
			return false;
		}
		return false;
	}

	public boolean selectTopic() {
		try{move=false;
		time= System.currentTimeMillis();
		endTime = time+60000;
		while(loading()==true) {
			print("Data collection process is/are Loading...");
			if(System.currentTimeMillis()>endTime) {
				print("Loading time takes more time");
				loop=true;
				break;
			}
		}if(loop==false) {
			moveElementFocusandClick(topicTeam);
			move=true;
			return true;
		}
		}catch(Exception e) {
			print("selectTopic method is failed");
			return false;
		}
		return false;
	}

	public boolean clickSchudleSessionBtn() {
		try{move=false;
		time= System.currentTimeMillis();
		endTime = time+60000;
		while(loading()==true) {
			print("Data collection process is/are Loading...");
			if(System.currentTimeMillis()>endTime) {
				print("Loading time takes more time");
				loop=true;
				break;
			}
		}if(loop==false) {
			moveElementFocusandClick(btnSchudleSession);	
			move=true;
			return true;
		}
		}catch(Exception e) {
			print("clickSchudleSessionBtn method is failed");
			return false;

		}
		return false;
	}

	public boolean enterSessionEndDate() {
		try{move=false;
		if(loop==false) {
			moveElementFocusandClick(endDate);
			clear(endDate);
			enterData(sEndDate,endDate);
			act.sendKeys(Keys.TAB).build().perform();
			return true;
		}
		}catch(Exception e) {
			print("enterSessionEndDate method is failed");
			login.goToURL(); 
			return false;
		}
		return false;
	} 

	public boolean clickSaveBtn() {
		try{move=false;
		if(loop==false) {
			moveElementFocusandClick(btnSaveSchedule);
			move=true;
			return true;
		}
		}catch(Exception e) {
			print("clickSaveBtn method is failed");
			login.goToURL();
			return false;
		}
		return false;
	}
	public boolean clickHome() {
		try {move=false;
		time= System.currentTimeMillis();
		endTime = time+60000;
		while(loading()==true) {
			print("Data collection process is/are Loading...");
			if(System.currentTimeMillis()>endTime) {
				print("Loading time takes more time");
				loop=true;
				break;
			}
		}if(loop==false) {
			click(lbltitleHome);
			move=true;
			return true;
		}}
		catch(Exception e) {
			print("clickHome method is failed");
			login.goToURL(); 
			return false;
		}
		return false;
	}
}