package com.dreamorbit.SMC3_Rater.pages;

import org.apache.log4j.Logger;
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
import com.dreamorbit.SMC3_Rater.testutils.RaterTestUtils;

public class CustomSetting extends TestBase {

	public static final Logger logger = Logger.getLogger(CustomSetting.class
			.getName());

	PropertyFileUtility propertyValue = new PropertyFileUtility("./Files/"
			+ "/DataFile.properties");

	WebDriver driver;

	@FindBy(xpath = "//div[@id='ajax-loader']/img")
	private WebElement loadingImage;

	// MANAGE SETTINGS page - Custom Setting - Setting table - When a
	// setting is opened - Data Module section - Web Elements
	@FindBy(xpath = "//div[@class='data-module-container']//div[@class='checkbox discount-link']//label")
	private WebElement toggleForDataModule;

	@FindBy(xpath = "//select[@id='rater-family']")
	private WebElement RateFamilyDropDown;

	@FindBy(xpath = "//select[@id='rater-tariff']")
	private WebElement availableTariffsDropDown;

	// MANAGE SETTINGS page - Custom Setting - Setting table - When a
	// setting is opened - Discounts section - Web Elements
	@FindBy(xpath = "//div[@id='carrier']//div[@class='discount-box']//div[@class='checkbox discount-link']//label")
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

	// MANAGE SETTINGS page - Custom Setting - Setting table - When a
	// setting is opened - Constant Class section - Web Elements
	@FindBy(xpath = "//div[@id='custom-constant-box']//div[@class='checkbox discount-link']//label")
	private WebElement toggleForConstantClass;

	@FindBy(xpath = "//select[@id='constantSelect1']")
	private WebElement constantClassDropDown;

	// MANAGE SETTINGS page - Custom Setting - Setting table - When a
	// setting is opened - Constant ZIPS section - Web Elements
	@FindBy(xpath = "//div[@id='custom-zip-box']//div[@class='checkbox discount-link']//label")
	private WebElement toggleForConstantZIPS;

	@FindBy(xpath = "//input[@id='originZip']")
	private WebElement originZIPTextBox;

	@FindBy(xpath = "//input[@id='destinationZip']")
	private WebElement destinationZIPTextBox;

	// MANAGE SETTINGS page - Custom Setting - Setting table - When a
	// setting is opened - FAK section - Web Elements
	@FindBy(xpath = "//div[@id='fakbox']//div[@class='checkbox discount-link']//label")
	private WebElement toggleForFAK;

	@FindBy(xpath = "//select[@id='c50']")
	private WebElement class50DropDown;

	@FindBy(xpath = "//select[@id='c55']")
	private WebElement class55DropDown;

	@FindBy(xpath = "//select[@id='c60']")
	private WebElement class60DropDown;

	@FindBy(xpath = "//select[@id='c65']")
	private WebElement class65DropDown;

	public CustomSetting(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// MANAGE SETTINGS page - Custom Setting - Setting table - When a
	// setting is opened - Data Module section - Functions
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
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(RateFamilyDropDown));
		Select select = new Select(RateFamilyDropDown);
		select.selectByVisibleText(rateFamily);
		Thread.sleep(2000);// Wait is required till next drop down is loaded
		wait.until(ExpectedConditions.visibilityOf(availableTariffsDropDown));
		Select select1 = new Select(availableTariffsDropDown);
		select1.selectByVisibleText(availableTariffs);
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - User has entered 'Data Module' details");
	}

	// MANAGE SETTINGS page - Custom Setting - Setting table - When a
	// setting is opened - Discounts section - Functions
	public void clickingOnTogglePresentForDiscounts() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(toggleForDiscounts))
				.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - User has clicked on toggle present for 'Discounts'");
	}

	public void enteringSingleDiscountsDetails(String discount,
			String mcDiscount, String mcFloor) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(discountTextBox));
		discountTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(1000);// Value is setting back to 0.00 without wait
		discountTextBox.sendKeys(Keys.chord(Keys.DELETE));
		discountTextBox.sendKeys(discount);
		wait.until(ExpectedConditions.elementToBeClickable(mcDiscountTextBox));
		mcDiscountTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(1000);// Value is setting back to 0.00 without wait
		mcDiscountTextBox.sendKeys(Keys.chord(Keys.DELETE));
		mcDiscountTextBox.sendKeys(mcDiscount);
		wait.until(ExpectedConditions.elementToBeClickable(mcFloorTextBox));
		mcFloorTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(1000);// Value is setting back to 0.00 without wait
		mcFloorTextBox.sendKeys(Keys.chord(Keys.DELETE));
		mcFloorTextBox.sendKeys(mcFloor);
		discountTextBox.click();// Added to handle inconsistent behavior with
								// mcFloorTextBox
		Thread.sleep(2000);// Required for Firefox browser

		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - User has entered 'Single Discount' details");
	}

	public void clickingOnMultipleDiscountOption() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(multipleOption));
		multipleOption.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - User has clicked on 'Multiple' option");
	}

	public void enteringMultipleDiscountsDetails(String l5c, String m5c,
			String m1m, String m2m, String m5m, String m10m, String m20m,
			String m30m, String m40m, String mc, String mcFloor) {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);

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

		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - User has entered 'Multiple Discount' details");
	}

	public void clickingOnSaveMultipleDiscountButton() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions
				.elementToBeClickable(saveMultipleDiscountButton));
		saveMultipleDiscountButton.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - User has saved 'Multiple Discount' details");
	}

	public void clickingOnEditMultipleDiscountButton() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		wait.until(ExpectedConditions
				.elementToBeClickable(editMultipleDiscountButton));
		editMultipleDiscountButton.click();
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - User has clicked on 'Edit' multiple discount details");
	}

	// MANAGE SETTINGS page - Custom Setting - Setting table - When a
	// setting is opened - Constant Class section - Functions
	public void clickingOnTogglePresentForConstantClass() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(
				ExpectedConditions.elementToBeClickable(toggleForConstantClass))
				.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - User has clicked on toggle present for 'Constant Class'");
	}

	public void enteringConstantClassDetails(String constantClass)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.visibilityOf(constantClassDropDown));
		Select select = new Select(constantClassDropDown);
		select.selectByVisibleText(constantClass);
		Thread.sleep(2000);// Value is setting back to default without wait
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - User has selected a 'Constant Class'");
	}

	// MANAGE SETTINGS page - Custom Setting - Setting table - When a
	// setting is opened - Constant ZIPS section - Functions
	public void clickingOnTogglePresentForConstantZIPS() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(
				ExpectedConditions.elementToBeClickable(toggleForConstantZIPS))
				.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - User has clicked on toggle present for 'Constant ZIPS'");
	}

	public void enteringConstantZIPSDetails(String originZIP,
			String destinationZIP) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(originZIPTextBox));
		originZIPTextBox.clear();
		originZIPTextBox.sendKeys(originZIP);
		Thread.sleep(2000);// Value is not getting set without wait in Firefox
		wait.until(ExpectedConditions
				.elementToBeClickable(destinationZIPTextBox));
		destinationZIPTextBox.clear();
		destinationZIPTextBox.sendKeys(destinationZIP);
		Thread.sleep(2000);// Value is not getting set without wait in Firefox
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - User has entered 'Constant ZIPS' details");
	}

	// MANAGE SETTINGS page - Custom Setting - Setting table - When a
	// setting is opened - FAK section - Functions
	public void clickingOnTogglePresentForFAK() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(toggleForFAK))
				.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - User has clicked on toggle present for 'FAK'");
	}

	public void enteringFAKDetails(String class50, String class55,
			String class60, String class65) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(class50DropDown));
		Thread.sleep(2000);// Value is not getting set without wait
		Select select = new Select(class50DropDown);
		select.selectByVisibleText(class50);
		wait.until(ExpectedConditions.elementToBeClickable(class55DropDown));
		Select select1 = new Select(class55DropDown);
		select1.selectByVisibleText(class55);
		wait.until(ExpectedConditions.elementToBeClickable(class60DropDown));
		Select select2 = new Select(class60DropDown);
		select2.selectByVisibleText(class60);
		wait.until(ExpectedConditions.elementToBeClickable(class65DropDown));
		Select select3 = new Select(class65DropDown);
		select3.selectByVisibleText(class65);
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - User has entered 'FAK' details");
	}
}