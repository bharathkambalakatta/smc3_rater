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

public class DefaultSetting extends TestBase {

	public static final Logger logger = Logger.getLogger(DefaultSetting.class
			.getName());

	PropertyFileUtility propertyValue = new PropertyFileUtility("./Files/"
			+ "/DataFile.properties");

	WebDriver driver;

	@FindBy(xpath = "//div[@id='ajax-loader']/img")
	private WebElement loadingImage;

	// MANAGE SETTINGS page - Default Setting - Web Elements
	@FindBy(xpath = "//a[@id='defaultPanel']")
	private WebElement defaultSettingOption;

	// MANAGE SETTINGS page - Default Setting - Discounts section - Web Elements
	@FindBy(xpath = "//div[@id='demo']//div[@class='discount-box']//div[@class='checkbox discount-link']//label")
	private WebElement toggleForDefaultDiscounts;

	@FindBy(xpath = "//input[@id='defaultdiscount']")
	private WebElement defaultDiscountTextBox;

	@FindBy(xpath = "//input[@id='mcdis']")
	private WebElement defaultMCDiscountTextBox;

	@FindBy(xpath = "//input[@id='default-mcfloor']")
	private WebElement defaultMCFloorTextBox;

	// MANAGE SETTINGS page - Default Setting - Constant Class section - Web
	// Elements
	@FindBy(xpath = "//div[@id='constant-class']//div[@class='checkbox discount-link']//label")
	private WebElement toggleForDefaultConstantClass;

	@FindBy(xpath = "//select[@id='constantDefault1']")
	private WebElement defaultClassDropDown;

	// MANAGE SETTINGS page - Default Setting - Constant ZIPS section - Web
	// Elements
	@FindBy(xpath = "//div[@id='zipInfo']//div[@class='checkbox discount-link']//label")
	private WebElement toggleForDefaultConstantZIPs;

	@FindBy(xpath = "//input[@id='orgZip']")
	private WebElement defaultOriginZIPTextBox;

	@FindBy(xpath = "//input[@id='desZip']")
	private WebElement defaultDestinationZIPTextBox;

	public DefaultSetting(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// MANAGE SETTINGS page - Default Setting - Functions
	public void clickingOnDefaultSettingOption() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(
				ExpectedConditions.elementToBeClickable(defaultSettingOption))
				.click();
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - User has clicked on 'Default Setting' option");
	}

	// MANAGE SETTINGS page - Default Setting - Discounts section - Functions
	public void makingDefaultDiscountsToggleON() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.visibilityOf(toggleForDefaultDiscounts));
		Thread.sleep(2000);// Required as Selenium execution is fast
		if (defaultMCFloorTextBox.isDisplayed()) {
			logger.info("MESSAGE :: MANAGE SETTINGS Tab - Default Setting - 'Discount' section toggle is already ON");
		} else {
			toggleForDefaultDiscounts.click();
			logger.info("MESSAGE :: MANAGE SETTINGS Tab - Default Setting - 'Discount' section toggle has been set to ON");
		}
	}

	public void enteringDefaultDiscountsDetails(String discount,
			String mcDiscount, String mcFloor) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions
				.elementToBeClickable(defaultDiscountTextBox));
		defaultDiscountTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(1000);// Value is setting back to 0.00 without wait
		defaultDiscountTextBox.sendKeys(Keys.chord(Keys.DELETE));
		defaultDiscountTextBox.sendKeys(discount);
		wait.until(ExpectedConditions
				.elementToBeClickable(defaultMCDiscountTextBox));
		defaultMCDiscountTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(1000);// Value is setting back to 0.00 without wait
		defaultMCDiscountTextBox.sendKeys(Keys.chord(Keys.DELETE));
		defaultMCDiscountTextBox.sendKeys(mcDiscount);
		wait.until(ExpectedConditions
				.elementToBeClickable(defaultMCFloorTextBox));
		defaultMCFloorTextBox.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		Thread.sleep(1000);// Value is setting back to 0.00 without wait
		defaultMCFloorTextBox.sendKeys(Keys.chord(Keys.DELETE));
		defaultMCFloorTextBox.sendKeys(mcFloor);
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Default Setting - User has entered 'Discount' details");
	}

	public void makingDefaultDiscountsToggleOff() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.visibilityOf(toggleForDefaultDiscounts));
		Thread.sleep(2000);// Required as Selenium execution is fast
		toggleForDefaultDiscounts.click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Default Setting - 'Discount' section toggle has been set to OFF");
	}

	// MANAGE SETTINGS page - Default Setting - Constant Class section - Web
	// Elements
	public void makingDefaultConstantClassToggleON() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions
				.visibilityOf(toggleForDefaultConstantClass));
		if (defaultClassDropDown.isDisplayed()) {
			logger.info("MESSAGE :: MANAGE SETTINGS Tab - Default Setting - 'Constant Class' section toggle is already ON");
		} else {
			toggleForDefaultConstantClass.click();
			logger.info("MESSAGE :: MANAGE SETTINGS Tab - Default Setting - 'Constant Class' section toggle has been set to ON");
		}
	}

	public void enteringDefaultConstantClassDetails(String constantClass)
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.visibilityOf(defaultClassDropDown));
		Select select = new Select(defaultClassDropDown);
		select.selectByVisibleText(constantClass);
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Default Setting - User has selected a 'Constant Class'");
	}

	public void makingDefaultConstantClassToggleOff()
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions
				.visibilityOf(toggleForDefaultConstantClass));
		Thread.sleep(2000);// Required as Selenium execution is fast
		toggleForDefaultConstantClass.click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Default Setting - 'Constant Class' section toggle has been set to OFF");
	}

	// MANAGE SETTINGS page - Default Setting - Constant ZIPS section - Web
	// Elements
	public void makingDefaultConstantZIPSToggleON() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions
				.visibilityOf(toggleForDefaultConstantZIPs));
		Thread.sleep(2000);// Required as Selenium execution is fast
		if (defaultOriginZIPTextBox.isDisplayed()) {
			logger.info("MESSAGE :: MANAGE SETTINGS Tab - Default Setting - 'Constant ZIPS' section toggle is already ON");
		} else {
			toggleForDefaultConstantZIPs.click();
			logger.info("MESSAGE :: MANAGE SETTINGS Tab - Default Setting - 'Constant ZIPS' section toggle has been set to ON");
		}
	}

	public void enteringDefaultConstantZIPSDetails(String originZIP,
			String destinationZIP) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions
				.elementToBeClickable(defaultOriginZIPTextBox));
		defaultOriginZIPTextBox.clear();
		defaultOriginZIPTextBox.sendKeys(originZIP);
		Thread.sleep(2000);// Value is not getting set without wait in Firefox
		wait.until(ExpectedConditions
				.elementToBeClickable(defaultDestinationZIPTextBox));
		defaultDestinationZIPTextBox.clear();
		defaultDestinationZIPTextBox.sendKeys(destinationZIP);
		defaultOriginZIPTextBox.click(); // Added to handle inconsistent
											// behavior with
											// defaultDestinationZIPTextBox
		Thread.sleep(2000);// Value is not getting set without wait in Firefox
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Default Setting - User has entered 'Constant ZIPS' details");
	}

	public void makingDefaultConstantZIPSToggleOff()
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions
				.visibilityOf(toggleForDefaultConstantZIPs));
		Thread.sleep(2000);// Required as Selenium execution is fast
		toggleForDefaultConstantZIPs.click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		Thread.sleep(2000);// Required as Selenium execution is fast
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Default Setting - 'Constant ZIPS' section toggle has been set to OFF");
	}
}