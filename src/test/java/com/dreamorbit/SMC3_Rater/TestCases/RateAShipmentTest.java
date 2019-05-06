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

public class RateAShipmentTest extends TestBase {

	public static final Logger logger = Logger
			.getLogger(RateAShipmentTest.class.getName());

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

	// 17. Procedure to Rate a LTL Shipment
	 @Test
	public void verifyProcedureToRateALTLShipment() throws Exception {
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
			rateAShipment.enterWeight(propertyValue.getValue("weight1"));
			rateAShipment.clickingOnRateShipmentButton();

			boolean valueDisplayed = rateAShipment
					.verifyIfChargeTotalValueIsDisplayed();
			Assert.assertTrue("RateAShipmentPage - 'chargeTotalText' ::",
					valueDisplayed);

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.deletingACustomSetting(customSettingDetails
					.getValue("customSettingID"));

			logger.info("========== FINAL MESSAGE :: Procedure to Rate a LTL Shipment Test Executed Successfully ==========");

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