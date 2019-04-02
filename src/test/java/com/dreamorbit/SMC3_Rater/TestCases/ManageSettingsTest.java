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

	public static final Logger log = Logger.getLogger(ManageSettingsTest.class
			.getName());

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

	@Test
	public void verifyCreateDefaultSettingTest() throws InterruptedException{
		loginToApplication.LoginToApplication(
				propertyValue.getValue("loginUserName"),
				propertyValue.getValue("loginPassword"));

		manageSettings.clickingOnManageSettingsTab();
		manageSettings.clickingDefaultSettingOption();
		manageSettings.enteringDefaultDiscountsDetails(propertyValue.getValue("discount1"), propertyValue.getValue("mcDiscount1"), propertyValue.getValue("mcFloor1"));
//		rateAShipment.clickingOnRateAShipmentTab();
		
		
//		rateAShipment.loggingOutFromTheApplication();
//		loginToApplication.LoginToApplication(
//				propertyValue.getValue("user1LoginName"),
//				propertyValue.getValue("user1LoginPassword"));
	}
	
	
	
	
	
	
//	@Test
	public void verifyCreateAndDeleteACustomSetting() throws Exception {
		try {
			loginToApplication.LoginToApplication(
					propertyValue.getValue("loginUserName"),
					propertyValue.getValue("loginPassword"));

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingCustomSettingOption();
			manageSettings.addingACustomSetting(
					propertyValue.getValue("settingForCreateAndDeleteTest"),
					propertyValue.getValue("description"));
			rateAShipment.clickingOnRateAShipmentTab();
			boolean available = rateAShipment.verifyIfSettingIsAvailable();
			Assert.assertTrue(available);
			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingCustomSettingOption();
			manageSettings.clickingOnDeleteCustomSetting();
			rateAShipment.clickingOnRateAShipmentTab();
			boolean notAvailable = rateAShipment.verifyIfSettingIsAvailable();
			Assert.assertFalse(notAvailable);

			System.out
					.println("CUSTOM MESSAGE :: Custom Setting Created and Deleted Successfully");

		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread
					.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(), Thread
					.currentThread().getStackTrace()[1].getMethodName());
		}
	}

//	@Test
	public void verifyCreateASettingWithDataModule() throws Exception {
		try {
			loginToApplication.LoginToApplication(
					propertyValue.getValue("loginUserName"),
					propertyValue.getValue("loginPassword"));

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingCustomSettingOption();
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
			Assert.assertEquals(propertyValue.getValue("rateFamily1"), Actual);
			String Actual1 = rateAShipment
					.verifySelectedValueInAvailableTariffs();
			Assert.assertEquals(propertyValue.getValue("availableTariffs1"),
					Actual1);

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingCustomSettingOption();
			manageSettings.clickingOnArrowPresentInFirstRow();
			manageSettings.settingUpDataModule(
					propertyValue.getValue("rateFamily2"),
					propertyValue.getValue("availableTariffs2"));
			rateAShipment.clickingOnRateAShipmentTab();
			rateAShipment.selectSetting(propertyValue
					.getValue("settingForDataModuleTest"));
			String Actual3 = rateAShipment.verifySelectedValueInRateFamily();
			Assert.assertEquals(propertyValue.getValue("rateFamily2"), Actual3);
			String Actual4 = rateAShipment
					.verifySelectedValueInAvailableTariffs();
			Assert.assertEquals(propertyValue.getValue("availableTariffs2"),
					Actual4);

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingCustomSettingOption();
			manageSettings.clickingOnDeleteCustomSetting();

			System.out
					.println("CUSTOM MESSAGE :: Data Module set for a Custom Setting are populating in 'RATE A SHIPMENT' tab successfully");

		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread
					.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(), Thread
					.currentThread().getStackTrace()[1].getMethodName());
		}
	}
	
//	@Test
	public void verifyCreateASettingWithSingleDiscount() throws Exception {
		try {
			loginToApplication.LoginToApplication(
					propertyValue.getValue("loginUserName"),
					propertyValue.getValue("loginPassword"));

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingCustomSettingOption();
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
			Assert.assertEquals(propertyValue.getValue("rateFamily1"), Actual);
			String Actual1 = rateAShipment
					.verifySelectedValueInAvailableTariffs();
			Assert.assertEquals(propertyValue.getValue("availableTariffs1"),
					Actual1);

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingCustomSettingOption();
			manageSettings.clickingOnArrowPresentInFirstRow();
			manageSettings.settingUpDataModule(
					propertyValue.getValue("rateFamily2"),
					propertyValue.getValue("availableTariffs2"));
			rateAShipment.clickingOnRateAShipmentTab();
			rateAShipment.selectSetting(propertyValue
					.getValue("settingForDataModuleTest"));
			String Actual3 = rateAShipment.verifySelectedValueInRateFamily();
			Assert.assertEquals(propertyValue.getValue("rateFamily2"), Actual3);
			String Actual4 = rateAShipment
					.verifySelectedValueInAvailableTariffs();
			Assert.assertEquals(propertyValue.getValue("availableTariffs2"),
					Actual4);

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingCustomSettingOption();
			manageSettings.clickingOnDeleteCustomSetting();

			System.out
					.println("CUSTOM MESSAGE :: Data Module set for a Custom Setting are populating in 'RATE A SHIPMENT' tab successfully");

		} catch (Exception e) {
			System.out.println(e);
			Assert.fail();
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread
					.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(), Thread
					.currentThread().getStackTrace()[1].getMethodName());
		}
	}
}