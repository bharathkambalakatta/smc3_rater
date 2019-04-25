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
	
	// MANAGE SETTINGS page - Elements present in 'Custom Setting' section -
	// When setting is opened - Data Module sub-section
	@FindBy(xpath = "//div[@id='ajax-loader']/img")
	private WebElement loadingImage;
	
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

	public CustomSetting(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
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