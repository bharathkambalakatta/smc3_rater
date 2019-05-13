package com.dreamorbit.SMC3_Rater.TestCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.dreamorbit.SMC3_Rater.pages.LoginPage;
import com.dreamorbit.SMC3_Rater.pages.ManageSettings;
import com.dreamorbit.SMC3_Rater.pages.RateAShipment;
import com.dreamorbit.SMC3_Rater.testbase.TestBase;
import com.dreamorbit.SMC3_Rater.testutils.ExceptionalHandlingFunctions;
import com.dreamorbit.SMC3_Rater.testutils.PropertyFileUtility;

public class ManageSettingsTest extends TestBase {

	public static final Logger logger = Logger
			.getLogger(ManageSettingsTest.class.getName());

	PropertyFileUtility propertyValue = new PropertyFileUtility("./Files/"
			+ "/DataFile.properties");
	PropertyFileUtility customSettingDetails = new PropertyFileUtility(
			"./Files/" + "/RandomSetting.properties");

	LoginPage loginToApplication;
	RateAShipment rateAShipment;
	ManageSettings manageSettings;

	@Before
	public void setUp() throws IOException {
		initialization();
		loginToApplication = new LoginPage(driver);
		rateAShipment = new RateAShipment(driver);
		manageSettings = new ManageSettings(driver);
	}

	// 2. Create a Custom Setting Test
	// 3. Procedure to Delete a Setting
	@Test
	public void verifyCreateAndDeleteACustomSetting() throws Exception {
		try {
			logger.info("========== INITIAL MESSAGE :: Create a Custom Setting Test & Procedure to Delete a Setting Test Execution Started ==========");

			loginToApplication.LoginToApplication(
					propertyValue.getValue("loginUserName"),
					propertyValue.getValue("loginPassword"));

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.generatingAndStoringARandomSettingName();
			manageSettings.addingACustomSetting(
					customSettingDetails.getValue("customSettingID"),
					customSettingDetails.getValue("customSettingDescription"));

			rateAShipment.clickingOnRateAShipmentTab();

			boolean available = rateAShipment
					.verifyIfSettingIsAvailable(customSettingDetails
							.getValue("customSettingID"));
			Assert.assertTrue("RateAShipmentPage - 'settingsDropDown' ::",
					available);

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.deletingACustomSetting(customSettingDetails
					.getValue("customSettingID"));

			rateAShipment.clickingOnRateAShipmentTab();

			boolean notAvailable = rateAShipment
					.verifyIfSettingIsAvailable(customSettingDetails
							.getValue("customSettingID"));
			Assert.assertFalse("RateAShipmentPage - 'settingsDropDown' ::",
					notAvailable);

			logger.info("========== FINAL MESSAGE :: Create a Custom Setting Test & Procedure to Delete a Setting Test Executed Successfully ==========");

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