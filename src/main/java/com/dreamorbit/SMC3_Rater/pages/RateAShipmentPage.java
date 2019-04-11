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
	PropertyFileUtility propertyValue1 = new PropertyFileUtility("./Files/" + "/Test.properties");

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

	@FindBy(xpath = "//input[@name='discount']")
	private WebElement discountTextBox;

	@FindBy(xpath = "//input[@id='minChargeDisc']")
	private WebElement mcDiscountTextBox;

	@FindBy(xpath = "//input[@id='minChargeFloor']")
	private WebElement mcFloorTextBox;

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
		wait.until(ExpectedConditions.elementToBeClickable(rateAShipmentTab));
		rateAShipmentTab.click();
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

	public boolean verifyIfSettingIsAvailable() {
		logger.info("MESSAGE :: RATE A SHIPMENT Tab - Verifying 'Setting' drop down value");
		String setting = propertyValue1
				.getValue("settingName");
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
		if (found==true) {
			logger.info("MESSAGE :: RATE A SHIPMENT Tab - Expected value is present in 'Settings' drop down");
		} else {
			logger.info("MESSAGE :: RATE A SHIPMENT Tab - Expected value is not present in 'Settings' drop down");
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

	public boolean verifyIfSingleDiscountIsSelected() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions
				.elementToBeSelected(singleDiscountRadioButton));
		boolean found = false;
		if (singleDiscountRadioButton.isSelected()) {
			found = true;
			logger.info("MESSAGE :: RATE A SHIPMENT Tab - 'Single' Discount radio button is selected");
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
