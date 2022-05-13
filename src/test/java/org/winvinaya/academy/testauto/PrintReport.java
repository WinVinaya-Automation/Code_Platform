package org.winvinaya.academy.testauto;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


import com.opencsv.CSVReader;

public class PrintReport  {
	static ArrayList<String> values = new ArrayList<String>();
	public void printReport() throws IOException  {

		{  
			CSVReader reader = null;  
			try  
			{  
				//parsing a CSV file into CSVReader class constructor  
				reader = new CSVReader(new FileReader("target/TestReport.csv"));  
				String [] nextLine;  
				//reads one line at a time  
				while ((nextLine = reader.readNext()) != null)  
				{  
					for(String token : nextLine)  
					{  
						values.add(token+"  ");
					}  
					values.add("\n");
				}  
			}  
			catch (Exception e)   
			{  
				e.printStackTrace();  
			}  
		}  
	}  
}