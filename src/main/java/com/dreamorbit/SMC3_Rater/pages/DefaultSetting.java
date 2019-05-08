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

	// MANAGE SETTINGS page - Elements present in 'Default Setting' section
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

	public DefaultSetting(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// MANAGE SETTINGS page - Default Setting - Various functions which are used
	// in the test cases
	public void makingDefaultDiscountsToggleON() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.visibilityOf(toggleForDefaultDiscounts));
		Thread.sleep(1000);// Required as selenium execution is fast
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
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Default Setting - User has entered 'Discount' details");
	}

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

	public void makingDefaultConstantZIPSToggleON() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions
				.visibilityOf(toggleForDefaultConstantZIPs));
		Thread.sleep(1000);
		if (defaultOriginZIPTextBox.isDisplayed()) {
			logger.info("MESSAGE :: MANAGE SETTINGS Tab - Default Setting - 'Constant ZIPS' section toggle is already ON");
		} else {
			toggleForDefaultConstantZIPs.click();
			logger.info("MESSAGE :: MANAGE SETTINGS Tab - Default Setting - 'Constant Class' section toggle has been set to ON");
		}
	}

	public void enteringDefaultConstantZIPSDetails(String originZIP,
			String destinationZIP) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions
				.elementToBeClickable(defaultOriginZIPTextBox));
		defaultOriginZIPTextBox.clear();
		defaultOriginZIPTextBox.click();
		defaultOriginZIPTextBox.sendKeys(originZIP);
		wait.until(ExpectedConditions
				.elementToBeClickable(defaultDestinationZIPTextBox));
		defaultDestinationZIPTextBox.clear();
		defaultDestinationZIPTextBox.click();
		Thread.sleep(1000);
		defaultDestinationZIPTextBox.sendKeys(destinationZIP);
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Default Setting - User has entered 'Constant ZIPS' details");
	}

	public void makingDefaultDiscountsToggleOff() throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.visibilityOf(toggleForDefaultDiscounts));
		Thread.sleep(1000);
		toggleForDefaultDiscounts.click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Default Setting - 'Discount' section toggle has been set to OFF");
	}

	public void makingDefaultConstantClassToggleOff()
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions
				.visibilityOf(toggleForDefaultConstantClass));
		Thread.sleep(1000);
		toggleForDefaultConstantClass.click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Default Setting - 'Constant Class' section toggle has been set to OFF");
	}

	public void makingDefaultConstantZIPSToggleOff()
			throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions
				.visibilityOf(toggleForDefaultConstantZIPs));
		Thread.sleep(1000);
		toggleForDefaultConstantZIPs.click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Default Setting - 'Constant ZIPS' section toggle has been set to OFF");
	}
}