package com.framework.BaseClass;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.framework.Utilites.ReadProperties;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	protected WebDriver driver;

	@BeforeTest
	/*
	 * This method will run before the Test Method and this method contains Browser
	 * specifications & Initializations
	 */
	public WebDriver setUp() throws InterruptedException {
		String browser = ReadProperties.getProperty("browser_type");
		String browser_url = ReadProperties.getProperty("browser_url");
		
		//Prabhakar: Convert these if blocks into switch..case.. block
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else {
			throw new IllegalArgumentException("Invalid browser specified: " + browser);
		}

		driver.get(browser_url);
		driver.manage().window().maximize();
		//Prabhakar: Remove hardcoded value.. get them from config file
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(25));
		return driver;
	}

	
	@AfterTest
	/*
	 * This method will run after all the Test Method and this method closes the
	 * currently opened browser
	 */
	public void tearDown() throws InterruptedException {
		if (driver != null) {
			//Prabhakar: Remove hardcoded value.. get them from config file
			Thread.sleep(5000);
			// driver.quit();
		}
	}
}