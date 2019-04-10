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

public class ManageSettingsTest extends TestBase {

	public static final Logger logger = Logger
			.getLogger(ManageSettingsTest.class.getName());

	PropertyFileUtility propertyValue = new PropertyFileUtility("./Files/"
			+ "/DataFile.properties");

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
	@Test
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

//			rateAShipment.clickingOnRateAShipmentTab();
//			rateAShipment.selectRateFamily(propertyValue
//					.getValue("rateFamily1"));
//
//			String actual = rateAShipment.verifyDiscountTextBoxValue();
//			Assert.assertEquals("RateAShipmentPage - 'discountTextBox' ::",
//					propertyValue.getValue("discount1"), actual);
//			String actual1 = rateAShipment.verifyMCDiscountTextBoxValue();
//			Assert.assertEquals("RateAShipmentPage - 'mcDiscountTextBox' ::",
//					propertyValue.getValue("mcDiscount1"), actual1);
//			String actual2 = rateAShipment.verifyMCFloorTextBoxValue();
//			Assert.assertEquals("RateAShipmentPage - 'mcFloorTextBox' ::",
//					propertyValue.getValue("mcFloor1"), actual2);
//			String actual3 = rateAShipment.verifyClassDropDownValue();
//			Assert.assertEquals("RateAShipmentPage - 'classDropDown' ::",
//					propertyValue.getValue("constantClass1"), actual3);
//			String actual4 = rateAShipment.verifyOriginTextBoxValue();
//			Assert.assertEquals("RateAShipmentPage - 'originTextBox' ::",
//					propertyValue.getValue("constantZIPSOriginZIP"), actual4);
//			String actual5 = rateAShipment.verifyDestinationTextBoxValue();
//			Assert.assertEquals("RateAShipmentPage - 'destinationTextBox' ::",
//					propertyValue.getValue("constantZIPSDestinationZIP"),
//					actual5);
//
//			rateAShipment.loggingOutFromTheApplication();
//
//			loginToApplication.LoginToApplication(
//					propertyValue.getValue("user1LoginName"),
//					propertyValue.getValue("user1LoginPassword"));
//
//			rateAShipment.selectRateFamily(propertyValue
//					.getValue("rateFamily1"));
//
//			String actual6 = rateAShipment.verifyDiscountTextBoxValue();
//			Assert.assertNotSame("RateAShipmentPage - 'discountTextBox' ::",
//					propertyValue.getValue("discount1"), actual6);
//			String actual7 = rateAShipment.verifyMCDiscountTextBoxValue();
//			Assert.assertNotSame("RateAShipmentPage - 'mcDiscountTextBox' ::",
//					propertyValue.getValue("mcDiscount1"), actual7);
//			String actual8 = rateAShipment.verifyMCFloorTextBoxValue();
//			Assert.assertNotSame("RateAShipmentPage - 'mcFloorTextBox' ::",
//					propertyValue.getValue("mcFloor1"), actual8);
//			boolean found = rateAShipment
//					.verifyIfClassDropDownHasAnyValueSelected();
//			Assert.assertTrue("RateAShipmentPage - 'classDropDown' ::", found);
//			String actual10 = rateAShipment.verifyOriginTextBoxValue();
//			Assert.assertNotSame("RateAShipmentPage - 'originTextBox' ::",
//					propertyValue.getValue("constantZIPSOriginZIP"), actual10);
//			String actual11 = rateAShipment.verifyDestinationTextBoxValue();
//			Assert.assertNotSame("RateAShipmentPage - 'destinationTextBox' ::",
//					propertyValue.getValue("constantZIPSDestinationZIP"),
//					actual11);
//
//			rateAShipment.loggingOutFromTheApplication();
//
//			loginToApplication.LoginToApplication(
//					propertyValue.getValue("loginUserName"),
//					propertyValue.getValue("loginPassword"));
//
//			manageSettings.clickingOnManageSettingsTab();
//			manageSettings.clickingOnDefaultSettingOption();
//			manageSettings.makingDefaultDiscountsToggleOff();
//			manageSettings.makingDefaultConstantClassToggleOff();
//			manageSettings.makingDefaultConstantZIPSToggleOff();
//
//			logger.info("FINAL MESSAGE :: Create Default Setting Test Executed Successfully");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread
					.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(), Thread
					.currentThread().getStackTrace()[1].getMethodName());
		}
	}

	// 2. Create a Custom Setting Test & 3. Procedure to Delete a Setting
	// @Test
	public void verifyCreateAndDeleteACustomSetting() throws Exception {
		try {
			loginToApplication.LoginToApplication(
					propertyValue.getValue("loginUserName"),
					propertyValue.getValue("loginPassword"));

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.addingACustomSetting(
					propertyValue.getValue("settingForCreateAndDeleteTest"),
					propertyValue.getValue("description"));

			rateAShipment.clickingOnRateAShipmentTab();

			boolean available = rateAShipment.verifyIfSettingIsAvailable();
			Assert.assertTrue("RateAShipmentPage - 'settingsDropDown' ::",
					available);

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.deletingACustomSetting();

			rateAShipment.clickingOnRateAShipmentTab();

			boolean notAvailable = rateAShipment.verifyIfSettingIsAvailable();
			Assert.assertFalse("RateAShipmentPage - 'settingsDropDown' ::",
					notAvailable);

			logger.info("FINAL MESSAGE :: Custom Setting Created and Deleted Successfully");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread
					.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(), Thread
					.currentThread().getStackTrace()[1].getMethodName());
		}
	}

	// 4. Create a Setting with Data Module Test
//	 @Test
	public void verifyCreateASettingWithDataModule() throws Exception {
		try {
			loginToApplication.LoginToApplication(
					propertyValue.getValue("loginUserName"),
					propertyValue.getValue("loginPassword"));

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.addingACustomSetting(
					propertyValue.getValue("settingForDataModuleTest"),
					propertyValue.getValue("description"));
			manageSettings.clickingOnTogglePresentForDataModule();
			manageSettings.settingUpDataModule(
					propertyValue.getValue("rateFamily1"),
					propertyValue.getValue("availableTariffs1"));

			rateAShipment.clickingOnRateAShipmentTab();
			rateAShipment.selectSetting(propertyValue
					.getValue("settingForDataModuleTest"));

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
			rateAShipment.selectSetting(propertyValue
					.getValue("settingForDataModuleTest"));

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
					propertyValue.getValue("settingForSingleDiscountTest"),
					propertyValue.getValue("description"));
			manageSettings.enteringDiscountsDetails(
					propertyValue.getValue("discount2"),
					propertyValue.getValue("mcDiscount2"),
					propertyValue.getValue("mcFloor2"));

			rateAShipment.clickingOnRateAShipmentTab();
			rateAShipment.selectSetting(propertyValue
					.getValue("settingForSingleDiscountTest"));

			boolean selected = rateAShipment.verifyIfSingleDiscountIsSelected();
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
		}
	}
}