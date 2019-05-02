package com.dreamorbit.SMC3_Rater.testutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {

	File file;
	Properties prop;
	FileInputStream fileInput;
	FileOutputStream fileOutput;

	public PropertyFileUtility(String PropertiesPath) {
		file = new File(PropertiesPath);
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.getMessage();
		}
		prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

	}

	public void addDataToTheFile(String key, String value) {
		try {
			fileOutput = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prop.setProperty(key, value);
		try {
			prop.store(fileOutput, "Data added to the file");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getValue(String value) {
		return prop.getProperty(value);
	}
}
