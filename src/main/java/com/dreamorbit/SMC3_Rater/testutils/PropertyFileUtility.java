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

	/**
	 * Method to write data into a property file 
	 * @author nutan.p
	 *
	 */
	
		public void addData(String key, String val) 
		{
			try {
			 File file = new File("./Properties/"+"/BidNameFile.properties");  
			 Properties props = new Properties();
			 props.load(new FileInputStream(file));
			FileOutputStream obj = new FileOutputStream(file);
			 props.setProperty(key, val);
			props.store(obj, "Update data into file ");
		}
			 catch (IOException ex) {
		         ex.printStackTrace();
		}
		}


	public String getValue(String value) {
		return prop.getProperty(value);
	}
}
