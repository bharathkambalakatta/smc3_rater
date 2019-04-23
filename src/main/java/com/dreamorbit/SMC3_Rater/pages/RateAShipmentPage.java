/* PROJECT		: SMC3 - Rater
 * AUTHOR		: Bharath Kambalakatta
 * COMPANY		: DreamOrbit Softech Pvt Ltd
 * CREATED DATE	: 
 */

package com.dreamorbit.SMC3_Rater.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dreamorbit.SMC3_Rater.testbase.TestBase;
import com.dreamorbit.SMC3_Rater.testutils.PropertyFileUtility;
import com.dreamorbit.SMC3_Rater.testutils.PropertyFileWriteUtility;
import com.dreamorbit.SMC3_Rater.testutils.RaterTestUtils;

public class RateAShipmentPage extends TestBase {

	public static final Logger logger = Logger
			.getLogger(RateAShipmentPage.class.getName());

	PropertyFileUtility propertyValue = new PropertyFileUtility("./Files/"
			+ "/DataFile.properties");
	PropertyFileWriteUtility propertyKeyValue = new PropertyFileWriteUtility(
			"./Files/" + "/Test.properties");
	PropertyFileUtility propertyValue1 = new PropertyFileUtility("./Files/"
			+ "/Test.properties");

	WebDriver driver;

	// RATE A SHIPMENT page - Elements present in the header
	@FindBy(id = "rateShipmentTab")
	WebElement rateAShipmentTab;

	@FindBy(xpath = "//a[@class='profile-pic profile-text-link']")
	private WebElement profileBox;

	@FindBy(xpath = "//a[@class='logout-link']")
	private WebElement logoutOption;

	// RATE A SHIPMENT page - Elements present in the left side section
	@FindBy(xpath = "//select[@id='settingId']")
	private WebElement settingsDropDown;

	@FindBy(xpath = "//select[@name='family']")
	private WebElement rateFamilyDropDown;

	@FindBy(xpath = "//select[@name='dataModule']")
	private WebElement availableTariffsDropDown;

	@FindBy(xpath = "//input[@id='pickupZip']")
	private WebElement originTextBox;

	@FindBy(xpath = "//input[@id='deliveryZip']")
	private WebElement destinationTextBox;

	@FindBy(xpath = "//input[@id='discountTypeSingle']")
	private WebElement singleDiscountRadioButton;

	@FindBy(xpath = "//input[@value='multiple']")
	private WebElement multipleDiscountRadioButton;

	@FindBy(xpath = "//input[@name='discount']")
	private WebElement discountTextBox;

	@FindBy(xpath = "//input[@id='minChargeDisc']")
	private WebElement mcDiscountTextBox;

	@FindBy(xpath = "//input[@id='minChargeFloor']")
	private WebElement mcFloorTextBox;

	@FindBy(xpath = "//td[contains(text(),'L5C')]/parent::tr//input")
	private WebElement l5cTextBox;

	@FindBy(xpath = "//td[contains(text(),'M5C')]/parent::tr//input")
	private WebElement m5cTextBox;

	@FindBy(xpath = "//td[contains(text(),'M1M')]/parent::tr//input")
	private WebElement m1mTextBox;

	@FindBy(xpath = "//td[contains(text(),'M2M')]/parent::tr//input")
	private WebElement m2mTextBox;

	@FindBy(xpath = "//td[contains(text(),'M5M')]/parent::tr//input")
	private WebElement m5mTextBox;

	@FindBy(xpath = "//td[contains(text(),'M10M')]/parent::tr//input")
	private WebElement m10mTextBox;

	@FindBy(xpath = "//td[contains(text(),'M20M')]/parent::tr//input")
	private WebElement m20mTextBox;

	@FindBy(xpath = "//td[contains(text(),'M30M')]/parent::tr//input")
	private WebElement m30mTextBox;

	@FindBy(xpath = "//td[contains(text(),'M40M')]/parent::tr//input")
	private WebElement m40mTextBox;

	@FindBy(xpath = "//td[contains(text(),'MC Discount')]/parent::tr//input")
	private WebElement mcDiscountMultipleTextBox;

	@FindBy(xpath = "//td[contains(text(),'MC Floor')]/parent::tr//input")
	private WebElement mcFloorMultipleTextBox;

	// RATE A SHIPMENT page - Elements present in the right side section
	@FindBy(xpath = "//select[@id='ltl-class-0']")
	private WebElement classDropDown;

	@FindBy(xpath = "//input[@value='Rate Shipment']")
	private WebElement rateShipmentButton;

	public RateAShipmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// RATE A SHIPMENT page - Various functions which are used in the test cases
	public void clickingOnRateAShipmentTab() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(rateAShipmentTab)).click();
		logger.info("MESSAGE :: User has clicked on 'RATE A SHIPMENT' tab");
	}

	public void loggingOutFromTheApplication() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.visibilityOf(profileBox));
		Actions action = new Actions(driver);
		action.moveToElement(profileBox).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(logoutOption));
		logoutOption.click();
		logger.info("MESSAGE :: User has been logged out from the application");
	}

	public void selectSetting(String setting) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.visibilityOf(settingsDropDown));
		Select select = new Select(settingsDropDown);
		select.selectByVisibleText(setting);
		logger.info("MESSAGE :: RATE A SHIPMENT Tab - Value has been selected in 'Settings' drop down");
	}

	public boolean verifyIfSettingIsAvailable(String setting) {
		logger.info("MESSAGE :: RATE A SHIPMENT Tab - Verifying 'Setting' drop down value");
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.visibilityOf(settingsDropDown));
		boolean found = false;
		Select select = new Select(settingsDropDown);
		List<WebElement> allOptions = select.getOptions();
		for (int i = 0; i < allOptions.size(); i++) {
			if (allOptions.get(i).getText().equals(setting)) {
				found = true;
				break;
			}
		}
		if (found == true) {
			logger.info("MESSAGE :: RATE A SHIPMENT Tab - Expected value is present in 'Settings' drop down");
		} else {
			logger.info("MESSAGE :: RATE A SHIPMENT Tab - Value is not present in 'Settings' drop down");
		}
		return found;
	}

	public void selectRateFamily(String rateFamily) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(rateFamilyDropDown));
		Select select = new Select(rateFamilyDropDown);
		select.selectByVisibleText(rateFamily);
		Thread.sleep(1000);
		logger.info("MESSAGE :: RATE A SHIPMENT Tab - Value has been selected in 'Rate Family' drop down");
	}

	public String verifySelectedValueInRateFamily() throws InterruptedException {
		logger.info("MESSAGE :: RATE A SHIPMENT Tab - Verifying 'Rate Family' drop down value");
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(rateFamilyDropDown));
		Thread.sleep(1000);
		Select select = new Select(rateFamilyDropDown);
		String valueSelected = select.getFirstSelectedOption().getText();
		return valueSelected;
	}

	public String verifySelectedValueInAvailableTariffs()
			throws InterruptedException {
		logger.info("MESSAGE :: RATE A SHIPMENT Tab - Verifying 'Available Tariffs' drop down value");
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions
				.elementToBeClickable(availableTariffsDropDown));
		Thread.sleep(1000);
		Select select = new Select(availableTariffsDropDown);
		String valueSelected = select.getFirstSelectedOption().getText();
		return valueSelected;
	}

	public String verifyOriginTextBoxValue() {
		logger.info("MESSAGE :: RATE A SHIPMENT Tab - Verifying 'Origin' text box value");
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(originTextBox));
		return originTextBox.getAttribute("value");
	}

	public String verifyDestinationTextBoxValue() {
		logger.info("MESSAGE :: RATE A SHIPMENT Tab - Verifying 'Destination' text box value");
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(destinationTextBox));
		return destinationTextBox.getAttribute("value");
	}

	public boolean verifyIfSingleDiscountRadioButtonIsSelected() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions
				.elementToBeSelected(singleDiscountRadioButton));
		boolean found = false;
		if (singleDiscountRadioButton.isSelected()) {
			found = true;
			logger.info("MESSAGE :: RATE A SHIPMENT Tab - 'Single' discount radio button is selected");
		}
		return found;
	}

	public boolean verifyIfMultipleDiscountRadioButtonIsSelected() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions
				.elementToBeSelected(multipleDiscountRadioButton));
		boolean found = false;
		if (multipleDiscountRadioButton.isSelected()) {
			found = true;
			logger.info("MESSAGE :: RATE A SHIPMENT Tab - 'Multiple' discount radio button is selected");
		}
		return found;
	}

	public String verifyDiscountTextBoxValue() {
		logger.info("MESSAGE :: RATE A SHIPMENT Tab - Verifying 'Discount' text box value");
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(discountTextBox));
		return discountTextBox.getAttribute("value");
	}

	public String verifyMCDiscountTextBoxValue() {
		logger.info("MESSAGE :: RATE A SHIPMENT Tab - Verifying 'MC Discount' text box value");
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(mcDiscountTextBox));
		return mcDiscountTextBox.getAttribute("value");
	}

	public String verifyMCFloorTextBoxValue() {
		logger.info("MESSAGE :: RATE A SHIPMENT Tab - Verifying 'MC Floor' text box value");
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(mcFloorTextBox));
		return mcFloorTextBox.getAttribute("value");
	}

	public String verifyL5CTextBoxValue() {
		logger.info("MESSAGE :: RATE A SHIPMENT Tab - Verifying 'L5C' text box value");
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(l5cTextBox));
		return l5cTextBox.getAttribute("value");
	}

	public String verifyM5CTextBoxValue() {
		logger.info("MESSAGE :: RATE A SHIPMENT Tab - Verifying 'M5C' text box value");
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(m5cTextBox));
		return m5cTextBox.getAttribute("value");
	}

	public String verifyM1MTextBoxValue() {
		logger.info("MESSAGE :: RATE A SHIPMENT Tab - Verifying 'M1M' text box value");
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(m1mTextBox));
		return m1mTextBox.getAttribute("value");
	}

	public String verifyM2MTextBoxValue() {
		logger.info("MESSAGE :: RATE A SHIPMENT Tab - Verifying 'M2M' text box value");
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(m2mTextBox));
		return m2mTextBox.getAttribute("value");
	}

	public String verifyM5MTextBoxValue() {
		logger.info("MESSAGE :: RATE A SHIPMENT Tab - Verifying 'M5M' text box value");
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(m5mTextBox));
		return m5mTextBox.getAttribute("value");
	}

	public String verifyM10MTextBoxValue() {
		logger.info("MESSAGE :: RATE A SHIPMENT Tab - Verifying 'M10M' text box value");
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(m10mTextBox));
		return m10mTextBox.getAttribute("value");
	}

	public String verifyM20MTextBoxValue() {
		logger.info("MESSAGE :: RATE A SHIPMENT Tab - Verifying 'M20M' text box value");
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(m20mTextBox));
		return m20mTextBox.getAttribute("value");
	}

	public String verifyM30MTextBoxValue() {
		logger.info("MESSAGE :: RATE A SHIPMENT Tab - Verifying 'M30M' text box value");
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(m30mTextBox));
		return m30mTextBox.getAttribute("value");
	}

	public String verifyM40MTextBoxValue() {
		logger.info("MESSAGE :: RATE A SHIPMENT Tab - Verifying 'M40M' text box value");
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(m40mTextBox));
		return m40mTextBox.getAttribute("value");
	}

	public String verifyMCDiscountMultipleTextBoxValue() {
		logger.info("MESSAGE :: RATE A SHIPMENT Tab - Verifying 'MC Discount' multiple text box value");
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions
				.elementToBeClickable(mcDiscountMultipleTextBox));
		return mcDiscountMultipleTextBox.getAttribute("value");
	}

	public String verifyMCFloorMultipleTextBoxValue() {
		logger.info("MESSAGE :: RATE A SHIPMENT Tab - Verifying 'MC Floor' multiple text box value");
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions
				.elementToBeClickable(mcFloorMultipleTextBox));
		return mcFloorMultipleTextBox.getAttribute("value");
	}

	public String verifyClassDropDownValue() {
		logger.info("MESSAGE :: RATE A SHIPMENT Tab - Verifying 'Class' drop down value");
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(classDropDown));
		Select select = new Select(classDropDown);
		return select.getFirstSelectedOption().getAttribute("value");
	}

	public boolean verifyIfClassDropDownHasAnyValueSelected() {
		logger.info("MESSAGE :: RATE A SHIPMENT Tab - Verifying 'Class' drop down value");
		boolean notSame = true;
		try {
			String text = propertyValue.getValue("constantClass1");
			WebDriverWait wait = new WebDriverWait(driver,
					RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
			wait.until(ExpectedConditions.visibilityOf(classDropDown));

			Select select = new Select(classDropDown);
			String value = select.getFirstSelectedOption().getText();
			if (text.equals(value)) {
				notSame = false;
			}
		} catch (NoSuchElementException e) {
			logger.info("MESSAGE :: RATE A SHIPMENT Tab - No value is selected in 'Class' drop down");
		}
		return notSame;
	}
}
