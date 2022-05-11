package org.winvinaya.academy.testauto;

import org.openqa.selenium.WebDriver;

import org.wv.auto.framework.BasePage;


public abstract class WinVinayaAcadamyWebBasePage extends BasePage {
	
	public WinVinayaAcadamyWebBasePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getLabel(String str) {
		String propKey = pageName + "_" + str;
		String lblValue = WinVinayaAcadamyWebUtils.getPageLabel(propKey);
		return lblValue;
	}
}