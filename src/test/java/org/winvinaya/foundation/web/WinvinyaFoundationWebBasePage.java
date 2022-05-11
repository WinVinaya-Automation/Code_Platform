package org.winvinaya.foundation.web;

import org.openqa.selenium.WebDriver;

import org.wv.auto.framework.BasePage;


public abstract class WinvinyaFoundationWebBasePage extends BasePage {
	
	public WinvinyaFoundationWebBasePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getLabel(String str) {
		String propKey = pageName + "_" + str;
		String lblValue = WinvinyaFoundationWebPageUtils.getPageLabel(propKey);
		return lblValue;
	}
}