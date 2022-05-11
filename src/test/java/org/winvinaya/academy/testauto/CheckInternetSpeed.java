package org.winvinaya.academy.testauto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckInternetSpeed extends WinVinayaAcadamyWebBasePage  {
	public By lblSpeed=By.xpath("//div[@id='speed-value']");
	public static String getSpeed;
	public CheckInternetSpeed(WebDriver driver) {
		super(driver);
		pageName="academy";
	}
	
 public void checkspeed() {
	 goTo(getLabel("checkspeed"));
	 wait(10);
	 getSpeed=getText(lblSpeed);
 }
}
