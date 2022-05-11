package org.winvinaya.academy.testauto;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class WinVinayaAcadamyWebUtils {
	private final static String propertyLFile = "target/test-classes/properties/WinVinayaAcademyWeb.properties";
	private static Properties LabelsProperties = new Properties();
	private static String OS = System.getProperty("os.name").toLowerCase();

	private static void loadPageLabelProperties() {
		try {
			//fractalPageLabelsProperties.load(new FileInputStream(new File(propertyLFile).getAbsoluteFile()));
			LabelsProperties.load(new FileInputStream(new File(propertyLFile)));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		assert !LabelsProperties.isEmpty();
	}
	public static String getPageLabel(final String key) {
		if (LabelsProperties.isEmpty())
			loadPageLabelProperties();
		String property = LabelsProperties.getProperty(key);
		return property != null ? property.trim() : property;
	}
	public static boolean isWindows() {
		return (OS.indexOf("win") >= 0);
	}
	public static boolean isMac() {
		return (OS.indexOf("mac") >= 0);
	}
	public static String getCurrentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); 
		return date.toString();
	}
}
