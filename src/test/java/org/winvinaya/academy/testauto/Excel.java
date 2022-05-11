package org.winvinaya.academy.testauto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel {
	public static void main(String args[]) throws IOException  {
		try  
		{  
			DateFormat df; String endDate;
			File file = new File("SAMPLE.xlsx");   
			FileInputStream fis = new FileInputStream(file);  
			XSSFWorkbook wb = new XSSFWorkbook(fis);   
			XSSFSheet sheet = wb.getSheet("SESSION_CREATION");
			Iterator<Row> itr = sheet.iterator();    
			while (itr.hasNext())                 
			{  
				Row row = itr.next();  
				Iterator<Cell> cellIterator = row.cellIterator();   
				while (cellIterator.hasNext())   
				{  
					Cell cell = cellIterator.next(); 
					if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						df = new SimpleDateFormat("dd-MM-YYYY");
						Date date = cell.getDateCellValue();
						endDate = df.format(date);
						System.out.print(endDate + " ");
					}
					else if(cell.getCellType() == Cell.CELL_TYPE_STRING) {
						System.out.print(cell.getStringCellValue() + " ");
					}
				}  
				System.out.println("");  
			}  
		}  
		catch(Exception e)  
		{  
			e.printStackTrace();  
		}  
		//		String line = "";  
		//		String splitBy = ",";  
		//		try   
		//		{  
		//			//parsing a CSV file into BufferedReader class constructor  
		//			BufferedReader br = new BufferedReader(new FileReader("SAMPLE.csv"));  
		//			while ((line = br.readLine()) != null)   //returns a Boolean value  
		//			{  
		//				String[] employee = line.split(splitBy);    // use comma as separator  
		//				System.out.println("Employee [First Name=" + employee[1] + "]");  
		//			}  
		//		}   
		//		catch (IOException e)   
		//		{  
		//			e.printStackTrace();  
		//		}  
	}  
}   