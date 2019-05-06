package com.dreamorbit.SMC3_Rater.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dreamorbit.SMC3_Rater.testbase.TestBase;
import com.dreamorbit.SMC3_Rater.testutils.PropertyFileUtility;
import com.dreamorbit.SMC3_Rater.testutils.RaterTestUtils;

public class FuelSurcharge extends TestBase {

	public static final Logger logger = Logger.getLogger(FuelSurcharge.class
			.getName());

	PropertyFileUtility propertyValue = new PropertyFileUtility("./Files/"
			+ "/DataFile.properties");

	WebDriver driver;

	// MANAGE SETTINGS page - 'Global' section - Web Elements
	@FindBy(xpath = "//a[@id='one']//span[contains(text(),'Global')]")
	private WebElement globalSubTab;

	@FindBy(xpath = "//a[@id='insert-more']//h6[@class='add-inner-title'][contains(text(),'+ Add New Row')]")
	private WebElement addNewRowButton;

	@FindBy(xpath = "//input[@id='lowRange-1']")
	private WebElement lowRangeAtLeast;

	@FindBy(xpath = "//input[@id='highRange-1']")
	private WebElement highRangeButLessThan;

	@FindBy(xpath = "//input[@id='ltl-1']")
	private WebElement LTLField;

	@FindBy(xpath = "//input[@id='tl-1']")
	private WebElement TLField;

	@FindBy(xpath = "//div[@class='save-icons']//a[@id='record-1']//img")
	private WebElement saveGlobalSurchargeButton;

	@FindBy(xpath = "//div[@id='ajax-loader']/img")
	private WebElement loadingImage;

	@FindBy(xpath = "//h6[contains(text(),'View Custom Global Surcharge')]")
	private WebElement viewCustomGlobalSurchargeoption;

	public FuelSurcharge(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// MANAGE SETTINGS page - 'Global' section - Functions
	public void clickingOnGlobalSubTab() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(globalSubTab))
				.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		Thread.sleep(3000);// Required as the table gets refreshed twice
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - User has clicked on 'Global' sub tab");
	}

	public void clickAddNewRow() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(addNewRowButton))
				.click();
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Global table - User has clicked on '+ ADD NEW ROW' button");
	}

	public void fillGlobalSurchargeFields(String lowRange, String highRange,
			String LTL, String TL) {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(lowRangeAtLeast));
		lowRangeAtLeast.sendKeys(lowRange);
		wait.until(ExpectedConditions
				.elementToBeClickable(highRangeButLessThan));
		highRangeButLessThan.sendKeys(highRange);
		wait.until(ExpectedConditions.elementToBeClickable(LTLField));
		LTLField.sendKeys(LTL);
		wait.until(ExpectedConditions.elementToBeClickable(TLField));
		TLField.sendKeys(TL);
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Global table - User has entered the values");
	}

	public void saveGlobalSurchargeFields() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(
				ExpectedConditions
						.elementToBeClickable(saveGlobalSurchargeButton))
				.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		Thread.sleep(3000);// Required as + ADD NEW ROW button is getting
							// disabled when the execution is fast
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Global table - User has saved a row");
	}

	public void clickingOnViewGlobalGlobalSurchargeOption() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions
				.elementToBeClickable(viewCustomGlobalSurchargeoption));
		viewCustomGlobalSurchargeoption.click();
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Default Setting - User has clicked on 'VIEW CUSTOM GLOBAL SURCHARGE' option");
	}

	public boolean verifyGlobalSurchargeAtLeastValue(String atLeast) {
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Default Setting - VIEW CUSTOM GLOBAL SURCHARGE table - Verifying 'At Least' value");
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		WebElement atLeastValue = driver
				.findElement(By
						.xpath("//table[@id='default-surcharge-table']//tbody//tr//td[contains(text(), '"
								+ atLeast + "')]"));
		wait.until(ExpectedConditions
				.visibilityOf(atLeastValue));
		boolean present = false;
		if (atLeastValue.isDisplayed()) {
			present = true;
		}
		return present;
	}

	public boolean verifyGlobalSurchargeButLessThanValue(String butLessThan) {
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Default Setting - VIEW CUSTOM GLOBAL SURCHARGE table - Verifying 'But Less Than' value");
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		WebElement butLessThanValue = driver
				.findElement(By
						.xpath("//table[@id='default-surcharge-table']//tbody//tr//td[contains(text(), '"
								+ butLessThan + "')]"));
		wait.until(ExpectedConditions
				.visibilityOf(butLessThanValue));
		boolean present = false;
		if (butLessThanValue.isDisplayed()) {
			present = true;
		}
		return present;
	}

	public boolean verifyGlobalSurchargeLTLValue(String ltl) {
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Default Setting - VIEW CUSTOM GLOBAL SURCHARGE table - Verifying 'LTL' value");
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		WebElement ltlValue = driver
				.findElement(By
						.xpath("//table[@id='default-surcharge-table']//tbody//tr//td[contains(text(), '"
								+ ltl + "')]"));
		wait.until(ExpectedConditions
				.visibilityOf(ltlValue));
		boolean present = false;
		if (ltlValue.isDisplayed()) {
			present = true;
		}
		return present;
	}

	public boolean verifyGlobalSurchargeTLValue(String tl) {
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Default Setting - VIEW CUSTOM GLOBAL SURCHARGE table - Verifying 'TL' value");
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		WebElement tlValue = driver
				.findElement(By
						.xpath("//table[@id='default-surcharge-table']//tbody//tr//td[contains(text(), '"
								+ tl + "')]"));
		wait.until(ExpectedConditions
				.visibilityOf(tlValue));
		boolean present = false;
		if (tlValue.isDisplayed()) {
			present = true;
		}
		return present;
	}

	public void deletingGlobalRows(String TL) throws InterruptedException {
		By deleteButton = By
				.xpath("//table[@id='globalTable']//tr//div[contains(text(), '"
						+ TL + "')]//following::a[@class='delete-row'][1]//img");
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(deleteButton))
				.click();
		driver.switchTo().alert().accept();
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		Thread.sleep(2000);//Required for Firefox browser
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Global table - User has deleted a row");
	}
}