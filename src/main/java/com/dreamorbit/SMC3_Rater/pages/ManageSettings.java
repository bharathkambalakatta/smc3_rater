package com.dreamorbit.SMC3_Rater.pages;

import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dreamorbit.SMC3_Rater.testbase.TestBase;
import com.dreamorbit.SMC3_Rater.testutils.PropertyFileUtility;
import com.dreamorbit.SMC3_Rater.testutils.RaterTestUtils;

public class ManageSettings extends TestBase {

	public static final Logger logger = Logger.getLogger(ManageSettings.class
			.getName());

	PropertyFileUtility propertyValue = new PropertyFileUtility("./Files/"
			+ "/DataFile.properties");
	PropertyFileUtility customSettingDetails = new PropertyFileUtility(
			"./Files/" + "/RandomSetting.properties");

	WebDriver driver;

	@FindBy(xpath = "//div[@id='ajax-loader']/img")
	private WebElement loadingImage;

	// MANAGE SETTINGS page - Header - Web Elements
	@FindBy(xpath = "//a[contains(text(),'Manage Settings')]")
	private WebElement manageSettingsTab;

	// MANAGE SETTINGS page - Custom Setting - Web Elements
	@FindBy(xpath = "//a[@id='custom-set-button']")
	private WebElement customSettingOption;

	// MANAGE SETTINGS page - Custom Setting - Setting table - Web Elements
	@FindBy(xpath = "//div[@class='card-header add-header custom-row active']//*[contains(text(),'Add New Row')]")
	private WebElement addNewRowButton;

	@FindBy(xpath = "//input[@id='settingName-1']")
	private WebElement settingIDTextBox;

	@FindBy(xpath = "//input[@id='description-1']")
	private WebElement descriptionTextBox;

	@FindBy(xpath = "//tr[@id='trCust-1 ']//div[3]")
	private WebElement saveButton;

	// MANAGE SETTINGS page - Custom Setting - Setting table - When a
	// setting is opened - Web Elements
	@FindBy(xpath = "//span[@id='settingName']")
	private WebElement settingName;

	public ManageSettings(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// MANAGE SETTINGS page - Header - Functions
	public void clickingOnManageSettingsTab() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(manageSettingsTab))
				.click();
		logger.info("MESSAGE :: User has clicked on 'MANAGE SETTINGS' Tab");
	}

	// MANAGE SETTINGS page - Custom Setting - Functions
	public void clickingOnCustomSettingOption() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(customSettingOption))
				.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - User has clicked on 'Custom Setting' option");
	}

	// MANAGE SETTINGS page - Custom Setting - Setting table - Functions
	public void generatingAndStoringARandomSettingName() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(999999);
		String randomString = "Custom Setting " + Integer.toString(randomInt);
		customSettingDetails.addDataToTheFile("customSettingID", randomString);
		customSettingDetails.addDataToTheFile("customSettingDescription",
				"Custom Setting Test Description");
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
		Thread.sleep(3000);// Required for Firefox browser
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - User has added a new custom setting");
	}

	public void clickingOnArrowPresentForASetting(String settingID) {
		By arrowPresentForSetting = By.xpath("//span[contains(text(),'"
				+ settingID + "')]/parent::div//img[@class='arrow-one']");
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(
				ExpectedConditions.elementToBeClickable(arrowPresentForSetting))
				.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - User has opened the custom setting");
	}

	public void deletingACustomSetting(String settingID) {
		By deleteButton = By
				.xpath("//span[contains(text(),'"
						+ settingID
						+ "')]/parent::div/parent::td/parent::tr/td[5]//a[@class='delete-row custom']");
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(deleteButton))
				.click();
		driver.switchTo().alert().accept();
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - User has deleted a custom setting");
	}
}
