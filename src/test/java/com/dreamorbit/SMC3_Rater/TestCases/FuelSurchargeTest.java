package com.dreamorbit.SMC3_Rater.TestCases;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.After;
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

	public static final Logger logger = Logger.getLogger(FuelSurchargeTest.class.getName());

	PropertyFileUtility propertyValue = new PropertyFileUtility("./Files/" + "/DataFile.properties");

	LoginPage loginToApplication;
	RateAShipment rateAShipment;
	ManageSettings manageSettings;
	FuelSurcharge fuelSurcharge;
	String lowRange1= propertyValue.getValue("lowRange1");



	@Before
	public void setUp() throws IOException {
		initialization();
		loginToApplication = new LoginPage(driver);
		rateAShipment = new RateAShipment(driver);
		manageSettings = new ManageSettings(driver);
		fuelSurcharge = new FuelSurcharge(driver);
	}

	/*
	 * 19. Procedure to Create Global Fuel surcharge
	 */
	@Test
	public void verifyCreateGlobalFuelSurchargeTest() throws Exception {
		try {
			loginToApplication.LoginToApplication(propertyValue.getValue("loginUserName"),
					propertyValue.getValue("loginPassword"));

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			fuelSurcharge.clickGlobalSurchargeTab();
			// Entering 1st Test data
			
			fuelSurcharge.clickAddNewRow();
			fuelSurcharge.fillGlobalSurchargeFields(propertyValue.getValue("lowRange1"),
					propertyValue.getValue("highRange1"), propertyValue.getValue("LTL1"),
					propertyValue.getValue("TL1"));
			fuelSurcharge.saveGlobalSurchargeFields();
			
			// Filling 2nd Test data
			fuelSurcharge.clickAddNewRow();
			fuelSurcharge.fillGlobalSurchargeFields(propertyValue.getValue("lowRange2"),
					propertyValue.getValue("highRange2"), propertyValue.getValue("LTL2"),
					propertyValue.getValue("TL2"));
			fuelSurcharge.saveGlobalSurchargeFields();
			// Filling 3nd Test data
			fuelSurcharge.clickAddNewRow();
			fuelSurcharge.fillGlobalSurchargeFields(propertyValue.getValue("lowRange3"),
					propertyValue.getValue("highRange3"), propertyValue.getValue("LTL3"),
					propertyValue.getValue("TL3"));
			fuelSurcharge.saveGlobalSurchargeFields();
			// Filling 4th Test data
			fuelSurcharge.clickAddNewRow();
			fuelSurcharge.fillGlobalSurchargeFields(propertyValue.getValue("lowRange4"),
					propertyValue.getValue("highRange4"), propertyValue.getValue("LTL4"),
					propertyValue.getValue("TL4"));
			fuelSurcharge.saveGlobalSurchargeFields();
			// Filling 5th Test data
			fuelSurcharge.clickAddNewRow();
			fuelSurcharge.fillGlobalSurchargeFields(propertyValue.getValue("lowRange5"),
					propertyValue.getValue("highRange5"), propertyValue.getValue("LTL5"),
					propertyValue.getValue("TL5"));
			fuelSurcharge.saveGlobalSurchargeFields();
			
			//Verifying that created global surcharge is reflected under custom setting
			manageSettings.clickingOnDefaultSettingOption();
			fuelSurcharge.viewGlobalsurchargeclick();
			
			Assert.assertTrue(fuelSurcharge.verifyGlobalsurchargeLowRange1().isDisplayed());
			Assert.assertTrue(fuelSurcharge.verifyGlobalsurchargeHighRange1().isDisplayed());
			Assert.assertTrue(fuelSurcharge.verifyGlobalsurchargeLTL1().isDisplayed());
			Assert.assertTrue(fuelSurcharge.verifyGlobalsurchargeTL1().isDisplayed());
			logger.info("MESSAGE :: The 1st set of data is verfied in Global surchage section under default settings");
			
			Assert.assertTrue(fuelSurcharge.verifyGlobalsurchargeLowRange2().isDisplayed());
			Assert.assertTrue(fuelSurcharge.verifyGlobalsurchargeHighRange2().isDisplayed());
			Assert.assertTrue(fuelSurcharge.verifyGlobalsurchargeLTL2().isDisplayed());
			Assert.assertTrue(fuelSurcharge.verifyGlobalsurchargeTL2().isDisplayed());
			logger.info("MESSAGE :: The 2nd set of data is verfied in Global surchage section under default settings");
			
			Assert.assertTrue(fuelSurcharge.verifyGlobalsurchargeLowRange3().isDisplayed());
			Assert.assertTrue(fuelSurcharge.verifyGlobalsurchargeHighRange3().isDisplayed());
			Assert.assertTrue(fuelSurcharge.verifyGlobalsurchargeLTL3().isDisplayed());
			Assert.assertTrue(fuelSurcharge.verifyGlobalsurchargeTL3().isDisplayed());
			logger.info("MESSAGE :: The 3rd set of data is verfied in Global surchage section under default settings");
			
			Assert.assertTrue(fuelSurcharge.verifyGlobalsurchargeLowRange4().isDisplayed());
			Assert.assertTrue(fuelSurcharge.verifyGlobalsurchargeHighRange4().isDisplayed());
			Assert.assertTrue(fuelSurcharge.verifyGlobalsurchargeLTL4().isDisplayed());
			Assert.assertTrue(fuelSurcharge.verifyGlobalsurchargeTL4().isDisplayed());
			logger.info("MESSAGE :: The 4th set of data is verfied in Global surchage section under default settings");
			
			Assert.assertTrue(fuelSurcharge.verifyGlobalsurchargeLowRange5().isDisplayed());
			Assert.assertTrue(fuelSurcharge.verifyGlobalsurchargeHighRange5().isDisplayed());
			Assert.assertTrue(fuelSurcharge.verifyGlobalsurchargeLTL5().isDisplayed());
			Assert.assertTrue(fuelSurcharge.verifyGlobalsurchargeTL5().isDisplayed());
			logger.info("MESSAGE :: The 5th set of data is verfied in Global surchage section under default settings");
			
			
			//Deleting all the created global surcharge settings
			fuelSurcharge.delete1stSetData();
			fuelSurcharge.delete2ndSetData();
			fuelSurcharge.delete3rdSetData();
			fuelSurcharge.delete4thSetData();
			fuelSurcharge.delete5thSetData();
			logger.info("MESSAGE :: All the 5 set up are deleted");
			
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
			ExceptionalHandlingFunctions.captureScreenShot(driver,
					Thread.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(),
					Thread.currentThread().getStackTrace()[1].getMethodName());
			Assert.fail();
		}
	}
	@After
	public void close()
	{
		driver.close();
		
	}
}