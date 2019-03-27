package com.dreamorbit.SMC3_Rater.testutils;

import java.io.File;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ExceptionalHandlingFunctions {
	public static String CurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
		Date date = new Date();
		return dateFormat.format(date).toString();
	}

	public static void captureScreenShot(WebDriver driver, String screenshotName) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			FileHandler.copy(src, new File("./Screenshot/" + screenshotName + "_" + CurrentDate() + ".png"));

		} catch (Exception e) {

			System.out.println("Exception while taking screen shot " + e.getMessage());
		}
	}

	public static void writeTOLog(String string, String TestcaseName) throws Exception {
		String FilePathAndName = String.format("./Log/" + TestcaseName + "_" + CurrentDate() + ".txt");
		FileWriter fw = new FileWriter(FilePathAndName);
		fw.write(string.toString());
		fw.close();
	}

}
