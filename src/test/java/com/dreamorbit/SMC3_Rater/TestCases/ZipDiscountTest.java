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
	// @Test
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
			zipDiscount.clickingOnDiscountIDOption();
			zipDiscount.clickingOnCreateDiscountIDButton();
			zipDiscount.enteringDiscountID(propertyValue
					.getValue("discountID1"));
			zipDiscount.enteringDiscountIDDetails(
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
			zipDiscount.clickingOnSaveDiscountIDButton();
			zipDiscount.enteringDiscountID(propertyValue
					.getValue("discountID2"));
			zipDiscount.enteringDiscountIDDetails(
					propertyValue.getValue("l5c3"),
					propertyValue.getValue("m5c3"),
					propertyValue.getValue("m1m3"),
					propertyValue.getValue("m2m3"),
					propertyValue.getValue("m5m3"),
					propertyValue.getValue("m10m3"),
					propertyValue.getValue("m20m3"),
					propertyValue.getValue("m30m3"),
					propertyValue.getValue("m40m3"),
					propertyValue.getValue("mc3"),
					propertyValue.getValue("mcFloor3"));
			zipDiscount.clickingOnSaveDiscountIDButton();
			zipDiscount.clickingOnCreateRangeButton();
			zipDiscount.enteringOriginZipDetailsForPostalCodeType(
					propertyValue.getValue("type"),
					propertyValue.getValue("country"),
					propertyValue.getValue("zip1"),
					propertyValue.getValue("zip2"));
			zipDiscount.enteringDestinationZipDetailsForPostalCodeType(
					propertyValue.getValue("type"),
					propertyValue.getValue("country"),
					propertyValue.getValue("zip3"),
					propertyValue.getValue("zip4"));
			zipDiscount.selectDiscountID(propertyValue.getValue("discountID1"));
			zipDiscount.clickingOnSaveRangeButton();

			rateAShipment.clickingOnRateAShipmentTab();
			rateAShipment.selectSetting(customSettingDetails
					.getValue("customSettingID"));
			rateAShipment.selectRateFamily(propertyValue
					.getValue("rateFamily1"));
			rateAShipment.selectAvailableTariffs(propertyValue
					.getValue("availableTariffs1"));
			rateAShipment.enterOrigin(propertyValue.getValue("zip1"));
			rateAShipment.enterDestination(propertyValue.getValue("zip3"));
			rateAShipment.selectClass(propertyValue.getValue("class1"));
			rateAShipment.enterWeight(propertyValue.getValue("weight2"));
			rateAShipment.clickingOnRateShipmentButton();

			String actual = rateAShipment.verifyDiscountValueInTheTable();
			Assert.assertEquals("RateAShipmentPage - 'discountValue' ::",
					propertyValue.getValue("discount%"), actual);

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

	// 8. Edit a Setting with Zip Discount Test
	@Test
	public void verifyEditASettingWithZipDiscountTest() throws Exception {
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
			zipDiscount.clickingOnDiscountIDOption();
			zipDiscount.clickingOnCreateDiscountIDButton();
			zipDiscount.enteringDiscountID(propertyValue
					.getValue("discountID1"));
			zipDiscount.enteringDiscountIDDetails(
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
			zipDiscount.clickingOnSaveDiscountIDButton();
			zipDiscount.enteringDiscountID(propertyValue
					.getValue("discountID2"));
			zipDiscount.enteringDiscountIDDetails(
					propertyValue.getValue("l5c3"),
					propertyValue.getValue("m5c3"),
					propertyValue.getValue("m1m3"),
					propertyValue.getValue("m2m3"),
					propertyValue.getValue("m5m3"),
					propertyValue.getValue("m10m3"),
					propertyValue.getValue("m20m3"),
					propertyValue.getValue("m30m3"),
					propertyValue.getValue("m40m3"),
					propertyValue.getValue("mc3"),
					propertyValue.getValue("mcFloor3"));
			zipDiscount.clickingOnSaveDiscountIDButton();
			zipDiscount.clickingOnCreateRangeButton();
			zipDiscount.enteringOriginZipDetailsForPostalCodeType(
					propertyValue.getValue("type"),
					propertyValue.getValue("country"),
					propertyValue.getValue("zip1"),
					propertyValue.getValue("zip2"));
			zipDiscount.enteringDestinationZipDetailsForPostalCodeType(
					propertyValue.getValue("type"),
					propertyValue.getValue("country"),
					propertyValue.getValue("zip3"),
					propertyValue.getValue("zip4"));
			zipDiscount.selectDiscountID(propertyValue.getValue("discountID1"));
			zipDiscount.clickingOnSaveRangeButton();

			rateAShipment.clickingOnRateAShipmentTab();

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings
					.clickingOnArrowPresentForASetting(customSettingDetails
							.getValue("customSettingID"));

			zipDiscount.clickingOnZipDiscountButton();
			zipDiscount.verifyZipRangeOriginValue(propertyValue
					.getValue("originZipRange"));
			zipDiscount.verifyZipRangeDestinationValue(propertyValue
					.getValue("destinationZipRange"));
			zipDiscount.verifyZipRangeDiscountIDValueValue(propertyValue
					.getValue("discountID1"));
			zipDiscount.clickingOnEditZipRangeButton(propertyValue
					.getValue("originZipRange"));

			// manageSettings.clickingOnManageSettingsTab();
			// manageSettings.clickingOnCustomSettingOption();
			// manageSettings.deletingACustomSetting(customSettingDetails
			// .getValue("customSettingID"));

			logger.info("========== FINAL MESSAGE :: Edit a Setting with Zip Discount Test Executed Successfully ==========");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			ExceptionalHandlingFunctions.captureScreenShot(driver, Thread
					.currentThread().getStackTrace()[1].getMethodName());
			ExceptionalHandlingFunctions.writeTOLog(e.getMessage(), Thread
					.currentThread().getStackTrace()[1].getMethodName());
			Assert.fail();
		}
	}

	// 9. Zip Discount Range Overlap Test
	// @Test
	public void verifyZipDiscountRangeOverlapTest() throws Exception {
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
			zipDiscount.clickingOnDiscountIDOption();
			zipDiscount.clickingOnCreateDiscountIDButton();
			zipDiscount.enteringDiscountID(propertyValue
					.getValue("discountID1"));
			zipDiscount.enteringDiscountIDDetails(
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
			zipDiscount.clickingOnSaveDiscountIDButton();
			zipDiscount.enteringDiscountID(propertyValue
					.getValue("discountID2"));
			zipDiscount.enteringDiscountIDDetails(
					propertyValue.getValue("l5c3"),
					propertyValue.getValue("m5c3"),
					propertyValue.getValue("m1m3"),
					propertyValue.getValue("m2m3"),
					propertyValue.getValue("m5m3"),
					propertyValue.getValue("m10m3"),
					propertyValue.getValue("m20m3"),
					propertyValue.getValue("m30m3"),
					propertyValue.getValue("m40m3"),
					propertyValue.getValue("mc3"),
					propertyValue.getValue("mcFloor3"));
			zipDiscount.clickingOnSaveDiscountIDButton();
			zipDiscount.clickingOnCreateRangeButton();
			zipDiscount.enteringOriginZipDetailsForPostalCodeType(
					propertyValue.getValue("type"),
					propertyValue.getValue("country"),
					propertyValue.getValue("zip1"),
					propertyValue.getValue("zip2"));
			zipDiscount.enteringDestinationZipDetailsForPostalCodeType(
					propertyValue.getValue("type"),
					propertyValue.getValue("country"),
					propertyValue.getValue("zip3"),
					propertyValue.getValue("zip4"));
			zipDiscount.selectDiscountID(propertyValue.getValue("discountID1"));
			zipDiscount.clickingOnSaveRangeButton();
			zipDiscount.clickingOnCancelRangeButton();
			zipDiscount.clickingOnCreateRangeButton();
			zipDiscount.enteringOriginZipDetailsForStateType(
					propertyValue.getValue("type2"),
					propertyValue.getValue("country"),
					propertyValue.getValue("state1"));
			zipDiscount.enteringDestinationZipDetailsForStateType(
					propertyValue.getValue("type2"),
					propertyValue.getValue("country"),
					propertyValue.getValue("state2"));
			zipDiscount.selectDiscountID(propertyValue.getValue("discountID1"));
			zipDiscount.clickingOnSaveRangeButton();

			String actual = zipDiscount.verifyErrorDisplayedForZipRange();
			Assert.assertEquals("ZipDiscount - 'errorBlock' ::",
					propertyValue.getValue("zipRangeError1"), actual);

			rateAShipment.clickingOnRateAShipmentTab();

			manageSettings.clickingOnManageSettingsTab();
			manageSettings.clickingOnCustomSettingOption();
			manageSettings.deletingACustomSetting(customSettingDetails
					.getValue("customSettingID"));

			logger.info("========== FINAL MESSAGE :: Zip Discount Range Overlap Test Executed Successfully ==========");

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