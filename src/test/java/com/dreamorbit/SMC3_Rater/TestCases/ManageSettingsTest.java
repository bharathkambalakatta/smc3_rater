/* PROJECT		: SMC3 - Rater
 * AUTHOR		: Bharath Kambalakatta
 * COMPANY		: DreamOrbit Softech Pvt Ltd
 * CREATED DATE	: 
 */

package com.dreamorbit.SMC3_Rater.TestCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dreamorbit.SMC3_Rater.pages.LoginPage;
import com.dreamorbit.SMC3_Rater.pages.ManageSettingsPage;
import com.dreamorbit.SMC3_Rater.pages.RateAShipmentPage;
import com.dreamorbit.SMC3_Rater.testbase.TestBase;
import com.dreamorbit.SMC3_Rater.testutils.ExceptionalHandlingFunctions;
import com.dreamorbit.SMC3_Rater.testutils.PropertyFileUtility;
import com.dreamorbit.SMC3_Rater.testutils.PropertyFileWriteUtility;

public class ManageSettingsTest extends TestBase {

	public static final Logger logger = Logger
			.getLogger(ManageSettingsTest.class.getName());

	PropertyFileUtility propertyValue = new PropertyFileUtility("./Files/"
			+ "/DataFile.properties");
	PropertyFileUtility propertyValue1 = new PropertyFileUtility("./Files/"
			+ "/Test.properties");
	PropertyFileWriteUtility propertyKeyValue = new PropertyFileWriteUtility(
			"./Files/" + "/Test.properties");

	LoginPage loginToApplication;
	RateAShipmentPage rateAShipment;
	ManageSettingsPage manageSettings;

	@Before
	public void setUp() throws IOException {
		initialization();
		loginToApplication = new LoginPage(driver);
		rateAShipment = new RateAShipmentPage(driver);
		manageSettings = new ManageSettingsPage(driver);
	}

	// 1. Create Default Setting Test
//	@Test
	public void verifyCreateDefaultSettingTest() throws Exception {
		try {
			loginToApplication.LoginToApplication(
					propertyValue.getValue("loginUserName"),
					propertyValue.getValue("loginPassword"));

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnDefaultSettingOption();
			manageSettings.enteringDefaultDiscountsDetails(
					propertyValue.getValue("discount1"),
					propertyValue.getValue("mcDiscount1"),
					propertyValue.getValue("mcFloor1"));
			manageSettings.enteringDefaultConstantClassDetails(propertyValue
					.getValue("constantClass1"));
			manageSettings.enteringDefaultConstantZIPSDetails(
					propertyValue.getValue("constantZIPSOriginZIP"),
					propertyValue.getValue("constantZIPSDestinationZIP"));

			rateAShipment.clickingOnRateAShipmentTab();
			rateAShipment.selectRateFamily(propertyValue
					.getValue("rateFamily1"));

			String actual = rateAShipment.verifyDiscountTextBoxValue();
			Assert.assertEquals("RateAShipmentPage - 'discountTextBox' ::",
					propertyValue.getValue("discount1"), actual);
			String actual1 = rateAShipment.verifyMCDiscountTextBoxValue();
			Assert.assertEquals("RateAShipmentPage - 'mcDiscountTextBox' ::",
					propertyValue.getValue("mcDiscount1"), actual1);
			String actual2 = rateAShipment.verifyMCFloorTextBoxValue();
			Assert.assertEquals("RateAShipmentPage - 'mcFloorTextBox' ::",
					propertyValue.getValue("mcFloor1"), actual2);
			String actual3 = rateAShipment.verifyClassDropDownValue();
			Assert.assertEquals("RateAShipmentPage - 'classDropDown' ::",
					propertyValue.getValue("constantClass1"), actual3);
			String actual4 = rateAShipment.verifyOriginTextBoxValue();
			Assert.assertEquals("RateAShipmentPage - 'originTextBox' ::",
					propertyValue.getValue("constantZIPSOriginZIP"), actual4);
			String actual5 = rateAShipment.verifyDestinationTextBoxValue();
			Assert.assertEquals("RateAShipmentPage - 'destinationTextBox' ::",
					propertyValue.getValue("constantZIPSDestinationZIP"),
					actual5);

			rateAShipment.loggingOutFromTheApplication();

			loginToApplication.LoginToApplication(
					propertyValue.getValue("loginUserNameCompany2"),
					propertyValue.getValue("loginPasswordCompany2"));

			rateAShipment.selectRateFamily(propertyValue
					.getValue("rateFamily1"));

			String actual6 = rateAShipment.verifyDiscountTextBoxValue();
			Assert.assertNotSame("RateAShipmentPage - 'discountTextBox' ::",
					propertyValue.getValue("discount1"), actual6);
			String actual7 = rateAShipment.verifyMCDiscountTextBoxValue();
			Assert.assertNotSame("RateAShipmentPage - 'mcDiscountTextBox' ::",
					propertyValue.getValue("mcDiscount1"), actual7);
			String actual8 = rateAShipment.verifyMCFloorTextBoxValue();
			Assert.assertNotSame("RateAShipmentPage - 'mcFloorTextBox' ::",
					propertyValue.getValue("mcFloor1"), actual8);
			boolean found = rateAShipment
					.verifyIfClassDropDownHasAnyValueSelected();
			Assert.assertTrue("RateAShipmentPage - 'classDropDown' ::", found);
			String actual10 = rateAShipment.verifyOriginTextBoxValue();
			Assert.assertNotSame("RateAShipmentPage - 'originTextBox' ::",
					propertyValue.getValue("constantZIPSOriginZIP"), actual10);
			String actual11 = rateAShipment.verifyDestinationTextBoxValue();
			Assert.assertNotSame("RateAShipmentPage - 'destinationTextBox' ::",
					propertyValue.getValue("constantZIPSDestinationZIP"),
					actual11);

			rateAShipment.loggingOutFromTheApplication();

			loginToApplication.LoginToApplication(
					propertyValue.getValue("loginUserName"),
					propertyValue.getValue("loginPassword"));

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnDefaultSettingOption();
			manageSettings.makingDefaultDiscountsToggleOff();
			manageSettings.makingDefaultConstantClassToggleOff();
			manageSettings.makingDefaultConstantZIPSToggleOff();

			logger.info("FINAL MESSAGE :: Create Default Setting Test Executed Successfully");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread
					.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(), Thread
					.currentThread().getStackTrace()[1].getMethodName());
			Assert.fail();
		}
	}

	// 2. Create a Custom Setting Test & 3. Procedure to Delete a Setting
	@Test
	public void verifyCreateAndDeleteACustomSetting() throws Exception {
		try {
			loginToApplication.LoginToApplication(
					propertyValue.getValue("loginUserName"),
					propertyValue.getValue("loginPassword"));

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.addingACustomSetting(
					propertyValue.getValue("settingName"),
					propertyValue.getValue("customSettingDescription"));

			rateAShipment.clickingOnRateAShipmentTab();

			boolean available = rateAShipment
					.verifyIfSettingIsAvailable(propertyValue
							.getValue("settingName"));
			Assert.assertTrue("RateAShipmentPage - 'settingsDropDown' ::",
					available);

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.deletingACustomSetting();

			rateAShipment.clickingOnRateAShipmentTab();

			boolean notAvailable = rateAShipment
					.verifyIfSettingIsAvailable(propertyValue
							.getValue("settingName"));
			Assert.assertFalse("RateAShipmentPage - 'settingsDropDown' ::",
					notAvailable);

			logger.info("FINAL MESSAGE :: Custom Setting Created and Deleted Successfully");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread
					.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(), Thread
					.currentThread().getStackTrace()[1].getMethodName());
			Assert.fail();
		}
	}

	// 4. Create a Setting with Data Module Test
	// @Test
	public void verifyCreateASettingWithDataModule() throws Exception {
		try {
			loginToApplication.LoginToApplication(
					propertyValue.getValue("loginUserName"),
					propertyValue.getValue("loginPassword"));

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.addingACustomSetting(
					propertyValue.getValue("settingName"),
					propertyValue.getValue("customSettingDescription"));
			manageSettings.clickingOnTogglePresentForDataModule();
			manageSettings.settingUpDataModule(
					propertyValue.getValue("rateFamily1"),
					propertyValue.getValue("availableTariffs1"));

			rateAShipment.clickingOnRateAShipmentTab();
			rateAShipment.selectSetting(propertyValue.getValue("settingName"));

			String Actual = rateAShipment.verifySelectedValueInRateFamily();
			Assert.assertEquals("RateAShipmentPage - 'rateFamilyDropDown' ::",
					propertyValue.getValue("rateFamily1"), Actual);
			String Actual1 = rateAShipment
					.verifySelectedValueInAvailableTariffs();
			Assert.assertEquals(
					"RateAShipmentPage - 'availableTariffsDropDown' ::",
					propertyValue.getValue("availableTariffs1"), Actual1);

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.clickingOnArrowPresentInFirstRow();
			manageSettings.settingUpDataModule(
					propertyValue.getValue("rateFamily2"),
					propertyValue.getValue("availableTariffs2"));

			rateAShipment.clickingOnRateAShipmentTab();
			rateAShipment.selectSetting(propertyValue.getValue("settingName"));

			String Actual3 = rateAShipment.verifySelectedValueInRateFamily();
			Assert.assertEquals("RateAShipmentPage - 'rateFamilyDropDown' ::",
					propertyValue.getValue("rateFamily2"), Actual3);
			String Actual4 = rateAShipment
					.verifySelectedValueInAvailableTariffs();
			Assert.assertEquals(
					"RateAShipmentPage - 'availableTariffsDropDown' ::",
					propertyValue.getValue("availableTariffs2"), Actual4);

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.deletingACustomSetting();

			logger.info("FINAL MESSAGE :: Create a Setting with Data Module Test Executed Successfully");

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
	// @Test
	public void verifyCreateASettingWithSingleDiscount() throws Exception {
		try {
			loginToApplication.LoginToApplication(
					propertyValue.getValue("loginUserName"),
					propertyValue.getValue("loginPassword"));

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.addingACustomSetting(
					propertyValue.getValue("settingName"),
					propertyValue.getValue("customSettingDescription"));
			manageSettings.clickingOnTogglePresentForDiscounts();
			manageSettings.enteringSingleDiscountsDetails(
					propertyValue.getValue("discount2"),
					propertyValue.getValue("mcDiscount2"),
					propertyValue.getValue("mcFloor2"));

			rateAShipment.clickingOnRateAShipmentTab();
			rateAShipment.selectSetting(propertyValue.getValue("settingName"));

			boolean selected = rateAShipment
					.verifyIfSingleDiscountRadioButtonIsSelected();
			Assert.assertTrue(
					"RateAShipmentPage - 'singleDiscountRadioButton' ::",
					selected);
			String actual = rateAShipment.verifyDiscountTextBoxValue();
			Assert.assertEquals("RateAShipmentPage - 'discountTextBox' ::",
					propertyValue.getValue("discount2"), actual);
			String actual1 = rateAShipment.verifyMCDiscountTextBoxValue();
			Assert.assertEquals("RateAShipmentPage - 'mcDiscountTextBox' ::",
					propertyValue.getValue("mcDiscount2"), actual1);
			String actual2 = rateAShipment.verifyMCFloorTextBoxValue();
			Assert.assertEquals("RateAShipmentPage - 'mcFloorTextBox' ::",
					propertyValue.getValue("mcFloor2"), actual2);

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.deletingACustomSetting();

			logger.info("FINAL MESSAGE :: Create a Setting with Single Discount Test Executed Successfully");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread
					.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(), Thread
					.currentThread().getStackTrace()[1].getMethodName());
			Assert.fail();
		}

	}

	// 5. Create a Setting with Multiple Discount Test
	// @Test
	public void verifyCreateASettingWithMultipleDiscount() throws Exception {
		try {
			loginToApplication.LoginToApplication(
					propertyValue.getValue("loginUserName"),
					propertyValue.getValue("loginPassword"));

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.addingACustomSetting(
					propertyValue.getValue("settingName"),
					propertyValue.getValue("customSettingDescription"));
			manageSettings.clickingOnTogglePresentForDiscounts();
			manageSettings.enteringMultipleDiscountsDetails(
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

			rateAShipment.clickingOnRateAShipmentTab();
			rateAShipment.selectSetting(propertyValue.getValue("settingName"));

			boolean selected = rateAShipment
					.verifyIfMultipleDiscountRadioButtonIsSelected();
			Assert.assertTrue(
					"RateAShipmentPage - 'multipleDiscountRadioButton' ::",
					selected);
			String actual = rateAShipment.verifyL5CTextBoxValue();
			Assert.assertEquals("RateAShipmentPage - 'l5cTextBox' ::",
					propertyValue.getValue("l5c1"), actual);
			String actual1 = rateAShipment.verifyM5CTextBoxValue();
			Assert.assertEquals("RateAShipmentPage - 'm5cTextBox' ::",
					propertyValue.getValue("m5c1"), actual1);
			String actual2 = rateAShipment.verifyM1MTextBoxValue();
			Assert.assertEquals("RateAShipmentPage - 'm1mTextBox' ::",
					propertyValue.getValue("m1m1"), actual2);
			String actual3 = rateAShipment.verifyM2MTextBoxValue();
			Assert.assertEquals("RateAShipmentPage - 'm2mTextBox' ::",
					propertyValue.getValue("m2m1"), actual3);
			String actual4 = rateAShipment.verifyM5MTextBoxValue();
			Assert.assertEquals("RateAShipmentPage - 'm5mTextBox' ::",
					propertyValue.getValue("m5m1"), actual4);
			String actual5 = rateAShipment.verifyM10MTextBoxValue();
			Assert.assertEquals("RateAShipmentPage - 'm10mTextBox' ::",
					propertyValue.getValue("m10m1"), actual5);
			String actual6 = rateAShipment.verifyM20MTextBoxValue();
			Assert.assertEquals("RateAShipmentPage - 'm20mTextBox' ::",
					propertyValue.getValue("m20m1"), actual6);
			String actual7 = rateAShipment.verifyM30MTextBoxValue();
			Assert.assertEquals("RateAShipmentPage - 'm30mTextBox' ::",
					propertyValue.getValue("m30m1"), actual7);
			String actual8 = rateAShipment.verifyM40MTextBoxValue();
			Assert.assertEquals("RateAShipmentPage - 'm40mTextBox' ::",
					propertyValue.getValue("m40m1"), actual8);
			String actual9 = rateAShipment
					.verifyMCDiscountMultipleTextBoxValue();
			Assert.assertEquals(
					"RateAShipmentPage - 'mcDiscountMultipleTextBox' ::",
					propertyValue.getValue("mc1"), actual9);
			String actual10 = rateAShipment.verifyMCFloorMultipleTextBoxValue();
			Assert.assertEquals(
					"RateAShipmentPage - 'mcFloorMultipleTextBox' ::",
					propertyValue.getValue("mcFloor1"), actual10);

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.deletingACustomSetting();

			logger.info("FINAL MESSAGE :: Create a Setting with Single Discount Test Executed Successfully");

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