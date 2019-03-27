package com.dreamorbit.SMC3_Rater.pages;

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

public class ManageSettingsPage extends TestBase {

	public static final Logger log = Logger.getLogger(ManageSettingsPage.class
			.getName());

	PropertyFileUtility propertyValue = new PropertyFileUtility("./Files/"
			+ "/DataFile.properties");

	public final String manageSettingsTabName = "MANAGE SETTINGS";

	WebDriver driver;

	// Create and Delete a Custom Setting Test
	@FindBy(xpath = "//a[contains(text(),'Manage Settings')]")
	WebElement manageSettingsTab;

	@FindBy(xpath = "//a[@id='custom-set-button']")
	private WebElement customSettingOption;

	@FindBy(xpath = "//div[@class='card-header add-header custom-row active']//*[contains(text(),'Add New Row')]")
	private WebElement addNewRowButton;

	@FindBy(xpath = "//input[@id='settingName-1']")
	private WebElement settingIDTextBox;

	@FindBy(xpath = "//input[@id='description-1']")
	private WebElement descriptionTextBox;

	@FindBy(xpath = "//tr[@id='trCust-1 ']//div[3]")
	private WebElement saveButton;

	@FindBy(xpath = "//span[@id='settingName']")
	private WebElement settingName;

	// span[text()='RaterTest']/parent::div/parent::td/following-sibling::td//a[@class='delete-row
	// custom']
	@FindBy(xpath = "//tr[1]/td[5]//a[@class='delete-row custom']")
	private WebElement deleteButton;

	// Create a Setting with Data Module Test
	@FindBy(xpath = "//div[@class='data-module-container']//div[@class='form-group']")
	private WebElement toggleForDataModule;

	@FindBy(xpath = "//select[@id='rater-family']")
	private WebElement RateFamilyDropDown;

	@FindBy(xpath = "//select[@id='rater-tariff']")
	private WebElement availableTariffsDropDown;

	@FindBy(xpath = "//tr[1]/td[1]//img[@class='arrow-one']")
	private WebElement arrowPresentInFirstRow;

	public ManageSettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Create and Delete a Custom Setting Test
	public void clickingOnManageSettingsTab() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(manageSettingsTab))
				.click();
	}

	public void clickingCustomSettingOption() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(customSettingOption))
				.click();
	}

	public void addingACustomSetting(String settingID, String description) {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(addNewRowButton));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", addNewRowButton);
		settingIDTextBox.sendKeys(settingID);
		descriptionTextBox.sendKeys(description);
		saveButton.click();
		wait.until(ExpectedConditions.visibilityOf(settingName));
	}

	public void clickingOnDeleteCustomSetting() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(deleteButton))
				.click();
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
	}

	// Create a Setting with Data Module Test
	public void clickingOnTogglePresentForDataModule() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(toggleForDataModule))
				.click();
	}

	public void settingUpDataModule(String rateFamily, String availableTariffs)
			throws InterruptedException {
		// WebDriverWait wait = new WebDriverWait(driver,
		// RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		// wait.until(ExpectedConditions.visibilityOf(RateFamilyDropDown));
		Thread.sleep(5000);
		Select select = new Select(RateFamilyDropDown);
		select.selectByVisibleText(rateFamily);
		// wait.until(ExpectedConditions.visibilityOf(availableTariffsDropDown));
		Thread.sleep(5000);
		Select select1 = new Select(availableTariffsDropDown);
		select1.selectByVisibleText(availableTariffs);
	}

	public void clickingOnArrowPresentInFirstRow() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(
				ExpectedConditions.elementToBeClickable(arrowPresentInFirstRow))
				.click();
	}
}
