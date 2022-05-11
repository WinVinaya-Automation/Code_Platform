package org.winvinaya.infosystems.web;

import org.openqa.selenium.WebDriver;

import org.wv.auto.framework.BasePage;


public abstract class WinvinyaInfosystemsWebBasePage extends BasePage {
	
	public WinvinyaInfosystemsWebBasePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getLabel(String str) {
		String propKey = pageName + "_" + str;
		String lblValue = WinvinyaInfosystemsWebPageUtils.getPageLabel(propKey);
		return lblValue;
	}
}