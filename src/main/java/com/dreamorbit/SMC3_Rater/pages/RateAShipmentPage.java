package com.dreamorbit.SMC3_Rater.pages;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
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

public class RateAShipmentPage extends TestBase {

	public static final Logger log = Logger.getLogger(RateAShipmentPage.class
			.getName());

	PropertyFileUtility propertyValue = new PropertyFileUtility("./Files/"
			+ "/DataFile.properties");

	WebDriver driver;

	// Create and Delete a Custom Setting Test
	@FindBy(id = "rateShipmentTab")
	WebElement rateAShipmentTab;

	// Create a Setting with Data Module Test
	@FindBy(xpath = "//select[@id='settingId']")
	private WebElement settingsDropDown;

	@FindBy(xpath = "//select[@name='family']")
	private WebElement rateFamilyDropDown;

	@FindBy(xpath = "//select[@name='dataModule']")
	private WebElement availableTariffsDropDown;

	public RateAShipmentPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Create and Delete a Custom Setting Test
	public void clickingOnRateAShipmentTab() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(rateAShipmentTab));
		rateAShipmentTab.click();
	}

	public boolean verifyIfSettingIsAvailable() {
		String setting = propertyValue
				.getValue("settingForCreateAndDeleteTest");
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
		return found;
	}

	// Create a Setting with Data Module Test
	public void selectSetting(String setting) throws InterruptedException {
		 WebDriverWait wait = new WebDriverWait(driver,
		 RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		 wait.until(ExpectedConditions.visibilityOf(settingsDropDown));
		Select select = new Select(settingsDropDown);
		select.selectByVisibleText(setting);
	}

	public String verifySelectedValueInRateFamily() throws InterruptedException {
		 WebDriverWait wait = new WebDriverWait(driver,
		 RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		 wait.until(ExpectedConditions.visibilityOf(rateFamilyDropDown));
		Select select = new Select(rateFamilyDropDown);
		String valueSelected = select.getFirstSelectedOption().getText();
		return valueSelected;
	}

	public String verifySelectedValueInAvailableTariffs()
			throws InterruptedException {
		 WebDriverWait wait = new WebDriverWait(driver,
		 RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		 wait.until(ExpectedConditions.visibilityOf(rateFamilyDropDown));
		Select select = new Select(availableTariffsDropDown);
		String valueSelected = select.getFirstSelectedOption().getText();
		return valueSelected;
	}
}
