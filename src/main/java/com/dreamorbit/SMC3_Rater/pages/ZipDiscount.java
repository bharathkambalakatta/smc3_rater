package com.dreamorbit.SMC3_Rater.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	
	public void clickingOnDiscountIDButton() {
		WebDriverWait wait = new WebDriverWait(driver,
				RaterTestUtils.UP_TO_TWENTY_FIVE_SECONDS);
		wait.until(ExpectedConditions.elementToBeClickable(discountIDButton))
				.click();
		logger.info("MESSAGE :: MANAGE SETTINGS Tab - Custom Setting - User has clicked on 'Discount ID (ZIP)' button");
	}
}