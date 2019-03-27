package com.dreamorbit.SMC3_Rater.testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.dreamorbit.SMC3_Rater.testutils.RaterTestUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public static ExtentReports extent;
	public static ExtentTest test;

	public static final Logger log = Logger.getLogger(TestBase.class.getName());

	public void loadPropertiesFile() throws IOException {
		prop = new Properties();
		File file = new File(System.getProperty("user.dir")
				+ "//Files//DataFile.properties");
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
	}

	public void selectBrowser(String browser) {
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")
							+ "//drivers//chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir")
							+ "//drivers//geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir")
							+ "//drivers//IEDriverServer.exe");
			driver = new InternetExplorerDriver();

		}
	}

	public void getUrl(String url) {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage()
				.timeouts()
				.implicitlyWait(RaterTestUtils.UP_TO_TEN_SECONDS,
						TimeUnit.SECONDS);
		driver.get(url);
	}

	public void initialization() throws IOException {
		PropertyConfigurator.configure("log4j//log4j.properties");
		loadPropertiesFile();
		selectBrowser(prop.getProperty("browser"));
		getUrl(prop.getProperty("url"));
	}

	@After
	public void endTest() {
//		driver.quit();
	}

}
