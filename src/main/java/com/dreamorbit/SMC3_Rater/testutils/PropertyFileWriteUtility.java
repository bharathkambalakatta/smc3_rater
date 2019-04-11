package com.dreamorbit.SMC3_Rater.testutils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileWriteUtility {

	Properties prop;
	File file;
	FileOutputStream fileOutput;

	public PropertyFileWriteUtility(String PropertiesPath) {

		file = new File(PropertiesPath);
		try {
			fileOutput = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prop = new Properties();
	}

	public void setValue(String key, String value) {
		prop.setProperty(key, value);
		try {
			prop.store(fileOutput, "test");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fileOutput.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getValue(String value) {
		return prop.getProperty(value);
	}

}
