package org.winvinaya.academy.testauto;

import org.openqa.selenium.WebDriver;

import org.wv.auto.framework.BasePage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public abstract class AcadamyWebBasePage extends BasePage {
	public static String courseName;
	public static String teamName;
	public static Sheet sheet;
	public static Row row;
	public static String sEndDate;
	static Workbook wb=null; 	static DateFormat df;
	public AcadamyWebBasePage(WebDriver driver) {
		this.driver = driver;
	}

	public String getLabel(String str) {
		String propKey = pageName + "_" + str;
		String lblValue = WinVinayaAcadamyWebUtils.getPageLabel(propKey);
		return lblValue;
	}

	public static void ReadExcelCellData(int i)  
	{  
		try	{  
			FileInputStream fis=new FileInputStream("SessionCreation.xlsx");  
			wb=new XSSFWorkbook(fis); 
			sheet=wb.getSheet("SESSION_CREATION");
			Row row=sheet.getRow(i);
			courseName=row.getCell(0).getStringCellValue();
			System.out.println("Collected CourseName = "+courseName);
			teamName=row.getCell(1).getStringCellValue();
			System.out.println("Collected TeamName = "+teamName);
			df = new SimpleDateFormat("dd-MM-YYYY");
			Date date = row.getCell(2).getDateCellValue();
			sEndDate = df.format(date);
			System.out.println("Collected session enddate = "+sEndDate);
		}  
		catch(Exception e){  
			e.printStackTrace();  
		}  
	}  
}