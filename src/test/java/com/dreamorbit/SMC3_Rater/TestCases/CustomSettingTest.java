package com.dreamorbit.SMC3_Rater.TestCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dreamorbit.SMC3_Rater.pages.CustomSetting;
import com.dreamorbit.SMC3_Rater.pages.LoginPage;
import com.dreamorbit.SMC3_Rater.pages.ManageSettings;
import com.dreamorbit.SMC3_Rater.pages.RateAShipment;
import com.dreamorbit.SMC3_Rater.testbase.TestBase;
import com.dreamorbit.SMC3_Rater.testutils.ExceptionalHandlingFunctions;
import com.dreamorbit.SMC3_Rater.testutils.PropertyFileUtility;

public class CustomSettingTest extends TestBase {

	public static final Logger logger = Logger
			.getLogger(CustomSettingTest.class.getName());

	PropertyFileUtility propertyValue = new PropertyFileUtility("./Files/"
			+ "/DataFile.properties");
	PropertyFileUtility customSettingDetails = new PropertyFileUtility(
			"./Files/" + "/RandomSetting.properties");

	LoginPage loginToApplication;
	RateAShipment rateAShipment;
	ManageSettings manageSettings;
	CustomSetting customSetting;

	@Before
	public void setUp() throws IOException {
		initialization();
		loginToApplication = new LoginPage(driver);
		rateAShipment = new RateAShipment(driver);
		manageSettings = new ManageSettings(driver);
		customSetting = new CustomSetting(driver);
	}

	// 4. Create a Setting with Data Module Test
	@Test
	public void verifyCreateASettingWithDataModule() throws Exception {
		try {
			logger.info("********** INITIAL MESSAGE :: Create a Setting with Data Module Test Execution Started **********");

			loginToApplication.LoginToApplication(
					propertyValue.getValue("loginUserName"),
					propertyValue.getValue("loginPassword"));

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.generatingAndStoringARandomSettingName();
			manageSettings.addingACustomSetting(
					customSettingDetails.getValue("customSettingID"),
					customSettingDetails.getValue("customSettingDescription"));

			customSetting.clickingOnTogglePresentForDataModule();
			customSetting.settingUpDataModule(
					propertyValue.getValue("rateFamily1"),
					propertyValue.getValue("availableTariffs1"));

			rateAShipment.clickingOnRateAShipmentTab();
			rateAShipment.selectSetting(customSettingDetails
					.getValue("customSettingID"));

			String Actual = rateAShipment.verifySelectedValueInRateFamily();
			Assert.assertEquals("RateAShipment - 'rateFamilyDropDown' ::",
					propertyValue.getValue("rateFamily1"), Actual);
			String Actual1 = rateAShipment
					.verifySelectedValueInAvailableTariffs();
			Assert.assertEquals(
					"RateAShipment - 'availableTariffsDropDown' ::",
					propertyValue.getValue("availableTariffs1"), Actual1);

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings
					.clickingOnArrowPresentForASetting(customSettingDetails
							.getValue("customSettingID"));

			customSetting.settingUpDataModule(
					propertyValue.getValue("rateFamily2"),
					propertyValue.getValue("availableTariffs2"));

			rateAShipment.clickingOnRateAShipmentTab();
			rateAShipment.selectSetting(customSettingDetails
					.getValue("customSettingID"));

			String Actual3 = rateAShipment.verifySelectedValueInRateFamily();
			Assert.assertEquals("RateAShipment - 'rateFamilyDropDown' ::",
					propertyValue.getValue("rateFamily2"), Actual3);
			String Actual4 = rateAShipment
					.verifySelectedValueInAvailableTariffs();
			Assert.assertEquals(
					"RateAShipment - 'availableTariffsDropDown' ::",
					propertyValue.getValue("availableTariffs2"), Actual4);

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.deletingACustomSetting(customSettingDetails
					.getValue("customSettingID"));

			logger.info("========== FINAL MESSAGE :: Create a Setting with Data Module Test Executed Successfully ==========");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread
					.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(), Thread
					.currentThread().getStackTrace()[1].getMethodName());
			Assert.fail();
		}
	}

	// 5. Create a Setting with Single Discount Test
	@Test
	public void verifyCreateASettingWithSingleDiscount() throws Exception {
		try {
			logger.info("********** INITIAL MESSAGE :: Create a Setting with Single Discount Test Execution Started **********");

			loginToApplication.LoginToApplication(
					propertyValue.getValue("loginUserName"),
					propertyValue.getValue("loginPassword"));

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.generatingAndStoringARandomSettingName();
			manageSettings.addingACustomSetting(
					customSettingDetails.getValue("customSettingID"),
					customSettingDetails.getValue("customSettingDescription"));
			customSetting.clickingOnTogglePresentForDiscounts();
			customSetting.enteringSingleDiscountsDetails(
					propertyValue.getValue("discount4"),
					propertyValue.getValue("mcDiscount4"),
					propertyValue.getValue("mcFloor4"));

			rateAShipment.clickingOnRateAShipmentTab();
			rateAShipment.selectSetting(customSettingDetails
					.getValue("customSettingID"));

			boolean selected = rateAShipment
					.verifyIfSingleDiscountRadioButtonIsSelected();
			Assert.assertTrue("RateAShipment - 'singleDiscountRadioButton' ::",
					selected);
			String actual = rateAShipment.verifyDiscountTextBoxValue();
			Assert.assertEquals("RateAShipment - 'discountTextBox' ::",
					propertyValue.getValue("discount4"), actual);
			String actual1 = rateAShipment.verifyMCDiscountTextBoxValue();
			Assert.assertEquals("RateAShipment - 'mcDiscountTextBox' ::",
					propertyValue.getValue("mcDiscount4"), actual1);
			String actual2 = rateAShipment.verifyMCFloorTextBoxValue();
			Assert.assertEquals("RateAShipment - 'mcFloorTextBox' ::",
					propertyValue.getValue("mcFloor4"), actual2);

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.deletingACustomSetting(customSettingDetails
					.getValue("customSettingID"));

			logger.info("========== FINAL MESSAGE :: Create a Setting with Single Discount Test Executed Successfully ==========");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread
					.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(), Thread
					.currentThread().getStackTrace()[1].getMethodName());
			Assert.fail();
		}
	}

	// 6. Create a Setting with Multiple Discount Test
	// 19. Procedure to Create a Multiple Discount
	@Test
	public void verifyCreateASettingWithMultipleDiscount() throws Exception {
		try {
			logger.info("********** INITIAL MESSAGE :: Create a Setting with Multiple Discount Test & Procedure to Create a Multiple Discount Test Execution Started **********");

			loginToApplication.LoginToApplication(
					propertyValue.getValue("loginUserName"),
					propertyValue.getValue("loginPassword"));

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.generatingAndStoringARandomSettingName();
			manageSettings.addingACustomSetting(
					customSettingDetails.getValue("customSettingID"),
					customSettingDetails.getValue("customSettingDescription"));

			customSetting.clickingOnTogglePresentForDiscounts();
			customSetting.clickingOnMultipleDiscountOption();
			customSetting.enteringMultipleDiscountsDetails(
					propertyValue.getValue("l5c1"),
					propertyValue.getValue("m5c1"),
					propertyValue.getValue("m1m1"),
					propertyValue.getValue("m2m1"),
					propertyValue.getValue("m5m1"),
					propertyValue.getValue("m10m1"),
					propertyValue.getValue("m20m1"),
					propertyValue.getValue("m30m1"),
					propertyValue.getValue("m40m1"),
					propertyValue.getValue("mc1"),
					propertyValue.getValue("mcFloor1"));
			customSetting.clickingOnSaveMultipleDiscountButton();

			rateAShipment.clickingOnRateAShipmentTab();
			rateAShipment.selectSetting(customSettingDetails
					.getValue("customSettingID"));

			boolean selected = rateAShipment
					.verifyIfMultipleDiscountRadioButtonIsSelected();
			Assert.assertTrue(
					"RateAShipment - 'multipleDiscountRadioButton' ::",
					selected);
			String actual = rateAShipment.verifyL5CTextBoxValue();
			Assert.assertEquals("RateAShipment - 'l5cTextBox' ::",
					propertyValue.getValue("l5c1"), actual);
			String actual1 = rateAShipment.verifyM5CTextBoxValue();
			Assert.assertEquals("RateAShipment - 'm5cTextBox' ::",
					propertyValue.getValue("m5c1"), actual1);
			String actual2 = rateAShipment.verifyM1MTextBoxValue();
			Assert.assertEquals("RateAShipment - 'm1mTextBox' ::",
					propertyValue.getValue("m1m1"), actual2);
			String actual3 = rateAShipment.verifyM2MTextBoxValue();
			Assert.assertEquals("RateAShipment - 'm2mTextBox' ::",
					propertyValue.getValue("m2m1"), actual3);
			String actual4 = rateAShipment.verifyM5MTextBoxValue();
			Assert.assertEquals("RateAShipment - 'm5mTextBox' ::",
					propertyValue.getValue("m5m1"), actual4);
			String actual5 = rateAShipment.verifyM10MTextBoxValue();
			Assert.assertEquals("RateAShipment - 'm10mTextBox' ::",
					propertyValue.getValue("m10m1"), actual5);
			String actual6 = rateAShipment.verifyM20MTextBoxValue();
			Assert.assertEquals("RateAShipment - 'm20mTextBox' ::",
					propertyValue.getValue("m20m1"), actual6);
			String actual7 = rateAShipment.verifyM30MTextBoxValue();
			Assert.assertEquals("RateAShipment - 'm30mTextBox' ::",
					propertyValue.getValue("m30m1"), actual7);
			String actual8 = rateAShipment.verifyM40MTextBoxValue();
			Assert.assertEquals("RateAShipment - 'm40mTextBox' ::",
					propertyValue.getValue("m40m1"), actual8);
			String actual9 = rateAShipment
					.verifyMCDiscountMultipleTextBoxValue();
			Assert.assertEquals(
					"RateAShipment - 'mcDiscountMultipleTextBox' ::",
					propertyValue.getValue("mc1"), actual9);
			String actual10 = rateAShipment.verifyMCFloorMultipleTextBoxValue();
			Assert.assertEquals("RateAShipment - 'mcFloorMultipleTextBox' ::",
					propertyValue.getValue("mcFloor1"), actual10);

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings
					.clickingOnArrowPresentForASetting(customSettingDetails
							.getValue("customSettingID"));

			customSetting.clickingOnEditMultipleDiscountButton();
			customSetting.enteringMultipleDiscountsDetails(
					propertyValue.getValue("l5c2"),
					propertyValue.getValue("m5c2"),
					propertyValue.getValue("m1m2"),
					propertyValue.getValue("m2m2"),
					propertyValue.getValue("m5m2"),
					propertyValue.getValue("m10m2"),
					propertyValue.getValue("m20m2"),
					propertyValue.getValue("m30m2"),
					propertyValue.getValue("m40m2"),
					propertyValue.getValue("mc2"),
					propertyValue.getValue("mcFloor2"));
			customSetting.clickingOnSaveMultipleDiscountButton();

			rateAShipment.clickingOnRateAShipmentTab();
			rateAShipment.selectSetting(customSettingDetails
					.getValue("customSettingID"));

			boolean selected1 = rateAShipment
					.verifyIfMultipleDiscountRadioButtonIsSelected();
			Assert.assertTrue(
					"RateAShipment - 'multipleDiscountRadioButton' ::",
					selected1);
			String actual11 = rateAShipment.verifyL5CTextBoxValue();
			Assert.assertEquals("RateAShipment - 'l5cTextBox' ::",
					propertyValue.getValue("l5c2"), actual11);
			String actual12 = rateAShipment.verifyM5CTextBoxValue();
			Assert.assertEquals("RateAShipment - 'm5cTextBox' ::",
					propertyValue.getValue("m5c2"), actual12);
			String actual13 = rateAShipment.verifyM1MTextBoxValue();
			Assert.assertEquals("RateAShipment - 'm1mTextBox' ::",
					propertyValue.getValue("m1m2"), actual13);
			String actual14 = rateAShipment.verifyM2MTextBoxValue();
			Assert.assertEquals("RateAShipment - 'm2mTextBox' ::",
					propertyValue.getValue("m2m2"), actual14);
			String actual15 = rateAShipment.verifyM5MTextBoxValue();
			Assert.assertEquals("RateAShipment - 'm5mTextBox' ::",
					propertyValue.getValue("m5m2"), actual15);
			String actual16 = rateAShipment.verifyM10MTextBoxValue();
			Assert.assertEquals("RateAShipment - 'm10mTextBox' ::",
					propertyValue.getValue("m10m2"), actual16);
			String actual17 = rateAShipment.verifyM20MTextBoxValue();
			Assert.assertEquals("RateAShipment - 'm20mTextBox' ::",
					propertyValue.getValue("m20m2"), actual17);
			String actual18 = rateAShipment.verifyM30MTextBoxValue();
			Assert.assertEquals("RateAShipment - 'm30mTextBox' ::",
					propertyValue.getValue("m30m2"), actual18);
			String actual19 = rateAShipment.verifyM40MTextBoxValue();
			Assert.assertEquals("RateAShipment - 'm40mTextBox' ::",
					propertyValue.getValue("m40m2"), actual19);
			String actual20 = rateAShipment
					.verifyMCDiscountMultipleTextBoxValue();
			Assert.assertEquals(
					"RateAShipment - 'mcDiscountMultipleTextBox' ::",
					propertyValue.getValue("mc2"), actual20);
			String actual21 = rateAShipment.verifyMCFloorMultipleTextBoxValue();
			Assert.assertEquals("RateAShipment - 'mcFloorMultipleTextBox' ::",
					propertyValue.getValue("mcFloor2"), actual21);

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.deletingACustomSetting(customSettingDetails
					.getValue("customSettingID"));

			logger.info("========== FINAL MESSAGE :: Create a Setting with Multiple Discount Test & Procedure to Create a Multiple Discount Test Executed Successfully ==========");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread
					.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(), Thread
					.currentThread().getStackTrace()[1].getMethodName());
			Assert.fail();
		}
	}

	// 14. Create a Setting with Constant Class Test
	@Test
	public void verifyCreateASettingWithConstantClassTest() throws Exception {
		try {
			logger.info("********** INITIAL MESSAGE :: Create a Setting with Constant Class Test Execution Started **********");

			loginToApplication.LoginToApplication(
					propertyValue.getValue("loginUserName"),
					propertyValue.getValue("loginPassword"));

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.generatingAndStoringARandomSettingName();
			manageSettings.addingACustomSetting(
					customSettingDetails.getValue("customSettingID"),
					customSettingDetails.getValue("customSettingDescription"));

			customSetting.clickingOnTogglePresentForConstantClass();
			customSetting.enteringConstantClassDetails(propertyValue
					.getValue("class2"));

			rateAShipment.clickingOnRateAShipmentTab();
			rateAShipment.selectSetting(customSettingDetails
					.getValue("customSettingID"));
			rateAShipment.selectRateFamily(propertyValue
					.getValue("rateFamily1"));

			String actual = rateAShipment.verifyClassDropDownValue();
			Assert.assertEquals("RateAShipment - 'classDropDown' ::",
					propertyValue.getValue("class2"), actual);

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.deletingACustomSetting(customSettingDetails
					.getValue("customSettingID"));

			logger.info("========== FINAL MESSAGE :: Create a Setting with Constant Class Test Executed Successfully ==========");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread
					.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(), Thread
					.currentThread().getStackTrace()[1].getMethodName());
			Assert.fail();
		}
	}

	// 15. Create a Setting with Constant Zips Test
	@Test
	public void verifyCreateASettingWithConstantZipsTest() throws Exception {
		try {
			logger.info("********** INITIAL MESSAGE :: Create a Setting with Constant Zips Test Execution Started **********");

			loginToApplication.LoginToApplication(
					propertyValue.getValue("loginUserName"),
					propertyValue.getValue("loginPassword"));

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.generatingAndStoringARandomSettingName();
			manageSettings.addingACustomSetting(
					customSettingDetails.getValue("customSettingID"),
					customSettingDetails.getValue("customSettingDescription"));

			customSetting.clickingOnTogglePresentForConstantZIPS();
			customSetting.enteringConstantZIPSDetails(
					propertyValue.getValue("origin2"),
					propertyValue.getValue("destination2"));

			rateAShipment.clickingOnRateAShipmentTab();
			rateAShipment.selectSetting(customSettingDetails
					.getValue("customSettingID"));

			String actual = rateAShipment.verifyOriginTextBoxValue();
			Assert.assertEquals("RateAShipment - 'originTextBox' ::",
					propertyValue.getValue("origin2"), actual);
			String actual1 = rateAShipment.verifyDestinationTextBoxValue();
			Assert.assertEquals("RateAShipment - 'destinationTextBox' ::",
					propertyValue.getValue("destination2"), actual1);

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.deletingACustomSetting(customSettingDetails
					.getValue("customSettingID"));

			logger.info("========== FINAL MESSAGE :: Create a Setting with Constant Zips Test Executed Successfully ==========");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread
					.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(), Thread
					.currentThread().getStackTrace()[1].getMethodName());
			Assert.fail();
		}
	}

	// 16. Create a Setting with FAK Test
	@Test
	public void verifyCreateASettingWithFAKTest() throws Exception {
		try {
			logger.info("********** INITIAL MESSAGE :: Create a Setting with FAK Test Execution Started **********");

			loginToApplication.LoginToApplication(
					propertyValue.getValue("loginUserName"),
					propertyValue.getValue("loginPassword"));

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.generatingAndStoringARandomSettingName();
			manageSettings.addingACustomSetting(
					customSettingDetails.getValue("customSettingID"),
					customSettingDetails.getValue("customSettingDescription"));

			customSetting.clickingOnTogglePresentForFAK();
			customSetting.enteringFAKDetails(propertyValue.getValue("class3"),
					propertyValue.getValue("class3"),
					propertyValue.getValue("class3"),
					propertyValue.getValue("class3"));

			rateAShipment.clickingOnRateAShipmentTab();
			rateAShipment.selectSetting(customSettingDetails
					.getValue("customSettingID"));
			rateAShipment.selectRateFamily(propertyValue
					.getValue("rateFamily1"));
			rateAShipment.selectAvailableTariffs(propertyValue
					.getValue("availableTariffs1"));
			rateAShipment.enterOrigin(propertyValue.getValue("origin1"));
			rateAShipment.enterDestination(propertyValue
					.getValue("destination1"));
			rateAShipment.selectClass(propertyValue.getValue("class1"));
			rateAShipment.enterWeight(propertyValue.getValue("weight3"));
			rateAShipment.clickingOnRateShipmentButton();

			boolean found = rateAShipment.verifyIfAsteriskSymbolIsDisplayed();
			Assert.assertTrue("RateAShipment - 'asteriskSymbol' ::", found);

			rateAShipment.selectClass(propertyValue.getValue("class4"));
			rateAShipment.clickingOnRateShipmentButton();

			boolean found1 = rateAShipment.verifyIfAsteriskSymbolIsDisplayed();
			Assert.assertFalse("RateAShipment - 'asteriskSymbol' ::", found1);

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.deletingACustomSetting(customSettingDetails
					.getValue("customSettingID"));

			logger.info("========== FINAL MESSAGE :: Create a Setting with FAK Test Executed Successfully ==========");

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