package com.dreamorbit.SMC3_Rater.TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestForTesting {

	static WebDriver driver;
	
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver", "C://Bharath//Automation//SMC3_Rater//drivers//chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://snapraterdo.smc3.com/Rater/login.auth");
	driver.findElement(By.name("username")).sendKeys("manual.rater.adminuser1@smc3.com");
	driver.findElement(By.name("password")).sendKeys("ThumbSalt43$");
	driver.findElement(By.id("login-button")).click();
	verifyIfSettingIsAvailable();
	driver.quit();
}
public static void verifyIfSettingIsAvailable()
{
	System.out.println("Start");
	boolean found = false;
	WebElement element = driver.findElement(By.xpath("//select[@id='settingId']"));
	Select select = new Select(element);
	List<WebElement> allOptions = select.getOptions();
	System.out.println(allOptions.size());
	
	for(int i=0;i<allOptions.size();i++) {
		System.out.println(allOptions.get(i).getText());
	
	    if(allOptions.get(i).getText().equals("RaterTest")) {
	        found=true;
	        break;
	    }
	}
	if(found) {
	    System.out.println("Value exists");
	}
	else{
		System.out.println("Value doesn't exists");
	}
}
}