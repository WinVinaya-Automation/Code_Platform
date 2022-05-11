package org.wv.auto.framework.utils;

import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;

public class CSVManager {
	public static CSVWriter getCSVWriter(String filePath) {
//		String csv = "data.csv";
		CSVWriter writer=null;
		try {
			writer = new CSVWriter(new FileWriter(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return writer;
	}





}
