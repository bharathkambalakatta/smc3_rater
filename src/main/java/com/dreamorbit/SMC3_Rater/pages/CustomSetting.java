package com.dreamorbit.SMC3_Rater.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.dreamorbit.SMC3_Rater.testbase.TestBase;
import com.dreamorbit.SMC3_Rater.testutils.PropertyFileUtility;

public class CustomSetting extends TestBase {

	public static final Logger logger = Logger.getLogger(CustomSetting.class
			.getName());

	PropertyFileUtility propertyValue = new PropertyFileUtility("./Files/"
			+ "/DataFile.properties");

	WebDriver driver;

	public CustomSetting(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}