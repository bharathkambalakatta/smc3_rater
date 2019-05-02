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

public class ZipDiscount extends TestBase {

	public static final Logger logger = Logger.getLogger(ZipDiscount.class
			.getName());

	PropertyFileUtility propertyValue = new PropertyFileUtility("./Files/"
			+ "/DataFile.properties");

	@FindBy(xpath = "//button[contains(text(),'Zip Discount')]")
	private WebElement zipDiscountButton;

	@FindBy(xpath = "//div[@id='ajax-loader']/img")
	private WebElement loadingImage;

	@FindBy(xpath = "//h6[contains(text(),'Discount ID (ZIP)')]/parent::a")
	private WebElement discountIDButton;

	@FindBy(xpath = "//button[@class='btn btn-responsive submit-btn create-btn cancel']")
	private WebElement createDiscountIDButton;

	@FindBy(xpath = "//input[@id='discountName']")
	private WebElement discountIDTextBox;

	@FindBy(xpath = "//input[@id='zip-l5c']")
	private WebElement l5cTextBox;

	@FindBy(xpath = "//input[@id='zip-m5c']")
	private WebElement m5cTextBox;

	@FindBy(xpath = "//input[@id='zip-m1m']")
	private WebElement m1mTextBox;

	@FindBy(xpath = "//input[@id='zip-m2m']")
	private WebElement m2mTextBox;

	@FindBy(xpath = "//input[@id='zip-m5m']")
	private WebElement m5mTextBox;

	@FindBy(xpath = "//input[@id='zip-m10']")
	private WebElement m10mTextBox;

	@FindBy(xpath = "//input[@id='zip-m20m']")
	private WebElement m20mTextBox;

	@FindBy(xpath = "//input[@id='zip-m30m']")
	private WebElement m30mTextBox;

	@FindBy(xpath = "//input[@id='zip-m40m']")
	private WebElement m40mTextBox;

	@FindBy(xpath = "//input[@id='zip-mc']")
	private WebElement mcTextBox;

	@FindBy(xpath = "//input[@id='zip-mcfloor']")
	private WebElement mcFloorTextBox;

	@FindBy(xpath = "//a[@title='Save/Add']")
	private WebElement saveDiscountIDButton;

	@FindBy(xpath = "//button[@class='btn btn-responsive submit-btn create-range-btn cancel']")
	private WebElement createRangeButton;

	@FindBy(xpath = "//select[@id='createOrgSelect']")
	private WebElement originTypeDropDown;

	@FindBy(xpath = "//select[@id='createCountrySelect']")
	private WebElement originCountryDropDown;
	
	@FindBy(xpath = "//select[@id='new-origin-Select']")
	private WebElement originStateDropDown;
	
	@FindBy(xpath = "//input[@id='originL']")
	private WebElement originLTextBox;

	@FindBy(xpath = "//input[@id='originH']")
	private WebElement originHTextBox;

	@FindBy(xpath = "//select[@id='createDestiSelect']")
	private WebElement destinationTypeDropDown;

	@FindBy(xpath = "//select[@id='createCountryList']")
	private WebElement destinationCountryDropDown;
	
	@FindBy(xpath = "//select[@id='new-destination-Select']")
	private WebElement destinationStateDropDown;

	@FindBy(xpath = "//input[@id='destinationL']")
	private WebElement destinationLTextBox;

	@FindBy(xpath = "//input[@id='destinationH']")
	private WebElement destinationHTextBox;

	@FindBy(xpath = "//select[@id='rangeDisId']")
	private WebElement discountIDDropDown;

	@FindBy(xpath = "//button[@class='btn btn-responsive submit-btn zip-range-btn create-range']")
	private WebElement saveRangeButton;
	
	@FindBy(xpath = "//button[@class='btn btn-responsive submit-btn common-enable cancel-range-btn cancel']")
	private WebElement cancelRangeButton;

	WebDriver driver;

	public ZipDiscount(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickingOnZipDiscountButton() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(zipDiscountButton))
				.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - User has clicked on 'Zip Discount' button");
	}

	public void clickingOnDiscountIDOption() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(discountIDButton))
				.click();
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - Zip Discount - User has clicked on 'Discount ID (ZIP)' button");
	}

	public void clickingOnCreateDiscountIDButton() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(
				ExpectedConditions.elementToBeClickable(createDiscountIDButton))
				.click();
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - Zip Discount - User has clicked on 'Create' Discount ID button");
	}

	public void enteringDiscountID(String discountID) {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(discountIDTextBox));
		discountIDTextBox.sendKeys(discountID);
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - Zip Discount - User has entered 'Discount ID'");
	}

	public void enteringDiscountIDDetails(String l5c, String m5c, String m1m,
			String m2m, String m5m, String m10m, String m20m, String m30m,
			String m40m, String mc, String mcFloor) {
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

		wait.until(ExpectedConditions.elementToBeClickable(mcFloorTextBox));
		mcFloorTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		mcFloorTextBox.sendKeys(Keys.chord(Keys.DELETE));
		mcFloorTextBox.sendKeys(mcFloor);

		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - Zip Discount - User has entered 'Discount ID' details");
	}

	public void clickingOnSaveDiscountIDButton() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions
				.elementToBeClickable(saveDiscountIDButton));
		saveDiscountIDButton.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - Zip Discount - User has saved 'Discount ID' details");
	}

	public void clickingOnCreateRangeButton() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		wait.until(ExpectedConditions.elementToBeClickable(createRangeButton))
				.click();
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - Zip Discount - User has clicked on 'Create' Range button");
	}

	public void enteringOriginZipDetailsForPostalCodeType(String type, String country,
			String zip1, String zip2) {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(originTypeDropDown));
		Select select = new Select(originTypeDropDown);
		select.selectByVisibleText(type);
		wait.until(ExpectedConditions
				.elementToBeClickable(originCountryDropDown));
		Select select1 = new Select(originCountryDropDown);
		select1.selectByVisibleText(country);
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		wait.until(ExpectedConditions.elementToBeClickable(originLTextBox));
		originLTextBox.sendKeys(zip1);
		wait.until(ExpectedConditions.elementToBeClickable(originHTextBox));
		originHTextBox.sendKeys(zip2);
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - Zip Discount - User has entered 'Origin ZIP' details for Postal Code type");
	}
	
	public void enteringOriginZipDetailsForStateType(String type, String country,
			String state) {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(originTypeDropDown));
		Select select = new Select(originTypeDropDown);
		select.selectByVisibleText(type);
		wait.until(ExpectedConditions
				.elementToBeClickable(originCountryDropDown));
		Select select1 = new Select(originCountryDropDown);
		select1.selectByVisibleText(country);
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		wait.until(ExpectedConditions
				.elementToBeClickable(originStateDropDown));
		Select select2 = new Select(originStateDropDown);
		select2.selectByVisibleText(state);	
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - Zip Discount - User has entered 'Origin ZIP' details for State type");
	}

	public void enteringDestinationZipDetailsForPostalCodeType(String type, String country,
			String zip1, String zip2) {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions
				.elementToBeClickable(destinationTypeDropDown));
		Select select = new Select(destinationTypeDropDown);
		select.selectByVisibleText(type);
		wait.until(ExpectedConditions
				.elementToBeClickable(destinationCountryDropDown));
		Select select1 = new Select(destinationCountryDropDown);
		select1.selectByVisibleText(country);
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		wait.until(ExpectedConditions.elementToBeClickable(destinationLTextBox));
		destinationLTextBox.sendKeys(zip1);
		wait.until(ExpectedConditions.elementToBeClickable(destinationHTextBox));
		destinationHTextBox.sendKeys(zip2);
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - Zip Discount - User has entered 'Destination ZIP' details for Postal Code type");
	}

	public void enteringDestinationZipDetailsForStateType(String type, String country,
			String state) {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(destinationTypeDropDown));
		Select select = new Select(destinationTypeDropDown);
		select.selectByVisibleText(type);
		wait.until(ExpectedConditions
				.elementToBeClickable(destinationCountryDropDown));
		Select select1 = new Select(destinationCountryDropDown);
		select1.selectByVisibleText(country);
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		wait.until(ExpectedConditions
				.elementToBeClickable(destinationStateDropDown));
		Select select2 = new Select(destinationStateDropDown);
		select2.selectByVisibleText(state);	
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - Zip Discount - User has entered 'Destination ZIP' details for State type");
	}
	
	public void selectDiscountID(String discountID) {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(discountIDDropDown));
		Select select = new Select(discountIDDropDown);
		select.selectByVisibleText(discountID);
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - Zip Discount - User has selected a value from 'DISCOUNT ID' drop down");
	}

	public void clickingOnSaveRangeButton() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(saveRangeButton));
		saveRangeButton.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - Zip Discount - User has saved 'Discount ID' details");
	}
	
	public void clickingOnCancelRangeButton() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(cancelRangeButton));
		cancelRangeButton.click();
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - Zip Discount - User has clicked on 'Cancel' Range button");
	}

}