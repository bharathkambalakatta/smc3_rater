package com.dreamorbit.SMC3_Rater.TestCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dreamorbit.SMC3_Rater.pages.DefaultSetting;
import com.dreamorbit.SMC3_Rater.pages.FuelSurcharge;
import com.dreamorbit.SMC3_Rater.pages.LoginPage;
import com.dreamorbit.SMC3_Rater.pages.ManageSettings;
import com.dreamorbit.SMC3_Rater.pages.RateAShipment;
import com.dreamorbit.SMC3_Rater.testbase.TestBase;
import com.dreamorbit.SMC3_Rater.testutils.ExceptionalHandlingFunctions;
import com.dreamorbit.SMC3_Rater.testutils.PropertyFileUtility;

public class FuelSurchargeTest extends TestBase {

	public static final Logger logger = Logger
			.getLogger(FuelSurchargeTest.class.getName());

	PropertyFileUtility propertyValue = new PropertyFileUtility("./Files/"
			+ "/DataFile.properties");
	PropertyFileUtility customSettingDetails = new PropertyFileUtility(
			"./Files/" + "/RandomSetting.properties");

	LoginPage loginToApplication;
	RateAShipment rateAShipment;
	ManageSettings manageSettings;
	DefaultSetting defaultSetting;
	FuelSurcharge fuelSurcharge;

	@Before
	public void setUp() throws IOException {
		initialization();
		loginToApplication = new LoginPage(driver);
		rateAShipment = new RateAShipment(driver);
		manageSettings = new ManageSettings(driver);
		defaultSetting = new DefaultSetting(driver);
		fuelSurcharge = new FuelSurcharge(driver);
	}

	// 10. Create a Setting with Constant Surcharge Test
	@Test
	public void verifyCreateASettingWithConstantSurchargeTest()
			throws Exception {
		try {
			logger.info("========== INITIAL MESSAGE :: Create a Setting with Constant Surcharge Test Execution Started ==========");

			loginToApplication.LoginToApplication(
					propertyValue.getValue("loginUserName"),
					propertyValue.getValue("loginPassword"));

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.generatingAndStoringARandomSettingName();
			manageSettings.addingACustomSetting(
					customSettingDetails.getValue("customSettingID"),
					customSettingDetails.getValue("customSettingDescription"));

			fuelSurcharge.clickingOnTogglePresentForSurcharge();
			fuelSurcharge.enteringSurchargeDetails(
					propertyValue.getValue("ltl6"),
					propertyValue.getValue("tl6"));

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

			String actual = rateAShipment.verifySurchargeValueInTheTable();
			Assert.assertEquals("RateAShipmentPage - 'surchargeValue' ::",
					propertyValue.getValue("ltl6%"), actual);

			rateAShipment.enterWeight(propertyValue.getValue("weight1"));
			rateAShipment.clickingOnRateShipmentButton();

			String actual1 = rateAShipment.verifySurchargeValueInTheTable();
			Assert.assertEquals("RateAShipmentPage - 'surchargeValue' ::",
					propertyValue.getValue("tl6%"), actual1);

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.deletingACustomSetting(customSettingDetails
					.getValue("customSettingID"));

			logger.info("========== FINAL MESSAGE :: Create a Setting with Constant Surcharge Test Executed Successfully ==========");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread
					.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(), Thread
					.currentThread().getStackTrace()[1].getMethodName());
			Assert.fail();
		}
	}

	// 11. Create a Setting with National Surcharge Test - Complete Range
	@Test
	public void verifyCreateASettingWithNationalSurchargeTestCompleteRange()
			throws Exception {
		try {
			logger.info("========== INITIAL MESSAGE :: Create a Setting with National Surcharge Test - Complete Range  - Execution Started ==========");

			loginToApplication.LoginToApplication(
					propertyValue.getValue("loginUserName"),
					propertyValue.getValue("loginPassword"));

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.generatingAndStoringARandomSettingName();
			manageSettings.addingACustomSetting(
					customSettingDetails.getValue("customSettingID"),
					customSettingDetails.getValue("customSettingDescription"));

			fuelSurcharge.clickingOnTogglePresentForSurcharge();
			fuelSurcharge.clickingOnNationalAverageSubTab();
			fuelSurcharge.clickingOnExpandOptionPresentInCustomSurchargeTable();

			fuelSurcharge
					.clickingOnAddNewRowButtonPresentInCustomSurchargeTable();
			fuelSurcharge.enteringCustomSurchargeDetails(
					propertyValue.getValue("row1"),
					propertyValue.getValue("lowRange1"),
					propertyValue.getValue("highRange1"),
					propertyValue.getValue("ltl7"),
					propertyValue.getValue("tl7"));
			fuelSurcharge.savingCustomSurchargeDetails();

			fuelSurcharge
					.clickingOnAddNewRowButtonPresentInCustomSurchargeTable();
			fuelSurcharge.enteringCustomSurchargeDetails(
					propertyValue.getValue("row2"),
					propertyValue.getValue("lowRange2"),
					propertyValue.getValue("highRange2"),
					propertyValue.getValue("ltl8"),
					propertyValue.getValue("tl8"));
			fuelSurcharge.savingCustomSurchargeDetails();

			fuelSurcharge
					.clickingOnAddNewRowButtonPresentInCustomSurchargeTable();
			fuelSurcharge.enteringCustomSurchargeDetails(
					propertyValue.getValue("row3"),
					propertyValue.getValue("lowRange3"),
					propertyValue.getValue("highRange3"),
					propertyValue.getValue("ltl9"),
					propertyValue.getValue("tl9"));
			fuelSurcharge.savingCustomSurchargeDetails();

			fuelSurcharge
					.clickingOnAddNewRowButtonPresentInCustomSurchargeTable();
			fuelSurcharge.enteringCustomSurchargeDetails(
					propertyValue.getValue("row4"),
					propertyValue.getValue("lowRange4"),
					propertyValue.getValue("highRange4"),
					propertyValue.getValue("ltl10"),
					propertyValue.getValue("tl10"));
			fuelSurcharge.savingCustomSurchargeDetails();

			fuelSurcharge
					.clickingOnAddNewRowButtonPresentInCustomSurchargeTable();
			fuelSurcharge.enteringCustomSurchargeDetails(
					propertyValue.getValue("row5"),
					propertyValue.getValue("lowRange5"),
					propertyValue.getValue("highRange5"),
					propertyValue.getValue("ltl11"),
					propertyValue.getValue("tl11"));
			fuelSurcharge.savingCustomSurchargeDetails();

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

			String actual = rateAShipment.verifySurchargeValueInTheTable();
			Assert.assertEquals("RateAShipmentPage - 'surchargeValue' ::",
					propertyValue.getValue("ltl9%"), actual);

			rateAShipment.enterWeight(propertyValue.getValue("weight1"));
			rateAShipment.clickingOnRateShipmentButton();

			String actual1 = rateAShipment.verifySurchargeValueInTheTable();
			Assert.assertEquals("RateAShipmentPage - 'surchargeValue' ::",
					propertyValue.getValue("tl9%"), actual1);

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.deletingACustomSetting(customSettingDetails
					.getValue("customSettingID"));

			logger.info("========== FINAL MESSAGE :: Create a Setting with National Surcharge Test - Complete Range - Executed Successfully ==========");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread
					.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(), Thread
					.currentThread().getStackTrace()[1].getMethodName());
			Assert.fail();
		}
	}

	// 12. Create a Setting with National Surcharge Test - Incomplete Range
	@Test
	public void verifyCreateASettingWithNationalSurchargeTestIncompleteRange()
			throws Exception {
		try {
			logger.info("========== INITIAL MESSAGE :: Create a Setting with National Surcharge Test - Incomplete Range - Execution Started ==========");

			loginToApplication.LoginToApplication(
					propertyValue.getValue("loginUserName"),
					propertyValue.getValue("loginPassword"));

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.generatingAndStoringARandomSettingName();
			manageSettings.addingACustomSetting(
					customSettingDetails.getValue("customSettingID"),
					customSettingDetails.getValue("customSettingDescription"));

			fuelSurcharge.clickingOnTogglePresentForSurcharge();
			fuelSurcharge.clickingOnNationalAverageSubTab();
			fuelSurcharge.clickingOnExpandOptionPresentInCustomSurchargeTable();

			fuelSurcharge
					.clickingOnAddNewRowButtonPresentInCustomSurchargeTable();
			fuelSurcharge.enteringCustomSurchargeDetails(
					propertyValue.getValue("row1"),
					propertyValue.getValue("lowRange1"),
					propertyValue.getValue("highRange1"),
					propertyValue.getValue("ltl7"),
					propertyValue.getValue("tl7"));
			fuelSurcharge.savingCustomSurchargeDetails();

			fuelSurcharge
					.clickingOnAddNewRowButtonPresentInCustomSurchargeTable();
			fuelSurcharge.enteringCustomSurchargeDetails(
					propertyValue.getValue("row2"),
					propertyValue.getValue("lowRange2"),
					propertyValue.getValue("highRange2"),
					propertyValue.getValue("ltl8"),
					propertyValue.getValue("tl8"));
			fuelSurcharge.savingCustomSurchargeDetails();

			fuelSurcharge
					.clickingOnAddNewRowButtonPresentInCustomSurchargeTable();
			fuelSurcharge.enteringCustomSurchargeDetails(
					propertyValue.getValue("row3"),
					propertyValue.getValue("lowRange3"),
					propertyValue.getValue("highRange3"),
					propertyValue.getValue("ltl9"),
					propertyValue.getValue("tl9"));
			fuelSurcharge.savingCustomSurchargeDetails();

			fuelSurcharge
					.clickingOnAddNewRowButtonPresentInCustomSurchargeTable();
			fuelSurcharge.enteringCustomSurchargeDetails(
					propertyValue.getValue("row4"),
					propertyValue.getValue("lowRange4"),
					propertyValue.getValue("highRange4"),
					propertyValue.getValue("ltl10"),
					propertyValue.getValue("tl10"));
			fuelSurcharge.savingCustomSurchargeDetails();

			String actual = fuelSurcharge.verifyErrorMessageText();
			Assert.assertEquals("FuelSurcharge - 'incompleteRangeText' ::",
					propertyValue.getValue("incompleteRangeText"), actual);
			boolean found = fuelSurcharge.verifyErrorImage();
			Assert.assertTrue("FuelSurcharge - 'errorImage' ::", found);

			rateAShipment.clickingOnRateAShipmentTab();

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.deletingACustomSetting(customSettingDetails
					.getValue("customSettingID"));

			logger.info("========== FINAL MESSAGE :: Create a Setting with National Surcharge Test - Incomplete Range - Executed Successfully ==========");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread
					.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(), Thread
					.currentThread().getStackTrace()[1].getMethodName());
			Assert.fail();
		}
	}

	// 13. Create a Setting with National Surcharge Test - Allow Override FSC
	// Effective Date
	@Test
	public void verifyCreateASettingWithNationalSurchargeTestAllowOverrideFSCEffectiveDate()
			throws Exception {
		try {
			logger.info("========== INITIAL MESSAGE :: Create a Setting with National Surcharge Test - Allow Override FSC Effective Date - Execution Started ==========");

			loginToApplication.LoginToApplication(
					propertyValue.getValue("loginUserName"),
					propertyValue.getValue("loginPassword"));

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.generatingAndStoringARandomSettingName();
			manageSettings.addingACustomSetting(
					customSettingDetails.getValue("customSettingID"),
					customSettingDetails.getValue("customSettingDescription"));

			fuelSurcharge.clickingOnTogglePresentForSurcharge();
			fuelSurcharge.clickingOnNationalAverageSubTab();
			fuelSurcharge.clickingOnExpandOptionPresentInCustomSurchargeTable();

			fuelSurcharge
					.clickingOnAddNewRowButtonPresentInCustomSurchargeTable();
			fuelSurcharge.enteringCustomSurchargeDetails(
					propertyValue.getValue("row1"),
					propertyValue.getValue("lowRange1"),
					propertyValue.getValue("highRange1"),
					propertyValue.getValue("ltl7"),
					propertyValue.getValue("tl7"));
			fuelSurcharge.savingCustomSurchargeDetails();

			fuelSurcharge
					.clickingOnAddNewRowButtonPresentInCustomSurchargeTable();
			fuelSurcharge.enteringCustomSurchargeDetails(
					propertyValue.getValue("row2"),
					propertyValue.getValue("lowRange2"),
					propertyValue.getValue("highRange2"),
					propertyValue.getValue("ltl8"),
					propertyValue.getValue("tl8"));
			fuelSurcharge.savingCustomSurchargeDetails();

			fuelSurcharge
					.clickingOnAddNewRowButtonPresentInCustomSurchargeTable();
			fuelSurcharge.enteringCustomSurchargeDetails(
					propertyValue.getValue("row3"),
					propertyValue.getValue("lowRange3"),
					propertyValue.getValue("highRange3"),
					propertyValue.getValue("ltl9"),
					propertyValue.getValue("tl9"));
			fuelSurcharge.savingCustomSurchargeDetails();

			fuelSurcharge
					.clickingOnAddNewRowButtonPresentInCustomSurchargeTable();
			fuelSurcharge.enteringCustomSurchargeDetails(
					propertyValue.getValue("row4"),
					propertyValue.getValue("lowRange4"),
					propertyValue.getValue("highRange4"),
					propertyValue.getValue("ltl10"),
					propertyValue.getValue("tl10"));
			fuelSurcharge.savingCustomSurchargeDetails();

			fuelSurcharge
					.clickingOnAddNewRowButtonPresentInCustomSurchargeTable();
			fuelSurcharge.enteringCustomSurchargeDetails(
					propertyValue.getValue("row5"),
					propertyValue.getValue("lowRange5"),
					propertyValue.getValue("highRange5"),
					propertyValue.getValue("ltl11"),
					propertyValue.getValue("tl11"));
			fuelSurcharge.savingCustomSurchargeDetails();
			fuelSurcharge.clickingOnAllowOverrideFSCEffectiveDateCheckBox();

			rateAShipment.clickingOnRateAShipmentTab();
			rateAShipment.selectSetting(customSettingDetails
					.getValue("customSettingID"));

			boolean found = rateAShipment
					.verifyIfValuesPresentInFSCEffectiveDateDropDown();
			Assert.assertTrue("RateAShipment - 'fscEffectiveDateDropDown' ::",
					found);

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.deletingACustomSetting(customSettingDetails
					.getValue("customSettingID"));

			logger.info("========== FINAL MESSAGE :: Create a Setting with National Surcharge Test - Allow Override FSC Effective Date - Executed Successfully ==========");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread
					.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(), Thread
					.currentThread().getStackTrace()[1].getMethodName());
			Assert.fail();
		}
	}

	// 18. Procedure to Create Global Fuel Surcharge
	@Test
	public void verifyCreateGlobalFuelSurchargeTest() throws Exception {
		try {
			logger.info("========== INITIAL MESSAGE :: Procedure to Create Global Fuel Surcharge Test Execution Started ==========");

			loginToApplication.LoginToApplication(
					propertyValue.getValue("loginUserName"),
					propertyValue.getValue("loginPassword"));

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();

			fuelSurcharge.clickingOnGlobalSubTab();
			fuelSurcharge.clickAddNewRow();
			fuelSurcharge.fillGlobalSurchargeFields(
					propertyValue.getValue("lowRange1"),
					propertyValue.getValue("highRange1"),
					propertyValue.getValue("LTL1"),
					propertyValue.getValue("TL1"));
			fuelSurcharge.saveGlobalSurchargeFields();
			fuelSurcharge.clickAddNewRow();
			fuelSurcharge.fillGlobalSurchargeFields(
					propertyValue.getValue("lowRange2"),
					propertyValue.getValue("highRange2"),
					propertyValue.getValue("LTL2"),
					propertyValue.getValue("TL2"));
			fuelSurcharge.saveGlobalSurchargeFields();
			fuelSurcharge.clickAddNewRow();
			fuelSurcharge.fillGlobalSurchargeFields(
					propertyValue.getValue("lowRange3"),
					propertyValue.getValue("highRange3"),
					propertyValue.getValue("LTL3"),
					propertyValue.getValue("TL3"));
			fuelSurcharge.saveGlobalSurchargeFields();
			fuelSurcharge.clickAddNewRow();
			fuelSurcharge.fillGlobalSurchargeFields(
					propertyValue.getValue("lowRange4"),
					propertyValue.getValue("highRange4"),
					propertyValue.getValue("LTL4"),
					propertyValue.getValue("TL4"));
			fuelSurcharge.saveGlobalSurchargeFields();
			fuelSurcharge.clickAddNewRow();
			fuelSurcharge.fillGlobalSurchargeFields(
					propertyValue.getValue("lowRange5"),
					propertyValue.getValue("highRange5"),
					propertyValue.getValue("LTL5"),
					propertyValue.getValue("TL5"));
			fuelSurcharge.saveGlobalSurchargeFields();

			defaultSetting.clickingOnDefaultSettingOption();

			fuelSurcharge.makingDefaultSurchargeToggleON();
			fuelSurcharge.clickingOnViewGlobalGlobalSurchargeOption();

			Assert.assertTrue("FuelSurcharge - 'atLeastValue' ::",
					fuelSurcharge
							.verifyGlobalSurchargeAtLeastValue(propertyValue
									.getValue("lowRange1")));
			Assert.assertTrue(
					"FuelSurcharge - 'butLessThanValue' ::",
					fuelSurcharge
							.verifyGlobalSurchargeButLessThanValue(propertyValue
									.getValue("highRange1")));
			Assert.assertTrue("FuelSurcharge - 'ltlValue' ::", fuelSurcharge
					.verifyGlobalSurchargeLTLValue(propertyValue
							.getValue("LTL1")));
			Assert.assertTrue("FuelSurcharge - 'tlValue' ::",
					fuelSurcharge.verifyGlobalSurchargeTLValue(propertyValue
							.getValue("TL1")));

			Assert.assertTrue("FuelSurcharge - 'atLeastValue' ::",
					fuelSurcharge
							.verifyGlobalSurchargeAtLeastValue(propertyValue
									.getValue("lowRange2")));
			Assert.assertTrue(
					"FuelSurcharge - 'butLessThanValue' ::",
					fuelSurcharge
							.verifyGlobalSurchargeButLessThanValue(propertyValue
									.getValue("highRange2")));
			Assert.assertTrue("FuelSurcharge - 'ltlValue' ::", fuelSurcharge
					.verifyGlobalSurchargeLTLValue(propertyValue
							.getValue("LTL2")));
			Assert.assertTrue("FuelSurcharge - 'tlValue' ::",
					fuelSurcharge.verifyGlobalSurchargeTLValue(propertyValue
							.getValue("TL2")));

			Assert.assertTrue("FuelSurcharge - 'atLeastValue' ::",
					fuelSurcharge
							.verifyGlobalSurchargeAtLeastValue(propertyValue
									.getValue("lowRange3")));
			Assert.assertTrue(
					"FuelSurcharge - 'butLessThanValue' ::",
					fuelSurcharge
							.verifyGlobalSurchargeButLessThanValue(propertyValue
									.getValue("highRange3")));
			Assert.assertTrue("FuelSurcharge - 'ltlValue' ::", fuelSurcharge
					.verifyGlobalSurchargeLTLValue(propertyValue
							.getValue("LTL3")));
			Assert.assertTrue("FuelSurcharge - 'tlValue' ::",
					fuelSurcharge.verifyGlobalSurchargeTLValue(propertyValue
							.getValue("TL3")));

			Assert.assertTrue("FuelSurcharge - 'atLeastValue' ::",
					fuelSurcharge
							.verifyGlobalSurchargeAtLeastValue(propertyValue
									.getValue("lowRange4")));
			Assert.assertTrue(
					"FuelSurcharge - 'butLessThanValue' ::",
					fuelSurcharge
							.verifyGlobalSurchargeButLessThanValue(propertyValue
									.getValue("highRange4")));
			Assert.assertTrue("FuelSurcharge - 'ltlValue' ::", fuelSurcharge
					.verifyGlobalSurchargeLTLValue(propertyValue
							.getValue("LTL4")));
			Assert.assertTrue("FuelSurcharge - 'tlValue' ::",
					fuelSurcharge.verifyGlobalSurchargeTLValue(propertyValue
							.getValue("TL4")));

			Assert.assertTrue("FuelSurcharge - 'atLeastValue' ::",
					fuelSurcharge
							.verifyGlobalSurchargeAtLeastValue(propertyValue
									.getValue("lowRange5")));
			Assert.assertTrue(
					"FuelSurcharge - 'butLessThanValue' ::",
					fuelSurcharge
							.verifyGlobalSurchargeButLessThanValue(propertyValue
									.getValue("highRange5")));
			Assert.assertTrue("FuelSurcharge - 'ltlValue' ::", fuelSurcharge
					.verifyGlobalSurchargeLTLValue(propertyValue
							.getValue("LTL5")));
			Assert.assertTrue("FuelSurcharge - 'tlValue' ::",
					fuelSurcharge.verifyGlobalSurchargeTLValue(propertyValue
							.getValue("TL5")));

			fuelSurcharge.deletingGlobalRows(propertyValue.getValue("TL1"));
			fuelSurcharge.deletingGlobalRows(propertyValue.getValue("TL2"));
			fuelSurcharge.deletingGlobalRows(propertyValue.getValue("TL3"));
			fuelSurcharge.deletingGlobalRows(propertyValue.getValue("TL4"));
			fuelSurcharge.deletingGlobalRows(propertyValue.getValue("TL5"));
			fuelSurcharge.makingDefaultSurchargeToggleOFF();

			logger.info("========== FINAL MESSAGE :: Procedure to Create Global Fuel Surcharge Test Executed Successfully ==========");

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