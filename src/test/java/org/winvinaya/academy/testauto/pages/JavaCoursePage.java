package org.winvinaya.academy.testauto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.winvinaya.academy.testauto.WinVinayaAcadamyWebBasePage;

public class JavaCoursePage extends WinVinayaAcadamyWebBasePage {
	public By searchTab=By.xpath("//input[@id='inputSearch']");
	public By javaLHScourseName=By.xpath("//h5[@title='Winvinaya - Java Programming in ISL']"); //for that course
	public By topicDisplay=By.xpath("//span[text()='Introduction to Java']");//sample text
	//added on 29-Jan-22
	public By homeLogo=By.xpath("(//a)[1]");
	public JavaCoursePage(WebDriver driver) {
		super(driver);   
	}

	//Weather checking the course is working or not
	public boolean checkJavaLHSCourse(){
		wait(5);
		//click(searchTab);
		enterData("java",searchTab);
		wait(2);
		if(elementExist(javaLHScourseName)) {
			click(javaLHScourseName);
			wait(5);
		}
		return isDisplayed(topicDisplay);
	}
	/* Added a code started on 29-Jan-22
	 * 
	 */
	public void checkHomeIsExisted() {
		while(elementExist(homeLogo)) {
			click(homeLogo);
			break;
		}
	}
	/*created for common courses
	 * checking waiting time
	 */
	public void searchItem(String courseName) {
		enterData("WinVinaya",searchTab);
		driver.findElement(searchTab).sendKeys(Keys.RETURN);
		By courseXpath=By.cssSelector(courseName);
		moveElementFocus(courseXpath);
		click(courseXpath);
	}

}
