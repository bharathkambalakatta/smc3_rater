package com.dreamorbit.SMC3_Rater.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.dreamorbit.SMC3_Rater.testbase.TestBase;

public class LoginPage extends TestBase {

	public static final Logger logger = Logger
			.getLogger(LoginPage.class.getName());

	WebDriver driver;

	@FindBy(name="username")
	private WebElement userName;
	
	@FindBy(name="password")
	private WebElement passWord;

	@FindBy(id="login-button")
	private WebElement loginBtn;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String username) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(userName)).sendKeys(username);
	}

	public void setPassword(String password) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(passWord)).sendKeys(password);
	}

	public void clickLogin() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
		
	}

	public RateAShipmentPage LoginToApplication(String userName, String password) {
		this.setUserName(userName);
		this.setPassword(password);
		this.clickLogin();
		logger.info("MESSAGE :: '"+userName+"' user has logged in to the application");
		return PageFactory.initElements(driver, RateAShipmentPage.class);
	}

}
