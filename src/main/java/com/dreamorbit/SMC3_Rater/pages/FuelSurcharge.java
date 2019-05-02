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

	public static final Logger logger = Logger.getLogger(FuelSurcharge.class.getName());

	PropertyFileUtility propertyValue = new PropertyFileUtility("./Files/" + "/DataFile.properties");

	WebDriver driver;
	WebDriverWait wait;

	@FindBy(xpath = "//a[@id='one']//span[contains(text(),'Global')]")
	private WebElement globalSurchargeTab;

	@FindBy(xpath = "//a[@id='insert-more']//h6[@class='add-inner-title'][contains(text(),'+ Add New Row')]")
	private WebElement addNewRowLink;

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
	private WebElement viewGlobalsurcharge;

	public FuelSurcharge(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Method to click on Global Surcharge tab
	public void clickGlobalSurchargeTab() throws Exception {
		wait = new WebDriverWait(driver, RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(globalSurchargeTab)).click();
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(addNewRowLink));
		logger.info("MESSAGE :: User has clicked on 'GLOBAL' Tab");
	}

	// Method to click on +ADD NEW ROW
	public void clickAddNewRow() throws Exception {
		wait = new WebDriverWait(driver, RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(addNewRowLink)).click();
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		logger.info("MESSAGE :: User has clicked on '+ADD NEW ROW' link.");
	}

	public void fillGlobalSurchargeFields(String lowRange, String highRange, String LTL, String TL) {
		wait = new WebDriverWait(driver, RaterTestUtils.UP_TO_TEN_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(lowRangeAtLeast));
		lowRangeAtLeast.sendKeys(lowRange);
		highRangeButLessThan.sendKeys(highRange);
		LTLField.sendKeys(LTL);
		TLField.sendKeys(TL);
		logger.info("MESSAGE :: User has entered the values in the fields.");
	}

	public void saveGlobalSurchargeFields() throws Exception {
		wait = new WebDriverWait(driver, RaterTestUtils.UP_TO_TEN_SECONDS);
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		wait.until(ExpectedConditions.elementToBeClickable(saveGlobalSurchargeButton)).click();
		wait.until(ExpectedConditions.invisibilityOf(loadingImage));
		Thread.sleep(3000);
		logger.info("MESSAGE :: The values are saved.");
	}

	public void viewGlobalsurchargeclick() {
		wait = new WebDriverWait(driver, RaterTestUtils.UP_TO_60_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(viewGlobalsurcharge));
		viewGlobalsurcharge.click();
		logger.info("MESSAGE :: User has clicked on Custom Global surcharge section");
	}

	public WebElement verifyGlobalsurchargeLowRange1() {
		return driver.findElement(By.xpath("//table[@id='default-surcharge-table']//tbody//tr//td[contains(text(), '"
				+ propertyValue.getValue("lowRange1") + "')]"));
	}

	public WebElement verifyGlobalsurchargeLowRange2() {
		return driver.findElement(By.xpath("//table[@id='default-surcharge-table']//tbody//tr//td[contains(text(),'"
				+ propertyValue.getValue("lowRange2") + "')]"));
	}

	public WebElement verifyGlobalsurchargeLowRange3() {
		return driver.findElement(By.xpath("//table[@id='default-surcharge-table']//tbody//tr//td[contains(text(),'"
				+ propertyValue.getValue("lowRange3") + "')]"));
	}

	public WebElement verifyGlobalsurchargeLowRange4() {
		return driver.findElement(By.xpath("//table[@id='default-surcharge-table']//tbody//tr//td[contains(text(),'"
				+ propertyValue.getValue("lowRange4") + "')]"));
	}

	public WebElement verifyGlobalsurchargeLowRange5() {
		return driver.findElement(By.xpath("//table[@id='default-surcharge-table']//tbody//tr//td[contains(text(),'"
				+ propertyValue.getValue("lowRange5") + "')]"));
	}

	public WebElement verifyGlobalsurchargeHighRange1() {
		return driver.findElement(By.xpath("//table[@id='default-surcharge-table']//tbody//tr//td[2][contains(text(),'"
				+ propertyValue.getValue("highRange1") + "')]"));
	}

	public WebElement verifyGlobalsurchargeHighRange2() {
		return driver.findElement(By.xpath("//table[@id='default-surcharge-table']//tbody//tr//td[2][contains(text(),'"
				+ propertyValue.getValue("highRange2") + "')]"));
	}

	public WebElement verifyGlobalsurchargeHighRange3() {
		return driver.findElement(By.xpath("//table[@id='default-surcharge-table']//tbody//tr//td[2][contains(text(),'"
				+ propertyValue.getValue("highRange3") + "')]"));
	}

	public WebElement verifyGlobalsurchargeHighRange4() {
		return driver.findElement(By.xpath("//table[@id='default-surcharge-table']//tbody//tr//td[2][contains(text(),'"
				+ propertyValue.getValue("highRange4") + "')]"));
	}

	public WebElement verifyGlobalsurchargeHighRange5() {
		return driver.findElement(By.xpath("//table[@id='default-surcharge-table']//tbody//tr//td[2][contains(text(),'"
				+ propertyValue.getValue("highRange5") + "')]"));
	}

	public WebElement verifyGlobalsurchargeLTL1() {
		return driver.findElement(By.xpath("//table[@id='default-surcharge-table']//tbody//tr//td[3][contains(text(),'"
				+ propertyValue.getValue("LTL1") + "')]"));
	}

	public WebElement verifyGlobalsurchargeLTL2() {
		return driver.findElement(By.xpath("//table[@id='default-surcharge-table']//tbody//tr//td[3][contains(text(),'"
				+ propertyValue.getValue("LTL2") + "')]"));
	}

	public WebElement verifyGlobalsurchargeLTL3() {
		return driver.findElement(By.xpath("//table[@id='default-surcharge-table']//tbody//tr//td[3][contains(text(),'"
				+ propertyValue.getValue("LTL3") + "')]"));
	}

	public WebElement verifyGlobalsurchargeLTL4() {
		return driver.findElement(By.xpath("//table[@id='default-surcharge-table']//tbody//tr//td[3][contains(text(),'"
				+ propertyValue.getValue("LTL4") + "')]"));
	}

	public WebElement verifyGlobalsurchargeLTL5() {
		return driver.findElement(By.xpath("//table[@id='default-surcharge-table']//tbody//tr//td[3][contains(text(),'"
				+ propertyValue.getValue("LTL5") + "')]"));
	}

	public WebElement verifyGlobalsurchargeTL1() {
		return driver.findElement(By.xpath("//table[@id='default-surcharge-table']//tbody//tr//td[4][contains(text(),'"
				+ propertyValue.getValue("TL1") + "')]"));
	}

	public WebElement verifyGlobalsurchargeTL2() {
		return driver.findElement(By.xpath("//table[@id='default-surcharge-table']//tbody//tr//td[4][contains(text(),'"
				+ propertyValue.getValue("TL2") + "')]"));
	}

	public WebElement verifyGlobalsurchargeTL3() {
		return driver.findElement(By.xpath("//table[@id='default-surcharge-table']//tbody//tr//td[4][contains(text(),'"
				+ propertyValue.getValue("TL3") + "')]"));
	}

	public WebElement verifyGlobalsurchargeTL4() {
		return driver.findElement(By.xpath("//table[@id='default-surcharge-table']//tbody//tr//td[4][contains(text(),'"
				+ propertyValue.getValue("TL4") + "')]"));
	}

	public WebElement verifyGlobalsurchargeTL5() {
		return driver.findElement(By.xpath("//table[@id='default-surcharge-table']//tbody//tr//td[4][contains(text(),'"
				+ propertyValue.getValue("TL5") + "')]"));
	}

	public void delete1stSetData() throws Exception {
		driver.findElement(By.xpath("//table[@id='globalTable']//tr//div[contains(text(), '"
				+ propertyValue.getValue("TL1") + "')]//following::a[@class='delete-row'][1]//img")).click();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(6000);

	}

	public void delete2ndSetData() throws Exception {
		driver.findElement(By.xpath("//table[@id='globalTable']//tr//div[contains(text(), '"
				+ propertyValue.getValue("TL2") + "')]//following::a[@class='delete-row'][1]//img")).click();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(6000);
	}

	public void delete3rdSetData() throws Exception {
		driver.findElement(By.xpath("//table[@id='globalTable']//tr//div[contains(text(), '"
				+ propertyValue.getValue("TL3") + "')]//following::a[@class='delete-row'][1]//img")).click();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(6000);
	}

	public void delete4thSetData() throws Exception {
		driver.findElement(By.xpath("//table[@id='globalTable']//tr//div[contains(text(), '"
				+ propertyValue.getValue("TL4") + "')]//following::a[@class='delete-row'][1]//img")).click();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(6000);
	}

	public void delete5thSetData() throws Exception {
		driver.findElement(By.xpath("//table[@id='globalTable']//tr//div[contains(text(), '"
				+ propertyValue.getValue("TL5") + "')]//following::a[@class='delete-row'][1]//img")).click();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		Thread.sleep(6000);

	}
}