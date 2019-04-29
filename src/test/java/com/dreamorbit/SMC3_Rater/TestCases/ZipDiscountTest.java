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
import com.dreamorbit.SMC3_Rater.pages.ZipDiscount;
import com.dreamorbit.SMC3_Rater.testbase.TestBase;
import com.dreamorbit.SMC3_Rater.testutils.ExceptionalHandlingFunctions;
import com.dreamorbit.SMC3_Rater.testutils.PropertyFileUtility;

public class ZipDiscountTest extends TestBase {

	public static final Logger logger = Logger.getLogger(ZipDiscountTest.class
			.getName());

	PropertyFileUtility propertyValue = new PropertyFileUtility("./Files/"
			+ "/DataFile.properties");
	PropertyFileUtility customSettingDetails = new PropertyFileUtility(
			"./Files/" + "/RandomSetting.properties");

	LoginPage loginToApplication;
	RateAShipment rateAShipment;
	ManageSettings manageSettings;
	CustomSetting customSetting;
	ZipDiscount zipDiscount;

	@Before
	public void setUp() throws IOException {
		initialization();
		loginToApplication = new LoginPage(driver);
		rateAShipment = new RateAShipment(driver);
		manageSettings = new ManageSettings(driver);
		customSetting = new CustomSetting(driver);
		zipDiscount = new ZipDiscount(driver);
	}
	
	// 7. Create a Setting with Zip Discount Test
		@Test
		public void verifyCreateASettingWithZipDiscountTest() throws Exception {
			try {
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
				zipDiscount.clickingOnZipDiscountButton();
				zipDiscount.clickingOnDiscountIDButton();
				
				
				rateAShipment.clickingOnRateAShipmentTab();
				
				manageSettings.clickingOnManageSettingsTab();
				manageSettings.clickingOnCustomSettingOption();
				manageSettings.deletingACustomSetting(customSettingDetails
						.getValue("customSettingID"));
				
				logger.info("========== FINAL MESSAGE :: Create a Setting with Zip Discount Test Executed Successfully ==========");

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