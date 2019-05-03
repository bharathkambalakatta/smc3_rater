package com.dreamorbit.SMC3_Rater.TestCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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

	LoginPage loginToApplication;
	RateAShipment rateAShipment;
	ManageSettings manageSettings;
	FuelSurcharge fuelSurcharge;

	@Before
	public void setUp() throws IOException {
		initialization();
		loginToApplication = new LoginPage(driver);
		rateAShipment = new RateAShipment(driver);
		manageSettings = new ManageSettings(driver);
		fuelSurcharge = new FuelSurcharge(driver);
	}

	// 19. Procedure to Create Global Fuel Surcharge
	@Test
	public void verifyCreateGlobalFuelSurchargeTest() throws Exception {
		try {
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

			manageSettings.clickingOnDefaultSettingOption();

			fuelSurcharge.clickingOnViewGlobalGlobalSurchargeOption();

			Assert.assertTrue("FuelSurcharge - 'atLeastValue' ::",
					fuelSurcharge
							.verifyGlobalSurchargeAtLeastValue(propertyValue
									.getValue("lowRange1")));
			Assert.assertTrue("FuelSurcharge - 'butLessThanValue' ::",
					fuelSurcharge
							.verifyGlobalSurchargeAtLeastValue(propertyValue
									.getValue("highRange1")));
			Assert.assertTrue("FuelSurcharge - 'ltlValue' ::", fuelSurcharge
					.verifyGlobalSurchargeAtLeastValue(propertyValue
							.getValue("LTL1")));
			Assert.assertTrue("FuelSurcharge - 'tlValue' ::", fuelSurcharge
					.verifyGlobalSurchargeAtLeastValue(propertyValue
							.getValue("TL1")));

			Assert.assertTrue("FuelSurcharge - 'atLeastValue' ::",
					fuelSurcharge
							.verifyGlobalSurchargeAtLeastValue(propertyValue
									.getValue("lowRange2")));
			Assert.assertTrue("FuelSurcharge - 'butLessThanValue' ::",
					fuelSurcharge
							.verifyGlobalSurchargeAtLeastValue(propertyValue
									.getValue("highRange2")));
			Assert.assertTrue("FuelSurcharge - 'ltlValue' ::", fuelSurcharge
					.verifyGlobalSurchargeAtLeastValue(propertyValue
							.getValue("LTL2")));
			Assert.assertTrue("FuelSurcharge - 'tlValue' ::", fuelSurcharge
					.verifyGlobalSurchargeAtLeastValue(propertyValue
							.getValue("TL2")));

			Assert.assertTrue("FuelSurcharge - 'atLeastValue' ::",
					fuelSurcharge
							.verifyGlobalSurchargeAtLeastValue(propertyValue
									.getValue("lowRange3")));
			Assert.assertTrue("FuelSurcharge - 'butLessThanValue' ::",
					fuelSurcharge
							.verifyGlobalSurchargeAtLeastValue(propertyValue
									.getValue("highRange3")));
			Assert.assertTrue("FuelSurcharge - 'ltlValue' ::", fuelSurcharge
					.verifyGlobalSurchargeAtLeastValue(propertyValue
							.getValue("LTL3")));
			Assert.assertTrue("FuelSurcharge - 'tlValue' ::", fuelSurcharge
					.verifyGlobalSurchargeAtLeastValue(propertyValue
							.getValue("TL3")));

			Assert.assertTrue("FuelSurcharge - 'atLeastValue' ::",
					fuelSurcharge
							.verifyGlobalSurchargeAtLeastValue(propertyValue
									.getValue("lowRange4")));
			Assert.assertTrue("FuelSurcharge - 'butLessThanValue' ::",
					fuelSurcharge
							.verifyGlobalSurchargeAtLeastValue(propertyValue
									.getValue("highRange4")));
			Assert.assertTrue("FuelSurcharge - 'ltlValue' ::", fuelSurcharge
					.verifyGlobalSurchargeAtLeastValue(propertyValue
							.getValue("LTL4")));
			Assert.assertTrue("FuelSurcharge - 'tlValue' ::", fuelSurcharge
					.verifyGlobalSurchargeAtLeastValue(propertyValue
							.getValue("TL4")));

			Assert.assertTrue("FuelSurcharge - 'atLeastValue' ::",
					fuelSurcharge
							.verifyGlobalSurchargeAtLeastValue(propertyValue
									.getValue("lowRange5")));
			Assert.assertTrue("FuelSurcharge - 'butLessThanValue' ::",
					fuelSurcharge
							.verifyGlobalSurchargeAtLeastValue(propertyValue
									.getValue("highRange5")));
			Assert.assertTrue("FuelSurcharge - 'ltlValue' ::", fuelSurcharge
					.verifyGlobalSurchargeAtLeastValue(propertyValue
							.getValue("LTL5")));
			Assert.assertTrue("FuelSurcharge - 'tlValue' ::", fuelSurcharge
					.verifyGlobalSurchargeAtLeastValue(propertyValue
							.getValue("TL5")));

			fuelSurcharge.deletingGlobalRows(propertyValue.getValue("TL1"));
			fuelSurcharge.deletingGlobalRows(propertyValue.getValue("TL2"));
			fuelSurcharge.deletingGlobalRows(propertyValue.getValue("TL3"));
			fuelSurcharge.deletingGlobalRows(propertyValue.getValue("TL4"));
			fuelSurcharge.deletingGlobalRows(propertyValue.getValue("TL5"));

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