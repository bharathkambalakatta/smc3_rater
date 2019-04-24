package com.dreamorbit.SMC3_Rater.pages;

import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dreamorbit.SMC3_Rater.testbase.TestBase;
import com.dreamorbit.SMC3_Rater.testutils.PropertyFileUtility;
import com.dreamorbit.SMC3_Rater.testutils.PropertyFileWriteUtility;
import com.dreamorbit.SMC3_Rater.testutils.RaterTestUtils;

public class ManageSettings extends TestBase {

	public static final Logger logger = Logger
			.getLogger(ManageSettings.class.getName());

	PropertyFileUtility propertyValue = new PropertyFileUtility("./Files/"
			+ "/DataFile.properties");
	PropertyFileWriteUtility propertyKeyValue = new PropertyFileWriteUtility(
			"./Files/" + "/Test.properties");

	public final String manageSettingsTabName = "MANAGE SETTINGS";

	WebDriver driver;

	// MANAGE SETTINGS page - Elements present in the header
	@FindBy(xpath = "//a[contains(text(),'Manage Settings')]")
	WebElement manageSettingsTab;

	// MANAGE SETTINGS page - Elements present in 'Default Setting' section
	@FindBy(xpath = "//a[@id='defaultPanel']")
	private WebElement defaultSettingOption;

	@FindBy(xpath = "//div[@id='ajax-loader']/img")
	private WebElement loadingImage;

	@FindBy(xpath = "//div[@class='discount-box']//div[@class='form-group']")
	private WebElement toggleForDefaultDiscounts;

	@FindBy(xpath = "//input[@id='defaultdiscount']")
	private WebElement defaultDiscountTextBox;

	@FindBy(xpath = "//input[@id='mcdis']")
	private WebElement defaultMCDiscountTextBox;

	@FindBy(xpath = "//input[@id='default-mcfloor']")
	private WebElement defaultMCFloorTextBox;

	@FindBy(xpath = "//div[@id='constant-class']//div[@class='form-group']")
	private WebElement toggleForDefaultConstantClass;

	@FindBy(xpath = "//select[@id='constantDefault1']")
	private WebElement defaultClassDropDown;

	@FindBy(xpath = "//div[@id='zipInfo']//div[@class='form-group']")
	private WebElement toggleForDefaultConstantZIPs;

	@FindBy(xpath = "//input[@id='orgZip']")
	private WebElement defaultOriginZIPTextBox;

	@FindBy(xpath = "//input[@id='desZip']")
	private WebElement defaultDestinationZIPTextBox;

	// MANAGE SETTINGS page - Elements present in 'Custom Setting' section
	@FindBy(xpath = "//a[@id='custom-set-button']")
	private WebElement customSettingOption;

	// MANAGE SETTINGS page - Elements present in 'Custom Setting' section -
	// Setting table
	@FindBy(xpath = "//div[@class='card-header add-header custom-row active']//*[contains(text(),'Add New Row')]")
	private WebElement addNewRowButton;

	@FindBy(xpath = "//input[@id='settingName-1']")
	private WebElement settingIDTextBox;

	@FindBy(xpath = "//input[@id='description-1']")
	private WebElement descriptionTextBox;

	@FindBy(xpath = "//tr[@id='trCust-1 ']//div[3]")
	private WebElement saveButton;

	@FindBy(xpath = "//tr[1]/td[1]//img[@class='arrow-one']")
	private WebElement arrowPresentInFirstRow;

	@FindBy(xpath = "//tr[1]/td[5]//a[@class='delete-row custom']")
	private WebElement deleteButton;

	// String settingFromFile = propertyValue.getValue("settingName");
	// @FindBy(xpath =
	// "//span[contains(text(),'+settingFromFile+')]/parent::div/parent::td/following-sibling::td[4]//a[@class='delete-row custom']")
	// private WebElement deleteButton;

	// MANAGE SETTINGS page - Elements present in 'Custom Setting' section -
	// When setting is opened
	@FindBy(xpath = "//span[@id='settingName']")
	private WebElement settingName;

	// MANAGE SETTINGS page - Elements present in 'Custom Setting' section -
	// When setting is opened - Data Module sub-section
	@FindBy(xpath = "//div[@class='data-module-container']//div[@class='form-group']")
	private WebElement toggleForDataModule;

	@FindBy(xpath = "//select[@id='rater-family']")
	private WebElement RateFamilyDropDown;

	@FindBy(xpath = "//select[@id='rater-tariff']")
	private WebElement availableTariffsDropDown;

	// MANAGE SETTINGS page - Elements present in 'Custom Setting' section -
	// When setting is opened - Discounts sub-section
	@FindBy(xpath = "//div[@id='carrier']//div[@class='discount-box']//div[@class='form-group']")
	private WebElement toggleForDiscounts;

	@FindBy(xpath = "//input[@id='custdiscount']")
	private WebElement discountTextBox;

	@FindBy(xpath = "//input[@id='mcdiscount']")
	private WebElement mcDiscountTextBox;

	@FindBy(xpath = "//input[@id='singleMcfloor']")
	private WebElement mcFloorTextBox;

	@FindBy(xpath = "//a[@class='btn btn-responsive bar-class multiple-padding']")
	private WebElement multipleOption;

	@FindBy(xpath = "//input[@id='l5c']")
	private WebElement l5cTextBox;

	@FindBy(xpath = "//input[@id='m5c']")
	private WebElement m5cTextBox;

	@FindBy(xpath = "//input[@id='m1m']")
	private WebElement m1mTextBox;

	@FindBy(xpath = "//input[@id='m2m']")
	private WebElement m2mTextBox;

	@FindBy(xpath = "//input[@id='m5m']")
	private WebElement m5mTextBox;

	@FindBy(xpath = "//input[@id='m10m']")
	private WebElement m10mTextBox;

	@FindBy(xpath = "//input[@id='m20m']")
	private WebElement m20mTextBox;

	@FindBy(xpath = "//input[@id='m30m']")
	private WebElement m30mTextBox;

	@FindBy(xpath = "//input[@id='m40m']")
	private WebElement m40mTextBox;

	@FindBy(xpath = "//input[@id='mc']")
	private WebElement mcTextBox;

	@FindBy(xpath = "//input[@id='mcfloor']")
	private WebElement mcFloorMultipleTextBox;

	@FindBy(xpath = "//div[@class='card-header add-header cust-multiple-disc show-table']//a[@title='Update']")
	private WebElement saveMultipleDiscountButton;

	@FindBy(xpath = "//div[@class='card-header add-header cust-multiple-disc show-table']//img[@class='img img-responsive']")
	private WebElement editMultipleDiscountButton;

	public ManageSettings(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// MANAGE SETTINGS page - Various functions which are used in the test cases
	public void clickingOnManageSettingsTab() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(manageSettingsTab))
				.click();
		logger.info("MESSAGE :: User has clicked on 'MANAGE SETTINGS' Tab");
	}

	// MANAGE SETTINGS page - Default Setting - Various functions which are used
	// in the test cases
	public void clickingOnDefaultSettingOption() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(
				ExpectedConditions.elementToBeClickable(defaultSettingOption))
				.click();
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - User has clicked on 'Default Setting' option");
	}

	public void enteringDefaultDiscountsDetails(String discount,
			String mcDiscount, String mcFloor) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions
				.elementToBeClickable(toggleForDefaultDiscounts));
		Thread.sleep(1000);
		if (defaultDiscountTextBox.isDisplayed()) {
			wait.until(ExpectedConditions
					.elementToBeClickable(defaultDiscountTextBox));
			defaultDiscountTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(1000);
			defaultDiscountTextBox.sendKeys(Keys.chord(Keys.DELETE));
			defaultDiscountTextBox.sendKeys(discount);
			wait.until(ExpectedConditions
					.elementToBeClickable(defaultMCDiscountTextBox));
			defaultMCDiscountTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(1000);
			defaultMCDiscountTextBox.sendKeys(Keys.chord(Keys.DELETE));
			defaultMCDiscountTextBox.sendKeys(mcDiscount);
			wait.until(ExpectedConditions
					.elementToBeClickable(defaultMCFloorTextBox));
			defaultMCFloorTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(1000);
			defaultMCFloorTextBox.sendKeys(Keys.chord(Keys.DELETE));
			defaultMCFloorTextBox.sendKeys(mcFloor);
		} else {
			toggleForDefaultDiscounts.click();
			wait.until(ExpectedConditions
					.elementToBeClickable(defaultDiscountTextBox));
			defaultDiscountTextBox.sendKeys(discount);
			wait.until(ExpectedConditions
					.elementToBeClickable(defaultMCDiscountTextBox));
			defaultMCDiscountTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(1000);
			defaultMCDiscountTextBox.sendKeys(Keys.chord(Keys.DELETE));
			defaultMCDiscountTextBox.sendKeys(mcDiscount);
			wait.until(ExpectedConditions
					.elementToBeClickable(defaultMCFloorTextBox));
			defaultMCFloorTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			Thread.sleep(1000);
			defaultMCFloorTextBox.sendKeys(Keys.chord(Keys.DELETE));
			defaultMCFloorTextBox.sendKeys(mcFloor);
		}
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Default Setting - User has entered 'Discount' details");
	}

	public void enteringDefaultConstantClassDetails(String constantClass)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions
				.visibilityOf(toggleForDefaultConstantClass));
		if (defaultClassDropDown.isDisplayed()) {
			Select select = new Select(defaultClassDropDown);
			select.selectByVisibleText(constantClass);
			Thread.sleep(1000);
		} else {
			toggleForDefaultConstantClass.click();
			wait.until(ExpectedConditions.visibilityOf(defaultClassDropDown));
			Select select = new Select(defaultClassDropDown);
			select.selectByVisibleText(constantClass);
			Thread.sleep(1000);
		}
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Default Setting - User has entered 'Constant Class' details");
	}

	public void enteringDefaultConstantZIPSDetails(String originZIP,
			String destinationZIP) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions
				.visibilityOf(toggleForDefaultConstantZIPs));
		if (defaultOriginZIPTextBox.isDisplayed()) {
			wait.until(ExpectedConditions
					.elementToBeClickable(defaultOriginZIPTextBox));
			defaultOriginZIPTextBox.clear();
			defaultOriginZIPTextBox.sendKeys(originZIP);
			wait.until(ExpectedConditions
					.elementToBeClickable(defaultDestinationZIPTextBox));
			defaultDestinationZIPTextBox.clear();
			Thread.sleep(2000);
			defaultDestinationZIPTextBox.sendKeys(destinationZIP);
		} else {
			toggleForDefaultConstantZIPs.click();
			wait.until(ExpectedConditions
					.elementToBeClickable(defaultOriginZIPTextBox));
			defaultDestinationZIPTextBox.click();
			defaultOriginZIPTextBox.sendKeys(originZIP);
			wait.until(ExpectedConditions
					.elementToBeClickable(defaultDestinationZIPTextBox));
			defaultDestinationZIPTextBox.click();
			Thread.sleep(2000);
			defaultDestinationZIPTextBox.sendKeys(destinationZIP);
		}
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Default Setting - User has entered 'Constant ZIPS' details");
	}

	public void makingDefaultDiscountsToggleOff() throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.visibilityOf(toggleForDefaultDiscounts));
		toggleForDefaultDiscounts.click();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Default Setting - 'Discount' section toggle has been set to OFF");
	}

	public void makingDefaultConstantClassToggleOff()
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions
				.visibilityOf(toggleForDefaultConstantClass));
		toggleForDefaultConstantClass.click();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Default Setting - 'Constant Class' section toggle has been set to OFF");
	}

	public void makingDefaultConstantZIPSToggleOff()
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions
				.visibilityOf(toggleForDefaultConstantZIPs));
		toggleForDefaultConstantZIPs.click();
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Default Setting - 'Constant ZIPS' section toggle has been set to OFF");
	}

	// MANAGE SETTINGS page - Custom Setting - Various functions which are used
	// in the test cases
	public void clickingOnCustomSettingOption() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(customSettingOption))
				.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - User has clicked on 'Custom Setting' option");
	}

	// MANAGE SETTINGS page - Custom Setting - Setting table - Various functions
	// which are used in the test cases
	public void generatingAndStoringARandomSettingName() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(999999);
		String randomString = "Setting" + Integer.toString(randomInt);
		propertyKeyValue.setValue("settingName", randomString);
	}

	public void addingACustomSetting(String settingID, String description)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", addNewRowButton);
		wait.until(ExpectedConditions.visibilityOf(settingIDTextBox));
		settingIDTextBox.sendKeys(settingID);
		wait.until(ExpectedConditions.visibilityOf(descriptionTextBox));
		descriptionTextBox.sendKeys(description);
		wait.until(ExpectedConditions.elementToBeClickable(saveButton));
		saveButton.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		wait.until(ExpectedConditions.visibilityOf(settingName));
		Thread.sleep(2000);// Required for Firefox browser
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - User has added a new custom setting");
	}

	public void clickingOnArrowPresentInFirstRow() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(
				ExpectedConditions.elementToBeClickable(arrowPresentInFirstRow))
				.click();
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - User has opened the custom setting");
	}

	public void deletingACustomSetting() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(deleteButton))
				.click();
		driver.switchTo().alert().accept();
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - User has deleted a custom setting");
	}

	// MANAGE SETTINGS page - Custom Setting - Data Module - Various functions
	// which are used in the test cases
	public void clickingOnTogglePresentForDataModule() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(toggleForDataModule))
				.click();
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - User has clicked on toggle present for 'Data Module'");
	}

	public void settingUpDataModule(String rateFamily, String availableTariffs)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.visibilityOf(RateFamilyDropDown));
		Thread.sleep(1000);
		Select select = new Select(RateFamilyDropDown);
		select.selectByVisibleText(rateFamily);
		wait.until(ExpectedConditions.visibilityOf(availableTariffsDropDown));
		// wait.until(ExpectedConditions.attributeContains(By.xpath("//select[@id='rater-tariff']/option[text()='LITECZ02 20140915']"),
		// "LITECZ02 20140915", "value"));
		// Thread.sleep(1000);
		Select select1 = new Select(availableTariffsDropDown);
		select1.selectByVisibleText(availableTariffs);
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - User has entered 'Data Module' details");
	}

	// MANAGE SETTINGS page - Custom Setting - Discounts - Various functions
	// which are used in the test cases
	public void clickingOnTogglePresentForDiscounts() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(toggleForDiscounts))
				.click();
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - User has clicked on toggle present for 'Discounts'");
	}

	public void enteringSingleDiscountsDetails(String discount,
			String mcDiscount, String mcFloor) {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(discountTextBox));
		discountTextBox.sendKeys(discount);
		wait.until(ExpectedConditions.elementToBeClickable(mcDiscountTextBox));
		mcDiscountTextBox.clear();
		mcDiscountTextBox.sendKeys(mcDiscount);
		wait.until(ExpectedConditions.elementToBeClickable(mcFloorTextBox));
		mcFloorTextBox.clear();
		mcFloorTextBox.sendKeys(mcFloor);
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - User has entered 'Discount' details");
	}

	public void enteringMultipleDiscountsDetails(String l5c, String m5c,
			String m1m, String m2m, String m5m, String m10m, String m20m,
			String m30m, String m40m, String mc, String mcFloor) {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(multipleOption));
		multipleOption.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));

		wait.until(ExpectedConditions.elementToBeClickable(l5cTextBox));
		l5cTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		l5cTextBox.sendKeys(Keys.chord(Keys.DELETE));
		l5cTextBox.sendKeys(l5c);

		wait.until(ExpectedConditions.elementToBeClickable(m5cTextBox));
		m5cTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		m5cTextBox.sendKeys(Keys.chord(Keys.DELETE));
		m5cTextBox.sendKeys(m5c);

		wait.until(ExpectedConditions.elementToBeClickable(m1mTextBox));
		m1mTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		m1mTextBox.sendKeys(Keys.chord(Keys.DELETE));
		m1mTextBox.sendKeys(m1m);

		wait.until(ExpectedConditions.elementToBeClickable(m2mTextBox));
		m2mTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		m2mTextBox.sendKeys(Keys.chord(Keys.DELETE));
		m2mTextBox.sendKeys(m2m);

		wait.until(ExpectedConditions.elementToBeClickable(m5mTextBox));
		m5mTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		m5mTextBox.sendKeys(Keys.chord(Keys.DELETE));
		m5mTextBox.sendKeys(m5m);

		wait.until(ExpectedConditions.elementToBeClickable(m10mTextBox));
		m10mTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		m10mTextBox.sendKeys(Keys.chord(Keys.DELETE));
		m10mTextBox.sendKeys(m10m);

		wait.until(ExpectedConditions.elementToBeClickable(m20mTextBox));
		m20mTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		m20mTextBox.sendKeys(Keys.chord(Keys.DELETE));
		m20mTextBox.sendKeys(m20m);

		wait.until(ExpectedConditions.elementToBeClickable(m30mTextBox));
		m30mTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		m30mTextBox.sendKeys(Keys.chord(Keys.DELETE));
		m30mTextBox.sendKeys(m30m);

		wait.until(ExpectedConditions.elementToBeClickable(m40mTextBox));
		m40mTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		m40mTextBox.sendKeys(Keys.chord(Keys.DELETE));
		m40mTextBox.sendKeys(m40m);

		wait.until(ExpectedConditions.elementToBeClickable(mcTextBox));
		mcTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		mcTextBox.sendKeys(Keys.chord(Keys.DELETE));
		mcTextBox.sendKeys(mc);

		wait.until(ExpectedConditions
				.elementToBeClickable(mcFloorMultipleTextBox));
		mcFloorMultipleTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		mcFloorMultipleTextBox.sendKeys(Keys.chord(Keys.DELETE));
		mcFloorMultipleTextBox.sendKeys(mcFloor);
	}

	public void clickingOnSaveMultipleDiscountButton() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions
				.elementToBeClickable(saveMultipleDiscountButton));
		saveMultipleDiscountButton.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
	}

	public void clickingOnEditMultipleDiscountButton() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		wait.until(ExpectedConditions
				.elementToBeClickable(editMultipleDiscountButton));
		editMultipleDiscountButton.click();
	}
}
