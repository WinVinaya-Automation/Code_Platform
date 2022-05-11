package org.winvinaya.academy.testauto.steps;

import org.openqa.selenium.WebDriver;
import org.winvinaya.academy.testauto.WinVinayaAcadamyWebSteps;
import org.winvinaya.academy.testauto.pages.JavaCoursePage;

public class JavaCourseSteps extends WinVinayaAcadamyWebSteps {
	JavaCoursePage page=null;	
	public JavaCourseSteps(WebDriver driver) {
		page=new JavaCoursePage(driver);
	}

	//Weather checking the course is working or not
	public void checkJavaLHSCourse(){
		try{result="FAILED";
		if(page.checkJavaLHSCourse()==true) {
			result="PASSED";
		}
		}catch(Exception e) {
			print("The checkJavaLHSCourse function is NOT working");
			result="FAILED";
		}
	}

	//Added on 29-Jan-22
	public void checkHomeIsExisted() {
		try{result="FAILED";
		page.checkHomeIsExisted();
		result="PASSED";
		}catch(Exception e) {
			print("Dashboard page is yet to opened!");
			result="FAILED";
		}
	}

	public void searchItem() {
		try {result="FAILED";
		page.searchItem("[title='WinVinaya – Learn HTML5 and CSS3 Basics - ISL']");
		result="PASSED";
		}catch(Exception e) {
			print("course is Not opened!");
			result="FAILED";
		}
	}
}
