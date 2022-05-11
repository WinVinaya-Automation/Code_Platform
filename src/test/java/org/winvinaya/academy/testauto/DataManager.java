package org.winvinaya.academy.testauto;

import org.testng.annotations.DataProvider;

import org.wv.auto.framework.BrowserFactory;

public class DataManager extends BrowserFactory{

	@DataProvider
	public static Object[][] browsers() {
		if(getOS().equalsIgnoreCase("win")) {
			return new Object[][] {
//				new Object[] { "1", "msedge" }, 
				new Object[] { "2", "Chrome" },
//				new Object[] { "3", "Firefox" }
			};
		}
		
		if(getOS().equalsIgnoreCase("mac")) {
			return new Object[][] {
					new Object[] { "1", "safari" }
				};
		}
		return null;
		/*return new Object[][] {
//			new Object[] { "1", "msedge" }, 
		new Object[] { "2", "Chrome" },
		//	new Object[] { "3", "safari" }
			new Object[] { "4", "Firefox" }

		};*/
	}
	
}


