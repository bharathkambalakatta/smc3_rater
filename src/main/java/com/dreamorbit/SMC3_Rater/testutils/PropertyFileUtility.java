package com.dreamorbit.SMC3_Rater.testutils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {

	File file;
	FileInputStream fileInput;
	Properties prop;

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

	public String getValue(String value) {
		return prop.getProperty(value);
	}

	public void PropertyFileWriteUtility(String PropertiesPath, String Key,
			String Value) {
		try {
			Properties properties = new Properties();
			properties.setProperty(Key, Value);

			File file = new File(PropertiesPath);
			FileOutputStream fileOut = new FileOutputStream(file);
			properties.store(fileOut, null);
			fileOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
