package com.dreamorbit.SMC3_Rater.TestCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dreamorbit.SMC3_Rater.pages.DefaultSetting;
import com.dreamorbit.SMC3_Rater.pages.LoginPage;
import com.dreamorbit.SMC3_Rater.pages.ManageSettings;
import com.dreamorbit.SMC3_Rater.pages.RateAShipment;
import com.dreamorbit.SMC3_Rater.testbase.TestBase;
import com.dreamorbit.SMC3_Rater.testutils.ExceptionalHandlingFunctions;
import com.dreamorbit.SMC3_Rater.testutils.PropertyFileUtility;

public class DefaultSettingTest extends TestBase {

	public static final Logger logger = Logger
			.getLogger(DefaultSettingTest.class.getName());

	PropertyFileUtility propertyValue = new PropertyFileUtility("./Files/"
			+ "/DataFile.properties");

	LoginPage loginToApplication;
	RateAShipment rateAShipment;
	ManageSettings manageSettings;
	DefaultSetting defaultSetting;

	@Before
	public void setUp() throws IOException {
		initialization();
		loginToApplication = new LoginPage(driver);
		rateAShipment = new RateAShipment(driver);
		manageSettings = new ManageSettings(driver);
		defaultSetting = new DefaultSetting(driver);
	}

	// 1. Create Default Setting Test
	@Test
	public void verifyCreateDefaultSettingTest() throws Exception {
		try {
			logger.info("********** INITIAL MESSAGE :: Create Default Setting Test Execution Started **********");

			loginToApplication.LoginToApplication(
					propertyValue.getValue("loginUserName"),
					propertyValue.getValue("loginPassword"));

			manageSettings.clickingOnManageSettingsTab();

			defaultSetting.clickingOnDefaultSettingOption();
			defaultSetting.makingDefaultDiscountsToggleON();
			defaultSetting.enteringDefaultDiscountsDetails(
					propertyValue.getValue("defaultDiscount1"),
					propertyValue.getValue("defaultMCDiscount1"),
					propertyValue.getValue("defaultMCFloor1"));
			defaultSetting.makingDefaultConstantClassToggleON();
			defaultSetting.enteringDefaultConstantClassDetails(propertyValue
					.getValue("constantClass1"));
			defaultSetting.makingDefaultConstantZIPSToggleON();
			defaultSetting.enteringDefaultConstantZIPSDetails(
					propertyValue.getValue("constantZIPSOriginZIP"),
					propertyValue.getValue("constantZIPSDestinationZIP"));

			rateAShipment.clickingOnRateAShipmentTab();
			rateAShipment.selectRateFamily(propertyValue
					.getValue("rateFamily1"));

			String actual = rateAShipment.verifyDiscountTextBoxValue();
			Assert.assertEquals("RateAShipment - 'discountTextBox' ::",
					propertyValue.getValue("defaultDiscount1"), actual);
			String actual1 = rateAShipment.verifyMCDiscountTextBoxValue();
			Assert.assertEquals("RateAShipment - 'mcDiscountTextBox' ::",
					propertyValue.getValue("defaultMCDiscount1"), actual1);
			String actual2 = rateAShipment.verifyMCFloorTextBoxValue();
			Assert.assertEquals("RateAShipment - 'mcFloorTextBox' ::",
					propertyValue.getValue("defaultMCFloor1"), actual2);
			String actual3 = rateAShipment.verifyClassDropDownValue();
			Assert.assertEquals("RateAShipment - 'classDropDown' ::",
					propertyValue.getValue("constantClass1"), actual3);
			String actual4 = rateAShipment.verifyOriginTextBoxValue();
			Assert.assertEquals("RateAShipment - 'originTextBox' ::",
					propertyValue.getValue("constantZIPSOriginZIP"), actual4);
			String actual5 = rateAShipment.verifyDestinationTextBoxValue();
			Assert.assertEquals("RateAShipment - 'destinationTextBox' ::",
					propertyValue.getValue("constantZIPSDestinationZIP"),
					actual5);

			rateAShipment.loggingOutFromTheApplication();

			loginToApplication.LoginToApplication(
					propertyValue.getValue("loginUserNameCompany2"),
					propertyValue.getValue("loginPasswordCompany2"));

			rateAShipment.selectRateFamily(propertyValue
					.getValue("rateFamily1"));
			rateAShipment.clickingOnSingleDiscountRadioButton();

			String actual6 = rateAShipment.verifyDiscountTextBoxValue();
			Assert.assertNotSame("RateAShipment - 'discountTextBox' ::",
					propertyValue.getValue("defaultDiscount1"), actual6);
			String actual7 = rateAShipment.verifyMCDiscountTextBoxValue();
			Assert.assertNotSame("RateAShipment - 'mcDiscountTextBox' ::",
					propertyValue.getValue("defaultMCDiscount1"), actual7);
			String actual8 = rateAShipment.verifyMCFloorTextBoxValue();
			Assert.assertNotSame("RateAShipment - 'mcFloorTextBox' ::",
					propertyValue.getValue("defaultMCFloor1"), actual8);
			boolean notSame = rateAShipment
					.verifyIfClassDropDownHasAnyValueSelected();
			Assert.assertTrue("RateAShipment - 'classDropDown' ::", notSame);
			String actual10 = rateAShipment.verifyOriginTextBoxValue();
			Assert.assertNotSame("RateAShipment - 'originTextBox' ::",
					propertyValue.getValue("constantZIPSOriginZIP"), actual10);
			String actual11 = rateAShipment.verifyDestinationTextBoxValue();
			Assert.assertNotSame("RateAShipment - 'destinationTextBox' ::",
					propertyValue.getValue("constantZIPSDestinationZIP"),
					actual11);

			rateAShipment.loggingOutFromTheApplication();

			loginToApplication.LoginToApplication(
					propertyValue.getValue("loginUserName"),
					propertyValue.getValue("loginPassword"));

			manageSettings.clickingOnManageSettingsTab();

			defaultSetting.clickingOnDefaultSettingOption();
			defaultSetting.makingDefaultDiscountsToggleOff();
			defaultSetting.makingDefaultConstantClassToggleOff();
			defaultSetting.makingDefaultConstantZIPSToggleOff();

			logger.info("========== FINAL MESSAGE :: Create Default Setting Test Executed Successfully ==========");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread
					.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(), Thread
					.currentThread().getStackTrace()[1].getMethodName());
			Assert.fail();
		}
	}
}